package com.example.shakar_biznes_loyiha.data.network

import com.example.shakar_biznes_loyiha.models.LoginResponseX
import com.example.shakar_biznes_loyiha.models.boshSahifa.BoshSahifa
import com.example.shakar_biznes_loyiha.models.klient.KlientlarSahifa
import retrofit2.Response
import retrofit2.http.*

interface NetworkApi {
    @FormUrlEncoded
    @POST("site/login")
    suspend fun login(
        @Field("username") email: String,
        @Field("password") password: String
    ): Response<LoginResponseX>


    @GET("home/index")
    suspend fun getIndex(): Response<BoshSahifa>

    @GET("client/index")
    suspend fun getClient(@Query("page") page: Int): Response<KlientlarSahifa>
}