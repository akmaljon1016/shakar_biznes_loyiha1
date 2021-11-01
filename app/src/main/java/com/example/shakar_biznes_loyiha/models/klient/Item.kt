package com.example.shakar_biznes_loyiha.models.klient


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("boshlangich_hisob")
    var boshlangichHisob: Int,
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("pul_oldi_berdi")
    var pulOldiBerdi: Int,
    @SerializedName("type_id")
    var typeId: Int,
    @SerializedName("typeName")
    var typeName: String,
    @SerializedName("yakuniy_hisob")
    var yakuniyHisob: Int,
    @SerializedName("yuk_oldi_berdi")
    var yukOldiBerdi: Int
)