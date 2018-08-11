package com.example.android.loginapp.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.android.loginapp.R
import com.example.android.loginapp.model.User
import com.example.android.loginapp.util.Constants
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var user : User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //Get user object from intent
        val bundle : Bundle = intent.extras
        user = bundle.get(Constants.USER_KEY) as User

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
}
