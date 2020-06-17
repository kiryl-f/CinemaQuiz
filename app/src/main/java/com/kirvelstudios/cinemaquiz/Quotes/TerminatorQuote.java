package com.kirvelstudios.cinemaquiz.Quotes;

import android.content.Context;

import com.kirvelstudios.cinemaquiz.R;


import java.util.ArrayList;

public class TerminatorQuote extends Quote {
    Context context;
    String text;
    String filmName;
    private String link = "https://www.imdb.com/title/tt0088247/?ref_=nv_sr_srsg_6";
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
    public TerminatorQuote(Context context) {
        super(context);
        this.context = context;
        this.text = context.getString(R.string.terminator_quote);
        this.filmName = context.getString(R.string.terminator);
        this.wrongAnswers = new ArrayList<>();
        wrongAnswers.add(context.getString(R.string.titanic));
        wrongAnswers.add(context.getString(R.string.taxi));
        wrongAnswers.add(context.getString(R.string.old_comedy));
    }
}
