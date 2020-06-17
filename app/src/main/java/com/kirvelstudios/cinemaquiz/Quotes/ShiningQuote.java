package com.kirvelstudios.cinemaquiz.Quotes;

import android.content.Context;

import com.kirvelstudios.cinemaquiz.R;


import java.util.ArrayList;

public class ShiningQuote extends Quote {

        String text;
        String filmName;
        private String link = "https://www.imdb.com/title/tt0081505/?ref_=nv_sr_srsg_0";
        private ArrayList<String> wrongAnswers;
        Context context;

    public String getLink() {
        return link;
    }
        public ShiningQuote(Context context) {
            super(context);
            this.context = context;
            this.text = context.getResources().getString(R.string.shining_quote);
            this.filmName = context.getString(R.string.shining);
            this.wrongAnswers = new ArrayList<>();
            wrongAnswers.add(context.getString(R.string.jd));
            wrongAnswers.add(context.getString(R.string.meet_joe));
            wrongAnswers.add(context.getString(R.string.morning_v));
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
