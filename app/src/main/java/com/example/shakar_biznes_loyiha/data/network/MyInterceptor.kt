package com.example.shakar_biznes_loyiha.data.network

import com.example.shakar_biznes_loyiha.utils.Constans
import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Authorization", "Bearer "+ Constans.token)
            .build()
        return chain.proceed(request)
    }
}