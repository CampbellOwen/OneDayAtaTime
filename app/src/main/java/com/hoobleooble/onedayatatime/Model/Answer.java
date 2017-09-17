package com.hoobleooble.onedayatatime.Model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Owen Campbell on 9/16/2017.
 */

public class Answer implements Model {
    private int qid;
    private int date;
    private String answer;

    public int getQid(){
        return qid;
    }

    public int getDate(){
        return date;
    }

    public String getAnswer(){
        return answer;
    }

    public Answer(SQLiteDatabase db, int qid, int date)
    {
        populate(db, qid, date);
    }

    private Answer( int qid, int date, String answer )
    {
        this.qid = qid;
        this.date = date;
        this.answer = answer;
    }

    private void populate(SQLiteDatabase db, int qid, int date)
    {
        this.qid = qid;
        this.date = date;

        String[] projection = {
                AnswerContract.AnswerEntry.COLUMN_NAME_ANSWER
        };

        String selection = AnswerContract.AnswerEntry.COLUMN_NAME_QID +
                " = ? AND " +
                AnswerContract.AnswerEntry.COLUMN_NAME_DATE +
                " = ?";
        String[] selectionArgs = {
                Integer.toString(qid),
                Integer.toString(date)
        };

        Cursor cursor = db.query(
                AnswerContract.AnswerEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        Log.d("DB", "Answer query count: " + cursor.getCount());

        cursor.moveToFirst();
        int answerIndex = cursor.getColumnIndexOrThrow(AnswerContract.AnswerEntry.COLUMN_NAME_ANSWER);

        this.answer = cursor.getString(answerIndex);
    }

    public long store(SQLiteDatabase db)
    {
        Log.d("DB", "Inserting new answer with qid: " + this.qid + ", date: " + this.date);
        ContentValues values = new ContentValues();
        values.put(AnswerContract.AnswerEntry.COLUMN_NAME_QID, this.qid);
        values.put(AnswerContract.AnswerEntry.COLUMN_NAME_DATE, this.date);
        values.put(AnswerContract.AnswerEntry.COLUMN_NAME_ANSWER, this.answer);

        return db.insert(AnswerContract.AnswerEntry.TABLE_NAME, null, values);
    }

    public static Answer Create(SQLiteDatabase db, int qid, int date, String answer)
    {
        Answer newAnswer = new Answer(qid, date, answer);
        newAnswer.store(db);

        return newAnswer;
    }
}
