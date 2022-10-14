package com.example.latihankonsep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.latihankonsep.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var profileActivityProfileBinding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        profileActivityProfileBinding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(profileActivityProfileBinding.root)
        supportActionBar?.hide()

        val mFragmentManager = supportFragmentManager
        val mProfileFragment = ProfileFragment()

        mFragmentManager.beginTransaction()
            .add(R.id.frameContainer, mProfileFragment, ProfileFragment::class.java.simpleName)
            .commit()

    }
}