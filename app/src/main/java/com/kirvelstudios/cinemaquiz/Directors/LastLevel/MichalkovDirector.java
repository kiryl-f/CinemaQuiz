package com.kirvelstudios.cinemaquiz.Directors.LastLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class MichalkovDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0586482/?ref_=tt_ov_dr";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public MichalkovDirector() {
        levelNumber = 4;
        directorNumber = 4;

        name = "Никита Михалков";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.svoy_sredi_chuzhuh_poster);

        directors.add(name);
        directors.add("Семен Аранович");
        directors.add("Моисей Беров");
        directors.add("Михаил Голер");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<Integer> getPosters() {
        return posters;
    }

    @Override
    public ArrayList<String> getDirectors() {
        return directors;
    }

    @Override
    public int getLevelNumber() {
        return levelNumber;
    }

    @Override
    public int getDirectorNumber() {
        return directorNumber;
    }
}
