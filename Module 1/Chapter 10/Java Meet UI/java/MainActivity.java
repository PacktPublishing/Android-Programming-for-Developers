package com.gamecodeschool.javameetui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // In int variable to hold a value
    private int value = 0;

    // A bunch of Buttons and a TextView
    private Button btnAdd;
    private Button btnTake;
    private TextView txtValue;
    private Button btnGrow;
    private Button btnShrink;
    private Button btnReset;
    private Button btnHide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to all the buttons in our UI
        // Match them up to all out Button objects we declared earlier
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnTake = (Button) findViewById(R.id.btnTake);
        txtValue = (TextView) findViewById(R.id.txtValue);
        btnGrow = (Button) findViewById(R.id.btnGrow);
        btnShrink = (Button) findViewById(R.id.btnShrink);
        btnReset = (Button) findViewById(R.id.btnReset);
        btnHide = (Button) findViewById(R.id.btnHide);

        // Listen for all the button clicks
        btnAdd.setOnClickListener(this);
        btnTake.setOnClickListener(this);
        txtValue.setOnClickListener(this);
        btnGrow.setOnClickListener(this);
        btnShrink.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnHide.setOnClickListener(this);


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

    @Override
    public void onClick(View v) {

        // A couple of locale variables to use later
        float size;

        switch(v.getId()){

            case R.id.btnAdd:
                value ++;
                txtValue.setText(""+ value);

                break;

            case R.id.btnTake:
                value--;
                txtValue.setText(""+ value);

                break;

            case R.id.btnReset:
                value = 0;
                txtValue.setText("" + value);

                break;

            case R.id.btnGrow:
                size = txtValue.getTextScaleX();
                txtValue.setTextScaleX(size + 1);


                break;

            case R.id.btnShrink:
                size = txtValue.getTextScaleX();
                txtValue.setTextScaleX(size - 1);

                break;



            case R.id.btnHide:
                if(txtValue.getVisibility() == View.VISIBLE)
                {
                    // Currently visible so hide it
                    txtValue.setVisibility(View.INVISIBLE);

                    // Change text on the button
                    btnHide.setText("SHOW");

                }else{
                    // Currently hidden so show it
                    txtValue.setVisibility(View.VISIBLE);

                    // Change text on the button
                    btnHide.setText("SHOW");
                }


                break;

        }

    }
}
