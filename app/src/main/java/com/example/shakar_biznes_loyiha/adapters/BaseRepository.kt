package com.example.shakar_biznes_loyiha.adapters

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): com.example.shakar_biznes_loyiha.data.network.Resources<T> {
        return withContext(Dispatchers.IO) {
            try {
                com.example.shakar_biznes_loyiha.data.network.Resources.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        com.example.shakar_biznes_loyiha.data.network.Resources.Failure(
                            false,
                            throwable.code(),
                            throwable.response()?.errorBody()
                        )
                    }
                    else -> {
                        com.example.shakar_biznes_loyiha.data.network.Resources.Failure(true, null, null)
                    }
                }
            }
        }
    }


}