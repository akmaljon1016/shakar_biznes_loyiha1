package com.example.shakar_biznes_loyiha.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecOlinganYuk(
    val klient: String,
    val shakarTuri: String,
    val sana: String,
    val yukMiqdori: String,
    val birlikNarx: Int,
    val umumiyNarx: Int
) : Parcelable