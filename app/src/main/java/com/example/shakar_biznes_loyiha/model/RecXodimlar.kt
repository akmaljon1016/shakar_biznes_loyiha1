package com.example.shakar_biznes_loyiha.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecXodimlar(
    val login: String,
    val ism: String,
    val familiya: String,
    val status: String,
    val yaratildi: String
) : Parcelable