package com.gamecodeschool.exploringmethodoverloading;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare and initialize a String and an int
        int anInt = 10;
        String aString = "I am a string";

        // Now call the different versions of printStuff
        // The name stays the same, only the parameters vary
        printStuff(anInt);
        printStuff(aString);
        printStuff(anInt, aString);

    }

    void printStuff(int myInt){
        Log.i("info", "This is the int only version");
        Log.i("info", "myInt = " + myInt);
    }

    void printStuff(String myString){
        Log.i("info", "This is the String only version");
        Log.i("info", "myString = "+ myString);
    }

    void printStuff(int myInt, String myString){
        Log.i("info", "This is the combined int and String version");
        Log.i("info", "myInt = "+ myInt);
        Log.i("info", "myString = "+ myString);
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
