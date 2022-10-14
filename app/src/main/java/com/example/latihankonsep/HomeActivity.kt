package com.example.latihankonsep

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihankonsep.databinding.ActivityHomeBinding


const val USER_DATA = "com.latihankonsep.userData"

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var homeActivityHomeBinding: ActivityHomeBinding
    private var listQuotes = ArrayList<String>()

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == PostQutesActivity.RESULT_CODE && it.data != null) {
            val selectedValue =
                it.data?.getStringExtra(PostQutesActivity.EXTRA_SELECTED_VALUE)
            listQuotes.add(selectedValue!!)
            showRecycleList()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeActivityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeActivityHomeBinding.root)
        supportActionBar?.hide()
        listQuotes.addAll(QuotesData.listQuotes)


        showRecycleList()
        homeActivityHomeBinding.edtStatus.text =
            "${intent.getStringExtra(NAME)}, apa yang anda pikirkan?"

        homeActivityHomeBinding.iconCall.setOnClickListener(this)
        homeActivityHomeBinding.addPost.setOnClickListener(this)
        homeActivityHomeBinding.profilePic.setOnClickListener(this)
        homeActivityHomeBinding.btnAddQuote.setOnClickListener(this)


    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.addPost -> {
                val galerry = Intent(Intent.ACTION_GET_CONTENT, Uri.parse("image/*"))
                startActivity(galerry)
            }
            R.id.iconCall -> {
                val i = Intent(Intent.ACTION_DIAL, Uri.parse("tel:0895384252730"))
                startActivity(i)
            }
            R.id.profilePic -> {
                val user = User("Achmad Syarif", "02mei2002", R.drawable.halland)
                val i = Intent(this@HomeActivity, ProfileActivity::class.java)
                i.putExtra(USER_DATA, user)
                startActivity(i)
            }
            R.id.btnAddQuote -> {
                val moveForResultIntent =
                    Intent(this@HomeActivity, PostQutesActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }
        }
    }

    private fun showRecycleList() {
        val layoutManager = LinearLayoutManager(this)
        homeActivityHomeBinding.rvQuotes.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        homeActivityHomeBinding.rvQuotes.addItemDecoration(itemDecoration)

        val adapter = ListQuotesAdapter(listQuotes)
        homeActivityHomeBinding.rvQuotes.adapter = adapter
    }
}