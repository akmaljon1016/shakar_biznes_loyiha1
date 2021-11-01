package com.example.shakar_biznes_loyiha.models.boshSahifa


import com.google.gson.annotations.SerializedName

data class Sklad(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("narx")
    var narx: Int,
    @SerializedName("qoldiq")
    var qoldiq: Int,
    @SerializedName("umumiyNarx")
    var umumiyNarx: Int
)