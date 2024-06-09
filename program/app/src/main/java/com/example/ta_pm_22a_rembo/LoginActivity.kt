package com.example.ta_pm_22a_rembo

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (validateInput(username, password)) {
                performLogin(username, password)
            }
        }
    }

    private fun validateInput(username: String, password: String): Boolean {
        return when {
            TextUtils.isEmpty(username) -> {
                etUsername.error = "Please enter your username"
                etUsername.requestFocus()
                false
            }
            TextUtils.isEmpty(password) -> {
                etPassword.error = "Please enter your password"
                etPassword.requestFocus()
                false
            }
            else -> true
        }
    }

    private fun performLogin(username: String, password: String) {
        // This is just a placeholder. You should implement actual login logic here.
        if (username == "admin" && password == "1234") {
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
            // Proceed to the DashboardActivity
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish() // Finish current activity to prevent going back to LoginActivity
        } else {
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
        }
    }
}