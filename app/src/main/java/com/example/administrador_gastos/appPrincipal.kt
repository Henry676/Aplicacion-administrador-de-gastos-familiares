package com.example.administrador_gastos

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class appPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_principal)
        var seccion1: ImageButton
        var seccion2: ImageButton
        var seccion3: ImageButton
        var seccion4: ImageButton
        var seccion5: ImageButton
        var seccion6: ImageButton


        seccion1=findViewById(R.id.btnextras)
        seccion2=findViewById(R.id.btntransporte)
        seccion3=findViewById(R.id.btncomida)
        seccion4=findViewById(R.id.btnservicios)
        seccion5=findViewById(R.id.btnhistorial)
        seccion6=findViewById(R.id.btnpagosprox)

        seccion1.setOnClickListener{
            val intent = Intent(this@appPrincipal, seccionExtras::class.java)
            startActivity(intent)
            /*Toast.makeText(
                this@appPrincipal,
                "Entrando a gastos extras",
                Toast.LENGTH_LONG
            ).show()*/
        }

        seccion2.setOnClickListener{
            val intent = Intent(this@appPrincipal, seccionTransporte::class.java)
            startActivity(intent)
            /*Toast.makeText(
                this@appPrincipal,
                "Entrando a gastos en transporte",
                Toast.LENGTH_LONG
            ).show()*/
        }

        seccion3.setOnClickListener{
            val intent = Intent(this@appPrincipal, seccionComida::class.java)
            startActivity(intent)
            /*Toast.makeText(
                this@appPrincipal,
                "Entrando a gastos en comida",
                Toast.LENGTH_LONG
            ).show()*/
        }

        seccion4.setOnClickListener{
            val intent = Intent(this@appPrincipal, seccionServicios::class.java)
            startActivity(intent)
            /*Toast.makeText(
                this@appPrincipal,
                "Entrando a gastos en servicios",
                Toast.LENGTH_LONG
            ).show()*/
        }

        seccion5.setOnClickListener{
            val intent = Intent(this@appPrincipal, historial::class.java)
            startActivity(intent)
            /*Toast.makeText(
                this@appPrincipal,
                "Entrando al historial",
                Toast.LENGTH_LONG
            ).show()*/
        }
        seccion6.setOnClickListener{
            val intent = Intent(this@appPrincipal, seccionProximosPagos::class.java)
            startActivity(intent)
            /*Toast.makeText(
                this@appPrincipal,
                "Entrando a próximos pagos",
                Toast.LENGTH_LONG
            ).show()*/
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //val intent = Intent(this@appPrincipal, MainActivity::class.java)
        //startActivity(intent)
        finish()
        when(item.itemId){
            R.id.opciones -> Toast.makeText(this,"Cerrando sesion",Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }
}