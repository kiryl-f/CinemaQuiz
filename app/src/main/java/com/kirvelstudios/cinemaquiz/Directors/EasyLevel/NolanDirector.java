package com.kirvelstudios.cinemaquiz.Directors.EasyLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class NolanDirector extends Director {

    String name, url;
    ArrayList <Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    public NolanDirector() {
        levelNumber = 1;
        directorNumber = 1;

        name = "Кристофер Нолан";
        posters = new ArrayList<>();
        directors = new ArrayList<>();
        url = "https://www.imdb.com/name/nm0634240/?ref_=nv_sr_srsg_0";

        posters.add(R.drawable.interstellar_poster);
        posters.add(R.drawable.insomnia_poster);
        posters.add(R.drawable.dark_knight_poster);
        posters.add(R.drawable.prestige_poster);

        directors.add("Дункан Джонс");
        directors.add("Квентин Тарантино");
        directors.add("Ридли Скотт");
        directors.add("Кристофер Нолан");
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
