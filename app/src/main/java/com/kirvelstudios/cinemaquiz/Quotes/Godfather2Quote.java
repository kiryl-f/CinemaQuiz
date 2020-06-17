package com.kirvelstudios.cinemaquiz.Quotes;

import android.content.Context;

import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class Godfather2Quote extends Quote {
    Context context;
    String text;
    String filmName;
    private String link = "https://www.imdb.com/title/tt0071562/?ref_=nv_sr_srsg_3";
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
    public Godfather2Quote(Context context) {
        super(context);
        this.context = context;
        this.text = context.getString(R.string.godfather2_quote);
        this.filmName = context.getString(R.string.godfather2);
        this.wrongAnswers = new ArrayList<>();
        wrongAnswers.add(context.getString(R.string.godfather));
        wrongAnswers.add(context.getString(R.string.casino));
        wrongAnswers.add(context.getString(R.string.road_to_perdition));
    }
}
