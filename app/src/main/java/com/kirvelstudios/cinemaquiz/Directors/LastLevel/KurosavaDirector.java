package com.kirvelstudios.cinemaquiz.Directors.LastLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class KurosavaDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0000041/?ref_=nv_sr_srsg_0";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public KurosavaDirector() {
        levelNumber = 4;
        directorNumber = 11;

        name = "Акира Куросава";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.dersu_uzala_poster);

        directors.add("Сёдзо Макино");
        directors.add("Масаки Кобояси");
        directors.add(name);
        directors.add("Ясудзиро Одзу");
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
