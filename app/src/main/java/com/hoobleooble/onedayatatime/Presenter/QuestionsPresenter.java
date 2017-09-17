package com.hoobleooble.onedayatatime.Presenter;

import android.app.Presentation;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.hoobleooble.onedayatatime.MainActivity;
import com.hoobleooble.onedayatatime.Model.Answer;
import com.hoobleooble.onedayatatime.Model.DbHelper;
import com.hoobleooble.onedayatatime.Model.Question;
import com.hoobleooble.onedayatatime.Overview_Main;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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


        questions.add(masterQuestions.get(14));


    }

    public List<Question> getQuestions()
    {
        return this.questions;
    }

    public boolean storeAnswer(String answer, int qid, long date)
    {
        try{

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
        Question currQuestion = questions.get(questions.size()-1);
        int nextQid = includeSubquestion ? (currQuestion.getNextSubQid() != -1 ? currQuestion.getNextSubQid() : currQuestion.getNextQid()) : currQuestion.getNextQid();
        if( nextQid == -1 ){
            //question time is OVER
            //switch to da overview
            viewContext.finish();
            //Intent intent = new Intent(viewContext, Overview_Main.class);
            //viewContext.startActivity(intent);
        }
        else {
            questions.add(masterQuestions.get(nextQid));
            viewContext.adapter.notifyItemChanged(questions.size() - 1);
            viewContext.rv.scrollToPosition(questions.size() - 1);
        }
    }

    private void initializeQuestions() {
        masterQuestions.put(14, new Question(db, 14));
        masterQuestions.get(14).setNextQid(10);
        masterQuestions.get(14).setNextSubQid(1);

        masterQuestions.put(1, new Question(db, 1));
        masterQuestions.get(1).setNextQid(4);
        masterQuestions.get(1).setNextSubQid(2);

        masterQuestions.put(2, new Question(db, 2));
        masterQuestions.get(2).setNextQid(3);

        masterQuestions.put(3, new Question(db, 3));
        masterQuestions.get(3).setNextQid(4);


        masterQuestions.put(4, new Question(db, 4));
        masterQuestions.get(4).setNextQid(7);
        masterQuestions.get(4).setNextSubQid(5);

        masterQuestions.put(5, new Question(db, 5));
        masterQuestions.get(5).setNextQid(6);

        masterQuestions.put(6, new Question(db, 6));
        masterQuestions.get(6).setNextQid(7);


        masterQuestions.put(7, new Question(db, 7));
        masterQuestions.get(7).setNextQid(10);
        masterQuestions.get(7).setNextSubQid(8);

        masterQuestions.put(8, new Question(db, 8));
        masterQuestions.get(8).setNextQid(9);

        masterQuestions.put(9, new Question(db, 9));
        masterQuestions.get(9).setNextQid(10);


        masterQuestions.put(10, new Question(db, 10));
        masterQuestions.get(10).setNextQid(12);
        masterQuestions.get(10).setNextSubQid(11);

        masterQuestions.put(11, new Question(db, 11));
        masterQuestions.get(11).setNextQid(12);


        masterQuestions.put(12, new Question(db, 12));
        masterQuestions.get(12).setNextQid(13);

        masterQuestions.put(13, new Question(db, 13));
        masterQuestions.get(13).setNextQid(16);


        masterQuestions.put(16, new Question(db, 16));
        masterQuestions.get(16).setNextQid(19);
        masterQuestions.get(16).setNextSubQid(17);

        masterQuestions.put(17, new Question(db, 17));
        masterQuestions.get(17).setNextQid(18);

        masterQuestions.put(18, new Question(db, 18));
        masterQuestions.get(18).setNextQid(19);


        masterQuestions.put(19, new Question(db, 19));
        masterQuestions.get(19).setNextQid(21);
        masterQuestions.get(19).setNextSubQid(20);

        masterQuestions.put(20, new Question(db, 20));
        masterQuestions.get(20).setNextQid(21);


        masterQuestions.put(21, new Question(db, 21));
        masterQuestions.get(21).setNextQid(27);
        masterQuestions.get(21).setNextSubQid(22);

        masterQuestions.put(22, new Question(db, 22));
        masterQuestions.get(22).setNextQid(24);
        masterQuestions.get(22).setNextSubQid(23);

        masterQuestions.put(23, new Question(db, 23));
        masterQuestions.get(23).setNextQid(24);


        masterQuestions.put(24, new Question(db, 24));
        masterQuestions.get(24).setNextQid(27);
        masterQuestions.get(24).setNextSubQid(25);

        masterQuestions.put(25, new Question(db, 25));
        masterQuestions.get(25).setNextQid(26);

        masterQuestions.put(26, new Question(db, 26));
        masterQuestions.get(26).setNextQid(27);

        masterQuestions.put(27, new Question(db, 27));

    }

}
