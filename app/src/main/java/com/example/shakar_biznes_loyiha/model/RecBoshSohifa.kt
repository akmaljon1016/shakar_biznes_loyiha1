package com.example.shakar_biznes_loyiha.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecBoshSohifa(
   val name: String,
   val summa: Int
) : Parcelable
