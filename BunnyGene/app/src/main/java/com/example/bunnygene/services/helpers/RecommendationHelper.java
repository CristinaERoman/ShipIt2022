package com.example.bunnygene.services.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.bunnygene.contract.RecommendationDTO;
import com.example.bunnygene.services.data.DBHelper;
import com.example.bunnygene.services.data.GenomeDAO;
import com.example.bunnygene.services.data.RecommendationsDAO;

import java.util.ArrayList;

public class RecommendationHelper {

    public static ArrayList<RecommendationDTO> getRecommendationsForPersonalDisease(Context context, SQLiteDatabase db) {
        ArrayList<RecommendationDTO> recommendations = new ArrayList<>();
        ArrayList<String> diseases = GenomeDAO.getDiseases(db);

        for (int i = 0; i < diseases.size(); i++) {
            ArrayList<RecommendationDTO> diseaseRecom = RecommendationsDAO.getRecommendations(db, diseases.get(i));
            for (int j = 0; j < diseaseRecom.size(); j++) {
                recommendations.add(diseaseRecom.get(j));
            }
        }

        return recommendations;
    }
}
