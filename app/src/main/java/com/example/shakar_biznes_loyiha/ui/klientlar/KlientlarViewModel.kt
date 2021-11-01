package com.example.shakar_biznes_loyiha.ui.klientlar

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.shakar_biznes_loyiha.models.klient.KlientlarSahifa
import com.example.shakar_biznes_loyiha.paging.KlientDataPagingSource
import com.example.shakar_biznes_loyiha.repository.Repository
import com.example.shakar_biznes_loyiha.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class KlientlarViewModel @Inject constructor(val repository: Repository, application: Application) :
    AndroidViewModel(application) {

    private val _readKlientData: MutableLiveData<NetworkResult<KlientlarSahifa>> = MutableLiveData()
    val readKlientData: LiveData<NetworkResult<KlientlarSahifa>> get() = _readKlientData

    val listData = Pager(PagingConfig(pageSize = 10)) {
        KlientDataPagingSource(repository)
    }.flow.cachedIn(viewModelScope)

//    @RequiresApi(Build.VERSION_CODES.M)
//    fun getKlientData(page: Int) = viewModelScope.launch {
//        getKlientSafeCall(page)
//    }

    @RequiresApi(Build.VERSION_CODES.M)
    suspend fun getKlientSafeCall(page: Int) {
        _readKlientData.value = NetworkResult.Loading()
        if (hasInternetConnection()) {
            try {
                val response = repository.remote.getKlientlar(page)
                _readKlientData.value = handleKlientlarResponse(response)
            } catch (e: Exception) {
                _readKlientData.value = NetworkResult.Error(e.message)
            }
        } else {
            _readKlientData.value = NetworkResult.Error("No Internet Connection")
        }
    }

    private fun handleKlientlarResponse(response: Response<KlientlarSahifa>): NetworkResult<KlientlarSahifa>? {
        when {
            response.message().contains("timeout") -> {
                return NetworkResult.Error("TimeOut")
            }
            response.code() == 401 -> {
                return NetworkResult.Error("UnAuthorized request")
            }
            response.isSuccessful -> {
                val klientData = response.body()
                return NetworkResult.Success(klientData!!)
            }
            else -> {
                return NetworkResult.Error(response.message())
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun hasInternetConnection(): Boolean {
        val connectivityManager =
            getApplication<Application>().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }
}
