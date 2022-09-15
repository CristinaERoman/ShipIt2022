package com.example.bunnygene.web;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bunnygene.R;
import com.example.bunnygene.ReportingActivity;
import com.example.bunnygene.contract.Recommendation;
import com.example.bunnygene.web.report.ReportAdapter;

import java.util.ArrayList;

public class ImportDnaActivity extends AppCompatActivity {
    private EditText mail;
    private EditText password;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_dna);

        loginButton = findViewById(R.id.buttonImport);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(ImportDnaActivity.this, MainActivity.class));
            }
        });

        Intent i = new Intent(getApplicationContext(), ReportingActivity.class);
        startActivity(i);
        //setContentView(R.layout.activity_reporting);

    }
}