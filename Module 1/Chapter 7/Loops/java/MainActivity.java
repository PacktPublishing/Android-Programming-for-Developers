package com.gamecodeschool.loops;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void countUp(View v){
        Log.i("message:","In countUp method");

        int x = 0;

        // Now an apparently infinite while loop
        while(true){

            // Add 1 to x each time
            x++;
            Log.i("x =", "" + x);

            if(x == 3){
                // Get me out of here
                break;
            }
        }
    }

    public void countDown(View v){
        Log.i("message:","In countDown method");

        int x = 4;
        // Now an apparently infinite while loop
        while(true){

            // Add 1 to x each time
            x--;
            Log.i("x =", "" + x);

            if(x == 1){
                // Get me out of here
                break;
            }
        }
    }

    public void nested(View v){
        Log.i("message:","In nested method");

        // a nested for loop
        for(int i = 0; i < 3; i ++){

            for(int j = 3; j > 0; j --){

                // Output the values of i and j
                Log.i("i =" + i,"j=" + j);
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

        return super.onOptionsItemSelected(item);
    }
}
