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
        rec1.image = "<vector xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    android:height=\"24dp\"\n" +
                "    android:width=\"24dp\"\n" +
                "    android:viewportWidth=\"24\"\n" +
                "    android:viewportHeight=\"24\">\n" +
                "    <path android:fillColor=\"#000\" android:pathData=\"M6,2L2,8L12,22L22,8L18,2H6Z\" />\n" +
                "</vector>";
        rec1.frequency = "2 times per year";
        rec1.link = "https://wwww.goolge.com";
        recommendations.add(rec1);
        RecommendationDTO rec2 = new RecommendationDTO();
        rec2.title = "Drink"; rec2.description = "Time to drink Something";
        rec2.frequency = "2 times per year";
        rec2.link = "https://wwww.goolge.com";

        recommendations.add(rec2);

        ReportAdapter reportAdapter = new ReportAdapter(recommendations);

        repRecycler.setAdapter(reportAdapter);

        LinearLayoutManager reportLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false);
        repRecycler.setLayoutManager(reportLayoutManager);
    }
}