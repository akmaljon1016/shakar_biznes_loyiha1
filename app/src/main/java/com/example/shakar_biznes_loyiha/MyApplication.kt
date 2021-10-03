package com.example.shakar_biznes_loyiha

import android.app.Application
import com.example.shakar_biznes_loyiha.utils.NetworkListener
import com.example.shakar_biznes_loyiha.utils.UserPreferences

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val userPreferences = UserPreferences(applicationContext)
        val networkListener=NetworkListener()
    }
}