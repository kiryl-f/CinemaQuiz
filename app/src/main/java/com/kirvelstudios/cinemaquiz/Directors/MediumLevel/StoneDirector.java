package com.kirvelstudios.cinemaquiz.Directors.MediumLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class StoneDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0000231/?ref_=nv_sr_srsg_8";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public StoneDirector() {
        levelNumber = 2;
        directorNumber = 6;

        name = "Оливер Стоун";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.jfk_poster);
        posters.add(R.drawable.platoon_poster);
        posters.add(R.drawable.wall_street_poster);

        directors.add("Эдвард Нортон");
        directors.add(name);
        directors.add("Декстер Флетчер");
        directors.add("Гас Ван Сет");
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
