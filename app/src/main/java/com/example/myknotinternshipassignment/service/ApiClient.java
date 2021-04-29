package com.example.myknotinternshipassignment.service;

import com.example.myknotinternshipassignment.model.SpotifyModel;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiClient {

    @POST("testData")
    Call<SpotifyModel> getData();
}
