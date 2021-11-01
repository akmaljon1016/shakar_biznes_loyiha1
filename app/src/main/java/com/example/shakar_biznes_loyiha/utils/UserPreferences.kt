package com.example.shakar_biznes_loyiha.utils

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferences(context: Context) {
    private val applicationContext = context.applicationContext
    private val dataSore: DataStore<Preferences> = applicationContext.createDataStore(
        name = Constans.DATASTORE_NAME
    )
}