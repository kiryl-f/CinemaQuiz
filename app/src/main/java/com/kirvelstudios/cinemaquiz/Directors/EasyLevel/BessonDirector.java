package com.kirvelstudios.cinemaquiz.Directors.EasyLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class BessonDirector extends Director {
    String name, url;
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    public BessonDirector() {
        levelNumber = 1;
        directorNumber = 11;

        name = "Люк Бессон";
        posters = new ArrayList<>();
        directors = new ArrayList<>();
        url = "https://www.imdb.com/name/nm0000108/?ref_=nv_sr_srsg_0";

        posters.add(R.drawable.leon_poster);
        posters.add(R.drawable.fifth_elt_poster);
        posters.add(R.drawable.angel_a_poster);
        posters.add(R.drawable.anna_poster);

        directors.add("Жан-Люк Годар");
        directors.add("Франсуа Клюзе");
        directors.add(name);
        directors.add("Жамель Деббуз");
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
