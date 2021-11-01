package com.example.shakar_biznes_loyiha.models.boshSahifa


import com.google.gson.annotations.SerializedName

data class Client(
    @SerializedName("finishAccount")
    var finishAccount: Int,
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("type_id")
    var typeId: Int,
    @SerializedName("typeName")
    var typeName: String
)