package com.eri.examenparcial1

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var xspinerTemperatura : Spinner
    lateinit var xeditTextCelcius : EditText
    lateinit var xbuttonCalcular : Button
    lateinit var xtextViewResultado : TextView
    lateinit var ximageKelvin : ImageView
    lateinit var ximageFahrenheit : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        xspinerTemperatura = findViewById(R.id.spinnerTemperatura)
        xeditTextCelcius = findViewById(R.id.editTextCelcius)
        xbuttonCalcular = findViewById(R.id.buttonCalcular)
        xtextViewResultado = findViewById(R.id.textViewResultado)
        ximageKelvin = findViewById(R.id.imagKelvin)
        ximageFahrenheit = findViewById(R.id.imageFare)


        val temperatura = arrayOf("Fahrenheit", "Kelvin")
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, temperatura)
        xspinerTemperatura.adapter = adaptador

        ximageKelvin.visibility = View.INVISIBLE
        ximageFahrenheit.visibility = View.INVISIBLE

    }
    fun CalcularTemperaturas(view : View){
        val temperatura = xspinerTemperatura.selectedItem.toString()



        if (xeditTextCelcius.text.toString().isNotEmpty()) {
            val celcius = xeditTextCelcius.text.toString().toDouble()
            var resultado = 0.0


            if (temperatura == "Fahrenheit") {
                resultado = (celcius * 1.8) + 32

                ximageFahrenheit.visibility = View.VISIBLE
                ximageKelvin.visibility = View.INVISIBLE
            } else if (temperatura == "Kelvin") {
                resultado = celcius + 273.15
                ximageKelvin.visibility = View.VISIBLE
                ximageFahrenheit.visibility = View.INVISIBLE
            }

            xtextViewResultado.text = String.format("%.2f", resultado) + " " + temperatura

        } else {

          Toast.makeText(this, "Ingrese un valor en Celcius", Toast.LENGTH_SHORT).show()

        }
    }
}