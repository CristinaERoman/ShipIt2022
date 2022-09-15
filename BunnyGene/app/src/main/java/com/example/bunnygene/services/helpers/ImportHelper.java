package com.example.bunnygene.services.helpers;

import android.database.sqlite.SQLiteDatabase;

import com.example.bunnygene.R;
import com.example.bunnygene.contract.GeneDTO;
import com.example.bunnygene.services.data.DBHelper;
import com.example.bunnygene.services.data.GenomeDAO;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ImportHelper {
    public static void importDnaData(InputStream is, CSVReader csvReader, SQLiteDatabase db) {
        List<String[]> rows = new ArrayList<>();
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

            GeneDTO gene = new GeneDTO(code, magnitude, repute, summary);
            GenomeDAO.insertGeneData(db, gene);
        }
    }
}
