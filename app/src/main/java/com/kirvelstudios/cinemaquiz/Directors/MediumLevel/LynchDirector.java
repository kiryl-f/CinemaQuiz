package com.kirvelstudios.cinemaquiz.Directors.MediumLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class LynchDirector extends Director {

    String name,url = "https://www.imdb.com/name/nm0000186/?ref_=nv_sr_srsg_0";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public LynchDirector() {
        levelNumber = 2;
        directorNumber = 1;

        name = "Дэвид Линч";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.mulh_drive_poster);
        posters.add(R.drawable.elephant_man_poster);
        posters.add(R.drawable.dumbland_poster);

        directors.add("Луис Бунюэль");
        directors.add(name);
        directors.add("Сергей Эйзенштейн");
        directors.add("Майкл Чимино");
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
