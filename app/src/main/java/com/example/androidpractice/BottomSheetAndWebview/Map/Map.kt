package com.example.androidpractice.BottomSheetAndWebview.Map
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractice.R
import com.google.android.gms.common.api.Status
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener

/*
1 open a websit to create a api key
2 https://console.cloud.google.com/
3 create a crediante
4 add package name and sha
5 copy api key add in manifest
 */
class Map : AppCompatActivity(),OnMapReadyCallback {
    var mgooglemap :GoogleMap?= null
    lateinit var automcompltedfragment:AutocompleteSupportFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        Places.initialize(applicationContext,getString(R.string.api_string))
        automcompltedfragment = supportFragmentManager.findFragmentById(R.id.autocomplete_fragment) as AutocompleteSupportFragment
        automcompltedfragment.setPlaceFields(listOf(Place.Field.ID, Place.Field.ADDRESS,Place.Field.LAT_LNG))
        automcompltedfragment.setOnPlaceSelectedListener(object : PlaceSelectionListener{
            override fun onError(p0: Status) {
                Toast.makeText(this@Map,"SOME ERROR IN SEARCH",Toast.LENGTH_SHORT).show()
            }

            override fun onPlaceSelected(place: Place) {
//              val add = place.address
//                val id = place.id
                val lating = place.latLng
                zoommap(lating)
            }

        })

        val mapFrgament = supportFragmentManager.findFragmentById(R.id.mapfragment) as SupportMapFragment
        mapFrgament.getMapAsync(this)



        }
    override fun onMapReady(p0: GoogleMap) {
        mgooglemap= p0
    }

    private fun zoommap(lating: LatLng){
        val newlatingzoom = CameraUpdateFactory.newLatLngZoom(lating,12f)
        mgooglemap!!.animateCamera(newlatingzoom)
    }
}