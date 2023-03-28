package com.example.bunnygene.web;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.MediaStore;
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
import com.google.android.material.snackbar.Snackbar;

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
        TextView firstName = (TextView) findViewById(R.id.firstName);
        TextView lastName = (TextView) findViewById(R.id.lastName);
        RadioGroup frequency = (RadioGroup) findViewById(R.id.frequencyRadioGroup);
        RadioGroup sexRadioGroup = (RadioGroup) findViewById(R.id.sexRadioGroup);
        SwitchCompat privacy = (SwitchCompat) findViewById(R.id.privacySwitch);

        RadioButton femaleButton = (RadioButton) findViewById(R.id.femaleButton);
        RadioButton maleButton = (RadioButton) findViewById(R.id.maleButton);

        RadioButton dailyButton = (RadioButton) findViewById(R.id.dailyButton);
        RadioButton weeklyButton = (RadioButton) findViewById(R.id.weeklyButton);
        RadioButton monthlyButton = (RadioButton) findViewById(R.id.monthlyButton);

        TextView birthdate = (TextView) findViewById(R.id.birthDate);
        //db.execSQL("DROP TABLE IF EXISTS " + PatientDAO.TABLE_NAME);
        //db.execSQL(PatientDAO.CREATE_PATIENT_TABLE);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        PatientDTO patient = PatientDAO.getPatient((db));

        //SETTING THE FIELDS
        firstName.setText(patient.getFirstName());
        lastName.setText(patient.getLastName());
        if (patient.getSex()== "female") {
            femaleButton.setChecked(true);
        } else {
            maleButton.setChecked(true);
        }

        String notificationFrequency = patient.getNotificationFrequency();

        if(notificationFrequency == "daily") {
            dailyButton.setChecked(true);
        } else if(notificationFrequency == "weekly"){
            weeklyButton.setChecked(true);
        } else {
            monthlyButton.setChecked(true);
        }

        if(patient.getPrivacy() == true) {
            privacy.setChecked(true);
        }

        birthdate.setText(patient.getDateOfBirth());

        Button save = (Button) findViewById(R.id.saveButton);

        save.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                String notificationFrequency = new String();
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
                        , birthdate.getText().toString()
                        , privacy.isChecked()
                        ,notificationFrequency);

                PatientDAO.insertPatient(db,patient);

                Snackbar.make(view,"Save successful", 3000).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}