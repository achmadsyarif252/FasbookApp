package com.example.latihankonsep

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class ProfileFragment : Fragment() {
    private lateinit var btnEditProfile: Button
    private lateinit var tvUsername: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        tvUsername = view.findViewById(R.id.usn)
        btnEditProfile = view.findViewById(R.id.btnEditProfile)

        if (arguments != null) {
            val updateUsn = arguments?.getString(EXTRA_USERNAME)
            tvUsername.text = updateUsn
        }
        btnEditProfile.setOnClickListener {

            val fragment = EditProfileFragment()
            val mFragmentManager = parentFragmentManager
            mFragmentManager?.beginTransaction()?.apply {
                replace(R.id.frameContainer, fragment, EditProfileFragment::class.java.simpleName)
                commit()
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        const val EXTRA_USERNAME = "EXTRA_USNNAME"
    }

}