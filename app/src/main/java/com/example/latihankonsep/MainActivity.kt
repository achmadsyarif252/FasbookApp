package com.example.latihankonsep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.example.latihankonsep.databinding.ActivityMainBinding

const val NAME = "com.latihankonsep.app"

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        supportActionBar?.hide()

        activityMainBinding.btnLogin.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnLogin -> {
                if (validateForm()) {
                    val i = Intent(this, HomeActivity::class.java)
                    i.putExtra(NAME, activityMainBinding.edtUsn.text.toString())
                    startActivity(i)
                }
            }
        }
    }

    private fun validateForm(): Boolean {
        val edtUsn = activityMainBinding.edtUsn
        val edtPassword = activityMainBinding.edtPassword

        if (edtUsn.text.isNotEmpty() && edtPassword.text.isNotEmpty()) return true

        if (edtUsn.text.isEmpty())
            edtUsn.error = "This field is empty!"

        if (edtPassword.text.isEmpty())
            edtPassword.error = "This field is empty!"
        return false
    }


}