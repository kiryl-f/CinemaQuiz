package com.kirvelstudios.cinemaquiz;

import android.content.Context;

import com.kirvelstudios.cinemaquiz.Quotes.*;

import java.util.ArrayList;

public class QuoteList {

    private ArrayList <Quote> quotes = new ArrayList<>();

    QuoteList(Context context) {quotes.add(new ApocalypseNowQuote(context));
        quotes.add(new ForrestGumpQuote(context));
        quotes.add(new ShiningQuote(context));
        quotes.add(new ShurickQuote(context));
        quotes.add(new GodfatherQuote(context));
        quotes.add(new TitanicQuote(context));
        quotes.add(new FrankensteinQuote(context));
        quotes.add(new AppoloQuote(context));
        quotes.add(new DirtyHarryQuote(context));
        quotes.add(new Godfather2Quote(context));
        quotes.add(new ImpactStrikeQuote(context));
        quotes.add(new LOTRQuote(context));
        quotes.add(new ScarfaceQuote(context));
        quotes.add(new SomeLikeItHotQuote(context));
        quotes.add(new TaxiDriverQuote(context));
        quotes.add(new TerminatorQuote(context));
    }


    public ArrayList<Quote> getQuotes() {
        return quotes;
    }
}
