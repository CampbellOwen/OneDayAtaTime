package com.hoobleooble.onedayatatime;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CalendarView;

import java.util.Calendar;
import java.util.HashMap;

public class Overview_Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CalendarView calendar = (CalendarView)findViewById(R.id.calendarView);
        calendar.setDate(Calendar.getInstance().getTime().getTime());
    }

        public String concatStrings(String string1, String string2) {
            return string1 + string2;
        }

    public static void main(String args[]) {












    }



}
