package com.example.shakar_biznes_loyiha

import android.app.Application
import com.example.shakar_biznes_loyiha.utils.NetworkListener
import com.example.shakar_biznes_loyiha.utils.UserPreferences
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}