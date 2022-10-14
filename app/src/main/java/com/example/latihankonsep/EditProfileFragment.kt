package com.example.latihankonsep

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


class EditProfileFragment : Fragment() {
    private lateinit var btnSaveProfile: Button
    private lateinit var edtUsn: EditText
    private lateinit var edtPassword: EditText
    var description: String? = null

    companion object {
        var EXTRA_USERNAME = "EXTRA_USERNAME"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSaveProfile = view.findViewById(R.id.btnSaveProfile)
        edtUsn = view.findViewById(R.id.edtUsn)
        edtPassword = view.findViewById(R.id.edtPassword)

        btnSaveProfile.setOnClickListener {
            if (validate()) {
                val mFragmentManager = parentFragmentManager
                val mProfileFragment = ProfileFragment()
                val mBundle = Bundle()
                mBundle.putString(ProfileFragment.EXTRA_USERNAME, edtUsn.text.toString())

                mProfileFragment.arguments = mBundle

                mFragmentManager.beginTransaction()
                    .replace(
                        R.id.frameContainer,
                        mProfileFragment,
                        ProfileFragment::class.java.simpleName
                    )
                    .commit()
            }
        }
    }

    private fun validate(): Boolean {
        if (edtUsn.text.isNotEmpty() && edtPassword.text.isNotEmpty()) return true
        if (edtUsn.text.isEmpty())
            edtUsn.error = "Masih kosong"
        if (edtPassword.text.isEmpty())
            edtPassword.error = "Masih kosong"

        return false
    }


}