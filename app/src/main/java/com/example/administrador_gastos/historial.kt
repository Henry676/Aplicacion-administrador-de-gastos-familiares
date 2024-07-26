package com.example.administrador_gastos

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class historial : AppCompatActivity() {
    private lateinit var luz: MutableList<String>
    private lateinit var agua: MutableList<String>
    private lateinit var internet: MutableList<String>
    private lateinit var gas: MutableList<String>
    private lateinit var comida: MutableList<String>
    private lateinit var transporte: MutableList<String>
    private lateinit var cine: MutableList<String>
    private lateinit var estacionamiento: MutableList<String>

    private lateinit var currentList: MutableList<String>

    private lateinit var miRecyclerView: RecyclerView
    private lateinit var miAdapter: AdaptadorHistorial
    private lateinit var miLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial)

        val buscadorGastos: AutoCompleteTextView = findViewById(R.id.buscador)
        val gastos = resources.getStringArray(R.array.historial)

        val gastosRegistrados: Spinner = findViewById(R.id.spinner_registro)

        ArrayAdapter(this, android.R.layout.simple_list_item_1, gastos).also { adapter ->
            buscadorGastos.setAdapter(adapter)
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.registro,
            android.R.layout.simple_list_item_1
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            gastosRegistrados.adapter = adapter
        }

        luz = gastosLuz()
        agua = gastosAgua()
        internet = gastosInternet()
        gas = gastosGas()
        comida = gastosComida()
        transporte = gastosTransporte()
        cine = gastosCine()
        estacionamiento = gastosEstacionamiento()

        currentList = luz
        val  alert = AlertDialog.Builder(this@historial)
        alert.setMessage("¿Esta seguro de querer eliminar este registro?")
        alert.setTitle("Alerta")
        alert.setCancelable(false)

        miRecyclerView = findViewById(R.id.recyclerView)
        miLayoutManager = LinearLayoutManager(this)
        miAdapter = AdaptadorHistorial(currentList, R.layout.recycler_view_item, object : AdaptadorHistorial.OnItemClickListener {
            override fun onItemClick(name: String?, position: Int) {
                //Toast.makeText(this@historial, "$name - $position", Toast.LENGTH_LONG).show()
                alert.setPositiveButton("Si") {_,_ ->
                    deleteName(position)
                }
                alert.setNegativeButton("No"){_,_->
                    Toast.makeText(this@historial, "Operación abortada",Toast.LENGTH_LONG).show()
                }
                alert.setNeutralButton("Cancelar"){_,_->
                    Toast.makeText(this@historial, "Operación cancelada",Toast.LENGTH_LONG).show()
                }
                val dialogoAlerta = alert.create()
                dialogoAlerta.show()
            }
        })
        miRecyclerView.layoutManager = miLayoutManager
        miRecyclerView.adapter = miAdapter

        gastosRegistrados.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedCategory = parent?.getItemAtPosition(position).toString()
                currentList = when (selectedCategory) {
                    "Luz" -> luz
                    "Agua" -> agua
                    "Gas" -> gas
                    "Internet" -> internet
                    "Comida" -> comida
                    "Transporte" -> transporte
                    "Cine" -> cine
                    "Estacionamientos" -> estacionamiento
                    else -> mutableListOf() // Default empty list
                }
                updateRecyclerView(currentList)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun updateRecyclerView(newList: MutableList<String>) {
        miAdapter.updateData(newList)
    }

    private fun deleteName(posicion: Int) {
        currentList.removeAt(posicion)
        miAdapter.notifyItemRemoved(posicion)
        miAdapter.notifyItemRangeChanged(posicion, currentList.size)
    }

    private fun gastosLuz(): MutableList<String> {
        return mutableListOf(
            "CFE 20 de enero 2016------1500 MXN",
            "CFE 20 de marzo 2016------1500 MXN",
            "CFE 20 de mayo 2016-------1500 MXN",
            "CFE 20 de julio 2016------1500 MXN",
            "CFE 20 de septiembre 2016-1500 MXN",
            "CFE 20 de noviembre 2016--1500 MXN",
            "CFE 20 de enero 2017------1500 MXN",
            "CFE 20 de marzo 2017------1500 MXN",
            "CFE 20 de mayo 2017-------1500 MXN",
            "CFE 20 de julio 2017------1500 MXN",
            "CFE 20 de septiembre 2017-1500 MXN",
            "CFE 20 de noviembre 2017--1500 MXN"
        )
    }

    private fun gastosAgua(): MutableList<String> {
        return mutableListOf(
            "SIAPA 20 de enero 2016------600 MXN",
            "SIAPA 20 de marzo 2016------600 MXN",
            "SIAPA 20 de mayo 2016-------600 MXN",
            "SIAPA 20 de julio 2016------600 MXN",
            "SIAPA 20 de septiembre 2016-600 MXN",
            "SIAPA 20 de noviembre 2016--600 MXN",
            "SIAPA 20 de enero 2017------600 MXN",
            "SIAPA 20 de marzo 2017------600 MXN",
            "SIAPA 20 de mayo 2017-------600 MXN",
            "SIAPA 20 de julio 2017------600 MXN",
            "SIAPA 20 de septiembre 2017-600 MXN",
            "SIAPA 20 de noviembre 2017--600 MXN"
        )
    }

    private fun gastosInternet(): MutableList<String> {
        return mutableListOf(
            "TOTALPLAY 20 de enero 2016------670 MXN",
            "TOTALPLAY 20 de febrero 2016------670 MXN",
            "TOTALPLAY 20 de marzo 2016-------670 MXN",
            "TOTALPLAY 20 de abril 2016------670 MXN",
            "TOTALPLAY 20 de mayo 2016-670 MXN",
            "TOTALPLAY 20 de junio 2016--670 MXN",
            "TOTALPLAY 20 de julio 2016------670 MXN",
            "TOTALPLAY 20 de agosto 2016------670 MXN",
            "TOTALPLAY 20 de septiembre 2016-------670 MXN",
            "TOTALPLAY 20 de octubre 2016------670 MXN",
            "TOTALPLAY 20 de noviembre 2016-670 MXN",
            "TOTALPLAY 20 de diciembre 2016--670 MXN"
        )
    }

    private fun gastosGas(): MutableList<String> {
        return mutableListOf(
            "Z GAS 20 de enero 2016------1200 MXN",
            "Z GAS  20 de marzo 2016------1200 MXN",
            "Z GAS  20 de mayo 2016-------1200 MXN",
            "Z GAS  20 de julio 2016------1200 MXN",
            "Z GAS  20 de septiembre 2016-1200 MXN",
            "Z GAS  20 de noviembre 2016--1200 MXN",
            "Z GAS  20 de enero 2017------1200 MXN",
            "Z GAS  20 de marzo 2017------1200 MXN",
            "Z GAS  20 de mayo 2017-------1200 MXN",
            "Z GAS  20 de julio 2017------1200 MXN",
            "Z GAS  20 de septiembre 2017-1200 MXN",
            "Z GAS  20 de noviembre 2017--1200 MXN"
        )
    }

    private fun gastosTransporte(): MutableList<String> {
        return mutableListOf(
            "Uber 20 de enero 2016------100 MXN",
            "Didi 15 de enero 2016------80 MXN",
            "Gasolina 7 de enero 2016-------700 MXN",
            "Camion 1 de enero 2016------10 MXN",
            "Uber 22 de enero 2016-150 MXN",
        )
    }

    private fun gastosCine(): MutableList<String> {
        return mutableListOf(
            "Avengers 20 de enero 2018------160 MXN",
            "Toy story 5 19 de junio 2019------80 MXN",
            "Spiderman 20 de mayo 2023-------160 MXN",
        )
    }

    private fun gastosComida(): MutableList<String> {
        return mutableListOf(
            "Tacos 20 de enero 2022------400 MXN",
            "1 kg de jamon 18 de enero 2022------75 MXN",
            "1 kg de tortillas 10 de enero 2022-------25 MXN",
            "2 bolillos 20 de enero 2022------8 MXN",
        )
    }

    private fun gastosEstacionamiento(): MutableList<String> {
        return mutableListOf(
            "Colomos 20 de enero 2024------30 MXN",
            "Sam's club 20 de enero 2024------12 MXN",
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_borrar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.add_name -> {
                Toast.makeText(this, "Para eliminar un registro, haga click en uno", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
