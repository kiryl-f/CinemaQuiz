package com.kirvelstudios.cinemaquiz.Directors.HardLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class EastwoodDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0000142/?ref_=nv_sr_srsg_0";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public EastwoodDirector() {
        levelNumber = 3;
        directorNumber = 7;

        name = "Клинт Иствуд";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.invictus_poster);
        posters.add(R.drawable.sully_poster);

        directors.add("Том Харди");
        directors.add("Джерри Брукхаммер");
        directors.add(name);
        directors.add("Пол Андерсон");
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
