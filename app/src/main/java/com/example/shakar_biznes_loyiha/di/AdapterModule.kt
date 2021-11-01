package com.example.shakar_biznes_loyiha.di

import android.content.Context
import com.example.shakar_biznes_loyiha.adapters.BoshSahifaAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AdapterModule {
    @JvmStatic
    @Provides
    fun provideAdapter(@ApplicationContext context: Context): BoshSahifaAdapter {
        return BoshSahifaAdapter(context)
    }
}