package com.kirvelstudios.cinemaquiz.Quotes;

import android.content.Context;

import com.kirvelstudios.cinemaquiz.R;


import java.util.ArrayList;

public class DirtyHarryQuote extends Quote {
    Context context;
    String text;
    String filmName;
    private String link = "https://www.imdb.com/title/tt0066999/?ref_=nv_sr_srsg_0";
    private ArrayList<String> wrongAnswers;
    public String getText() {
        return text;
    }
    public String getLink() {
        return link;
    }
    public String getFilmName() {
        return filmName;
    }

    public ArrayList<String> getWrongAnswers() {
        return wrongAnswers;
    }
    public DirtyHarryQuote(Context context) {
        super(context);
        this.context = context;
        this.text = context.getString(R.string.dirty_harry_quote);
        this.filmName = context.getString(R.string.dirty_harry);
        this.wrongAnswers = new ArrayList<>();
        wrongAnswers.add(context.getString(R.string.imp_strike));
        wrongAnswers.add(context.getString(R.string.revolver));
        wrongAnswers.add(context.getString(R.string.jackal));
    }
}
