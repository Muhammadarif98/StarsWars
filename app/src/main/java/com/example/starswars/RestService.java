package com.example.starswars;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestService {
    @GET("films/")
    public Call<SWModelList<Films>> getAllFilms(@Query("page") int page);

    @GET("people/")
    public Call<SWModelList<People>> getAllPeople(@Query("page") int page);
}
