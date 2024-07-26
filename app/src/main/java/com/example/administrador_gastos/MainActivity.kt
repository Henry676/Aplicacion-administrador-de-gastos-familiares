package com.example.administrador_gastos

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var usuarioIcon: ImageView
    private lateinit var toggleButton: ToggleButton
    private lateinit var usuarioET: EditText
    private lateinit var contraET: EditText
    private lateinit var recordarContra: CheckBox
    private lateinit var restablePaswd: TextView
    private lateinit var cuenta: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar las vistas
        var boton: Button = findViewById(R.id.iniciarSesion)
        boton.setOnClickListener {
            var campoUsuario = true
            var campoPasswd = true

            val txtusuario: EditText = findViewById(R.id.campoUsuario)
            val txtpassw: EditText = findViewById(R.id.campoContraseña)

            txtusuario.error = null
            txtpassw.error = null

            if (txtusuario.text.toString().isEmpty()){
                campoUsuario = false
                txtusuario.error = "Campo requerido"
            }
            if (txtpassw.text.toString().isEmpty()){
                campoPasswd = false
                txtpassw.error = "Campo requerido"
            }
            if(campoUsuario == true && campoPasswd == true) {
                val intent = Intent(this@MainActivity, appPrincipal::class.java)
                startActivity(intent)
            }
        }

        var link: TextView = findViewById(R.id.crearCuenta)
        var link2: TextView = findViewById(R.id.restablecerContr)

        link.setOnClickListener {
            val intent = Intent(this@MainActivity, FormularioRegistro::class.java)
            startActivity(intent)
        }

        link2.setOnClickListener {
            val intent = Intent(this@MainActivity, RestablecerContrase::class.java)
            startActivity(intent)
        }

        imageView = findViewById(R.id.imageView2)
        usuarioET = findViewById(R.id.campoUsuario)
        contraET = findViewById(R.id.campoContraseña)
        usuarioIcon = findViewById(R.id.user)
        toggleButton = findViewById(R.id.toggleButton)
        recordarContra = findViewById(R.id.recordarPasswd)

        // Restaurar el estado del ToggleButton
        val sharedPreferences = getSharedPreferences("AppPreferences", MODE_PRIVATE)
        val isDarkMode = sharedPreferences.getBoolean("DarkMode", false)
        toggleButton.isChecked = isDarkMode

        // Aplicar el modo oscuro o claro según el estado restaurado
        applyDarkMode(isDarkMode)

        toggleButton.setOnCheckedChangeListener { _, isChecked ->
            val editor = sharedPreferences.edit()
            editor.putBoolean("DarkMode", isChecked)
            editor.apply()

            // Aplicar el modo oscuro o claro
            applyDarkMode(isChecked)
        }
    }

    private fun applyDarkMode(isDarkMode: Boolean) {
        if (isDarkMode) {
            imageView.setImageResource(R.drawable.darkmode)
            usuarioIcon.setImageResource(R.drawable.usuario)
            findViewById<TextView>(R.id.crearCuenta).setTextColor(ContextCompat.getColor(this, R.color.cyan))
            findViewById<TextView>(R.id.restablecerContr).setTextColor(ContextCompat.getColor(this, R.color.cyan))
            usuarioET.setTextColor(ContextCompat.getColor(this, R.color.white))
            contraET.setTextColor(ContextCompat.getColor(this, R.color.white))
            usuarioET.setHintTextColor(ContextCompat.getColor(this, R.color.white))
            contraET.setHintTextColor(ContextCompat.getColor(this, R.color.white))
            recordarContra.setTextColor(ContextCompat.getColor(this, R.color.white))
        } else {
            imageView.setImageResource(R.mipmap.fondo)
            usuarioIcon.setImageResource(R.mipmap.icon)
            findViewById<TextView>(R.id.crearCuenta).setTextColor(ContextCompat.getColor(this, R.color.white))
            findViewById<TextView>(R.id.restablecerContr).setTextColor(ContextCompat.getColor(this, R.color.white))
            usuarioET.setTextColor(ContextCompat.getColor(this, R.color.black))
            contraET.setTextColor(ContextCompat.getColor(this, R.color.black))
            usuarioET.setHintTextColor(ContextCompat.getColor(this, R.color.black))
            contraET.setHintTextColor(ContextCompat.getColor(this, R.color.black))
            recordarContra.setTextColor(ContextCompat.getColor(this, R.color.black))
        }
    }
}
