package com.example.restoran;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://retoolapi.dev/StWODX/";
    @GET("uasresto")
    Call<List<Results>> getSuperMenu();
}
