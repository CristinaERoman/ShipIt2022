package com.example.bunnygene.data;

import android.provider.BaseColumns;

public final class TableDefinition {
    public static final class PatientEntry implements BaseColumns {
        public static final String TABLE_NAME = "Patient";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_FIRST_NAME = "FirstName";
        public static final String COLUMN_LAST_NAME = "LastName";
        public static final String COLUMN_MIDDLE_NAME = "MiddleName";
        public static final String COLUMN_SEX = "Sex";
        public static final String COLUMN_AGE = "Age";
    }

   public static final class DiseaseEntry implements BaseColumns {
        public static final String TABLE_NAME = "Patient";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "Name";
        public static final String COLUMN_CATEGORY_ID = "CategoryID";
        public static final String COLUMN_ACTION_TO_TAKE = "ActionToTakeID";
    }
}
