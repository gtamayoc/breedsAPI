package com.example.breeds.Views.Adapters

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.breeds.Models.Cat
import com.example.breeds.R

class BreedAdapter(private var breeds: List<Cat>) :
    RecyclerView.Adapter<BreedAdapter.BreedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_breed, parent, false)
        return BreedViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
        val breed = breeds[position]
        holder.bind(breed)
    }

    override fun getItemCount() = breeds.size


    fun updateBreeds(newBreeds: List<Cat>) {
        breeds = newBreeds
        notifyDataSetChanged()
    }

    class BreedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val breedName = itemView.findViewById<TextView>(R.id.breedName)
        private val breedOrigin = itemView.findViewById<TextView>(R.id.breedOrigin)
        private val breedIntelligence = itemView.findViewById<TextView>(R.id.breedIntelligence)
        private val breedImage = itemView.findViewById<ImageView>(R.id.breedImage)

        fun bind(breed: Cat) {
            breedName.text = breed.name
            breedOrigin.text = breed.origin
            breedIntelligence.text = breed.intelligence.toString()
            Glide.with(itemView)
                .load("https://cdn2.thecatapi.com/images/"+breed.reference_image_id+".jpg")
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(breedImage)
        }
    }

}