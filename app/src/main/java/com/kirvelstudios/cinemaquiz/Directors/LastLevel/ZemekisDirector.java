package com.kirvelstudios.cinemaquiz.Directors.LastLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;
import java.util.ArrayList;

public class ZemekisDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0000709/?ref_=nv_sr_srsg_0";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public ZemekisDirector() {
        levelNumber = 4;
        directorNumber = 6;

        name = "Роберт Земекис";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.forrest_gump_poster);

        directors.add("Орсон Уэллс");
        directors.add("Майкл Дж.Фокс");
        directors.add("Майкл Хёрст");
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
