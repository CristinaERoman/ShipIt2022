package com.example.bunnygene;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bunnygene.data.DBHelper;
import com.example.bunnygene.data.PatientQuery;

public class MainActivity extends AppCompatActivity {

    private Button buttonGetFirstName;
    private TextView textView;

    private Button buttonNotifyUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        PatientQuery.createPatient(db);

        textView = findViewById(R.id.textView);

        buttonGetFirstName = findViewById(R.id.button);
        buttonGetFirstName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(PatientQuery.getPatientFirstName(db));
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        buttonNotifyUser = findViewById(R.id.buttonNotifyUser);
        buttonNotifyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "Notify User");
//                builder.setContentTitle("My First Notification");
//                builder.setContentText("Hello from my first notification");
//                builder.setAutoCancel(true);
//
//                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
//                managerCompat.notify(10, builder.build());
            }
        });
    }
}