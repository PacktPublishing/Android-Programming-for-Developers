package com.gamecodeschool.whereintheworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.widget.TextView;

public class MainActivity extends Activity implements LocationListener {

    private TextView txtLat;
    private TextView txtLong;
    private TextView txtSource;
    private LocationManager locationManager;
    private String provider;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtLat = (TextView) findViewById(R.id.txtLat);
        txtLong = (TextView) findViewById(R.id.txtLong);
        txtSource = (TextView) findViewById(R.id.txtSource);

        // Initialize locationManager
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        Location location = locationManager.getLastKnownLocation(provider);

        // Initialize the location
        if (location != null) {
            txtSource.setText("Source = " + provider);
            onLocationChanged(location);
        }
    }

    // Start updates when app starts/resumes
    @Override
    protected void onResume() {
        super.onResume();

        locationManager.requestLocationUpdates(provider, 500, 1, this);
    }

    // pause the location manager when app is paused/stopped
    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {
        double lat = location.getLatitude();
        double lng = location.getLongitude();
        txtLat.setText(String.valueOf(lat));
        txtLong.setText(String.valueOf(lng));
        txtSource.setText("Source = " + provider);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        txtSource.setText("Source = " + provider);

    }

    @Override
    public void onProviderEnabled(String provider) {
        txtSource.setText("Source = " + provider);

    }

    @Override
    public void onProviderDisabled(String provider) {
        txtSource.setText("Source = " + provider);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
