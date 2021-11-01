package com.example.shakar_biznes_loyiha.data.network


import com.example.shakar_biznes_loyiha.models.LoginResponseX
import com.example.shakar_biznes_loyiha.models.boshSahifa.BoshSahifa
import com.example.shakar_biznes_loyiha.models.klient.KlientlarSahifa
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val networkApi: NetworkApi
) {
    /**Login**/
    suspend fun login(login: String, password: String): Response<LoginResponseX> {
        return networkApi.login(login, password)
    }

    /**Bosh Sahifa**/
    suspend fun getBoshSahifaData(): Response<BoshSahifa> {
        return networkApi.getIndex()
    }

    /**Klientlar**/
    suspend fun getKlientlar(page: Int): Response<KlientlarSahifa> {
        return networkApi.getClient(page)
    }

}