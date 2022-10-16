package com.example.latihankonsep

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.example.latihankonsep.databinding.FragmentEditProfileBinding


class EditProfileFragment : Fragment() {
    private var _binding: FragmentEditProfileBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnSaveProfile.setOnClickListener {
            if (validate()) {
                val toProfile =
                    EditProfileFragmentDirections.actionEditProfileFragment2ToProfileFragment4()
                toProfile.recentUsername = binding.edtUsn.text.toString()
                view.findNavController().navigate(toProfile)
            }
        }
    }

    private fun validate(): Boolean {
        if (binding.edtUsn.text.isNotEmpty() && binding.edtPassword.text.isNotEmpty()) return true
        if (binding.edtUsn.text.isEmpty())
            binding.edtUsn.error = "Masih kosong"
        if (binding.edtPassword.text.isEmpty())
            binding.edtPassword.error = "Masih kosong"

        return false
    }


}