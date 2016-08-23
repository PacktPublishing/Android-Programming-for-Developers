package com.gamecodeschool.helloandroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MyActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_layout);

        // Let's take a look at Toast and Log in action
        Toast.makeText(this, "Can you see me", Toast.LENGTH_SHORT).show();
        Log.i("info", "Done creating the app");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_menu, menu);
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

    public void topClick(View v){
        Toast.makeText(this, "Top button clicked", Toast.LENGTH_SHORT).show();
        Log.i("info","The user clicked the top button");
    }

    public void bottomClick(View v){
        Toast.makeText(this, "Bottom button clicked", Toast.LENGTH_SHORT).show();
        Log.i("info","The user clicked the bottom button");
    }
}
