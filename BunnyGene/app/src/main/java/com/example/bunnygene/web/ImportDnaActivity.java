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
import com.example.bunnygene.services.helpers.CSVReader;
import com.example.bunnygene.web.report.ReportAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ImportDnaActivity extends AppCompatActivity {

    private Button buttonImport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_dna);

        buttonImport = findViewById(R.id.buttonImport);

        buttonImport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(ImportDnaActivity.this, MainActivity.class));
                importDnaData();
            }
        });
    }

    private void importDnaData() {
        InputStream is = getResources().openRawResource(R.raw.report);
        List<String[]> rows = new ArrayList<>();
        CSVReader csvReader = new CSVReader(this);
        try {
            rows = csvReader.readCSV(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < rows.size(); i++) {
            String code = rows.get(i)[1];
            String magnitude = rows.get(i)[2];
            String repute = rows.get(i)[3];
            String summary = rows.get(i)[5];
        }
    }
}