package com.example.shakar_biznes_loyiha.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecSkladdagiQoldiq(
    val shakarTuri:String,
    val qoldiqQop:Int,
    val narxQop:Int,
    val umumiySumma:Int
):Parcelable