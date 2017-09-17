package com.hoobleooble.onedayatatime.Utilities;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;

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


    public Truss generate(HashMap<Integer, Answer> answers)
    {
        Truss sb = new Truss();
        if( answers.isEmpty()){
            return sb;
        }
        sb.append(context.getText(R.string.hardcoded_madlibs_1));
        Answer ans;

        ans = answers.get(19);
        if (ans != null){
            if( ans.getAnswer().equals("no")){
                sb.pushSpan(new StyleSpan(android.graphics.Typeface.BOLD));
                sb.append(" no sleep");
                sb.popSpan();
            }
            else {
                int rating = Integer.parseInt(answers.get(20).getAnswer());
                sb.append(" ");
                sb.pushSpan(new StyleSpan(android.graphics.Typeface.BOLD));
                sb.append(RatingConverter.convert(rating, RatingConverter.ratingType.sleep));
                sb.popSpan();
            }
            sb.append(". ");
        }
        ans = answers.get(1);
        if( ans != null){
            if (ans.getAnswer().equals("yes")){
                sb.append(context.getText(R.string.hardcoded_madlibs_2));
                sb.append(" ");
                sb.pushSpan(new StyleSpan(android.graphics.Typeface.BOLD));
                sb.append(answers.get(2).getAnswer());
                sb.popSpan();
                sb.append(". ");
            }
            else{
                sb.append("I ");
                sb.pushSpan(new StyleSpan(android.graphics.Typeface.BOLD));
                sb.append("didn't eat breakfast. ");
                sb.popSpan();
            }
        }

        ans = answers.get(4);
        if( ans != null){
            if (ans.getAnswer().equals("yes")){
                sb.append(context.getText(R.string.hardcoded_madlibs_3));
                sb.append(" ");
                sb.pushSpan(new StyleSpan(android.graphics.Typeface.BOLD));
                sb.append(answers.get(5).getAnswer());
                sb.popSpan();
                sb.append(". ");
            }
            else{
                sb.append("I ");
                sb.pushSpan(new StyleSpan(android.graphics.Typeface.BOLD));
                sb.append("didn't eat lunch. ");
                sb.popSpan();
            }
        }

        ans = answers.get(7);
        if( ans != null){
            if (ans.getAnswer().equals("yes")){
                sb.append(context.getText(R.string.hardcoded_madlibs_6));
                sb.append(" ");
                sb.pushSpan(new StyleSpan(android.graphics.Typeface.BOLD));
                sb.append(answers.get(8).getAnswer());
                sb.popSpan();
                sb.append(". ");
            }
            else{
                sb.append("I ");
                sb.pushSpan(new StyleSpan(android.graphics.Typeface.BOLD));
                sb.append("didn't eat dinner. ");
                sb.popSpan();
            }
        }

        int totalHealthy = 0;
        int count = 0;

        Integer[] scores = new Integer[]{3, 6, 9};
        for( int i = 0; i < scores.length; i++){
            ans = answers.get(scores[i]);
            if( ans != null){
                totalHealthy += Integer.parseInt(ans.getAnswer());
                count++;
            }
        }

        int average = (int)Math.round((1.0*totalHealthy)/(count*1.0));

        if (count > 0){
            sb.append(context.getText(R.string.hardcoded_madlibs_7));
            sb.append(" ");
            sb.pushSpan(new StyleSpan(android.graphics.Typeface.BOLD));
            sb.append(RatingConverter.convert(average, RatingConverter.ratingType.meal));
            sb.popSpan();
            sb.append(". ");
        }

        ans = answers.get(16);
        if( ans != null){
            if (ans.getAnswer().equals("yes")){
                sb.append(context.getText(R.string.hardcoded_madlibs_8));
                sb.append(" ");
                sb.pushSpan(new StyleSpan(android.graphics.Typeface.BOLD));
                sb.append(answers.get(18).getAnswer());
                sb.popSpan();
                sb.append(" ");
                sb.append(context.getText(R.string.hardcoded_madlibs_9));
                sb.append(" ");
                sb.pushSpan(new StyleSpan(android.graphics.Typeface.BOLD));
                sb.append(answers.get(17).getAnswer());
                sb.popSpan();
                sb.append(". ");
            }
        }

        ans = answers.get(22);
        if( ans != null) {
            if (ans.getAnswer().equals("yes")) {
                sb.append(context.getText(R.string.hardcoded_madlibs_10));
                sb.append(" ");
                sb.pushSpan(new StyleSpan(android.graphics.Typeface.BOLD));
                sb.append(answers.get(23).getAnswer());
                sb.popSpan();
                sb.append(" ");
                sb.append(context.getText(R.string.hardcoded_madlibs_11));
                sb.append(". ");
            }
            else{
                sb.append("I ");
                sb.pushSpan(new StyleSpan(android.graphics.Typeface.BOLD));
                sb.append("didn't take time for myself today. ");
                sb.popSpan();
            }

        }

        ans = answers.get(24);
        if( ans != null) {
            if (ans.getAnswer().equals("yes")) {
                sb.append(context.getText(R.string.hardcoded_madlibs_12));
                sb.append(" ");
                sb.pushSpan(new StyleSpan(android.graphics.Typeface.BOLD));
                sb.append(answers.get(25).getAnswer());
                sb.popSpan();
                sb.append(" ");
                sb.append(context.getText(R.string.hardcoded_madlibs_13));
                sb.append(" ");
                sb.pushSpan(new StyleSpan(android.graphics.Typeface.BOLD));
                sb.append(RatingConverter.convert(Integer.parseInt(answers.get(26).getAnswer()), RatingConverter.ratingType.interaction));
                sb.popSpan();
                sb.append(". ");
            }

        }

        ans = answers.get(26);
        if( ans != null) {
            sb.append(context.getText(R.string.hardcoded_madlibs_14));
            sb.append(" ");
            sb.pushSpan(new StyleSpan(android.graphics.Typeface.BOLD));
            sb.append(RatingConverter.convert(Integer.parseInt(answers.get(26).getAnswer()), RatingConverter.ratingType.day));
            sb.popSpan();
            sb.append(". ");
        }

        return sb;
    }
}
