package com.kirvelstudios.cinemaquiz.Quotes;

import android.content.Context;

import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class ApocalypseNowQuote extends Quote {

    String text;
    String filmName;
    ArrayList<String> wrongAnswers;
    private String link = "https://www.imdb.com/title/tt0078788/";
    Context context;

    public ApocalypseNowQuote(Context context) {
        super(context);
        this.context = context;
        this.text = context.getResources().getString(R.string.apocalypse_quote);
        this.filmName = context.getResources().getString(R.string.ap_now);
        this.wrongAnswers = new ArrayList<>();
        wrongAnswers.add(context.getResources().getString(R.string.were_soldiers));
        wrongAnswers.add(context.getResources().getString(R.string.morning_v));
        wrongAnswers.add(context.getString(R.string.cas_of_war));
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
