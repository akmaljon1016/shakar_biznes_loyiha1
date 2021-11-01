package com.example.shakar_biznes_loyiha.loginActivity

import com.example.shakar_biznes_loyiha.adapters.BaseRepository
import com.example.shakar_biznes_loyiha.data.network.NetworkApi

class LoginRepository(
    private val networkApi: NetworkApi
):BaseRepository() {

    suspend fun login(
        login: String,
        password: String
    ) = safeApiCall { networkApi.login(login, password) }
}