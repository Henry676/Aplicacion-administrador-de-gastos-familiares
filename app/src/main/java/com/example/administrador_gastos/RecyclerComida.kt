package com.example.administrador_gastos

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Date


class RecyclerComida : AppCompatActivity() {
    private lateinit var miRecyclerView: RecyclerView
    private lateinit var miAdapter: AdaptadorComida
    private lateinit var miLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_comida)

        // Obtener la lista de gastos desde el intent
        val listaGastos = intent.getStringArrayListExtra("listaGastos")

        miRecyclerView = findViewById(R.id.recyclerViewComida)
        miLayoutManager = LinearLayoutManager(this)
        miRecyclerView.layoutManager = miLayoutManager

        // Crear y asignar el adaptador con la lista de gastos
        miAdapter = AdaptadorComida(
            listaGastos ?: ArrayList(),
            R.layout.recycler_view_item,
            object : AdaptadorComida.OnItemClickListener {
                override fun onItemClick(name: String?, position: Int) {
                    Toast.makeText(
                        this@RecyclerComida,
                        name + " - " + position,
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
        miRecyclerView.adapter = miAdapter
    }
}
