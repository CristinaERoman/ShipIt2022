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
<<<<<<< HEAD
        rec1.recommendation = "Eat"; rec1.description = "Time to eat Something";
        recommendations.add(rec1);
        RecommendationDTO rec2 = new RecommendationDTO();
        rec2.recommendation = "Drink"; rec2.description = "Time to drink Something";
=======
        rec1.title = "Eat"; rec1.description = "Time to eat Something";
        rec1.image = "@drawable/avoid_air_pollution";
        rec1.frequency = "2 times per year";
        rec1.link = "https://wwww.goolge.com";
        recommendations.add(rec1);
        RecommendationDTO rec2 = new RecommendationDTO();
        rec2.title = "Drink"; rec2.description = "Time to drink Something";
        rec2.frequency = "2 times per year";
        rec2.link = "https://wwww.goolge.com";
        rec2.image = "@drawable/avoid_cold_air";

>>>>>>> origin/main
        recommendations.add(rec2);

        ReportAdapter reportAdapter = new ReportAdapter(recommendations);

        repRecycler.setAdapter(reportAdapter);

        LinearLayoutManager reportLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false);
        repRecycler.setLayoutManager(reportLayoutManager);
    }
}