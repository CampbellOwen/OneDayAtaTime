package com.hoobleooble.onedayatatime.Presenter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hoobleooble.onedayatatime.Model.Question;
import com.hoobleooble.onedayatatime.R;

import java.util.List;

/**
 * Created by Owen Campbell on 9/16/2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.QuestionViewHolder>
{
    List<Question> questions;
    public RVAdapter(List<Question> questions)
    {
        this.questions = questions;
    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout)
        return null;
    }

    @Override
    public void onBindViewHolder(QuestionViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public static class QuestionViewHolder extends RecyclerView.ViewHolder
    {
        CardView cv;
        TextView question;
        TextView subText;
        EditText answer;
        Button button;

        public QuestionViewHolder(View itemView)
        {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            question = (TextView)itemView.findViewById(R.id.question);
            subText = (TextView)itemView.findViewById(R.id.subtext);
            answer = (EditText)itemView.findViewById(R.id.answer);
            button = (Button)itemView.findViewById(R.id.nextButton);
        }
    }
}
