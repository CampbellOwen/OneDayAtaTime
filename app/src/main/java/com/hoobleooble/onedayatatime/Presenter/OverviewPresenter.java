package com.hoobleooble.onedayatatime.Presenter;

import android.app.Presentation;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.hoobleooble.onedayatatime.Model.Answer;
import com.hoobleooble.onedayatatime.Model.DbHelper;
import com.hoobleooble.onedayatatime.Overview_Main;
import com.hoobleooble.onedayatatime.Utilities.ParagraphGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Owen Campbell on 9/17/2017.
 */

public class OverviewPresenter {

    private Context viewContext;
    private Date currentDate;
    private DbHelper dbHelper;
    HashMap<Integer, Answer> answers;


    public Date getCurrentDate()
    {
        return currentDate;
    }

    public void setCurrentDate(Date newDate)
    {
        currentDate = newDate;
    }

    public OverviewPresenter(Context context)
    {
        viewContext = context;
        dbHelper = new DbHelper(context);
        answers = new HashMap<Integer, Answer>();

    }

    public void updateAnswers()
    {
        for(int i = 1; i<=27; i++){
            try {
                Answer ans = new Answer(dbHelper.getReadableDatabase(), i, currentDate.getTime());
                answers.put(ans.getQid(), ans);

                Log.d("ANSWER", "RETRIEVED ANSWER: qid: " + Integer.toString(ans.getQid()) + ", date: " + Long.toString(ans.getDate()) + ", answer: " + ans.getAnswer());
            }
            catch( Exception e){
                Log.d("ANSWER", "Answer qid: " + Integer.toString(i) + " not found for date: " + Long.toString(currentDate.getTime()));
            }
        }

        generateParagraph();

    }

    private void generateParagraph()
    {
        ParagraphGenerator paraGen = new ParagraphGenerator(viewContext);
        String paragraph = paraGen.generate(answers);

        ((Overview_Main)viewContext).setParagraph(paragraph);
    }
}
