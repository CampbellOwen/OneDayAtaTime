package com.hoobleooble.onedayatatime.Utilities;

import android.content.Context;

import com.hoobleooble.onedayatatime.Model.Answer;
import com.hoobleooble.onedayatatime.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Owen Campbell on 9/17/2017.
 */

public class ParagraphGenerator {

    private HashMap<Integer, String> strings;
    private Context context;

    public ParagraphGenerator(Context context)
    {
        this.context = context;
    }


    public String generate(HashMap<Integer, Answer> answers)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getText(R.string.hardcoded_madlibs_1));
        Answer ans;

        ans = answers.get(19);
        if (ans != null){
            if( ans.getAnswer().equals("no")){
                sb.append(" no sleep");
            }
            else {
                int rating = Integer.parseInt(answers.get(20).getAnswer());
                sb.append(" ");
                sb.append(RatingConverter.convert(rating, RatingConverter.ratingType.sleep));
            }
            sb.append(".");
        }
        ans = answers.get(1);
        if( ans != null){
            if (ans.getAnswer().equals("yes")){
                sb.append(context.getText(R.string.hardcoded_madlibs_2));
                sb.append(" ");
                sb.append(answers.get(2).getAnswer());
            }
        }

        ans = answers.get(4);
        if( ans != null){
            if (ans.getAnswer().equals("yes")){
                sb.append(context.getText(R.string.hardcoded_madlibs_3));
                sb.append(" ");
                sb.append(answers.get(5).getAnswer());
            }
        }

        ans = answers.get(7);
        if( ans != null){
            if (ans.getAnswer().equals("yes")){
                sb.append(context.getText(R.string.hardcoded_madlibs_6));
                sb.append(" ");
                sb.append(answers.get(8).getAnswer());
            }
        }




        return sb.toString();
    }
}
