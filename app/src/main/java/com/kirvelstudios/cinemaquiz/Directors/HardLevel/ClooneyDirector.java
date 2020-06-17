package com.kirvelstudios.cinemaquiz.Directors.HardLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class ClooneyDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0000123/?ref_=nv_sr_srsg_0";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public ClooneyDirector() {
        levelNumber = 3;
        directorNumber = 10;

        name = "Джордж Клуни";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.suburbicon_poster);
        posters.add(R.drawable.confessions_of_dang_man_poster);

        directors.add("Клайв Оуэн");
        directors.add("Джоди Фостер");
        directors.add("Орсон Уэллс");
        directors.add(name);
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
