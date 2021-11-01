package com.example.shakar_biznes_loyiha.loginActivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class LoginViewModelFactory(private val repository: LoginRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
           // modelClass.isAssignableFrom(LoginViewModel::class.java) -> LoginViewModel(repository as LoginRepository) as T
            else -> throw IllegalArgumentException("ViewModelClass not found")
        }
    }
}