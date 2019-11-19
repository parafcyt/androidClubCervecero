package com.example.clubcerveceromona.view;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.clubcerveceromona.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String nombreCerveceria, direccion, telefono, horario, friendly;
    private Double lat, lng;

    //para los que voy a pisar
    private TextView nombreMaps, direccionMaps, telefonoMaps, horarioMaps, friendlyMaps;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        //traigo desde el adapter
        nombreCerveceria = getIntent().getStringExtra("nombreCerveceria");
        direccion = getIntent().getStringExtra("direccion");
        telefono = getIntent().getStringExtra("telefono");
        horario = getIntent().getStringExtra("horario");
        friendly = getIntent().getStringExtra("friendly");
        lat = getIntent().getDoubleExtra("lat", -32.484483);
        lng = getIntent().getDoubleExtra("lng", -58.232145);

        //ligo con el id del .xml
        nombreMaps = findViewById(R.id.nombreCerveceria);
        direccionMaps = findViewById(R.id.direccion);
        telefonoMaps = findViewById(R.id.telefono);
        horarioMaps = findViewById(R.id.horario);
        friendlyMaps = findViewById(R.id.friendly);

        //los relleno y quedan en()
        nombreMaps.setText(nombreCerveceria);
        direccionMaps.setText(direccion);
        telefonoMaps.setText(telefono);
        horarioMaps.setText(horario);
        friendlyMaps.setText(friendly);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng lugar = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(lugar).title(nombreCerveceria).icon(BitmapDescriptorFactory.fromResource(R.drawable.mapsbrewer)).
                flat(true).snippet(direccion)).showInfoWindow();

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lugar, 20.0f));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);


    }
}
