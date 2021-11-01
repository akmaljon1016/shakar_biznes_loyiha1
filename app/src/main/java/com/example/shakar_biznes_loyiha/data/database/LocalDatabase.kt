package com.example.shakar_biznes_loyiha.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.shakar_biznes_loyiha.data.database.Entity.BoshSahifaEntity

@Database(
    entities = [BoshSahifaEntity::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(DatabaseTypeConverter::class)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
}