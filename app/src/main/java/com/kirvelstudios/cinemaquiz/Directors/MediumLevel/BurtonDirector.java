package com.kirvelstudios.cinemaquiz.Directors.MediumLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class BurtonDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0000318/?ref_=nv_sr_srsg_3";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    public BurtonDirector() {
        levelNumber = 2;
        directorNumber = 12;

        name = "Тим Бертон";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.sleeply_hollow_poster);
        posters.add(R.drawable.big_fish_poster);
        posters.add(R.drawable.batman_poster);

        directors.add(name);
        directors.add("Клайв Оуэн");
        directors.add("Эзра Миллер");
        directors.add("Нил Маршалл");
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
