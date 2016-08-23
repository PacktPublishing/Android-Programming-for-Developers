package com.gamecodeschool.dualfragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class PortraitDetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portrait_detail);

        // Get a fragment manager
        FragmentManager fManager = getFragmentManager();

        // Create a new fragment using the manager
        // Passing in the id of the layout to hold it
        Fragment frag = fManager.findFragmentById(R.id.detailFragmentHolder);

        // Pass the Bundle onto the fragment
        int position = 0;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            position = extras.getInt("Position");
        }
        Log.i("Position = ", "" + position);

        //Fragment fragNew = AddressDetailFragment.newInstance(position);

        // Check the fragment has not already been initialized
        if(frag == null){

            frag  = AddressDetailFragment.newInstance(position);



            fManager.beginTransaction()
                    .add(R.id.detailFragmentHolder, frag)
                    .commit();
        }



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