package com.kirvelstudios.cinemaquiz.Directors.HardLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class LumetDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0001486/?ref_=nv_sr_srsg_0";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public LumetDirector() {
        levelNumber = 3;
        directorNumber = 4;

        name = "Сидни Люмет";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.twelwe_angry_man_poster);
        posters.add(R.drawable.serpico_poster);

        directors.add(name);
        directors.add("Джеймс Дин");
        directors.add("Джон Казеле");
        directors.add("Орсон Уэллс");
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
