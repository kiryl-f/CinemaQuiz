package com.kirvelstudios.cinemaquiz.Directors.EasyLevel;
import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class WesAndersonDirector extends Director {

    String name, url;
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public WesAndersonDirector() {
        levelNumber = 1;
        directorNumber = 10;

        name = "Уэс Андерсон";
        posters = new ArrayList<>();
        directors = new ArrayList<>();
        url = "https://www.imdb.com/name/nm0027572/?ref_=nv_sr_srsg_0";

        posters.add(R.drawable.mr_fox_poster);
        posters.add(R.drawable.hotel_budapest_poster);
        posters.add(R.drawable.rushmore_poster);
        posters.add(R.drawable.dog_isle_poster);


        directors.add("Тони Маршалл");
        directors.add(name);
        directors.add("Тимур Бекмамбетов");
        directors.add("Джони Ли Миллер");
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
