package com.example.shakar_biznes_loyiha.models.klient


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("first")
    var first: First,
    @SerializedName("last")
    var last: Last,
    @SerializedName("next")
    var next: Next,
    @SerializedName("self")
    var self: Self
)