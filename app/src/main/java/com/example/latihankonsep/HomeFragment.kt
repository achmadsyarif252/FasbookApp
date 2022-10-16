package com.example.latihankonsep

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.latihankonsep.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener { view ->
            if (validateForm()) {
                val toHomeActivity = HomeFragmentDirections.actionHomeFragmentToMenuFragment()
                toHomeActivity.defaultName = binding.edtUsn.text.toString()
                view.findNavController().navigate(toHomeActivity)
            }
        }
    }

    private fun validateForm(): Boolean {
        val edtUsn = binding.edtUsn
        val edtPassword = binding.edtPassword

        if (edtUsn.text.isNotEmpty() && edtPassword.text.isNotEmpty()) return true

        if (edtUsn.text.isEmpty())
            edtUsn.error = "This field is empty!"

        if (edtPassword.text.isEmpty())
            edtPassword.error = "This field is empty!"
        return false
    }

}