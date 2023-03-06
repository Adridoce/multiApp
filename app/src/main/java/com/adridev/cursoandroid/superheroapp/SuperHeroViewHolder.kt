package com.adridev.cursoandroid.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.adridev.cursoandroid.databinding.ItemSuperheroBinding

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superHeroItemResponse: SuperHeroItemResponse){
        binding.tvSuperHeroName.text = superHeroItemResponse.superheroName
    }
}