package com.hoobleooble.onedayatatime.Presenter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hoobleooble.onedayatatime.Model.Question;
import com.hoobleooble.onedayatatime.R;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by Owen Campbell on 9/16/2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    QuestionsPresenter presenter;
    private ClickListener listener;

    public RVAdapter(QuestionsPresenter presenter, ClickListener listener)
    {
        this.presenter = presenter;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position)
    {
        String questionType = presenter.getQuestions().get(position).getType();
        int type;
        switch (questionType){
            case "bool":
                type = 0;
                break;
            case "string":
                type = 1;
                break;
            case "int":
            default:
                type = 2;
                break;
        }

        return type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        RecyclerView.ViewHolder vh;
        switch( viewType ){
            case 0:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_bool, parent, false);
                vh = new QuestionBoolViewHolder(v);
                break;
            case 1:
            default:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_string, parent, false);
                vh = new QuestionStringViewHolder(v, listener);
                break;
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        switch(holder.getItemViewType())
        {
            case 0:
                QuestionBoolViewHolder qbvh = (QuestionBoolViewHolder)holder;
                qbvh.question.setText(presenter.getQuestions().get(position).getText());
                break;
            case 2:
                QuestionStringViewHolder qivh = (QuestionStringViewHolder)holder;
                qivh.answer.setInputType(InputType.TYPE_CLASS_NUMBER);
            case 1:
            default:
                QuestionStringViewHolder qsvh = (QuestionStringViewHolder)holder;
                qsvh.question.setText(presenter.getQuestions().get(position).getText());
                qsvh.subText.setText(presenter.getQuestions().get(position).getSubText());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return presenter.getQuestions().size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class QuestionStringViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private WeakReference<ClickListener> listenerRef;

        CardView cv;
        TextView question;
        TextView subText;
        EditText answer;
        Button button;

        public QuestionStringViewHolder(View itemView, ClickListener listener)
        {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            question = (TextView)itemView.findViewById(R.id.question);
            subText = (TextView)itemView.findViewById(R.id.subtext);
            answer = (EditText)itemView.findViewById(R.id.answer);
            button = (Button)itemView.findViewById(R.id.nextButton);
            listenerRef = new WeakReference<>(listener);

            button.setOnClickListener(this);

        }

        @Override
        public void onClick(View v)
        {
            listenerRef.get().onPositionClicked(v, getAdapterPosition());
        }
    }

    public static class QuestionBoolViewHolder extends RecyclerView.ViewHolder
    {
        CardView cv;
        TextView question;
        Button noButton;
        Button yesButton;

        public QuestionBoolViewHolder(View itemView)
        {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            question = (TextView)itemView.findViewById(R.id.question);
            noButton = (Button)itemView.findViewById(R.id.noButton);
            yesButton = (Button)itemView.findViewById(R.id.yesButton);
        }
    }
}
