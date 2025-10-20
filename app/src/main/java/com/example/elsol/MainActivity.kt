package com.example.elsol

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recycler: RecyclerView
    private lateinit var adapter: SolarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        recycler = findViewById(R.id.recyclerview)

        val data = mutableListOf(
            SolarItem("corona solar", R.drawable.corona_solar),
            SolarItem("erupción solar", R.drawable.erupcionsolar),
            SolarItem("espículas", R.drawable.espiculas),
            SolarItem("filamentos", R.drawable.filamentos),
            SolarItem("sol verde", R.drawable.magnetosfera),
            SolarItem("manchas", R.drawable.manchasolar)
        )

        adapter = SolarAdapter(data)
        recycler.layoutManager = GridLayoutManager(this, 2)
        recycler.adapter = adapter

    }
}