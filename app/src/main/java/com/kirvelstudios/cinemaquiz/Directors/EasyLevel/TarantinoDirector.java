package com.kirvelstudios.cinemaquiz.Directors.EasyLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class TarantinoDirector extends Director {

    String name, url;
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public TarantinoDirector() {
        levelNumber = 1;
        directorNumber = 4;

        name = "Квентин Тарантино";
        posters = new ArrayList<>();
        directors = new ArrayList<>();
        url = "https://www.imdb.com/name/nm0000233/?ref_=nv_sr_srsg_0";

        posters.add(R.drawable.inglorious_basterds_poster);
        posters.add(R.drawable.hateful_eight_poster);
        posters.add(R.drawable.in_holywood_poster);
        posters.add(R.drawable.reservoir_dogs_poster);


        directors.add(name);
        directors.add("Мартин Скорсезе");
        directors.add("Клинт Иствуд");
        directors.add("Тони Скотт");
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
