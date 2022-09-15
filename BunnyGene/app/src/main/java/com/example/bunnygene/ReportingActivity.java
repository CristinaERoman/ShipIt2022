package com.example.bunnygene;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bunnygene.contract.Recommendation;
import com.example.bunnygene.web.report.ReportAdapter;

import java.util.ArrayList;

public class ReportingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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