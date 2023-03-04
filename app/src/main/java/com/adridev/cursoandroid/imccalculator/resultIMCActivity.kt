package com.adridev.cursoandroid.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.adridev.cursoandroid.R
import com.adridev.cursoandroid.imccalculator.ImcCalculatorActivity.Companion.IMC_KEY

class resultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvImc: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnRecalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)

        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0

        initComponents()
        initUI(result)
        initListeners()
    }

    private fun initComponents() {

        tvResult = findViewById(R.id.tvResult)
        tvImc = findViewById(R.id.tvImc)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalcular = findViewById(R.id.btnRecalcular)
    }

    private fun initUI(result: Double) {

        tvImc.text = result.toString()

        when (result) {

            in 0.00..18.50 -> {   //Bajo peso
                tvResult.text = getString(R.string.title_peso_bajo)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
                tvDescription.text = getString(R.string.description_peso_bajo)
            }
            in 18.51..24.99 -> {  // Peso normal
                tvResult.text = getString(R.string.title_peso_normal)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
                tvDescription.text = getString(R.string.description_peso_normal)
            }
            in 25.00..29.99 -> {  // Sobrepeso
                tvResult.text = getString(R.string.title_peso_sobrepeso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_sobrepeso))
                tvDescription.text = getString(R.string.description_peso_sobrepeso)
            }
            in 30.00..99.00 -> {  // Obesidad
                tvResult.text = getString(R.string.title_peso_obesidad)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_obesidad))
                tvDescription.text = getString(R.string.description_peso_obesidad)
            }
            else -> {
                tvImc.text = getString(R.string.error)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_obesidad))
                tvResult.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
            }
        }
    }

    private fun initListeners() {

        btnRecalcular.setOnClickListener { onBackPressed() }
    }


}