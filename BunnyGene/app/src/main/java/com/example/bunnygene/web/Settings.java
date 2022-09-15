package com.example.bunnygene.web;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bunnygene.R;
import com.example.bunnygene.services.data.DBHelper;
import com.example.bunnygene.services.helpers.CSVReader;
import com.example.bunnygene.services.helpers.ImportHelper;

import java.io.InputStream;

public class Settings extends AppCompatActivity {

    private DBHelper dbHelper;
    private SQLiteDatabase db;
    private CSVReader csvReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        dbHelper = new DBHelper(this);
        db = dbHelper.getReadableDatabase();
        csvReader = new CSVReader(this);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Button yourButton = (Button) findViewById(R.id.reImport);

        yourButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                InputStream is = getResources().openRawResource(R.raw.report);
                ImportHelper.importDnaData(is, csvReader, db);
            }
        });

    }

}