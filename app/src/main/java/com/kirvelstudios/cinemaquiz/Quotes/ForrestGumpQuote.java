package com.kirvelstudios.cinemaquiz.Quotes;

import android.content.Context;

import com.kirvelstudios.cinemaquiz.R;


import java.util.ArrayList;

public class ForrestGumpQuote extends Quote {

    String text;
    String filmName;
    private String link = "https://www.imdb.com/title/tt0109830/?ref_=nv_sr_srsg_0";
    ArrayList<String> wrongAnswers;
    Context context;
    public String getLink() {
        return link;
    }
    public ForrestGumpQuote(Context context) {
        super(context);
        this.context = context;
        this.text = context.getString(R.string.forrest_gump_quote);
        this.filmName = context.getString(R.string.forrest_gump);
        this.wrongAnswers = new ArrayList<>();
        wrongAnswers.add(context.getString(R.string.green_book));
        wrongAnswers.add(context.getString(R.string.breakfast));
        wrongAnswers.add(context.getString(R.string.back_future));
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
