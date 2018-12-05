package com.example.wilmer.foodzappbusiness;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaRestaurantes extends FragmentActivity implements ActivityCompat.OnRequestPermissionsResultCallback, OnMapReadyCallback, GoogleMap.OnMarkerDragListener {

    private GoogleMap mMap;
    private Marker markerDrag;
    private Double tvLatitud, tvLongitud, tvAltura, tvPrecision;
    private Location loc;
    private String prueba;
    private LocationManager locManager;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        setContentView(R.layout.activity_mapa_restaurantes);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//PARFAVAR
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {


            return;
        }else
        {
            locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            loc = locManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            tvLatitud=(Double.valueOf(loc.getLatitude()));
            tvLongitud=(Double.valueOf(loc.getLongitude()));
            tvAltura=(Double.valueOf(loc.getAltitude()));
            tvPrecision=(Double.valueOf(loc.getAccuracy()));
            prueba= tvLatitud.toString();
        }
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        // Add a marker
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        LatLng sabrozura = new LatLng(tvLatitud,tvLongitud);
        mMap.addMarker(new MarkerOptions().position(sabrozura).draggable(true).title("no se xd").snippet("Esta e mi ksa?").icon(BitmapDescriptorFactory.fromResource(R.drawable.restauranteubicacion)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sabrozura, 15));
        //arrastrar el marcador
        googleMap.setOnMarkerDragListener(this);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }


    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

    }
}
