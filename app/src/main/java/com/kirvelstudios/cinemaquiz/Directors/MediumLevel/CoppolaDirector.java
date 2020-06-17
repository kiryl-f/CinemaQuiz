package com.kirvelstudios.cinemaquiz.Directors.MediumLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;
import java.util.ArrayList;

public class CoppolaDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0000338/?ref_=nv_sr_srsg_3";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    public CoppolaDirector() {
        levelNumber = 2;
        directorNumber = 11;

        name = "Фрэнсис Форд Коппола";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.godfather_poster);
        posters.add(R.drawable.apocalypse_now_poster);
        posters.add(R.drawable.conversation_poster);

        directors.add("Марлон Брандо");
        directors.add("Орсон Уэллс");
        directors.add("Нил Маршалл");
        directors.add(name);
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
