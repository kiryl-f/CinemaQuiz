package com.kirvelstudios.cinemaquiz.Directors.LastLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;
import java.util.ArrayList;

public class HowardDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0000165/?ref_=nv_sr_srsg_0";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public HowardDirector() {
        levelNumber = 4;
        directorNumber = 8;

        name = "Рон Ховард";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.beautiful_mind_poster);

        directors.add("Кен Бернс");
        directors.add("Тони Гилрой");
        directors.add("Томми Вайсо");
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
