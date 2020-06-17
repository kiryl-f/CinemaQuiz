package com.kirvelstudios.cinemaquiz.Quotes;

import android.content.Context;

import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class TaxiDriverQuote extends Quote {
    Context context;
    String text;
    String filmName;
    private String link = "https://www.imdb.com/title/tt0075314/?ref_=nv_sr_srsg_0";
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
    public TaxiDriverQuote(Context context) {
        super(context);
        this.context = context;
        this.text = context.getString(R.string.tx_driver_quote);
        this.filmName = context.getString(R.string.taxi_driver);
        this.wrongAnswers = new ArrayList<>();
        wrongAnswers.add(context.getString(R.string.departed));
        wrongAnswers.add(context.getString(R.string.ny_gangs));
        wrongAnswers.add(context.getString(R.string.old_comedy));
    }
}
