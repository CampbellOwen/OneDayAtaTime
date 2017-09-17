package com.hoobleooble.onedayatatime.Presenter;

import android.app.Presentation;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.hoobleooble.onedayatatime.MainActivity;
import com.hoobleooble.onedayatatime.Model.Answer;
import com.hoobleooble.onedayatatime.Model.DbHelper;
import com.hoobleooble.onedayatatime.Model.Question;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Owen Campbell on 9/16/2017.
 */

public class QuestionsPresenter {

    private List<Question> questions;
    private DbHelper dbHelper;
    private SQLiteDatabase db;
    private MainActivity viewContext;
    private HashMap<Integer, Question> masterQuestions;

    public QuestionsPresenter(Context context)
    {
        viewContext = (MainActivity)context;
        questions = new ArrayList<Question>();
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();

        masterQuestions = new HashMap<Integer, Question>();
        initializeQuestions();

        for(int i = 1; i <= 1; i++){
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
            long date = Calendar.getInstance().getTime().getTime() / 86400000;

            Answer.Create(db, qid, date, answer);
            Log.d("DB", "Successfully saved answer: qid: " + Integer.toString(qid) + ", date: " + Long.toString(date) + ", answer: " + answer);
            return true;
        }
        catch (Exception e){
            Log.d("DB", "Saving answer failed :(");
            return false;
        }
    }

    public void getNextQuestion(boolean includeSubquestion)
    {
        questions.add(new Question(db, 9));
        viewContext.adapter.notifyItemChanged(questions.size()-1);
        viewContext.rv.scrollToPosition(questions.size()-1);
    }

    private void initializeQuestions() {
        for (int i = 1; i <= 27; i++)
        {
            masterQuestions.put(i, new Question(db, i));
        }
    }

}
