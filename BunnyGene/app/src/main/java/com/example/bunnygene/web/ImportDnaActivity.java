package com.example.bunnygene.web;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bunnygene.R;
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

        setContentView(R.layout.activity_reporting);
        RecyclerView repRecycler = findViewById(R.id.rep_recycler);

        ArrayList<Recommendation> recommendations = new ArrayList<Recommendation>();
        Recommendation rec1 = new Recommendation();
        rec1.title = "Eat"; rec1.description = "Time to eat Something";
        recommendations.add(rec1);
        Recommendation rec2 = new Recommendation();
        rec2.title = "Drink"; rec2.description = "Time to drink Something";
        recommendations.add(rec2);

        ReportAdapter reportAdapter = new ReportAdapter(recommendations);

        repRecycler.setAdapter(reportAdapter);

        LinearLayoutManager reportLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false);
        repRecycler.setLayoutManager(reportLayoutManager);
    }
}