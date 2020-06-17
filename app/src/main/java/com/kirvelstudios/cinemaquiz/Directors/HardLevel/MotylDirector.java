package com.kirvelstudios.cinemaquiz.Directors.HardLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;
import java.util.ArrayList;

public class MotylDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0609594/?ref_=nv_sr_srsg_0";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public MotylDirector() {
        levelNumber = 3;
        directorNumber = 3;

        name = "Владимир Мотыль";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.zvezda_plen_sh_poster);
        posters.add(R.drawable.white_sun_poster);

        directors.add(name);
        directors.add("Станислав Ростоцкий");
        directors.add("Марат Арипов");
        directors.add("Александр Алов");
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
