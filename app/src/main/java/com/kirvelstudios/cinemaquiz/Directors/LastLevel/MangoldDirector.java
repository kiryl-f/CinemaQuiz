package com.kirvelstudios.cinemaquiz.Directors.LastLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;
import java.util.ArrayList;

public class MangoldDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0003506/?ref_=nv_sr_srsg_0";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public MangoldDirector() {
        levelNumber = 4;
        directorNumber = 12;

        name = "Джейма Мэнголд";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.ford_v_ferrari_poster);

        directors.add("Фидон Папамайкл");
        directors.add("Бак Сандерс");
        directors.add(name);
        directors.add("Джез Баттеруорт");
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
