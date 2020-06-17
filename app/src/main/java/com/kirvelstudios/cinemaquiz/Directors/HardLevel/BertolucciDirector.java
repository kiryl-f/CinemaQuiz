package com.kirvelstudios.cinemaquiz.Directors.HardLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class BertolucciDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0000934/?ref_=nv_sr_srsg_0";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public BertolucciDirector() {
        levelNumber = 3;
        directorNumber = 1;

        name = "Бернардо Бертолуччи";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.last_emperor_poster);
        posters.add(R.drawable.xx_vek_poster);

        directors.add("Филипп Гаррел");
        directors.add("Паоло Соррентино");
        directors.add(name);
        directors.add("Витторио Де Сика");
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
