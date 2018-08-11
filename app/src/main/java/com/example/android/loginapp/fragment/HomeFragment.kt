package com.example.android.loginapp.fragment

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.loginapp.R
import com.example.android.loginapp.model.User
import com.example.android.loginapp.util.Constants
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(){

    private lateinit var user : User

    companion object {
        fun newInstance(user : User) : HomeFragment{
            val homeFragment = HomeFragment()
            val args = Bundle()
            args.putSerializable(Constants.USER_KEY, user)
            homeFragment.arguments = args
            return homeFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        user = arguments?.getSerializable(Constants.USER_KEY) as User
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showUser(user)
    }

    /**
     * shows user information on screen
     */
    private fun showUser(user : User){
        user_name.text = user.name
        user_age.text = user.age.toString()
        user_college.text = user.college
        user_department.text = user.college
        user_expected_graduation_year.text = user.expectedGraduationYear.toString()
        user_last_grade.text = user.lastGrade
    }

    interface HomeTransitionInterface{
        fun openFragment(fragment: Fragment)
    }
}