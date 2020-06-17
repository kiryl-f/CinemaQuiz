package com.kirvelstudios.cinemaquiz.Quotes;

import android.content.Context;

import com.kirvelstudios.cinemaquiz.R;


import java.util.ArrayList;

public class ShurickQuote extends Quote {

    String text;
    String filmName;
    ArrayList<String> wrongAnswers;
    private String link = "https://www.imdb.com/title/tt0059550/?ref_=nv_sr_srsg_0";
    Context context;

    public String getLink() {
        return link;
    }
    public ShurickQuote(Context context) {
        super(context);
        this.text = context.getString(R.string.shurick_quote);
        this.filmName = context.getString(R.string.shurick);
        this.wrongAnswers = new ArrayList<>();
        wrongAnswers.add(context.getString(R.string.ivan_v));
        wrongAnswers.add(context.getString(R.string.max_p));
        wrongAnswers.add(context.getString(R.string.old_comedy));
    }

    public String getText() {
        return text;
    }

    public String getFilmName() {
        return filmName;
    }

    public ArrayList<String> getWrongAnswers() {
        return wrongAnswers;
    }
}
