package com.hoobleooble.onedayatatime;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import com.hoobleooble.onedayatatime.Presenter.OverviewPresenter;

import java.util.Calendar;
import java.util.HashMap;

public class Overview_Main extends AppCompatActivity {
    private CalendarView calendar;
    OverviewPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new OverviewPresenter(this);

        calendar = (CalendarView)findViewById(R.id.calendarView);
        calendar.setDate(Calendar.getInstance().getTime().getTime());

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.clear();
                calendar.set(year, month, dayOfMonth);
                presenter.setCurrentDate( calendar.getTime() );
                presenter.updateAnswers();
                Log.d("CALENDAR", Long.toString(presenter.getCurrentDate().getTime()));
            }
        });

        Button quiz = (Button)findViewById(R.id.startQuestionsButton);
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQuestions();
            }
        });
    }

    private void startQuestions()
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("date", presenter.getCurrentDate().getTime());
        this.startActivity(intent);
    }

        public String concatStrings(String string1, String string2) {
            return string1 + string2;
        }

    public static void main(String args[]) {












    }



}
