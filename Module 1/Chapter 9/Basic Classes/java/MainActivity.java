package com.gamecodeschool.basicclasses;

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

        // first we make an object of type soldier
        Soldier rambo = new Soldier();
        rambo.soldierType = "Green Beret";
        rambo.health = 150;
        // It takes allot to kill Rambo

        // Now we make another Soldier object
        Soldier vassily = new Soldier();
        vassily.soldierType = "Sniper";
        vassily.health = 50;
        // Snipers have less health

        // And one more Soldier object
        Soldier wellington = new Soldier();
        wellington.soldierType = "Sailor";
        wellington.health = 100;
        // He's tough but no green beret

        Log.i("Rambo's health = ", "" + rambo.health);
        Log.i("Vassily's health = ", "" + vassily.health);
        Log.i("Wellington's health = ", "" + wellington.health);

        rambo.shootEnemy();
        vassily.shootEnemy();
        wellington.shootEnemy();








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
