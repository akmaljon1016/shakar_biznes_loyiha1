package com.example.shakar_biznes_loyiha.models.klient


import com.google.gson.annotations.SerializedName

data class KlientlarSahifa(
    @SerializedName("data")
    var `data`: Data,
    @SerializedName("message")
    var message: String,
    @SerializedName("status")
    var status: Int
)