package com.example.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtPeso: EditText= findViewById(R.id.edtPeso)
        val tvAltura: TextView = findViewById(R.id.tvAlturaVal)
        val seekAltura: SeekBar = findViewById(R.id.seekAltura)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val tvResultado: TextView = findViewById(R.id.tvResultado)

        seekAltura.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Atualize o texto da TextView com base no progresso
                tvAltura.text = (progress / 100.0f).toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Este método é chamado quando o usuário começa a interagir com o SeekBar
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Este método é chamado quando o usuário para de interagir com o SeekBar
            }
        })

        btnCalcular.setOnClickListener{
            val pesoStr = edtPeso.text.toString()
            val altuaStr = tvAltura.text.toString()
            if (pesoStr.isNotEmpty() && altuaStr.isNotEmpty()){
                val peso:Float = pesoStr.toFloat()
                val altura:Float = altuaStr.toFloat()
                val resultado:Float = peso / (altura * altura)

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_IMC", resultado)
                    }
                startActivity(intent)
            }else{
                val toast = Toast.makeText(this,"Preencha todos os campos", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER,0,0)
                toast.show()
            }
        }

    }
}






