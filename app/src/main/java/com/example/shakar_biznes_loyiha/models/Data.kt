
package com.example.shakar_biznes_loyiha.models

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("firstname")
    var firstname: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("lastname")
    var lastname: String,
    @SerializedName("token")
    var token: String,
    @SerializedName("userRole")
    var userRole: String,
    @SerializedName("worker_id")
    var workerId: Any?
)