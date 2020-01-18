package com.talegate.flixster.models;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private String posterPath;
    private String backdropPath;
    private String title;
    private String overview;

    public Movie(@NotNull JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        backdropPath = jsonObject.getString("backdrop_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
    }

    public static List<Movie> fromJsonArray(@NotNull JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        return "https://image.tmdb.org/t/p/w154" + posterPath;
    }

    public String getBackdropPath() { return "https://image.tmdb.org/t/p/w300" + backdropPath; }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}