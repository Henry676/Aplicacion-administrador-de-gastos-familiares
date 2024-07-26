package com.example.administrador_gastos

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerServicios : AppCompatActivity() {

    private lateinit var miRecyclerView: RecyclerView
    private lateinit var miAdapter: AdaptadorServicios
    private lateinit var miLayoutManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_servicios)
        // Obtener la lista de gastos desde el intent
        val listaGastos = intent.getStringArrayListExtra("listaGastos")

        miRecyclerView = findViewById(R.id.recyclerViewServicios)
        miLayoutManager = LinearLayoutManager(this)
        miRecyclerView.layoutManager = miLayoutManager

        // Crear y asignar el adaptador con la lista de gastos
        miAdapter = AdaptadorServicios(
            listaGastos ?: ArrayList(),
            R.layout.recycler_view_item,
            object : AdaptadorServicios.OnItemClickListener {
                override fun onItemClick(name: String?, position: Int) {
                    Toast.makeText(
                        this@RecyclerServicios,
                        name + " - " + position,
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
        miRecyclerView.adapter = miAdapter
    }
}