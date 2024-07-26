package com.example.administrador_gastos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormularioRegistro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_registro)
        var boton: Button
        boton=findViewById(R.id.button2)

        boton.setOnClickListener {
            var campo1 = true
            var campo2 = true
            var campo3 = true
            var campo4 = true

            val txtnombre: EditText = findViewById(R.id.txtnombre)
            val txtusuario: EditText = findViewById(R.id.txtusuario)
            val txtpassw: EditText = findViewById(R.id.txtpassw)
            val txtemail: EditText = findViewById(R.id.txtemail)

            txtnombre.error = null
            txtusuario.error = null
            txtpassw.error = null
            txtemail.error = null

            if (txtnombre.text.toString().isEmpty()){
                campo1 = false
                txtnombre.error = "Campo requerido"
            }
            if (txtusuario.text.toString().isEmpty()){
                campo2 = false
                txtusuario.error = "Campo requerido"
            }
            if (txtpassw.text.toString().isEmpty()){
                campo3 = false
                txtpassw.error = "Campo requerido"
            }
            if (txtemail.text.toString().isEmpty()){
                campo4 = false
                txtemail.error = "Campo requerido"
            }
            if (campo1 == true && campo2 == true && campo3 == true && campo4 == true) {
                val intent = Intent(this@FormularioRegistro, MainActivity::class.java)
                startActivity(intent)
                /*Toast.makeText(
                    this@FormularioRegistro,
                    "Datos capturados \nNombre: "+txtnombre.text.toString()+"\nUsuario: "
                            +txtusuario.text.toString()+"\nContraseña: "+txtpassw.text.toString()
                            +"\nCorreo: "+txtemail.text.toString(),
                    Toast.LENGTH_LONG
                ).show()*/
                Toast.makeText(
                    this@FormularioRegistro,
                    "Datos capturados ",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}