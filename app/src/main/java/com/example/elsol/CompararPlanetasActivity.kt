package com.example.elsol

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CompararPlanetasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comparar_planetas)

        val auto1 = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView1)
        val auto2 = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView2)

        val diametro1 = findViewById<TextView>(R.id.diametro1)
        val distancia1 = findViewById<TextView>(R.id.distancia1)
        val densidad1  = findViewById<TextView>(R.id.densidad1)

        val diametro2 = findViewById<TextView>(R.id.diametro2)
        val distancia2 = findViewById<TextView>(R.id.distancia2)
        val densidad2  = findViewById<TextView>(R.id.densidad2)

        // 2) Datos (no nulos; más simple)
        val listaPlanetas = mutableListOf(
            Planeta("Mercurio", 0.382, 0.387, 5400),
            Planeta("Venus",    0.949, 0.723, 5250),
            Planeta("Tierra",   1.0,   1.0,   5520),
            Planeta("Marte",    0.53,  1.542, 3960),
            Planeta("Júpiter",  11.2,  5.203, 1350),
            Planeta("Saturno",  9.41,  9.539, 700),
            Planeta("Urano",    3.38,  19.81, 1200),
            Planeta("Neptuno",  3.81,  30.07, 1500),
            Planeta("Plutón",   0.0,   39.44, 5)
        )


        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, listaPlanetas)
        auto1.setAdapter(adapter)
        auto2.setAdapter(adapter)
        auto1.threshold = 1
        auto2.threshold = 1

        fun renderA(p: Planeta) {
            diametro1.text = p.diametro.toString()
            distancia1.text = p.distanciaAlSol.toString()
            densidad1.text = p.densidad.toString()
        }
        fun renderB(p: Planeta) {
            diametro2.text = p.diametro.toString()
            distancia2.text = p.distanciaAlSol.toString()
            densidad2.text = p.densidad.toString()
        }

        auto1.setOnItemClickListener { parent, _, position, _ ->
            val planeta = parent.adapter.getItem(position) as Planeta
            renderA(planeta)
        }
        auto2.setOnItemClickListener { parent, _, position, _ ->
            val planeta = parent.adapter.getItem(position) as Planeta
            renderB(planeta)
        }
    }
}
