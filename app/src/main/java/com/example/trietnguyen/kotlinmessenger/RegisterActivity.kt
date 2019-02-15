package com.example.trietnguyen.kotlinmessenger

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sigup_button_register.setOnClickListener {
            performSignUp()
        }

        already_have_account_textView.setOnClickListener {
            Log.d("RegisterActivity", "Clicked")
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun performSignUp() {
        val email = email_editText_register.text.toString()
        val password = password_editText_register.text.toString()
        val username = username_editText_register.text.toString()

        if (email.isEmpty() || password.isEmpty() || username.isEmpty()) {
            Toast.makeText(this, "Please fill all the text fields", Toast.LENGTH_SHORT).show()
            return
        }

        auth = FirebaseAuth.getInstance()

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Account created!", Toast.LENGTH_SHORT).show()
                    val user = auth.currentUser
                }
            }

            .addOnFailureListener {
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            }
    }
}
