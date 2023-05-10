package com.example.breeds.Data

import com.example.breeds.Interfaces.ApiService
import com.example.breeds.Models.Cat
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiHelper {
    private val apiService: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiService::class.java)
    }

    suspend fun getBreeds(): List<Cat> = apiService.getBreeds()
}