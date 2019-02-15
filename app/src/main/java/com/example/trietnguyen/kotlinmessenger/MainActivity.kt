package com.example.trietnguyen.kotlinmessenger

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sigup_button_register.setOnClickListener {
            val email =  email_editText_register.text.toString()
            val password = password_editText_register.text.toString()

            Log.d("MainActivity", "email " + email)
            Log.d("MainActivity", "password " + password)
        }

        already_have_account_textView.setOnClickListener {
            Log.d("MainActivity", "Clicked")
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
