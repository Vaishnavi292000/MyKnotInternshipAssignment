package com.example.myknotinternshipassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myknotinternshipassignment.model.SpotifyModel;
import com.example.myknotinternshipassignment.service.ApiClient;
import com.example.myknotinternshipassignment.service.RetrofitClient;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog;

import java.io.IOException;

import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    ApiClient apiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit=RetrofitClient.getInstance();
        apiClient=retrofit.create(ApiClient.class);

        Call<SpotifyModel> spotifyModelCall=apiClient.getData();

        spotifyModelCall.enqueue(new Callback<SpotifyModel>() {
            @Override
            public void onResponse(Call<SpotifyModel> call, Response<SpotifyModel> response) {
                System.out.println(response.body().getImageURL()+" response is");
                DialogClass dialogClass=new DialogClass();
                try {
                    dialogClass.showDialog(response.body().getTitle(),response.body().getImageURL(),response.body().getSuccess_url(),MainActivity.this);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<SpotifyModel> call, Throwable t) {

            }
        });

    }
}