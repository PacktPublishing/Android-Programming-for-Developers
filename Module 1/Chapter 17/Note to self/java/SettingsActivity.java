package com.gamecodeschool.notetoselfc8;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class SettingsActivity extends ActionBarActivity {

    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mEditor;

    private boolean mSound;

    public static final int FAST = 0;
    public static final int SLOW = 1;
    public static final int NONE = 2;

    private int mAnimOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mPrefs = getSharedPreferences("Note to self", MODE_PRIVATE);
        mEditor = mPrefs.edit();

        mSound  = mPrefs.getBoolean("sound", true);

        CheckBox checkBoxSound = (CheckBox) findViewById(R.id.checkBoxSound);
        if(mSound){
            checkBoxSound.setChecked(true);
        }else{
            checkBoxSound.setChecked(false);
        }

        checkBoxSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                Log.i("sound = ", "" + mSound);
                Log.i("isChecked = ", "" + isChecked);
                mSound = ! mSound;
                mEditor.putBoolean("sound", mSound);


            }
        });


        // Now for the radio buttons

        mAnimOption = mPrefs.getInt("anim option", FAST);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        // Uncheck all buttons
        radioGroup.clearCheck();

        switch(mAnimOption){

            case FAST:
                radioGroup.check(R.id.radioFast);
                break;

            case SLOW:
                radioGroup.check(R.id.radioSlow);
                break;

            case NONE:
                radioGroup.check(R.id.radioNone);
                break;

        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {

                    switch (rb.getId()){

                        case R.id.radioFast:
                            mAnimOption = FAST;
                            break;

                        case R.id.radioSlow:
                            mAnimOption = SLOW;
                            break;

                        case R.id.radioNone:
                            mAnimOption = NONE;
                            break;


                    }
                    // End switch block

                    mEditor.putInt("anim option", mAnimOption);

                }

            }
        });
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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
    protected void onPause() {
        super.onPause();

        // Save the settings here
        mEditor.commit();
    }
}
