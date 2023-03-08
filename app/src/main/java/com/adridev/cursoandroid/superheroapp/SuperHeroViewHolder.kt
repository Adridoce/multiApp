package com.adridev.cursoandroid.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.adridev.cursoandroid.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superHeroItemResponse: SuperHeroItemResponse, onItemSelected: (String) -> Unit){
        binding.tvSuperHeroName.text = superHeroItemResponse.superheroName

        Picasso.get().load(superHeroItemResponse.superheroImage.url).into(binding.ivSuperhero)
        binding.root.setOnClickListener { onItemSelected(superHeroItemResponse.superheroId) }
    }
}