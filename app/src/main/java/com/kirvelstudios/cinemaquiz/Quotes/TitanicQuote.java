package com.kirvelstudios.cinemaquiz.Quotes;

import android.content.Context;

import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class TitanicQuote extends Quote {

    String text;
    String filmName;
    ArrayList<String> wrongAnswers;
    Context context;
    private String link = "https://www.imdb.com/title/tt0120338/?ref_=nv_sr_srsg_0";
    public String getLink() {
        return link;
    }
    public TitanicQuote(Context context) {
        super(context);
        this.context = context;
        this.text = context.getString(R.string.titanic_quote);
        this.filmName = context.getString(R.string.titanic);
        this.wrongAnswers = new ArrayList<>();
        wrongAnswers.add(context.getString(R.string.kings_speech));
        wrongAnswers.add(context.getString(R.string.fight_club));
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
