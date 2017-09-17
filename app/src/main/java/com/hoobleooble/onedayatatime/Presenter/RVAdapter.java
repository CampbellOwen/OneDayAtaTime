package com.hoobleooble.onedayatatime.Presenter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hoobleooble.onedayatatime.Model.Question;
import com.hoobleooble.onedayatatime.R;

/**
 * Created by Owen Campbell on 9/16/2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.QuestionViewHolder>
{
    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(QuestionViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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
        }
    }
}
