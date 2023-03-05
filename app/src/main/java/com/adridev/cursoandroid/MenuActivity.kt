package com.adridev.cursoandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.adridev.cursoandroid.imccalculator.ImcCalculatorActivity
import com.adridev.cursoandroid.superheroapp.SuperHeroListActivity
import com.adridev.cursoandroid.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

//      val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnToDo = findViewById<Button>(R.id.btnToDoApp)
        val btnSuperhero = findViewById<Button>(R.id.btnSuperHero)

//      btnSaludApp.setOnClickListener { navigateToSaludApp() }
        btnIMCApp.setOnClickListener { navigateToIMCApp() }
        btnToDo.setOnClickListener { navigateToToDoApp() }
        btnSuperhero.setOnClickListener { navigateToSuperHeroApp() }
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