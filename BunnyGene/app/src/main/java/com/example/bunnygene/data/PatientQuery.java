package com.example.bunnygene.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.bunnygene.contract.Patient;

public class PatientQuery {
    public static final String TABLE_NAME = "Patient";
    public static final String _ID = BaseColumns._ID;
    public static final String COLUMN_FIRST_NAME = "FirstName";
    public static final String COLUMN_LAST_NAME = "LastName";
    public static final String COLUMN_MIDDLE_NAME = "MiddleName";
    public static final String COLUMN_SEX = "Sex";
    public static final String COLUMN_DATE_OF_BIRTH = "DateOfBirth";

    public static final String CREATE_PATIENT_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    _ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_FIRST_NAME + " TEXT, " +
                    COLUMN_LAST_NAME + " TEXT, " +
                    COLUMN_MIDDLE_NAME + " TEXT, " +
                    COLUMN_SEX + " TEXT, " +
                    COLUMN_DATE_OF_BIRTH + " TEXT" +
                    ")";

    public static void insertPatient(SQLiteDatabase db, Patient patient) {
        // Insert into table - Option 2
        ContentValues values = new ContentValues();
        values.put(COLUMN_FIRST_NAME, patient.getFirstName());
        values.put(COLUMN_LAST_NAME, patient.getLastName());
        values.put(COLUMN_MIDDLE_NAME, patient.getMiddleName());
        values.put(COLUMN_SEX, patient.getSex());
        values.put(COLUMN_DATE_OF_BIRTH, patient.getDateOfBirth());
        db.insert(TABLE_NAME, null, values);
    }

    public static String getPatientFirstName(SQLiteDatabase db) {
        Cursor c = db.rawQuery("SELECT * FROM Patient", null);
        int i = c.getCount();
        c.move(i);
        int firstNameIndex = c.getColumnIndex("FirstName");
        int lastNameIndex = c.getColumnIndex("LastName");
        return c.getString(firstNameIndex) + " " + c.getString(lastNameIndex);
    }
}
