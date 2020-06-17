package com.kirvelstudios.cinemaquiz.Directors.LastLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class RefnDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0716347/?ref_=nv_sr_srsg_0";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public RefnDirector() {
        levelNumber = 4;
        directorNumber = 5;

        name = "Николас Виндинг Рефн";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.drive_poster);

        directors.add("Лукас Мудиссон");
        directors.add(name);
        directors.add("Томас Винтерберг");
        directors.add("Фридрик Тоур Фридриксон");
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
