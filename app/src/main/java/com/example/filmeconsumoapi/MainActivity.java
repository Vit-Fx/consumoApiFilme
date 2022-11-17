package com.example.filmeconsumoapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://omdbapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieService movieService = retrofit.create(MovieService.class);
        Call<MoviesJson> dtoMovieCall = movieService.getDefaultMovies();

        dtoMovieCall.enqueue(new Callback<MoviesJson>() {
            @Override
            public void onResponse(Call<MoviesJson> call, Response<MoviesJson> response) {
                ArrayList<DtoMovie> dtoMovieArrayList = response.body().arrayListMovie;
                RecyclerView.Adapter adapter = new CustomAdapter(dtoMovieArrayList);
                RecyclerView recyclerViewMovie = findViewById(R.id.recyclerViewMovie);
                recyclerViewMovie.setLayoutManager(new GridLayoutManager(MainActivity.this,1));
                recyclerViewMovie.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<MoviesJson> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Erro!!!!!", Toast.LENGTH_SHORT).show();


            }
    });
    }
}