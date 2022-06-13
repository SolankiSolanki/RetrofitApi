package com.sunny.retrofitapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.sunny.retrofitapi.adapter.ImageAdapter;
import com.sunny.retrofitapi.databinding.ActivityImageApiBinding;
import com.sunny.retrofitapi.model.ImageModel;
import com.sunny.retrofitapi.retrofitClient.BodyRetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ImageApi extends AppCompatActivity {

    ActivityImageApiBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityImageApiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        imageholder();
    }
    private void imageholder(){
        BodyRetrofitClient.getInstance().getMyApi().imageholder().enqueue(new Callback<List<ImageModel>>() {
            @Override
            public void onResponse(Call<List<ImageModel>> call, Response<List<ImageModel>> response) {
                try {
                    binding.imageRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
                    binding.imageRecycler.setAdapter(new ImageAdapter(getApplicationContext(),response.body()));
                }catch (Exception e){
                    Log.e("TAGG", "onResponse: ", e);
                }

            }

            @Override
            public void onFailure(Call<List<ImageModel>> call, Throwable t) {

            }
        });
    }
}