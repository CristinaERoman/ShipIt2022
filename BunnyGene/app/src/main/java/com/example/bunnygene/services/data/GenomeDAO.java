package com.example.bunnygene.services.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.bunnygene.contract.GeneDTO;

import java.util.ArrayList;

public class GenomeDAO {
    public static final String TABLE_NAME = "Genome";
    public static final String _ID = BaseColumns._ID;
    public static final String COLUMN_CODE = "Code";
    public static final String COLUMN_MAGNITUDE = "Magnitude";
    public static final String COLUMN_REPUTE = "Repute";
    public static final String COLUMN_SUMMARY = "Summary";

    public static final String CREATE_GENOME_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    _ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_CODE + " TEXT, " +
                    COLUMN_MAGNITUDE + " TEXT, " +
                    COLUMN_REPUTE + " TEXT, " +
                    COLUMN_SUMMARY + " TEXT" +
                    ")";

    public static void insertGeneData(SQLiteDatabase db, GeneDTO gene) {
        // Insert into table - Option 2
        ContentValues values = new ContentValues();
        values.put(COLUMN_CODE, gene.getCode());
        values.put(COLUMN_MAGNITUDE, gene.getMagnitude());
        values.put(COLUMN_REPUTE, gene.getRepute());
        values.put(COLUMN_SUMMARY, gene.getSummary());
        db.insert(TABLE_NAME, null, values);
    }

    public static ArrayList<String> getDiseases(SQLiteDatabase db) {
        Cursor cursor = db.rawQuery("SELECT Code FROM Genome", null);
        ArrayList<String> genesList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                int geneCodeIndex = cursor.getColumnIndex("Code");
                genesList.add(cursor.getString(geneCodeIndex));
            } while (cursor.moveToNext());
        }

        return genesList;
    }
}
