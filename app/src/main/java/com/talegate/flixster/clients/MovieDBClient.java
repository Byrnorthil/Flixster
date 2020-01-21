package com.talegate.flixster.clients;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

public class MovieDBClient {
    private final String API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed";
    private final String BASE_URL = "https://api.themoviedb.org/3/";
    private AsyncHttpClient client;

    public MovieDBClient() {
        client = new AsyncHttpClient();
    }

    private String getApiUrl(String relativeUrl) {
        return BASE_URL + relativeUrl + "?api_key=" + API_KEY;
    }

    public void getNowPlaying(JsonHttpResponseHandler handler) {
        String url = getApiUrl("movie/now_playing");
        client.get(url, handler);
    }
}