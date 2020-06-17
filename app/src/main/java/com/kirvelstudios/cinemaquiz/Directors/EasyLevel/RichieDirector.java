package com.kirvelstudios.cinemaquiz.Directors.EasyLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class RichieDirector extends Director {

    String name, url;
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    public RichieDirector() {
        levelNumber = 1;
        directorNumber = 2;

        name = "Гай Ричи";
        posters = new ArrayList<>();
        directors = new ArrayList<>();
        url = "https://www.imdb.com/name/nm0005363/?ref_=nv_sr_srsg_0";

        posters.add(R.drawable.lock_stock_poster);
        posters.add(R.drawable.snatch_poster);
        posters.add(R.drawable.rocknrolla_poster);
        posters.add(R.drawable.holmes_poster);


        directors.add("Клинт Иствуд");
        directors.add("Квентин Тарантино");
        directors.add(name);
        directors.add("Тони Скотт");
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
