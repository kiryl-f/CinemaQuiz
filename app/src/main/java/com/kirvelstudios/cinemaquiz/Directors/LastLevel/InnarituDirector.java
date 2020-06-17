package com.kirvelstudios.cinemaquiz.Directors.LastLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class InnarituDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0327944/?ref_=tt_ov_dr";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public InnarituDirector() {
        levelNumber = 4;
        directorNumber = 9;

        name = "Алехандро Гонсалес Иньярриту";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.revenant_poster);

        directors.add(name);
        directors.add("Фернандо Бовайра");
        directors.add("Густаво Сантаолалья");
        directors.add("Стивен Миррионе");
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
