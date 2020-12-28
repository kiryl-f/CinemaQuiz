package com.kirvelstudios.cinemaquiz.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {
    @GET("3/movie/top_rated?api_key=33d65e0ed0777308653502b72db75fd0&language=en-US&region=US&page=")
    Call<Result> getMovie(@Query("page")int page, @Query("api_key")String apiKey, @Query("language")String language, @Query("region")String region);
}
