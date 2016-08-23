package com.gamecodeschool.simplemap;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap map) {
        // Add a marker in Silicon Vallley
        // 37.3876° N, 123.0575° W
        LatLng siliconValley = new LatLng(37.3876,238.0575);
        map.addMarker(new MarkerOptions().position(siliconValley).title("Silicon Valley"));
        map.moveCamera(CameraUpdateFactory.newLatLng(siliconValley));
    }
}

