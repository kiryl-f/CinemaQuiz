package com.kirvelstudios.cinemaquiz.Directors.EasyLevel;
import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;

import java.util.ArrayList;

public class BayDirector extends Director {

    String name, url;
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    public BayDirector() {
        levelNumber = 1;
        directorNumber = 12;

        name = "Майкл Бэй";
        posters = new ArrayList<>();
        directors = new ArrayList<>();
        url = "https://www.imdb.com/name/nm0000881/?ref_=nv_sr_srsg_0";

        posters.add(R.drawable.armageddon_poster);
        posters.add(R.drawable.perl_harbor_poster);
        posters.add(R.drawable.rock_poster);
        posters.add(R.drawable.island_bay_poster);


        directors.add("Арчи Хиккокс");
        directors.add("Дон Смитт");
        directors.add(name);
        directors.add("Гарри Гордон");
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
