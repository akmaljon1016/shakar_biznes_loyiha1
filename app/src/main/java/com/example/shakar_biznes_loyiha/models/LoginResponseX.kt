package com.example.shakar_biznes_loyiha.models


import com.google.gson.annotations.SerializedName

data class LoginResponseX(
    @SerializedName("data")
    var `data`: Data,
    @SerializedName("message")
    var message: String,
    @SerializedName("status")
    var status: Int
)