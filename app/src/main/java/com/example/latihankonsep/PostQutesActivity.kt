package com.example.latihankonsep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.latihankonsep.databinding.ActivityPostQutesBinding

class PostQutesActivity : AppCompatActivity() {
    private lateinit var postQutesBinding: ActivityPostQutesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postQutesBinding = ActivityPostQutesBinding.inflate(layoutInflater)
        setContentView(postQutesBinding.root)
        supportActionBar?.hide()

        postQutesBinding.btnPost.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_SELECTED_VALUE, postQutesBinding.edtQuotes.text.toString())
            setResult(RESULT_CODE, resultIntent)
            finish()
        }
    }


    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

}