package com.example.bunnygene;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bunnygene.contract.RecommendationDTO;
import com.example.bunnygene.web.report.ReportAdapter;

import java.util.ArrayList;

public class ReportingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporting);

        RecyclerView repRecycler = findViewById(R.id.rep_recycler);

        ArrayList<RecommendationDTO> recommendations = new ArrayList<RecommendationDTO>();
        RecommendationDTO rec1 = new RecommendationDTO();
        rec1.title = "Eat"; rec1.description = "Time to eat Something";
        recommendations.add(rec1);
        RecommendationDTO rec2 = new RecommendationDTO();
        rec2.title = "Drink"; rec2.description = "Time to drink Something";
        recommendations.add(rec2);

        ReportAdapter reportAdapter = new ReportAdapter(recommendations);

        repRecycler.setAdapter(reportAdapter);

        LinearLayoutManager reportLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false);
        repRecycler.setLayoutManager(reportLayoutManager);
    }
}