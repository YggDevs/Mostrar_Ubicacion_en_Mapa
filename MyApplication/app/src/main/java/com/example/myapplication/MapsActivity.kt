package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.support.v4.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback,GoogleMap.OnMarkerClickListener{

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }


    override fun onMarkerClick(p0: Marker?)=false


    //propiedades
    private lateinit var mMap: GoogleMap
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var lastLocation:Location


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(this)

        fusedLocationProviderClient=LocationServices.getFusedLocationProviderClient(this)

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @SuppressLint("MissingPermission")




    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap
        mMap.uiSettings.isZoomControlsEnabled=true
        mMap.setOnMarkerClickListener(this)
        setUpMap()
        Aunt(googleMap)




    }




    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
            return
        }


        mMap.isMyLocationEnabled=true
        // mMap.mapType=GoogleMap.MAP_TYPE_TERRAIN //Cambia el tipo de terreno
        fusedLocationProviderClient.lastLocation.addOnSuccessListener(this) { location ->

            if (location!=null){
                lastLocation=location
                val currentLastLong=LatLng(location.latitude,location.longitude)
                placeMarker(currentLastLong)//recibe longitu y lat mostrar mapa

                println("*******estas son las coordenadas $currentLastLong")



                //el zoom se cambia cambiando el valor 10f
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLastLong,10f))
            }

        }
    }

    //inserta un marcador en lalatitud y longitud que se le envia
    private fun placeMarker(location:LatLng){

        val markerOption = MarkerOptions().position(location)


        //cambia color marcador
        markerOption.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        mMap.addMarker(markerOption)

    }


    fun Aunt(googleMap: GoogleMap) {   // Metodo para añadir puntos estaticos en el mapa

        mMap = googleMap
        val Alcampo = LatLng(28.4629569, -16.30664790000003)
        mMap.addMarker(MarkerOptions().position(Alcampo).title("Alcampo de la Laguna"))

        mMap = googleMap
        val Atecresa = LatLng(28.456538, -16.30217700000003)
        mMap.addMarker(MarkerOptions().position(Atecresa).title("Atecresa Base"))

    }


 /*   fun enviarResultados(Localizacion:LatLng) {

        val localizacion = Intent(this, MostrarDatosActivity::class.java)

        //val position = LatLng(16.099108, -22.812924)
        localizacion.putExtra("Pos", Localizacion)


        startActivity(localizacion)
    }
*/


}

