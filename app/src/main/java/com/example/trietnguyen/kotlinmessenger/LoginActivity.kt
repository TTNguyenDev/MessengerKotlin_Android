package com.example.trietnguyen.kotlinmessenger

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        login_button_login.setOnClickListener {

            val email = email_editText_login.text.toString()
            val password = password_editText_Login.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all the text field", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth = FirebaseAuth.getInstance()

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Sign in success!", Toast.LENGTH_SHORT).show()
                        val user = auth.currentUser
                    } else {
                        Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
                    }


                }
        }



        backToRegister_textView.setOnClickListener {
            finish()
        }
    }
}