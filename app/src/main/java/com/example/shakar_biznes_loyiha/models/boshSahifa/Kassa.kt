package com.example.shakar_biznes_loyiha.models.boshSahifa


import com.google.gson.annotations.SerializedName

data class Kassa(
    @SerializedName("kassaBank")
    var kassaBank: Int,
    @SerializedName("kassaDollar")
    var kassaDollar: Int,
    @SerializedName("kassaSum")
    var kassaSum: Int,
    @SerializedName("umumiyHisob")
    var umumiyHisob: Int
)