package com.example.shakar_biznes_loyiha.models.klient


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("currentPage")
    var currentPage: Int,
    @SerializedName("pageCount")
    var pageCount: Int,
    @SerializedName("perPage")
    var perPage: Int,
    @SerializedName("totalCount")
    var totalCount: Int
)