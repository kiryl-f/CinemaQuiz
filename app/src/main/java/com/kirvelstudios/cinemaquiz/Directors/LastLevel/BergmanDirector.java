package com.kirvelstudios.cinemaquiz.Directors.LastLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;
import java.util.ArrayList;

public class BergmanDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0000006/?ref_=nv_sr_srsg_0";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public BergmanDirector() {
        levelNumber = 4;
        directorNumber = 3;

        name = "Ингмар Бергман";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.seven_pechat_poster);

        directors.add("Макс фон Сюдов");
        directors.add("Рагнар Клаван");
        directors.add(name);
        directors.add("Дэнни Трехо");
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
