package com.kirvelstudios.cinemaquiz;

import java.util.ArrayList;

public class MPSquad extends Movie {
    private String title;
    private int url;
    private String posterUrl;
    private String director;
    private String id;
    private ArrayList<Integer> genreId;

    MPSquad() {
        title = "MPSquad";
        posterUrl = "https://ru.inettools.net/upload/TvDJoMht932Jo3XGoeaKl2aK6ipZ9PhKUeY8wsK0/mpsquad.X5EsD.jpg";
        id = "1234567890";
        genreId = new ArrayList<>();
        posterUrl = "";
        url = R.drawable.mpsquad;
    }

    public MPSquad(String title, String posterUrl, String id, ArrayList<Integer> genreId) {
        this.title = title;
        this.posterUrl = posterUrl;
        this.id = id;
        this.genreId = genreId;
    }

    @Override
    public int getUrl() {
        return url;
    }

    @Override
    public void setUrl(int url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Integer> getGenreId() {
        return genreId;
    }

    public void setGenreId(ArrayList<Integer> genreId) {
        this.genreId = genreId;
    }
}
