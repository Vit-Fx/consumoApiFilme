package com.example.filmeconsumoapi;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MoviesJson {

    @SerializedName("Search")

    ArrayList<DtoMovie> arrayListMovie;

}
