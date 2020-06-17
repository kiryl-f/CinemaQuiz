package com.kirvelstudios.cinemaquiz.Directors.EasyLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class KubrikDirector extends Director {

    String name, url;
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    public KubrikDirector() {
        levelNumber = 1;
        directorNumber = 6;

        name = "Стэнли Кубрик";
        posters = new ArrayList<>();
        directors = new ArrayList<>();
        url = "https://www.imdb.com/name/nm0000040/?ref_=nv_sr_srsg_0";

        posters.add(R.drawable.k2001_poster);
        posters.add(R.drawable.path_of_glory_poster);
        posters.add(R.drawable.lindon_poster);
        posters.add(R.drawable.full_metal_poster);

        directors.add("Дункан Джонс");
        directors.add("Стэнли Кубрик");
        directors.add("Федерико Феллини");
        directors.add("Джеймс Грей");
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
