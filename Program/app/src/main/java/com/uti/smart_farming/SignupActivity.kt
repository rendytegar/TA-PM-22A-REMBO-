package com.uti.smart_farming

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uti.smart_farming.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var databaseHelper: dbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Binding SignupActivity
        val binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Binding database
        databaseHelper = dbHelper(this)

//        event btnRegis
        binding.btnRegis.setOnClickListener {
            val user = binding.Username.text.toString()
            val pass = binding.Password.text.toString()
            signupDatabase(user, pass)
        }

//        event txLogin
        binding.txLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    //    insert username dan password ke SQLite
    private fun signupDatabase(username: String, password: String) {
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Username atau Password tidak boleh kosong !", Toast.LENGTH_SHORT)
                .show()
            return
        }

        val insertedRowId = databaseHelper.insertUser(username, password)
        if (insertedRowId != -1L) {
            Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Signup Failed", Toast.LENGTH_SHORT).show()
        }
    }
}