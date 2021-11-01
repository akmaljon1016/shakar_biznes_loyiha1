package com.example.shakar_biznes_loyiha.data.database.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.shakar_biznes_loyiha.models.boshSahifa.BoshSahifa
import com.example.shakar_biznes_loyiha.utils.Constans.Companion.TABLE_NAME
import com.google.gson.annotations.SerializedName

@Entity(tableName = TABLE_NAME)
class BoshSahifaEntity(
    @SerializedName("data")
    var data: BoshSahifa
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}