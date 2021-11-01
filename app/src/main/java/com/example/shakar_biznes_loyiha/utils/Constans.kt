package com.example.shakar_biznes_loyiha.utils

import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.preferencesKey

class Constans {
    companion object {
        const val DATASTORE_NAME = "my_data_store_user"
        val USERLOGGED = preferencesKey<Boolean>("isUserLogged")
        var token: String = ""
        const val BASE_URL = "https://muhammadkarim.uz/api/"
        const val TABLE_NAME = "boshSahifaTable"
        const val DATABASE_NAME = "localDatabase"

    }
}