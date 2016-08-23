package com.gamecodeschool.expressingyourself;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int numMessages;
        numMessages = 10;

        // Output the value of numMessages
        Log.i("numMessages = ", "" + numMessages);

        numMessages ++;
        numMessages = numMessages + 1;

        // Output the value of numMessages
        Log.i("numMessages = ", "" + numMessages);

        // Now a boolean (just true or false)
        boolean isFriend = true;
        Log.i("isFriend = ", "" + isFriend);

        // A contact and an important message
        String contact = "James Gosling";
        String message = "Dear reader, I invented Java.";

        // Now let's play with those String variables
        Toast.makeText(this, "Message from " + contact, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Message is: " + message, Toast.LENGTH_SHORT).show();
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
