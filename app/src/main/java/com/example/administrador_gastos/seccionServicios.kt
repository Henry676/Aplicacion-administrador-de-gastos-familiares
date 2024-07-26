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

class seccionServicios : AppCompatActivity() {
    private val listaGastos = mutableListOf<String>()
    var agregar: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seccion_servicios)
        val boton1: Button = findViewById(R.id.addRecyclerServicio)
        val boton2: Button = findViewById(R.id.showRecyclerServicio)
        val txtservicio: EditText = findViewById(R.id.txtTipoServicio)
        val txtdate: EditText = findViewById(R.id.txtFechaServicio)
        val txtcosto: EditText = findViewById(R.id.txtTotalServicio)

        txtdate.setOnClickListener{ showDatePickerDialog()}

        txtservicio.error = null
        txtdate.error = null
        txtcosto.error = null

        boton1.setOnClickListener {
            agregar++
            var campo1 = true
            var campo2 = true
            var campo3 = true
            var campo4 = true
            if (txtservicio.text.toString().isEmpty()){
                campo1 = false
                txtservicio.error = "Campo requerido"
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
                Toast.makeText(this@seccionServicios, "Gasto registrado", Toast.LENGTH_LONG).show()
            }
        }

        boton2.setOnClickListener {
            var campo1 = true
            var campo2 = true
            var campo3 = true
            var campo4 = true
            if (txtservicio.text.toString().isEmpty()){
                campo1 = false
                txtservicio.error = "Campo requerido"
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
                Toast.makeText(this@seccionServicios, "Accediendo a los últimos gastos registrados", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun showDatePickerDialog() {
        val datePicker= DatePickerFragment {day,month,year->onDateSelected(day,month,year)}
        datePicker.show(supportFragmentManager, "datePicker")
    }
    fun onDateSelected(day:Int, month: Int, year: Int){
        val txtdate: EditText = findViewById(R.id.txtFechaServicio)
        txtdate.setText("$day/$month/$year")
    }

    private fun agregarGasto() {
        // Obtener referencias a los EditText
        val txtServ: EditText = findViewById(R.id.txtTipoServicio)
        val txtdate: EditText = findViewById(R.id.txtFechaServicio)
        val txtcosto: EditText = findViewById(R.id.txtTotalServicio)

        // Crear el string del gasto y agregarlo a la lista
        val nombre = txtServ.text.toString()
        val fecha = txtdate.text.toString()
        val total = txtcosto.text.toString()

        val gasto = "Nombre: $nombre, Fecha: $fecha, Total: $total"
        listaGastos.add(gasto)
    }

    private fun abrirRecyclerView() {
        // Abrir la actividad del RecyclerView y pasar la lista de gastos
        val intent = Intent(this@seccionServicios, RecyclerServicios::class.java)
        intent.putStringArrayListExtra("listaGastos", ArrayList(listaGastos))
        startActivity(intent)
    }
}