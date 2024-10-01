package com.example.prueba3

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    private lateinit var formLayout: ConstraintLayout
    private lateinit var mainScreenLayout: ConstraintLayout
    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var tvName: TextView
    private lateinit var tvAge: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//vistas
        formLayout = findViewById(R.id.formLayout)
        mainScreenLayout = findViewById(R.id.mainScreenLayout)
        etName = findViewById(R.id.etName)
        etAge = findViewById(R.id.etAge)
        tvName = findViewById(R.id.tvName)
        tvAge = findViewById(R.id.tvAge)

//boton de envio
        findViewById<Button>(R.id.btnSubmit).setOnClickListener {
            submitForm()
        }

//boton regreso
        findViewById<Button>(R.id.btnBack).setOnClickListener {
            showForm()
        }
    }
    // Función de envío del formulario
    private fun submitForm() {
        val name = etName.text.toString()
        val age = etAge.text.toString()

        if (name.isNotEmpty() && age.isNotEmpty()) {

            // Mostrar datos ingresados
            tvName.text = "Nombre: $name"
            tvAge.text = "Edad: $age"
            applyTransition(formLayout, mainScreenLayout)
        }
    }
    // funcion de regreso al formulario inicial
    private fun showForm() {
        applyTransition(mainScreenLayout, formLayout)
    }
    //cambio de animacion
    private fun applyTransition(hideLayout: View, showLayout: View) {
        hideLayout.animate().alpha(0f).setDuration(500).withEndAction {
            hideLayout.visibility = View.GONE
            showLayout.alpha = 0f
            showLayout.visibility = View.VISIBLE
            showLayout.animate().alpha(1f).setDuration(500).start()
        }.start()
    }
}
