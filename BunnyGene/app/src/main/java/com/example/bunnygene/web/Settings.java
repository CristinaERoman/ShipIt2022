package com.example.bunnygene.web;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
            actionBar.setHomeButtonEnabled(true);
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
                //TextView birthdate = (Date)
                SwitchCompat privacy = (SwitchCompat) findViewById(R.id.privacySwitch);
                String notificationFrequency = new String();

                RadioGroup frequency = (RadioGroup) findViewById(R.id.frequencyRadioGroup);
                RadioGroup sexRadioGroup = (RadioGroup) findViewById(R.id.sexRadioGroup);

                String sex = new String();

                if(sexRadioGroup.getCheckedRadioButtonId() == R.id.femaleButton)
                {
                    sex = "female";
                }else {
                    sex = "male";
                }

                if(frequency.getCheckedRadioButtonId() == R.id.dailyButton) {
                    notificationFrequency = "daily";
                } else if (frequency.getCheckedRadioButtonId() == R.id.weeklyButton) {
                    notificationFrequency = "weekly";
                } else {
                    notificationFrequency = "monthly";
                }


                PatientDTO patient = new PatientDTO(
                        firstName.getText().toString()
                        , lastName.getText().toString()
                        , ""
                        , sex
                        , "23.01.1999"
                        , privacy.isChecked()
                        ,notificationFrequency);

                PatientDAO.insertPatient(db,patient);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}