package com.example.shakar_biznes_loyiha.models.boshSahifa


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("clients")
    var clients: List<Client>,
    @SerializedName("kassa")
    var kassa: Kassa,
    @SerializedName("sklad")
    var sklad: List<Sklad>
)