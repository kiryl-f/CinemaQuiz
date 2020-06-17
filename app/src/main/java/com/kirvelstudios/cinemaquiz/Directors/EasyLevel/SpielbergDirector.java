package com.kirvelstudios.cinemaquiz.Directors.EasyLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class SpielbergDirector extends Director {

    String name, url;
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public SpielbergDirector() {
        levelNumber = 1;
        directorNumber = 5;

        name = "Стивен Спилберг";
        posters = new ArrayList<>();
        directors = new ArrayList<>();
        url = "https://www.imdb.com/name/nm0000229/?ref_=nv_sr_srsg_0";

        posters.add(R.drawable.catchme_poster);
        posters.add(R.drawable.bridgeofspies_poster);
        posters.add(R.drawable.jaws_poster);
        posters.add(R.drawable.minory_report_poster);


        directors.add("Альфред Хичкок");
        directors.add(name);
        directors.add("Фрэнсис Форд Коппола");
        directors.add("Джордж Клуни");
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
