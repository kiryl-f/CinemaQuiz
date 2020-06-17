package com.kirvelstudios.cinemaquiz.Directors.HardLevel;


import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;
import java.util.ArrayList;

public class EisensteinDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0001178/?ref_=nv_sr_srsg_0";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public EisensteinDirector() {
        levelNumber = 3;
        directorNumber = 2;

        name = "Сергей Эйзенштейн";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.alexander_nevsky_poster);
        posters.add(R.drawable.ivan_grozny_poster);

        directors.add("Владимир Мотыль");
        directors.add("Сергей Звягинцев");
        directors.add("Витторио Де Сика");
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
