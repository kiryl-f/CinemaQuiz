package com.kirvelstudios.cinemaquiz.Directors.HardLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class SidorovDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm1284414/?ref_=nv_sr_srsg_9";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public SidorovDirector() {
        levelNumber = 3;
        directorNumber = 11;

        name = "Алексей Сидоров";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.brigada_poster);
        posters.add(R.drawable.shadow_fight_poster);

        directors.add("Михаил Беликов");
        directors.add(name);
        directors.add("Сергей Бондарчук");
        directors.add("Борис Бунеев");
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
