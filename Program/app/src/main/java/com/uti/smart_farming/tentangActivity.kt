package com.uti.smart_farming

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

<<<<<<< HEAD
<<<<<<< HEAD
class tentangActivity : AppCompatActivity() {
=======

=======
class tentangActivity : AppCompatActivity() {
>>>>>>> 3a58b6685a416be24707a83b458b84f5bfaab4c1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enablceEdgeToEdge()
        setContentView(R.layout.activity_tentang)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}