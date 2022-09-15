package com.example.bunnygene.web;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bunnygene.R;
import com.example.bunnygene.contract.GeneDTO;
import com.example.bunnygene.services.data.DBHelper;
import com.example.bunnygene.services.data.GenomeDAO;
import com.example.bunnygene.services.helpers.CSVReader;
import com.example.bunnygene.services.helpers.ImportHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ImportDnaActivity extends AppCompatActivity {

    private Button buttonImport;

    private DBHelper dbHelper;
    private SQLiteDatabase db;
    private CSVReader csvReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_dna);

        dbHelper = new DBHelper(this);
        db = dbHelper.getReadableDatabase();
        csvReader = new CSVReader(this);

        buttonImport = findViewById(R.id.buttonImport);
        buttonImport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(ImportDnaActivity.this, MainActivity.class));
                InputStream is = getResources().openRawResource(R.raw.report);
                ImportHelper.importDnaData(is, csvReader, db);
            }
        });
    }
}