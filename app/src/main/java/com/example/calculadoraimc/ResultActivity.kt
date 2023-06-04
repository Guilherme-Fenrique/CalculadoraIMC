package com.example.calculadoraimc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        //Ativa botão voltar na toolbar
        supportActionBar?.setHomeButtonEnabled(true)
        //Ativa visibilidade do botão voltar na toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvImc: TextView = findViewById(R.id.tvIMC)
        val imc: Float = intent.getFloatExtra("EXTRA_IMC",0.1f)
        tvImc.text = String.format("%.2f",imc)

        var classificacao = ""
        val tvClassificacao: TextView = findViewById(R.id.textview_classificacao)
        if(imc < 18.5f){
            tvClassificacao.setTextColor(Color.parseColor("#FFFF00"))
            classificacao= "Abaixo do Peso"
        }else if (imc in 18.5f..24.9f){
            tvClassificacao.setTextColor(Color.parseColor("#0B6623"))
            classificacao = "Peso Normal"
        }else if (imc in 25.0f..29.9f){
            tvClassificacao.setTextColor(Color.parseColor("#FFFF00"))
            classificacao = "Obesidade"
        }else if (imc in 30.0f..39.9f){
            tvClassificacao.setTextColor(Color.parseColor("#FFA500"))
            classificacao = "Obesidade II"
        }else{
            tvClassificacao.setTextColor(Color.parseColor("#FF0000"))
            classificacao = "Obesidade III"
        }
        tvClassificacao.text = getString(R.string.message_classificacao,classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}