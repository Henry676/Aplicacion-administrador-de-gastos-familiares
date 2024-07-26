package com.example.administrador_gastos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class seccionExtras : AppCompatActivity() {
    private val listaGastos = mutableListOf<String>()
    var agregar: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seccion_extras)
        val boton1: Button = findViewById(R.id.addRecyclerExtra)
        val boton2: Button = findViewById(R.id.showRecyclerExtra)
        val txtExtras: EditText = findViewById(R.id.txtTipoExtra)
        val txtccantidad: EditText = findViewById(R.id.txtCantidadExtra)
        val txtdate: EditText = findViewById(R.id.txtFechaExtra)
        val txtcosto: EditText = findViewById(R.id.txtTotalExtra)

        txtdate.setOnClickListener{ showDatePickerDialog()}

        txtExtras.error = null
        txtccantidad.error = null
        txtdate.error = null
        txtcosto.error = null

        boton1.setOnClickListener {
            agregar++
            var campo1 = true
            var campo2 = true
            var campo3 = true
            var campo4 = true
            if (txtExtras.text.toString().isEmpty()){
                campo1 = false
                txtExtras.error = "Campo requerido"
            }
            if (txtccantidad.text.toString().isEmpty()){
                campo2 = false
                txtccantidad.error = "Campo requerido"
            }
            if (txtdate.text.toString().isEmpty()){
                campo3 = false
                txtdate.error = "Campo requerido"
            }
            if (txtcosto.text.toString().isEmpty()){
                campo4 = false
                txtcosto.error = "Campo requerido"
            }
            if (campo1 && campo2 && campo3 && campo4) {
                agregarGasto()
                Toast.makeText(this@seccionExtras, "Gasto registrado", Toast.LENGTH_LONG).show()
            }
        }

        boton2.setOnClickListener {
            var campo1 = true
            var campo2 = true
            var campo3 = true
            var campo4 = true
            if (txtExtras.text.toString().isEmpty()){
                campo1 = false
                txtExtras.error = "Campo requerido"
            }
            if (txtccantidad.text.toString().isEmpty()){
                campo2 = false
                txtccantidad.error = "Campo requerido"
            }
            if (txtdate.text.toString().isEmpty()){
                campo3 = false
                txtdate.error = "Campo requerido"
            }
            if (txtcosto.text.toString().isEmpty()){
                campo4 = false
                txtcosto.error = "Campo requerido"
            }
            if (campo1 && campo2 && campo3 && campo4 && agregar > 0) {
                abrirRecyclerView()
                Toast.makeText(this@seccionExtras, "Accediendo a los últimos gastos registrados", Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun showDatePickerDialog() {
        val datePicker= DatePickerFragment {day,month,year->onDateSelected(day,month,year)}
        datePicker.show(supportFragmentManager, "datePicker")
    }
    fun onDateSelected(day:Int, month: Int, year: Int){
        val txtdate: EditText = findViewById(R.id.txtFechaExtra)
        txtdate.setText("$day/$month/$year")
    }

    private fun agregarGasto() {
        // Obtener referencias a los EditText
        val txtExtr: EditText = findViewById(R.id.txtTipoExtra)
        val txtccantidad: EditText = findViewById(R.id.txtCantidadExtra)
        val txtdate: EditText = findViewById(R.id.txtFechaExtra)
        val txtcosto: EditText = findViewById(R.id.txtTotalExtra)

        // Crear el string del gasto y agregarlo a la lista
        val nombre = txtExtr.text.toString()
        val cantidad = txtccantidad.text.toString()
        val fecha = txtdate.text.toString()
        val total = txtcosto.text.toString()

        val gasto = "Nombre: $nombre, cantidad: $cantidad, Fecha: $fecha, Total: $total"
        listaGastos.add(gasto)
    }

    private fun abrirRecyclerView() {
        // Abrir la actividad del RecyclerView y pasar la lista de gastos
        val intent = Intent(this@seccionExtras, RecyclerTransporte::class.java)
        intent.putStringArrayListExtra("listaGastos", ArrayList(listaGastos))
        startActivity(intent)
    }
}