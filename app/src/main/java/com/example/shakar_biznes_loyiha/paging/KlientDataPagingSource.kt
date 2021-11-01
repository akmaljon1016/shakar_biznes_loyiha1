package com.example.shakar_biznes_loyiha.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.shakar_biznes_loyiha.models.klient.Item
import com.example.shakar_biznes_loyiha.repository.Repository


class KlientDataPagingSource(val repository: Repository) :
    PagingSource<Int, Item>() {
    @ExperimentalPagingApi
    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        return try {
            val currentPage = params.key ?: 1
            val response = repository.remote.getKlientlar(currentPage)
            val data = response.body()?.data?.items ?: emptyList()
            val responseData = mutableListOf<Item>()
            responseData.addAll(data)
            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}