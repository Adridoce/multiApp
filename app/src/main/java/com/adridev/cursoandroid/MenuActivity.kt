package com.adridev.cursoandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.adridev.cursoandroid.databinding.ActivityMenuBinding
import com.adridev.cursoandroid.imccalculator.ImcCalculatorActivity
import com.adridev.cursoandroid.superheroapp.SuperHeroListActivity
import com.adridev.cursoandroid.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

//      btnSaludApp.setOnClickListener { navigateToSaludApp() }
        binding.btnIMCApp.setOnClickListener { navigateToIMCApp() }
        binding.btnToDoApp.setOnClickListener { navigateToToDoApp() }
        binding.btnSuperHero.setOnClickListener { navigateToSuperHeroApp() }
    }

    private fun navigateToSuperHeroApp() {
        val intent = Intent(this, SuperHeroListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToToDoApp() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToIMCApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludApp() {
        //val intent = Intent(this, OTRAACTIVIDAD::class.java)
        //startActivity(intent)
    }
}