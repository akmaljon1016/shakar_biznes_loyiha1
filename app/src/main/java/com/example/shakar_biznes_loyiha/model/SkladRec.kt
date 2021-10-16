package com.example.shakar_biznes_loyiha.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SkladRec(
    val shakarTuri: String,
    val qoldiqQop: Int,
    val narx: Double,
    val ummumiySumma: Double,
    val olindiQop: Int,
    val sotildiQop: Int,
    val boshlangichMiqdoriQop: Int
) : Parcelable
