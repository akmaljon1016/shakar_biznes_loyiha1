package com.example.shakar_biznes_loyiha.di

import android.content.Context
import androidx.room.Room
import com.example.shakar_biznes_loyiha.data.database.LocalDatabase
import com.example.shakar_biznes_loyiha.utils.Constans.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        LocalDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: LocalDatabase) = database.databaseDao()
}