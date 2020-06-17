package com.kirvelstudios.cinemaquiz.Directors.MediumLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class DePalmaDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0000361/?ref_=nv_sr_srsg_0";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    public DePalmaDirector() {
        levelNumber = 2;
        directorNumber = 3;

        name = "Брайан де Пальма";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.untouchables_poster);
        posters.add(R.drawable.scarface_poster);
        posters.add(R.drawable.mission_poster);


        directors.add("Федерико Феллини");
        directors.add("Паоло Соррентино");
        directors.add("Орсон Уэлс");
        directors.add(name);
    }

    @Override
    public String getUrl() {
        return url;
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
