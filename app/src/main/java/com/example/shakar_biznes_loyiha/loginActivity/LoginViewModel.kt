package com.example.shakar_biznes_loyiha.loginActivity

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.shakar_biznes_loyiha.models.LoginResponseX
import com.example.shakar_biznes_loyiha.data.network.Resources
import com.example.shakar_biznes_loyiha.repository.Repository
import com.example.shakar_biznes_loyiha.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: Repository,
    application: Application
) : AndroidViewModel(application) {
    private val _loginResponse: MutableLiveData<NetworkResult<LoginResponseX>> =
        MutableLiveData()
    val loginResponse: LiveData<NetworkResult<LoginResponseX>> get() = _loginResponse

    @RequiresApi(Build.VERSION_CODES.M)
    fun login(login: String, password: String) = viewModelScope.launch {
        loginSafeCall(login, password)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    suspend fun loginSafeCall(login: String, password: String) {
        _loginResponse.value = NetworkResult.Loading()
        if (hasInternetConnection()) {
            try {
                val response = loginRepository.remote.login(login, password)
                _loginResponse.value = handleLoginResponse(response)
            } catch (e: Exception) {
                _loginResponse.value = NetworkResult.Error(e.message)
            }
        } else {
            _loginResponse.value = NetworkResult.Error("No Internet Connection")
        }
    }

    fun handleLoginResponse(response: Response<LoginResponseX>): NetworkResult<LoginResponseX>? {
        when {
            response.message().toString().contains("timeout") -> {
                return NetworkResult.Error("TimeOut")
            }
            response.code() == 401 -> {
                return NetworkResult.Error("UnAuthorized request")
            }
            response.isSuccessful -> {
                val loginData = response.body()
                return NetworkResult.Success(loginData!!)
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