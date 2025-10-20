package com.example.elsol

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity

class CompararPlanetasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comparar_planetas)

        val peliculas = arrayOf(
            "Scarface", "Titanic", "Pretty Woman",
            "Star Wars", "El rey León", "E.T."
        )

        val auto = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)

        val adapter = ArrayAdapter(
            this,                                  // contexto de Activity
            android.R.layout.simple_dropdown_item_1line,
            peliculas
        )
        auto.setAdapter(adapter)
        auto.threshold = 1 // sugiere a partir de 1 carácter (opcional)
    }
}

