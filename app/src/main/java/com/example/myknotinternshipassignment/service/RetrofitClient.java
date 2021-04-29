package com.example.myknotinternshipassignment.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    static Retrofit retrofitInstance;

    public static Retrofit getInstance()
    {
        if (retrofitInstance==null)
            retrofitInstance=new Retrofit.Builder()
                    .baseUrl("https://backend-test-zypher.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofitInstance;
    }

}

