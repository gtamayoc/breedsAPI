package com.example.breeds.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.breeds.Data.ApiHelper
import com.example.breeds.Models.Cat
import kotlinx.coroutines.launch

class CatViewModel : ViewModel() {
    private val apiHelper = ApiHelper()
    private val breeds = MutableLiveData<List<Cat>>()
    private val errorMessage = MutableLiveData<String>()

    fun getBreeds() {
        viewModelScope.launch {
            try {
                val result = apiHelper.getBreeds()
                breeds.postValue(result)
            } catch (e: Exception) {
                errorMessage.postValue(e.message)
            }
        }
    }

    fun getBreedsLiveData(): LiveData<List<Cat>> = breeds

    fun getErrorMessage(): LiveData<String> = errorMessage

}