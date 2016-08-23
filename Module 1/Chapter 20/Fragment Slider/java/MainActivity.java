package com.gamecodeschool.fragmentslider;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;

// Using support library because we need to accommodate the methods of FragmentAdapter

public class MainActivity extends AppCompatActivity {

    SimpleFragmentPagerAdapter pageAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize a list of three fragments
        List<Fragment> fragmentList = new ArrayList<Fragment>();

        // Add three new Fragments to the list
        fragmentList.add(SimpleFragment.newInstance("1"));
        fragmentList.add(SimpleFragment.newInstance("2"));
        fragmentList.add(SimpleFragment.newInstance("3"));

        pageAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), fragmentList);

        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(pageAdapter);

    }



    private class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
        // A List to hold our fragments
        private List<Fragment> fragments;

        // A constructor to receive a fragment manager and a List
        public SimpleFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        // Just two methods to override to get the current position of the adapter and the size of the List
        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
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
