package com.example.bunnygene.web;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.example.bunnygene.R;
import com.example.bunnygene.contract.PatientDTO;
import com.example.bunnygene.services.data.DBHelper;
import com.example.bunnygene.services.data.PatientDAO;
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

        db.execSQL("DROP TABLE IF EXISTS " + PatientDAO.TABLE_NAME);
        db.execSQL(PatientDAO.CREATE_PATIENT_TABLE);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Button reImport = (Button) findViewById(R.id.reImport);

        reImport.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                InputStream is = getResources().openRawResource(R.raw.report);
                ImportHelper.importDnaData(is, csvReader, db);
            }
        });

        Button save = (Button) findViewById(R.id.saveButton);

        save.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                TextView firstName = (TextView) findViewById(R.id.firstName);
                TextView lastName = (TextView) findViewById(R.id.lastName);
                SwitchCompat privacy = (SwitchCompat) findViewById(R.id.privacySwitch);

                PatientDTO patient = new PatientDTO(
                        firstName.getText().toString()
                        , lastName.getText().toString()
                        , ""
                        , "M"
                        , "23.01.1999"
                        , privacy.isChecked()
                        ,"monthly");

                PatientDAO.insertPatient(db,patient);
            }
        });

    }

}