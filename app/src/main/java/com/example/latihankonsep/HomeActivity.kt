package com.example.latihankonsep

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

    }

}