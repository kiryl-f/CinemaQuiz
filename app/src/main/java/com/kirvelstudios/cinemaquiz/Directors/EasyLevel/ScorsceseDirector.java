package com.kirvelstudios.cinemaquiz.Directors.EasyLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class ScorsceseDirector extends Director {

    String name, url;
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public ScorsceseDirector() {
        levelNumber = 1;
        directorNumber = 9;

        name = "Мартин Скорсезе";
        posters = new ArrayList<>();
        directors = new ArrayList<>();
        url = "https://www.imdb.com/name/nm0000217/?ref_=nv_sr_srsg_1";

        posters.add(R.drawable.departed_poster);
        posters.add(R.drawable.casino_poster);
        posters.add(R.drawable.raging_bull_poster);
        posters.add(R.drawable.shutter_island_poster);


        directors.add("Федерико Феллини");
        directors.add("Паоло Соррентино");
        directors.add(name);
        directors.add("Орсон Уэлс");
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
