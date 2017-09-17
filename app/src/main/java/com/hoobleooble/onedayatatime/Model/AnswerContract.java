package com.hoobleooble.onedayatatime.Model;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.support.design.widget.TabLayout;

/**
 * Created by Owen Campbell on 9/16/2017.
 */

public final class AnswerContract{
    private AnswerContract(){}

    public static class AnswerEntry implements BaseColumns, DataContract
    {
        public static final String TABLE_NAME = "answer";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_ANSWER = "answer";
        public static final String COLUMN_NAME_QID = "qid";

        @Override
        public String GetCreationString() {
            return "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_NAME_DATE + " INTEGER, " +
                    COLUMN_NAME_QID + " INTEGER, " +
                    COLUMN_NAME_ANSWER + " TEXT," +
                    "PRIMARY KEY ("+COLUMN_NAME_DATE+", "+ COLUMN_NAME_QID+"))";
        }

        @Override
        public String GetDeletionString(){
            return "DROP TABLE IF EXISTS " + TABLE_NAME;
        }

        @Override
        public void populate(SQLiteDatabase db)
        {

        }
    }
}
