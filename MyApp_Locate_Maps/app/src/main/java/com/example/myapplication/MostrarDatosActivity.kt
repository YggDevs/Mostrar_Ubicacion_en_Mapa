package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.activity_mostrar_datos.*

class MostrarDatosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_datos)


    /*    val intento1 = intent.getParcelableExtra<LatLng>("Pos")
        //val textoIntent = intent.getStringExtra("texto") //Imprimir texto
        println("intent es nulo")
        textViewDatos.text="latitud: ${intento1.latitude} longitud: ${intento1.longitude} "*/
recibirdatos()
    }

    fun recibirdatos() {
        val extras = intent.extras


        val d1 = intent.getParcelableExtra<LatLng>("Pos")


        // Obtener los datos y mostrarlos

        textViewDatos.text="latitud: ${d1.latitude} longitud: ${d1.longitude} "

    }

}
