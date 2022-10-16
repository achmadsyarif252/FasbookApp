package com.example.latihankonsep

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.latihankonsep.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (arguments != null) {
            val updateUsn = ProfileFragmentArgs.fromBundle(arguments as Bundle).recentUsername
            binding.usn.text = updateUsn
        }

        binding.btnEditProfile.setOnClickListener {
            view.findNavController().navigate(R.id.action_profileFragment4_to_editProfileFragment2)
        }

        super.onViewCreated(view, savedInstanceState)
    }

}