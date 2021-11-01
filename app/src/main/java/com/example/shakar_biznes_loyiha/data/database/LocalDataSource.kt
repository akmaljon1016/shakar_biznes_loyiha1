package com.example.shakar_biznes_loyiha.data.database

import com.example.shakar_biznes_loyiha.data.database.Entity.BoshSahifaEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    val databaseDao: DatabaseDao
) {

    /**Bosh SahifaData**/
    suspend fun insertBoshSahifaData(boshSahifaEntity: BoshSahifaEntity){
        databaseDao.insertBoshSahifaData(boshSahifaEntity)
    }
    fun readBoshSahifaData():Flow<BoshSahifaEntity>{
        return databaseDao.getBoshSahifaData()
    }
}