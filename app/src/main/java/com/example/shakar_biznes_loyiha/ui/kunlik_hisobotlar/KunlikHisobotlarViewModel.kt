package com.example.shakar_biznes_loyiha.ui.kunlik_hisobotlar

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shakar_biznes_loyiha.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KunlikHisobotlarViewModel @Inject constructor(
    repository: Repository,
    application: Application
) : AndroidViewModel(application) {


}