package com.kirvelstudios.cinemaquiz.Quotes;

import android.content.Context;

import com.kirvelstudios.cinemaquiz.R;


import java.util.ArrayList;

public class GodfatherQuote extends Quote {

    String text;
    String filmName;
    private String link = "https://www.imdb.com/title/tt0068646/?ref_=nv_sr_srsg_0";
    ArrayList<String> wrongAnswers;
    Context context;

    public GodfatherQuote(Context context) {
        super(context);
        this.context = context;
        this.text = context.getString(R.string.godfather_quote);
        this.filmName = context.getString(R.string.godfather);
        this.wrongAnswers = new ArrayList<>();
        wrongAnswers.add(context.getString(R.string.heat));
        wrongAnswers.add(context.getString(R.string.goodfellas));
        wrongAnswers.add(context.getString(R.string.casino));
    }

    public String getLink() {
        return link;
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
