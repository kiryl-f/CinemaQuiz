package com.kirvelstudios.cinemaquiz.Directors.EasyLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class HichkokDirector extends Director {

    String name, url;
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    public HichkokDirector() {
        levelNumber = 1;
        directorNumber = 7;

        name = "Альфред Хичкок";
        posters = new ArrayList<>();
        directors = new ArrayList<>();
        url = "https://www.imdb.com/name/nm0000033/?ref_=nv_sr_srsg_0";

        posters.add(R.drawable.rear_window_poster);
        posters.add(R.drawable.psycho_poster);
        posters.add(R.drawable.call_m_poster);
        posters.add(R.drawable.vertigo_poster);


        directors.add("Сидни Люмет");
        directors.add("Фрэнсис Форд Коппола");
        directors.add(name);
        directors.add("Серджио Леоне");
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
