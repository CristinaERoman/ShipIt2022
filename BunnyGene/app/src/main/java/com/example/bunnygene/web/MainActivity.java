package com.example.bunnygene.web;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bunnygene.R;
import com.example.bunnygene.contract.Patient;
import com.example.bunnygene.services.helpers.AsyncInput;
import com.example.bunnygene.services.helpers.AsyncJob;
import com.example.bunnygene.services.data.DBHelper;
import com.example.bunnygene.services.helpers.Notif;
import com.example.bunnygene.services.data.PatientQuery;

public class MainActivity extends AppCompatActivity {

    private Button buttonGetFirstName;
    private Button buttonNotifyUser;
    private TextView textView;

    int counter =0;

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




    }

    public void notify(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            AsyncInput input = new AsyncInput();
            input.frequency = 10000;
            input.methodParam = () -> {
                counter++;
                Notif.showNotif(this,"Notification " +counter,
                        "This is a healthy notification!","Notification " +counter  );
                return null;
            };

            AsyncJob asyncJob = new AsyncJob();
            asyncJob.execute(input);

        }
    }
}