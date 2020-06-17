package com.kirvelstudios.cinemaquiz.Quotes;

import android.content.Context;

import com.kirvelstudios.cinemaquiz.R;


import java.util.ArrayList;

public class FrankensteinQuote extends Quote {

    String text;
    String filmName;
    private String link = "https://www.imdb.com/title/tt0021884/?ref_=nv_sr_srsg_8";
    ArrayList<String> wrongAnswers;
    Context context;
    public String getLink() {
        return link;
    }
    public FrankensteinQuote(Context context) {
        super(context);
        this.context = context;
        this.text = context.getString(R.string.frankenstein_quote);
        this.filmName = context.getString(R.string.frankenstein);
        this.wrongAnswers = new ArrayList<>();
        wrongAnswers.add(context.getString(R.string.street_horror));
        wrongAnswers.add(context.getString(R.string.exorcist));
        wrongAnswers.add(context.getString(R.string.jacob_letter));
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
