package com.kirvelstudios.cinemaquiz.Directors.LastLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class FerraraDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0001206/?ref_=nv_sr_srsg_3";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public FerraraDirector() {
        levelNumber = 4;
        directorNumber = 2;

        name = "Абель Феррара";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.bad_liutenant_poster);

        directors.add("Жак Ив-Кусто");
        directors.add("Ленни Рифеншталь");
        directors.add("Густав Одиар");
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
