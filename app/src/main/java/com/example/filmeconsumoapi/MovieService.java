package com.example.filmeconsumoapi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;


public interface MovieService {
    @GET("?apikey=d745c6fc&t=matrix")
    Call <DtoMovie> getDefaultMovie();

    @GET("?apikey=d745c6fc&s=matrix")
    Call <MoviesJson> getDefaultMovies();

}
