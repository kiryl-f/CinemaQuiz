package com.kirvelstudios.cinemaquiz.Directors.MediumLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class JohnsonDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0426059/?ref_=nv_sr_srsg_8";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    public JohnsonDirector() {
        levelNumber = 2;
        directorNumber = 5;

        name = "Райан Джонсон";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.last_jedis_poster);
        posters.add(R.drawable.knives_out_poster);
        posters.add(R.drawable.looper_poster);

        directors.add("Барри Левинсон");
        directors.add(name);
        directors.add("Пол МакГикан");
        directors.add("Тед Мелфи");
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
