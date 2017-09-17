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

        HashMap<Integer, String> rateDay = new HashMap<Integer, String>();

        rateDay.put(1, "a very bad day");
        rateDay.put(2, "a bad day");
        rateDay.put(3, "a fairly bad day");
        rateDay.put(4, "a moderately bad day");
        rateDay.put(5, "an average day");
        rateDay.put(6, "a moderately good day");
        rateDay.put(7, "a fairly good day");
        rateDay.put(8, "a good day");
        rateDay.put(9, "a great day");
        rateDay.put(10, "an awesome day");


        HashMap<Integer, String> rateInteraction = new HashMap<Integer, String>();

        rateInteraction.put(1, "truly horrible");
        rateInteraction.put(2, "very unenjoyable");
        rateInteraction.put(3, "unenjoyable");
        rateInteraction.put(4, "somewhat unenjoyable");
        rateInteraction.put(5, "average");
        rateInteraction.put(6, "somewhat enjoyable");
        rateInteraction.put(7, "enjoyable");
        rateInteraction.put(8, "very enjoyable");
        rateInteraction.put(9, "thoroughly enjoyable");
        rateInteraction.put(10, "incredibly enjoyable");


        HashMap<Integer, String> rateSleep = new HashMap<Integer, String>();

        rateSleep.put(1, "nowhere near enough sleep");
        rateSleep.put(2, "barely any sleep");
        rateSleep.put(3, "very little sleep");
        rateSleep.put(4, "little sleep");
        rateSleep.put(5, "fairly little sleep");
        rateSleep.put(6, "not quite enough sleep");
        rateSleep.put(7, "almost enough sleep");
        rateSleep.put(8, "a full 8 hours of sleep");
        rateSleep.put(9, "more than enough sleep");
        rateSleep.put(10, "more than enough sleep");


        HashMap<Integer, String> rateMeal = new HashMap<Integer, String>();

        rateMeal.put(1, "very unhealthy");
        rateMeal.put(2, "unhealthily");
        rateMeal.put(3, "fairly unhealthily");
        rateMeal.put(4, "moderately unhealthily");
        rateMeal.put(5, "neither healthily nor unhealthily");
        rateMeal.put(6, "moderately healthily");
        rateMeal.put(7, "fairly healthily");
        rateMeal.put(8, "fairly healthily");
        rateMeal.put(9, "healthily");
        rateMeal.put(10, "very healthily");

    }



}
