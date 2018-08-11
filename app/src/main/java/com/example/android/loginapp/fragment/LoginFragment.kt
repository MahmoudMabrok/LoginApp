package com.example.android.loginapp.fragment

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.loginapp.LoginApplication
import com.example.android.loginapp.R
import com.example.android.loginapp.activity.HomeActivity
import com.example.android.loginapp.util.Constants
import com.example.android.loginapp.util.Utils
import com.example.android.loginapp.viewModel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import rx.Subscription
import javax.inject.Inject

class LoginFragment : Fragment() {

    @Inject
    lateinit var loginViewModel : LoginViewModel

    private lateinit var transition : LoginTransitionInterface
    private lateinit var subscription : Subscription

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as LoginApplication).component.inject(this)
        transition = activity as LoginTransitionInterface
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLoginButtonOnClickListener()
    }

    interface LoginTransitionInterface{
        fun openFragment(fragment : Fragment)
    }

    private fun setLoginButtonOnClickListener(){
        val context : Context? = getContext()
        login_btn.setOnClickListener {
            //hide error text view
            if(error_text.visibility == View.VISIBLE){
                error_text.visibility = View.INVISIBLE
            }

            //show loading progress bar
            loading_progress_bar.visibility = View.VISIBLE

            //check internet connection
            if(!Utils.isNetworkConnected(context)){
                showErrorMessage(R.string.no_internet_connection)
                return@setOnClickListener
            }

            //get email and password entered by user
            val userInput : HashMap<String, String> = getUserInput()

            //check empty email or password
            if(!loginViewModel.checkEmptyInputs(userInput.get(Constants.EMAIL_KEY).toString(), userInput.get(Constants.PASSWORD_KEY).toString())){
                showErrorMessage(R.string.invalid_email)
                return@setOnClickListener
            }

            //check email validity
            if(!loginViewModel.isValidEmail(userInput.get(Constants.EMAIL_KEY).toString())){
                showErrorMessage(R.string.invalid_email)
                return@setOnClickListener
            }

            //check password validity
            if(!loginViewModel.isValidPassword(userInput.get(Constants.PASSWORD_KEY).toString())){
                showErrorMessage(R.string.invalid_password)
                return@setOnClickListener
            }
            //Call web service
            callLoginService(Constants.SUCCESS_STATUS)
        }
    }

    override fun onPause() {
        super.onPause()
        subscription?.unsubscribe()
    }

    private fun callLoginService(status : String){
        val input : HashMap<String, String> = HashMap()
        input.put(Constants.TYPE_KEY, status)
        subscription = loginViewModel.login(input).subscribe({
            val intent : Intent = Intent(context, HomeActivity::class.java)
            intent.putExtra(Constants.USER_KEY, it.user)
            startActivity(intent)
            activity?.finish()
        }, {
            showErrorMessage(R.string.failure_response)
        })
    }

    /**
     * extract email and password of user in a HashMap
     */
    private fun getUserInput() : HashMap<String, String>{
        val userInput : HashMap<String, String> = HashMap()
        userInput.put(Constants.EMAIL_KEY, email_edit_text.text.toString())
        userInput.put(Constants.PASSWORD_KEY, password_edit_text.text.toString())
        return userInput
    }

    /**
     * show error message to user
     */
    private fun showErrorMessage(messageId : Int){
        error_text.visibility = View.VISIBLE
        error_text.text = getString(messageId)
    }

}