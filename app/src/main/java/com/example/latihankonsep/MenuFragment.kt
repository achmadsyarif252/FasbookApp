package com.example.latihankonsep

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihankonsep.databinding.FragmentMenuBinding

const val USER_DATA = "com.konsep.app"

class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listQuotes.addAll(QuotesData.listQuotes)
        showRecycleList()

        val dataName = MenuFragmentArgs.fromBundle(arguments as Bundle).defaultName
        binding.edtStatus.text = "$dataName, apa yang anda pikirkan?"

        binding.iconCall.setOnClickListener {
            val i = Intent(Intent.ACTION_DIAL, Uri.parse("tel:0895384252730"))
            startActivity(i)
        }
        binding.addPost.setOnClickListener {
            val galerry = Intent(Intent.ACTION_GET_CONTENT, Uri.parse("image/*"))
            startActivity(galerry)
        }
        binding.profilePic.setOnClickListener {
            view.findNavController().navigate(R.id.action_menuFragment_to_profileFragment4)
        }
        binding.btnAddQuote.setOnClickListener {
            val moveForResultIntent =
                Intent(requireContext(), PostQutesActivity::class.java)
            resultLauncher.launch(moveForResultIntent)
        }

    }

    private fun showRecycleList() {
        val layoutManager = LinearLayoutManager(requireContext())
        binding.rvQuotes.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(requireContext(), layoutManager.orientation)
        binding.rvQuotes.addItemDecoration(itemDecoration)

        val adapter = ListQuotesAdapter(listQuotes)
        binding.rvQuotes.adapter = adapter

        binding.profilePic.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_menuFragment_to_profileFragment4)
        }
    }

}