package com.example.aplikasirembo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Mendapatkan referensi ke elemen UI
        val edUser: EditText = findViewById(R.id.eduser)
        val edPass: EditText = findViewById(R.id.pass)
        val loginButton: Button = findViewById(R.id.login)

        // Menambahkan fungsi klik pada tombol login
        loginButton.setOnClickListener {
            val username = edUser.text.toString()
            val password = edPass.text.toString()

            // Lakukan validasi username dan password
            if (username == "Petani" && password == "12345") {
                // Jika username dan password sesuai, arahkan ke aktivitas Dashboard
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
            } else {
                // Jika username atau password tidak sesuai, tampilkan pesan kesalahan
                Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

