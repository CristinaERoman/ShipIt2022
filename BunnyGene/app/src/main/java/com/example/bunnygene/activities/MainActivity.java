package com.example.bunnygene.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bunnygene.R;
import com.example.bunnygene.contract.Patient;
import com.example.bunnygene.data.DBHelper;
import com.example.bunnygene.data.PatientQuery;

public class MainActivity extends AppCompatActivity {

    private Button buttonGetFirstName;
    private Button buttonNotifyUser;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a database
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Patient patient = new Patient("John", "Davis", "Paul", "M", "07/21/1983");
        PatientQuery.insertPatient(db, patient);

        textView = findViewById(R.id.textView);
        buttonGetFirstName = findViewById(R.id.button);
        buttonGetFirstName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(PatientQuery.getPatientFirstName(db));
            }
        });


        buttonNotifyUser = findViewById(R.id.buttonNotifyUser);
        buttonNotifyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}