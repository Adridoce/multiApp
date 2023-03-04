package com.adridev.cursoandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.adridev.cursoandroid.imccalculator.ImcCalculatorActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    //      Navegar a una actividad del paquete
//        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
//        btnSaludApp.setOnClickListener { navigateToSaludApp() }
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        btnIMCApp.setOnClickListener { navigateToIMCApp() }
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