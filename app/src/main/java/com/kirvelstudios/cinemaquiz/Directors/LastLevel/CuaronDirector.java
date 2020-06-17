package com.kirvelstudios.cinemaquiz.Directors.LastLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;
import java.util.ArrayList;

public class CuaronDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0190859/?ref_=nv_sr_srsg_0";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public CuaronDirector() {
        levelNumber = 4;
        directorNumber = 10;

        name = "Альфонсо Куарон";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.children_of_men_poster);

        directors.add("Алекс Родригес");
        directors.add("Дэвид Арата");
        directors.add("Хосе Родригес");
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
