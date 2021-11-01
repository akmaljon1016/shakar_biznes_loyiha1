package com.example.shakar_biznes_loyiha.ui.bosh_sahifa

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.*
import com.example.shakar_biznes_loyiha.data.database.Entity.BoshSahifaEntity
import com.example.shakar_biznes_loyiha.models.boshSahifa.BoshSahifa
import com.example.shakar_biznes_loyiha.repository.Repository
import com.example.shakar_biznes_loyiha.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class BoshSahifaViewModel @Inject constructor(
    private val repository: Repository,
    application: Application
) :
    AndroidViewModel(application) {

    /**BoshSahifaData**/
    val readBoshSahifaData: LiveData<BoshSahifaEntity> =
        repository.local.readBoshSahifaData().asLiveData()

    fun insertBoshSahifaData(boshSahifaEntity: BoshSahifaEntity) = viewModelScope.launch {
        repository.local.insertBoshSahifaData(boshSahifaEntity)
    }

    /**Retrofit**/
    private val _boshSahifaData: MutableLiveData<NetworkResult<BoshSahifa>> = MutableLiveData()
    val boshSahifaData: LiveData<NetworkResult<BoshSahifa>> get() = _boshSahifaData

    @RequiresApi(Build.VERSION_CODES.M)
    fun getBoshSahifaData() = viewModelScope.launch {
        getBoshSahifaDataSafeCall()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    suspend private fun getBoshSahifaDataSafeCall() {
        _boshSahifaData.value = NetworkResult.Loading()
        if (hasInternetConnection()) {
            try {
                val response = repository.remote.getBoshSahifaData()
                _boshSahifaData.value = handleBoshSahifaResponse(response)
                val data = boshSahifaData.value!!.data
                if (data != null) {
                    offlineCacheData(data)
                }
            } catch (e: Exception) {
                _boshSahifaData.value = NetworkResult.Error(e.message)
            }
        } else {
            _boshSahifaData.value = NetworkResult.Error("No Internet Connection")
        }
    }

    private fun offlineCacheData(data: BoshSahifa) {
        val boshSahifaEntity = BoshSahifaEntity(data)
        insertBoshSahifaData(boshSahifaEntity)
    }

    private fun handleBoshSahifaResponse(response: Response<BoshSahifa>): NetworkResult<BoshSahifa>? {
        when {
            response.message().contains("timeout") -> {
                return NetworkResult.Error("TimeOut")
            }
            response.code() == 401 -> {
                return NetworkResult.Error("UnAuthorized request")
            }
            response.isSuccessful -> {
                val boshSahifaData = response.body()
                return NetworkResult.Success(boshSahifaData!!)
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