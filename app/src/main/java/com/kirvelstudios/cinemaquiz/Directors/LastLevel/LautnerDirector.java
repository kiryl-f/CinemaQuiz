package com.kirvelstudios.cinemaquiz.Directors.LastLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class LautnerDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0491626/?ref_=tt_ov_dr";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public LautnerDirector() {
        levelNumber = 4;
        directorNumber = 1;

        name = "Жорж Лонтер";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.le_professionnel_poster);

        directors.add("Жюст Жакен");
        directors.add(name);
        directors.add("Луи Ганье");
        directors.add("Андре Барсак");
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
