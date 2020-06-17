package com.kirvelstudios.cinemaquiz.Directors.HardLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class AlmadovarDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0000264/?ref_=nv_sr_srsg_3";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public AlmadovarDirector() {
        levelNumber = 3;
        directorNumber = 6;

        name = "Педро Альмадовар";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.pain_and_glory_poster);
        posters.add(R.drawable.stupid_edu_poster);

        directors.add("Карлос Саура");
        directors.add("Алехандро Аменевар");
        directors.add(name);
        directors.add("Хавьер Бардем");
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
