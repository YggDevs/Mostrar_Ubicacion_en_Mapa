package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import android.content.ActivityNotFoundException
import android.net.Uri
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton1.setOnClickListener {
            val intentMapa = Intent(this, MapsActivity::class.java)
            startActivity(intentMapa)






    }


/* Abrir en Google Maps punto o ruta
        val uri = String.format(Locale.getDefault(), "http://maps.google.com/maps?saddr=%f,%f&daddr=%f,%f", 37.424307, -122.095023, 37.422867, -122.0932849)
//marker
//String uri = String.format("http://maps.google.com/maps?q=%f,%f",37.424307,-122.095023);
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity")
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this,"ds" ,Toast.LENGTH_SHORT).show()
        }
*/

    }

}
