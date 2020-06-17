package com.kirvelstudios.cinemaquiz.Directors.MediumLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class SnyderDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0811583/?ref_=nv_sr_srsg_0";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public SnyderDirector() {
        levelNumber = 2;
        directorNumber = 7;

        name = "Зак Снайдер";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.watchmen_poster);
        posters.add(R.drawable.s300_poster);
        posters.add(R.drawable.b_vs_s_poster);

        directors.add("Декстер Флетчер");
        directors.add(name);
        directors.add("Майкл Бэй");
        directors.add("Нил Маршалл");
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
