package com.kirvelstudios.cinemaquiz.Directors.MediumLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class PaulThomasDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0000759/?ref_=nv_sr_srsg_0";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public PaulThomasDirector() {
        levelNumber = 2;
        directorNumber = 10;

        name = "Пол Томас Андерсон";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.neft);
        posters.add(R.drawable.prizr_nit_poster);
        posters.add(R.drawable.master_poster);

        directors.add("Тоби Джеймс");
        directors.add("Орсон Уэллс");
        directors.add(name);
        directors.add("Курт Уиммер");
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
