package com.example.shakar_biznes_loyiha.models.klient


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("items")
    var items: List<Item>,
    @SerializedName("_links")
    var links: Links,
    @SerializedName("_meta")
    var meta: Meta
)