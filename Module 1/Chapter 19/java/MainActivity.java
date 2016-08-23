package com.gamecodeschool.dualfragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity implements ActivityComs{

    public void onListItemSelected(int position) {

        // Is there a layout with an id that matches the detail container?

        if (findViewById(R.id.detailFragmentHolder) == null) {
            // If not we need to start a new activity

            Intent i = new Intent(this, PortraitDetailActivity.class);

            // We cant pass an object in an intent
            // So we pass its position in the array list
            i.putExtra("Position", position);

            startActivity(i);

        } else {

            FragmentManager fManager= getFragmentManager();
            FragmentTransaction fTransaction= fManager.beginTransaction();

            Fragment fragOld = fManager.findFragmentById(R.id.detailFragmentHolder);
            Fragment fragNew = AddressDetailFragment.newInstance(position);

            if (fragOld != null) {
                fTransaction.remove(fragOld);
            }

            fTransaction.add(R.id.detailFragmentHolder, fragNew);
            fTransaction.commit();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dualfragment);

        // Get a fragment manager
        FragmentManager fManager = getFragmentManager();

        // Create a new fragment using the manager
        // Passing in the id of the layout to hold it
        Fragment frag = fManager.findFragmentById(R.id.listFragmentHolder);

        // Check the fragment has not already been initialized
        if(frag == null){
            // Initialize the fragment based on our AddressListFragment
            frag  = new AddressListFragment();
            fManager.beginTransaction()
                    .add(R.id.listFragmentHolder, frag)
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
