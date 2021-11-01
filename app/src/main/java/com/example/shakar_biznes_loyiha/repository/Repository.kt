package com.example.shakar_biznes_loyiha.repository

import com.example.shakar_biznes_loyiha.data.database.LocalDataSource
import com.example.shakar_biznes_loyiha.data.network.RemoteDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject
@ActivityRetainedScoped
class Repository @Inject constructor(
    remoteDataSource: RemoteDataSource,
    localDataSource: LocalDataSource
) {
    val remote = remoteDataSource
    val local = localDataSource
}