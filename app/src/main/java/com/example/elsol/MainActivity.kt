package com.example.elsol

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.compara_planetas -> {
                startActivity(Intent(this, CompararPlanetasActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}