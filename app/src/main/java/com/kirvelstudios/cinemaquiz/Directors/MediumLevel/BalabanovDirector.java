package com.kirvelstudios.cinemaquiz.Directors.MediumLevel;

import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;
import java.util.ArrayList;

public class BalabanovDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0049326/?ref_=nv_sr_srsg_6";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    public BalabanovDirector() {
        levelNumber = 2;
        directorNumber = 8;

        name = "Алексей Балабанов";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.brat_poster);
        posters.add(R.drawable.zhmurki_poster);
        posters.add(R.drawable.happy_days_poster);

        directors.add(name);
        directors.add("Юрий Быков");
        directors.add("Андрей Звягинцев");
        directors.add("Никита Михалков");
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
