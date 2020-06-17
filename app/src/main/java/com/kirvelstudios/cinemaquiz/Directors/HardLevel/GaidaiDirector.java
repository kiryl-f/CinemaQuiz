package com.kirvelstudios.cinemaquiz.Directors.HardLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class GaidaiDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0301145/?ref_=nv_sr_srsg_5";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public GaidaiDirector() {
        levelNumber = 3;
        directorNumber = 9;

        name = "Леонид Гайдай";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.iv_changing_profession_poster);
        posters.add(R.drawable.operation_y_poster);

        directors.add(name);
        directors.add("Валерий Леонов");
        directors.add("Семён Аранович");
        directors.add("Михаил Ромм");
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
