package com.hoobleooble.onedayatatime.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Owen Campbell on 9/16/2017.
 */

public class Question implements Model {

    private int qid;
    private String text;
    private String subText;
    private int cid;
    private String type;

    public int getQid(){
        return qid;
    }

    public int getCid(){
        return cid;
    }

    public String getText(){
        return text;
    }

    public String getSubText(){
        return subText;
    }

    public String getType(){
        return type;
    }

    public Question( SQLiteDatabase db, int qid)
    {
        populate(db, qid);
    }

    private Question( int qid, int cid, String text, String subText, String type )
    {
        this.qid = qid;
        this.cid = cid;
        this.text = text;
        this.subText = subText;
        this.type = type;
    }

    private void populate(SQLiteDatabase db, int qid)
    {
        this.qid = qid;

        String[] projection = {
                QuestionContract.QuestionEntry.COLUMN_NAME_CID,
                QuestionContract.QuestionEntry.COLUMN_NAME_TEXT,
                QuestionContract.QuestionEntry.COLUMN_NAME_SUBTEXT,
                QuestionContract.QuestionEntry.COLUMN_NAME_TYPE
        };

        String selection = QuestionContract.QuestionEntry.COLUMN_NAME_QID + " = ?";
        String[] selectionArgs = { Integer.toString(qid) };

        Cursor cursor = db.query(
                QuestionContract.QuestionEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        Log.d("DB", "Question query count: " + cursor.getCount());

        cursor.moveToFirst();
        int cidIndex = cursor.getColumnIndexOrThrow(QuestionContract.QuestionEntry.COLUMN_NAME_CID);
        int textIndex = cursor.getColumnIndexOrThrow(QuestionContract.QuestionEntry.COLUMN_NAME_TEXT);
        int subTextIndex = cursor.getColumnIndexOrThrow(QuestionContract.QuestionEntry.COLUMN_NAME_SUBTEXT);
        int typeIndex = cursor.getColumnIndexOrThrow(QuestionContract.QuestionEntry.COLUMN_NAME_TYPE);

        this.cid = cursor.getInt(cidIndex);
        this.text = cursor.getString(textIndex);
        this.subText = cursor.getString(subTextIndex);
        this.type = cursor.getString(typeIndex);
    }

    public long store(SQLiteDatabase db)
    {
        Log.d("DB", "Inserting new question with qid: " + this.qid);
        ContentValues values = new ContentValues();
        values.put(QuestionContract.QuestionEntry.COLUMN_NAME_QID, this.qid);
        values.put(QuestionContract.QuestionEntry.COLUMN_NAME_CID, this.cid);
        values.put(QuestionContract.QuestionEntry.COLUMN_NAME_TEXT, this.text);
        values.put(QuestionContract.QuestionEntry.COLUMN_NAME_SUBTEXT, this.subText);
        values.put(QuestionContract.QuestionEntry.COLUMN_NAME_TYPE, this.type);

        return db.insert(QuestionContract.QuestionEntry.TABLE_NAME, null, values);
    }

    public static Question Create(SQLiteDatabase db, int qid, int cid, String text, String subText, String type)
    {
        Question newQuestion = new Question(qid, cid, text, subText, type);
        newQuestion.store(db);

        return newQuestion;
    }
}
