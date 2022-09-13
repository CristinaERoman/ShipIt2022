package com.example.bunnygene.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PatientQuery {
    public static void createPatient(SQLiteDatabase db) {
        // Insert into table - Option 1
        String query = "INSERT INTO Patient ("
                + TableDefinition.PatientEntry.COLUMN_FIRST_NAME + ","
                + TableDefinition.PatientEntry.COLUMN_LAST_NAME + ","
                + TableDefinition.PatientEntry.COLUMN_MIDDLE_NAME + ","
                + TableDefinition.PatientEntry.COLUMN_SEX + ","
                + TableDefinition.PatientEntry.COLUMN_AGE + ")"
                + " VALUES (\"Madalina\", \"Stelea\", \"Ioana\", \"F\", \"30\")";
        db.execSQL(query);

        // Insert into table - Option 2
        ContentValues values = new ContentValues();
        values.put(TableDefinition.PatientEntry.COLUMN_FIRST_NAME, "John");
        values.put(TableDefinition.PatientEntry.COLUMN_LAST_NAME, "Davis");
        values.put(TableDefinition.PatientEntry.COLUMN_MIDDLE_NAME, "Christian");
        values.put(TableDefinition.PatientEntry.COLUMN_SEX, "M");
        values.put(TableDefinition.PatientEntry.COLUMN_AGE, "25");
        db.insert(TableDefinition.PatientEntry.TABLE_NAME, null, values);
    }

    public static String getPatientFirstName(SQLiteDatabase db) {
        Cursor c = db.rawQuery("SELECT * FROM Patient", null);
        int i = c.getCount();
        c.move(i);
        int firstName = c.getColumnIndex("FirstName");
        int lastName = c.getColumnIndex("LastName");
        return c.getString(firstName) + " " + c.getString(lastName);
    }
}
