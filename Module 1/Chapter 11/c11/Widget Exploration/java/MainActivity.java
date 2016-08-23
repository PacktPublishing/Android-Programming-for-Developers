package com.gamecodeschool.widgetexploration;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextClock;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exploration_layout);

        // Get a reference to all our widgets
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton rbBeijing = (RadioButton) findViewById(R.id.radioButtonBeijing);
        RadioButton rbLondon = (RadioButton) findViewById(R.id.radioButtonLondon);
        RadioButton rbnewYork = (RadioButton) findViewById(R.id.radioButtonNewYork);

        final EditText editText = (EditText) findViewById(R.id.editText);
        final Button button = (Button) findViewById(R.id.button);

        final TextClock tClock = (TextClock) findViewById(R.id.textClock);

        final CheckBox cbTransparency = (CheckBox) findViewById(R.id.checkBoxTransparency);
        final CheckBox cbTint = (CheckBox) findViewById(R.id.checkBoxTint);
        final CheckBox cbReSize = (CheckBox) findViewById(R.id.checkBoxReSize);

        final ImageView imageView = (ImageView) findViewById(R.id.imageView);

        Switch switch1 = (Switch) findViewById(R.id.switch1);
        final WebView webView = (WebView) findViewById(R.id.webView);

        // Now we need to listen for clicks on the button, the CheckBoxes and the RadioButtons

        // First the check boxes using an anonymous class
        cbTransparency.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(cbTransparency.isChecked()){
                    // Set some transparency
                    imageView.setAlpha(.1f);
                }else{
                    imageView.setAlpha(1f);
                }

            }
        });

        // First the check boxes using an anonymous class
        cbTint.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cbTint.isChecked()) {
                    // Checked so set some tint
                    imageView.setColorFilter(Color.argb(150, 255, 0, 0));
                } else {
                    // No tint required
                    imageView.setColorFilter(Color.argb(0, 0, 0, 0));
                }

            }
        });

        // First the check boxes using an anonymous class
        cbReSize.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (cbReSize.isChecked()) {
                    // It's checked so make bigger
                    imageView.setScaleX(2);
                    imageView.setScaleY(2);
                } else {
                    // It's not checked make regular size
                    imageView.setScaleX(1);
                    imageView.setScaleY(1);
                }

            }
        });


        // Now for the radio buttons
        // Uncheck all buttons
        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);

                    switch (rb.getId()) {

                        case R.id.radioButtonLondon:
                            tClock.setTimeZone("Europe/London");
                            break;

                        case R.id.radioButtonBeijing:
                            tClock.setTimeZone("CST6CDT");
                            break;


                        case R.id.radioButtonNewYork:
                            tClock.setTimeZone("America/New_York");
                            break;


                    }
                    // End switch block

                //}
            }
        });

        /*
           Let's listen for clicks on our regular Button.
           We can do this with an anonymous class as well.
           An interface seems a bit much for one button.
        */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // We only handle one button
                // So no switching required
                button.setText(editText.getText());
            }
        });

        // Make the webview display a page
        //webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.cs.yale.edu/homes/tap/Files/hopper-story.html");

        webView.setVisibility(View.INVISIBLE);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    webView.setVisibility(View.VISIBLE);
                }else{
                    webView.setVisibility(View.INVISIBLE);
                }
            }
        });




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
