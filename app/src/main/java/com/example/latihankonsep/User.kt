package com.example.latihankonsep

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var username: String = "",
    var password: String = "",
    var photo: Int = 0
) : Parcelable
