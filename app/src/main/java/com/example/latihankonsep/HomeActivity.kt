package com.example.latihankonsep

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.latihankonsep.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    private lateinit var homeActivityHomeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeActivityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeActivityHomeBinding.root)

        supportActionBar?.hide()
        homeActivityHomeBinding.edtStatus.text =
            "${intent.getStringExtra(NAME)}, apa yang anda pikirkan?"

        homeActivityHomeBinding.call.setOnClickListener {
            val i = Intent(Intent.ACTION_DIAL, Uri.parse("tel:0895384252730"))
            startActivity(i)
        }

    }

}