package com.example.shakar_biznes_loyiha.data.database

import androidx.room.TypeConverter
import com.example.shakar_biznes_loyiha.models.boshSahifa.BoshSahifa
import com.example.shakar_biznes_loyiha.models.boshSahifa.Client
import com.example.shakar_biznes_loyiha.models.boshSahifa.Kassa
import com.example.shakar_biznes_loyiha.models.boshSahifa.Sklad
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DatabaseTypeConverter {
    var gson = Gson()

    /**Client**/
    @TypeConverter
    fun ClientToString(boshSahifa: BoshSahifa): String {
        return gson.toJson(boshSahifa)
    }

    @TypeConverter
    fun stringToClient(data: String): BoshSahifa {
        val listType = object : TypeToken<BoshSahifa>() {}.type
        return gson.fromJson(data, listType)
    }
}