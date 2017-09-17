package com.hoobleooble.onedayatatime.Presenter;

import android.app.Presentation;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.hoobleooble.onedayatatime.Model.Answer;
import com.hoobleooble.onedayatatime.Model.DbHelper;
import com.hoobleooble.onedayatatime.Model.Question;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Owen Campbell on 9/16/2017.
 */

public class QuestionsPresenter {

    private List<Question> questions;
    private DbHelper dbHelper;
    private SQLiteDatabase db;

    public QuestionsPresenter(Context context)
    {
        questions = new ArrayList<Question>();
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
        for(int i = 1; i <= 20; i++){
            questions.add(new Question(db, i));
        }

    }

    public List<Question> getQuestions()
    {
        return this.questions;
    }

    public boolean storeAnswer(String answer, int qid)
    {
        try{
            int date = (int)Calendar.getInstance().getTime().getTime();
            Answer.Create(db, qid, date, answer);
            Log.d("DB", "Successfully saved answer: qid: " + Integer.toString(qid) + ", date: " + Integer.toString(date) + ", answer: " + answer);
            return true;
        }
        catch (Exception e){
            Log.d("DB", "Saving answer failed :(");
            return false;
        }
    }

}
