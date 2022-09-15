package com.example.bunnygene.services.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.bunnygene.contract.RecommendationDTO;

import java.util.ArrayList;

public class RecommendationsDAO {
    public static final String TABLE_NAME = "DiseaseRecom";
    public static final String _ID = BaseColumns._ID;
    public static final String COLUMN_GENE = "gene";
    public static final String COLUMN_GENOTYPE = "genotype";
    public static final String COLUMN_RECOMMENDATION = "recommendation";
    public static final String COLUMN_FREQUENCY = "frequency";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_ICON = "icon";
    public static final String COLUMN_DISEASE = "disease";
    public static final String COLUMN_RECOMCATEGORY = "recomcategory";

    public static ArrayList<RecommendationDTO> getRecommendations(SQLiteDatabase db, String diseaseCode) {
        int startGenotype = diseaseCode.indexOf('(');
        String geneCode = diseaseCode.substring(0, startGenotype);
        String genotypeCode = diseaseCode.substring(startGenotype + 1, diseaseCode.length());
        Cursor cursor = db.rawQuery("SELECT * FROM DiseaseRecom WHERE gene='" + geneCode + "' AND genotype='" + genotypeCode + "'", null);
        RecommendationDTO recommendation = new RecommendationDTO();
        ArrayList<RecommendationDTO> recommendations = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                int recomIndex = cursor.getColumnIndex(COLUMN_RECOMMENDATION);
                int frequencyIndex = cursor.getColumnIndex(COLUMN_FREQUENCY);
                int descriptionIndex = cursor.getColumnIndex(COLUMN_DESCRIPTION);
                int iconIndex = cursor.getColumnIndex(COLUMN_ICON);
                int diseaseIndex = cursor.getColumnIndex(COLUMN_DISEASE);

                recommendation.setRecommendation(cursor.getString(recomIndex));
                recommendation.setDescription(cursor.getString(descriptionIndex));
                recommendation.setFrequency(cursor.getString(frequencyIndex));
                recommendation.setIcon(cursor.getString(iconIndex));
                recommendation.setDisease(cursor.getString(diseaseIndex));

                recommendations.add(recommendation);
            } while (cursor.moveToNext());
        }

        return recommendations;
    }
}
