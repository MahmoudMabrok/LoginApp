package com.example.android.loginapp.activity

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.android.loginapp.R
import com.example.android.loginapp.fragment.LoginFragment

class LoginActivity : AppCompatActivity() , LoginFragment.LoginTransitionInterface{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.loginactivity_framelayout, fragment)
                .addToBackStack(null)
                .commit()
    }
}