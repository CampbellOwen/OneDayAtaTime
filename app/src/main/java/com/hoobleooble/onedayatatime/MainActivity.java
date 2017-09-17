package com.hoobleooble.onedayatatime;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewParent;
import android.widget.EditText;

import com.hoobleooble.onedayatatime.Model.Answer;
import com.hoobleooble.onedayatatime.Model.DbHelper;
import com.hoobleooble.onedayatatime.Model.Question;
import com.hoobleooble.onedayatatime.Model.QuestionContract;
import com.hoobleooble.onedayatatime.Presenter.ClickListener;
import com.hoobleooble.onedayatatime.Presenter.QuestionsPresenter;
import com.hoobleooble.onedayatatime.Presenter.RVAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Question> questions;
    public RVAdapter adapter;
    public RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rv = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        final QuestionsPresenter presenter = new QuestionsPresenter(this);

         adapter = new RVAdapter(presenter, new ClickListener() {
            @Override
            public void onPositionClicked(View v, int position) {

                switch(v.getId()){
                    case R.id.yesButton:
                            presenter.getNextQuestion(true);
                        break;
                    case R.id.noButton:
                            presenter.getNextQuestion(false);
                        break;
                    case R.id.nextButton:
                        Log.d("CLICKED", Integer.toString(v.getId()) ) ;
                        View parent = (View)v.getParent();
                        EditText answer = (EditText) parent.findViewById(R.id.answer);
                        Log.d("CLICKED", answer.getText().toString());
                        int qid = presenter.getQuestions().get(position).getQid();
                        Log.d("CLICKED", Integer.toString(qid));
                        presenter.storeAnswer(answer.getText().toString(), qid);
                        presenter.getNextQuestion(true);
                        break;
                }


            }
        });
        rv.setAdapter(adapter);

        //dbHelper.onUpgrade(db, 1, 1);

        //Question question = Question.Create(db, 2, 1, "Did you eat breakfast?", "bool");

        //Question question = new Question(dbHelper.getReadableDatabase(), 2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
