package com.kirvelstudios.cinemaquiz.Quotes;

import android.content.Context;

import com.kirvelstudios.cinemaquiz.R;


import java.util.ArrayList;

public class SomeLikeItHotQuote extends Quote {
    private String link = "https://www.imdb.com/title/tt0053291/?ref_=nv_sr_srsg_0";
    Context context;
    String text;
    String filmName;
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
    public SomeLikeItHotQuote(Context context) {
        super(context);
        this.context = context;
        this.text = context.getString(R.string.some_like_it_hot_quote);
        this.filmName = context.getString(R.string.some_like_it_hot);
        this.wrongAnswers = new ArrayList<>();
        wrongAnswers.add(context.getString(R.string.dirty_harry));
        wrongAnswers.add(context.getString(R.string.ny_gangs));
        wrongAnswers.add(context.getString(R.string.old_comedy));
    }
}
