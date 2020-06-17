package com.kirvelstudios.cinemaquiz.Directors.LastLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class VilnevDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0898288/?ref_=tt_ov_dr";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public VilnevDirector() {
        levelNumber = 4;
        directorNumber = 7;

        name = "Денни Вильнёв";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.sicario_poster);
        posters.add(R.drawable.b2049_poster);

        directors.add("Кен Бернс");
        directors.add("Тони Гилрой");
        directors.add("Томми Вайсо");
        directors.add(name);
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
