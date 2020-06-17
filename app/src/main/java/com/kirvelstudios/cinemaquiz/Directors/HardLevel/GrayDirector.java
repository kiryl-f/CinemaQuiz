package com.kirvelstudios.cinemaquiz.Directors.HardLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class GrayDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0336695/?ref_=nv_sr_srsg_10";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public GrayDirector() {
        levelNumber = 3;
        directorNumber = 5;

        name = "Джеймс Грэй";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.ad_astra_poster);
        posters.add(R.drawable.lost_city_z_poster);

        directors.add(name);
        directors.add("Сэм Хэмм");
        directors.add("Тим Кук");
        directors.add("Роберт Вулл");
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
