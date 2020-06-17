package com.kirvelstudios.cinemaquiz.Quotes;

import android.content.Context;

import java.util.ArrayList;

public class Quote {

    String text;
    String filmName;
    private String link = "";
    ArrayList <String> wrongAnswers;
    Context context;

    public Quote(Context context) {
        this.context = context;
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
