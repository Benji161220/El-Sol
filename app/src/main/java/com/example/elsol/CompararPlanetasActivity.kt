package com.example.elsol

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity


class CompararPlanetasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comparar_planetas)

        val listaPlanetas: MutableList<Planeta?> = ArrayList<Planeta?>()
        listaPlanetas.add(Planeta("Mercurio", 0.382, 0.387, 5400))
        listaPlanetas.add(Planeta("Venus", 0.949, 0.723, 5250))
        listaPlanetas.add(Planeta("Tierra", 1.0, 1.0, 5520))
        listaPlanetas.add(Planeta("Marte", 0.53, 1.542, 3960))
        listaPlanetas.add(Planeta("Júpiter", 11.2, 5.203, 1350))
        listaPlanetas.add(Planeta("Saturno", 9.41, 9.539, 700))
        listaPlanetas.add(Planeta("Urano", 3.38, 19.81, 1200))
        listaPlanetas.add(Planeta("Neptuno", 3.81, 30.07, 1500))
        listaPlanetas.add(Planeta("Plutón", 0.0, 39.44, 5))
        val adapter = ArrayAdapter<Planeta?>(
            this,
            android.R.layout.simple_dropdown_item_1line, listaPlanetas
        )
        val auto = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView1)

        auto.setAdapter(adapter)
        auto.threshold = 1
        auto.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val planetaSeleccionado =
                    auto.getAdapter().getItem(position) as Planeta
                diametro1.setText(planetaSeleccionado.diametro.toString())
                distancia1.setText(planetaSeleccionado.distanciaAlSol.toString())
                densidad1.setText(planetaSeleccionado.densidad.toString())
            }
        })
    }
}

