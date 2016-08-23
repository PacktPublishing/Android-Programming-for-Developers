package com.gamecodeschool.whereitssnap1;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    private ListView mNavDrawerList;
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // We will come back here in a minute!
        mNavDrawerList = (ListView)findViewById(R.id.navList);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        mActivityTitle = getTitle().toString();

        // Initialize an array with our titles from strings.xml
        String[] navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
        // Initialize our ArrayAdapter
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navMenuTitles);
        // Set the adapter to the ListView
        mNavDrawerList.setAdapter(mAdapter);

        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mNavDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int whichItem, long id) {

                switchFragment(whichItem);

            }
        });

        switchFragment(0);
    }


    private void switchFragment(int position) {

        Fragment fragment = null;
        String fragmentID ="";
        switch (position) {
            case 0:
                fragmentID = "TITLES";
                Bundle args = new Bundle();
                args.putString("Tag", "_NO_TAG");
                fragment = new TitlesFragment();
                fragment.setArguments(args);
                break;

            case 1:
                fragmentID = "TAGS";
                fragment = new TagsFragment();
                break;

            case 2:
                fragmentID = "CAPTURE";
                fragment = new CaptureFragment();
                break;


            default:
                break;
        }


        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentHolder, fragment, fragmentID).commit();

        // close the drawer
        mDrawerLayout.closeDrawer(mNavDrawerList);

    }


    private void setupDrawer() {

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            // Called when drawer is opened
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Make selelection");

                // triggers call to onPrepareOptionsMenu
                invalidateOptionsMenu();
            }

            // Called when drawer is closed
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);

                // triggers call to onPrepareOptionsMenu
                invalidateOptionsMenu();
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }



    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mDrawerToggle.syncState();
    }


    /*
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        mDrawerToggle.onConfigurationChanged(newConfig);
    }
    */

    @Override
    public void onBackPressed() {
        // Close drawer if open
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            //drawer is open so close it
            mDrawerLayout.closeDrawer(mNavDrawerList);
        }else {

            // Go back tot titles fragment
            // Quit if already at titles fragment
            Fragment f = getFragmentManager().findFragmentById(R.id.fragmentHolder);
            if (f instanceof TitlesFragment) {
                finish();
                System.exit(0);
            }else{
                switchFragment(0);
            }

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

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
