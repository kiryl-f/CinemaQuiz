package com.kirvelstudios.cinemaquiz.Directors.HardLevel;
import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.R;
import java.util.ArrayList;

public class OdiarDirector extends Director {

    String name, url = "https://www.imdb.com/name/nm0002191/?ref_=tt_ov_dr";
    ArrayList<Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    @Override
    public String getUrl() {
        return url;
    }

    public OdiarDirector() {
        levelNumber = 3;
        directorNumber = 12;

        name = "Жак Одиар";
        posters = new ArrayList<>();
        directors = new ArrayList<>();

        posters.add(R.drawable.sisters_brothers_poster);
        posters.add(R.drawable.prorok_poster);

        directors.add("Жан-Жак Анно");
        directors.add(name);
        directors.add("Вадим Роже");
        directors.add("Жак Беккер");
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
