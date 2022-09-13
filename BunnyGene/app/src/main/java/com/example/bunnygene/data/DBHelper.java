package com.example.bunnygene.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.bunnygene.data.TableDefinition.PatientEntry;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "BugGene.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_PATIENT_CREATE =
            "CREATE TABLE " + PatientEntry.TABLE_NAME + "(" +
                    PatientEntry._ID + " INTEGER PRIMARY KEY, " +
                    PatientEntry.COLUMN_FIRST_NAME + " TEXT, " +
                    PatientEntry.COLUMN_LAST_NAME + " TEXT, " +
                    PatientEntry.COLUMN_MIDDLE_NAME + " TEXT, " +
                    PatientEntry.COLUMN_SEX + " TEXT, " +
                    PatientEntry.COLUMN_AGE + " TEXT" +
                    ")";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_PATIENT_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PatientEntry.TABLE_NAME);
        onCreate(db);
    }
}
