package com.hoobleooble.onedayatatime.Model;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Owen Campbell on 9/16/2017.
 */

public final class QuestionContract {
    private QuestionContract(){}

    public static class QuestionEntry implements BaseColumns, DataContract
    {
        public static final String TABLE_NAME = "question";
        public static final String COLUMN_NAME_QID = "qid";
        public static final String COLUMN_NAME_TEXT = "text";
        public static final String COLUMN_NAME_SUBTEXT = "subtext";
        public static final String COLUMN_NAME_CID = "cid";
        public static final String COLUMN_NAME_TYPE = "type";

        @Override
        public String GetCreationString() {
            return "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_NAME_QID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_CID + " INTEGER, " +
                    COLUMN_NAME_TEXT + " TEXT, " +
                    COLUMN_NAME_SUBTEXT + " TEXT, " +
                    COLUMN_NAME_TYPE + " TEXT)";
        }

        @Override
        public String GetDeletionString(){
            return "DROP TABLE IF EXISTS " + TABLE_NAME;
        }

        @Override
        public void populate(SQLiteDatabase db)
        {
            Question.Create(db, 1, 1, "Did you eat breakfast?", "", "bool");
            Question.Create(db, 2, 1, "What did you eat for breakfast?", "For breakfast, I ate", "string");
            Question.Create(db, 3, 1, "Rate how healthy your breakfast was on a scale of 1-10", "I'd give it a(n)" ,"int");

            Question.Create(db, 4, 1, "Did you eat lunch?", "","bool");
            Question.Create(db, 5, 1, "What did you eat for lunch?", "For lunch, I ate", "string");
            Question.Create(db, 6, 1, "Rate how healthy your lunch was on a scale of 1-10", "I'd give it a(n)", "int");

            Question.Create(db, 7, 1, "Did you eat dinner?", "","bool");
            Question.Create(db, 8, 1, "What did you eat for dinner?", "For dinner, I ate", "string");
            Question.Create(db, 9, 1, "Rate how healthy your dinner was on a scale of 1-10", "I'd give it a(n)", "int");

            Question.Create(db, 10, 1, "Do you take medication?", "","bool");
            Question.Create(db, 11, 1, "Did you take your medication on time?", "","bool");

            Question.Create(db, 12, 1, "Did you drink enough water?", "","bool");
            Question.Create(db, 13, 1, "Did you drink alcohol?", "","bool");

            Question.Create(db, 14, 1, "Do you want to answer questions about your diet?", "","bool");

            Question.Create(db, 15, 1, "Do you want to answer questions about medication?", "","bool");

            Question.Create(db, 16, 2, "Did you exercise today?", "","bool");
            Question.Create(db, 17, 2, "How did you exercise?", "I exercised by","string");
            Question.Create(db, 18, 2, "How long did you exercise for?", "I exercised for __ minutes","int");

            Question.Create(db, 19, 2, "Did you sleep?", "","bool");
            Question.Create(db, 20, 2, "How long in total did you sleep?", "I slept for __ hours","int");

            Question.Create(db, 21, 3, "Do you want to answer questions about your social life?", "","bool");
            Question.Create(db, 22, 3, "Did you take time for yourself?", "","bool");
            Question.Create(db, 23, 3, "How much time did you take for yourself?", "I took __ hours","int");

            Question.Create(db, 24, 3, "Did you spend time with a friend?", "","bool");
            Question.Create(db, 25, 3, "Which friend(s) did you spend time with?", "I spent time with __","string");
            Question.Create(db, 26, 3, "On a scale from 1-10, rate how much you enjoyed your time with them.", "I'd give it a(n)","int");

            Question.Create(db, 27, 4, "Rate today on a scale from 1-10", "I'd give it a(n)","int");

        }
    }
}
