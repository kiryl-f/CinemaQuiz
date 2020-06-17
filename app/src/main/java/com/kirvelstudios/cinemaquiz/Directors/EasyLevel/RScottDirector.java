package com.kirvelstudios.cinemaquiz.Directors.EasyLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class RScottDirector extends Director {

    String name, url;
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public RScottDirector() {
        levelNumber = 1;
        directorNumber = 3;

        name = "Ридли Скотт";
        posters = new ArrayList<>();
        directors = new ArrayList<>();
        url = "https://www.imdb.com/name/nm0000631/?ref_=nv_sr_srsg_6";

        posters.add(R.drawable.gladiator_poster);
        posters.add(R.drawable.body_of_lies_poster);
        posters.add(R.drawable.bladerunner_poster);
        posters.add(R.drawable.robin_hood_poster);


        directors.add("Стивен Спилберг");
        directors.add("Майкл Бэй");
        directors.add("Тони Скотт");
        directors.add(name);
    }

    @Override
    public int getLevelNumber() {
        return levelNumber;
    }

    @Override
    public int getDirectorNumber() {
        return directorNumber;
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
}
