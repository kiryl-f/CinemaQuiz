package com.kirvelstudios.cinemaquiz.Quotes;

import android.content.Context;

import com.kirvelstudios.cinemaquiz.R;


import java.util.ArrayList;

public class AppoloQuote extends Quote {
    String text;
    String filmName;
    ArrayList<String> wrongAnswers;
    Context context;
    private String link = "https://www.imdb.com/title/tt0112384/?ref_=nv_sr_srsg_0";
    public String getLink() {
        return link;
    }

    public AppoloQuote(Context context) {
        super(context);
        this.context = context;
        this.text = context.getString(R.string.appolo_quote);
        this.filmName = context.getString(R.string.appolo);
        this.wrongAnswers = new ArrayList<>();
        wrongAnswers.add(context.getString(R.string.man_on_moon));
        wrongAnswers.add(context.getString(R.string.mars));
        wrongAnswers.add(context.getString(R.string.twelwe));
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
