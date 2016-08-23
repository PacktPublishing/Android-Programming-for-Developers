package com.gamecodeschool.switchdemo;

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

        // get input from user in a String variable called command
        String command = "ofolof";

        switch(command){

            case "go east":
                Log.i("Player: ", "Moves to the east");
                break;

            case "go west":
                Log.i("Player: ", "Moves to the East" );

                break;

            case "go north":
                Log.i("Player: ", "Moves to the North" );

                break;

            case "go south":
                Log.i("Player: ", "Moves to the South" );

                break;

            case "Take sword":
                Log.i("Player: ", "Takes the silver sword" );

                break;

            // more possible cases

            default:
                Log.i("Message: ", "Sorry I don't speak Elfish" );
                break;

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
