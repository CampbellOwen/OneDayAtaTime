package com.hoobleooble.onedayatatime.Model;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Owen Campbell on 9/16/2017.
 */

public final class CategoryContract {
    private CategoryContract(){}

    public static class CategoryEntry implements BaseColumns, DataContract
    {
        public static final String TABLE_NAME = "category";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_CID = "cid";

        @Override
        public String GetCreationString() {
            return "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_NAME_CID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_NAME + " TEXT)";
        }

        @Override
        public String GetDeletionString(){
            return "DROP TABLE IF EXISTS " + TABLE_NAME;
        }

        @Override
        public void populate(SQLiteDatabase db) {
            Category.Create(db, 1, "Diet");
            Category.Create(db, 2, "Health");
            Category.Create(db, 3, "Social");
            Category.Create(db, 4, "General");
        }
    }
}
