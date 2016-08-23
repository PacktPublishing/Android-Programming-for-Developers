package com.gamecodeschool.database;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // For all our buttons and edit text
    Button btnInsert;
    Button btnDelete;
    Button btnSelect;
    Button btnSearch;

    EditText editName;
    EditText editAge;
    EditText editDelete;
    EditText editSearch;

    // This is our DataManager instance
    DataManager dm;

    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dm = new DataManager(this);

        // get a reference to the UI item
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnSelect = (Button) findViewById(R.id.btnSelect);
        btnSearch = (Button) findViewById(R.id.btnSearch);

        editName = (EditText) findViewById(R.id.editName);
        editAge = (EditText) findViewById(R.id.editAge);
        editDelete = (EditText) findViewById(R.id.editDelete);
        editSearch = (EditText) findViewById(R.id.editSearch);

        // Register MainActivity as a listener
        btnSelect.setOnClickListener(this);
        btnInsert.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        switch (v.getId()){
            case R.id.btnInsert:
                dm.insert(editName.getText().toString(),
                        editAge.getText().toString());

                break;

            case R.id.btnSelect:
                showData(dm.selectAll());
                break;

            case R.id.btnSearch:
                showData(dm.searchName(editSearch.getText().toString()));
                break;

            case R.id.btnDelete:
                dm.delete(editDelete.getText().toString());
                break;

        }

    }

    // Output the cursor contents to the log
    public void showData(Cursor c){

        while (c.moveToNext()){
            Log.i(c.getString(1), c.getString(2));
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
