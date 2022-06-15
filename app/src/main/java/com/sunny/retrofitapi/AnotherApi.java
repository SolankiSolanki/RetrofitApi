package com.sunny.retrofitapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.sunny.retrofitapi.databinding.ActivityAnotherApiBinding;
import com.sunny.retrofitapi.model.AnotherModel;
import com.sunny.retrofitapi.retrofitClient.BodyRetrofitClient;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnotherApi extends AppCompatActivity {
    ActivityAnotherApiBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAnotherApiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BodyRetrofitClient.getInstance().getMyApi().anotherholder().enqueue(new Callback<AnotherModel>() {
            @Override
            public void onResponse(Call<AnotherModel> call, Response<AnotherModel> response) {


                binding.another.append(response.body().getUserId().toString());
                binding.anotherId.append(response.body().getId().toString());
                binding.anotherTitle.append(response.body().getTitle());
                
            }

            @Override
            public void onFailure(Call<AnotherModel> call, Throwable t) {

            }
        });

    }
}