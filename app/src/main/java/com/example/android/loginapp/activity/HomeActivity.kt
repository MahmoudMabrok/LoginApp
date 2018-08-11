package com.example.android.loginapp.activity

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.android.loginapp.R
import com.example.android.loginapp.fragment.HomeFragment
import com.example.android.loginapp.model.User
import com.example.android.loginapp.util.Constants


class HomeActivity : AppCompatActivity(), HomeFragment.HomeTransitionInterface {

    private lateinit var user : User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //Get user object from intent
        val bundle : Bundle = intent.extras
        user = bundle.get(Constants.USER_KEY) as User

        openFragment(HomeFragment.newInstance(user))

    }

    override fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.homeactivity_framelayout, fragment)
                .commit()
    }
}
