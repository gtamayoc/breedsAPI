package com.example.breeds.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.breeds.Interfaces.ApiService
import com.example.breeds.R
import com.example.breeds.ViewModels.CatViewModel
import com.example.breeds.Views.Adapters.BreedAdapter
import com.example.breeds.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ViewCats : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var catViewModel: CatViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.breedRecyclerView.layoutManager = LinearLayoutManager(this)

        var breedAdapter = BreedAdapter(emptyList())
        binding.breedRecyclerView.adapter = breedAdapter
        binding.breedRecyclerView.layoutManager = LinearLayoutManager(this)

        catViewModel = ViewModelProvider(this).get(CatViewModel::class.java)

        catViewModel.getBreedsLiveData().observe(this, Observer {
            breedAdapter.updateBreeds(it)
        })

        catViewModel.getErrorMessage().observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        catViewModel.getBreeds()
    }
}