package com.example.breeds.Models

data class Cat(
    val id: String,
    val name: String,
    val origin: String,
    val temperament: String,
    val description: String,
    val intelligence: Int,
    val wikipedia_url: String,
    val reference_image_id: String
)

