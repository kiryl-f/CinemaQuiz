package com.kirvelstudios.cinemaquiz.Quotes;

import android.content.Context;

import com.kirvelstudios.cinemaquiz.R;


import java.util.ArrayList;

public class ScarfaceQuote extends Quote {
    Context context;
    String text;
    String filmName;
    private String link = "https://www.imdb.com/title/tt0086250/?ref_=nv_sr_srsg_0";
    private ArrayList<String> wrongAnswers;

    public String getLink() {
        return link;
    }
    public String getFilmName() {
        return filmName;
    }
    public String getText() {
        return text;
    }
    public ArrayList<String> getWrongAnswers() {
        return wrongAnswers;
    }
    public ScarfaceQuote(Context context) {
        super(context);
        this.context = context;
        this.text = context.getString(R.string.scarface_quote);
        this.filmName = context.getString(R.string.scarface);
        this.wrongAnswers = new ArrayList<>();
        wrongAnswers.add(context.getString(R.string.gangsters));
        wrongAnswers.add(context.getString(R.string.ny_gangs));
        wrongAnswers.add(context.getString(R.string.old_comedy));
    }
}
