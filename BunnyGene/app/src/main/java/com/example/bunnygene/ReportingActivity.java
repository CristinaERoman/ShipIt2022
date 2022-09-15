package com.example.bunnygene;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.bunnygene.contract.RecommendationDTO;
import com.example.bunnygene.services.data.DBHelper;
import com.example.bunnygene.services.data.GenomeDAO;
import com.example.bunnygene.services.helpers.AsyncInput;
import com.example.bunnygene.services.helpers.ImportHelper;
import com.example.bunnygene.services.helpers.RecommendationHelper;
import com.example.bunnygene.web.report.ReportAdapter;

import java.io.InputStream;
import java.util.ArrayList;

public class ReportingActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporting);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        RecyclerView repRecycler = findViewById(R.id.rep_recycler);

        ArrayList<RecommendationDTO> recommendations = new ArrayList<RecommendationDTO>();
        ArrayList<RecommendationDTO> recommendationsProcessed = new ArrayList<RecommendationDTO>();

        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();


        recommendations = RecommendationHelper.getRecommendationsForPersonalDisease(this, db);

        for(int index=9; index>=5;  index--) {
            RecommendationDTO recommandation = recommendations.get(index);
            recommandation.link = "https://www.snpedia.com/index.php/" + recommandation.getGene();
            recommandation.icon = recommandation.getIcon();
            recommendationsProcessed.add(recommandation);
        }

        ReportAdapter reportAdapter = new ReportAdapter(recommendationsProcessed);

        repRecycler.setAdapter(reportAdapter);

        LinearLayoutManager reportLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false);
        repRecycler.setLayoutManager(reportLayoutManager);



        AsyncInput inputParam = new AsyncInput();
        inputParam.frequency = 15000;
        //inputParam.methodParam

    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }




    public void startReporting(MenuItem item) {
        //Intent i = new Intent(getApplicationContext(), ReportingActivity.class);
         //startActivity(i);
    }
}