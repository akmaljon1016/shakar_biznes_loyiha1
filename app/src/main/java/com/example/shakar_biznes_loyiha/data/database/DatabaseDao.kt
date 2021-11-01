package com.example.shakar_biznes_loyiha.data.database

import androidx.room.*
import com.example.shakar_biznes_loyiha.data.database.Entity.BoshSahifaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DatabaseDao {

    /**Client DAO**/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBoshSahifaData(boshSahifaEntity: BoshSahifaEntity)

    @Query("SELECT * FROM boshSahifaTable")
    fun getBoshSahifaData(): Flow<BoshSahifaEntity>

}