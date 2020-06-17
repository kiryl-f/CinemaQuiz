package com.kirvelstudios.cinemaquiz.Directors.EasyLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class AllenDirector extends Director {

    String name, url;
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    public AllenDirector() {
        levelNumber = 1;
        directorNumber = 8;

        name = "Вуди Аллен";
        posters = new ArrayList<>();
        directors = new ArrayList<>();
        url = "https://www.imdb.com/name/nm0000095/?ref_=nv_sr_srsg_3";

        posters.add(R.drawable.in_paris_poster);
        posters.add(R.drawable.ir_man_poster);
        posters.add(R.drawable.cassandra_poster);
        posters.add(R.drawable.vicky_poster);

        directors.add("Ингмар Бергман");
        directors.add("Роман Полански");
        directors.add(name);
        directors.add("Мартин Скорсезе");
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
