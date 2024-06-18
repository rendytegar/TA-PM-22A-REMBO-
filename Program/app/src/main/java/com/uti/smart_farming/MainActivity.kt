package com.uti.smart_farming

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.uti.smart_farming.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cdObat = findViewById<CardView>(R.id.cdObat)
        val cdPupuk = findViewById<CardView>(R.id.cdPupuk)
        val cdBenih = findViewById<CardView>(R.id.cdBenih)
        val cdPerkembangan = findViewById<CardView>(R.id.cdPerkembangan)

        binding.Logout.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tentang.setOnClickListener {
            val intent = Intent(this, TentangActivity::class.java)
            startActivity(intent)
        }

        cdObat.setOnClickListener {
            openWebView("https://www.kliktani.com/2021/01/insektisida-sistemik.html")
        }

        cdPupuk.setOnClickListener {
            openWebView("https://saprotan-utama.com/pemupukan-yang-tepat-berimbang-untuk-tanaman-padi/")
        }

        cdBenih.setOnClickListener {
            openWebView("https://gdm.id/bibit-padi-unggul/")
        }

        cdPerkembangan.setOnClickListener {
            openWebView("https://desa-lerang.pinrangkab.go.id/artikel/2023/12/25/fase-pertumbuhan-tanaman-padi")
        }
    }

    private fun openWebView(url: String) {
        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("URL", url)
        startActivity(intent)
    }
}
