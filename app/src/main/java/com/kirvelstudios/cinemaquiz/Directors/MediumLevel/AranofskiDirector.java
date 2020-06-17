package com.kirvelstudios.cinemaquiz.Directors.MediumLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class AranofskiDirector extends Director {

    String name, url = "";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    public AranofskiDirector() {
        levelNumber = 2;
        directorNumber = 4;

        name = "Даррен Аранофски";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.black_swan_poster);
        posters.add(R.drawable.pi_poster);
        posters.add(R.drawable.requiem_poster);

        directors.add("Дункан Джонс");
        directors.add("Джеймс МакТиг");
        directors.add("Курт Уиммер");
        directors.add(name);
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
