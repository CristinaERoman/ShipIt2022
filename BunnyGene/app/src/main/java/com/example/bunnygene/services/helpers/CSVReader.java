package com.example.bunnygene.services.helpers;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    Context context;
//    String fileName;
    List<String[]> rows = new ArrayList<>();

    public CSVReader(Context context/*, String fileName*/) {
        this.context = context;
//        this.fileName = fileName;
    }

    public List<String[]> readCSV(InputStream is) throws IOException {
        InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
        BufferedReader br = new BufferedReader(isr);
        String line;
        String csvSplitBy = ",";

        br.readLine();

        while ((line = br.readLine()) != null) {
            String[] row = line.split(csvSplitBy);
            rows.add(row);
        }
        return rows;
    }
}
