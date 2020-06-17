package com.kirvelstudios.cinemaquiz.Directors;

import java.util.ArrayList;

public class Director {

    String name, url;
    ArrayList <Integer> posters;
    ArrayList <String> directors;
    int levelNumber,directorNumber;

    public Director() {
        levelNumber = 1;
        directorNumber = 1;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getPosters() {
        return posters;
    }

    public ArrayList<String> getDirectors() { return directors; }

    public int getLevelNumber() {
        return levelNumber;
    }

    public int getDirectorNumber() {
        return directorNumber;
    }

    public String getUrl() {
        return url;
    }
}
