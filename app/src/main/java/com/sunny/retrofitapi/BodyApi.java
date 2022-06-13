package com.sunny.retrofitapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.sunny.retrofitapi.adapter.BodyAdapter;
import com.sunny.retrofitapi.databinding.ActivityBodyApiBinding;
import com.sunny.retrofitapi.model.BodyModel;
import com.sunny.retrofitapi.retrofitClient.BodyRetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BodyApi extends AppCompatActivity {

    ActivityBodyApiBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBodyApiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        placeholder();
    }
    private void placeholder(){
        BodyRetrofitClient.getInstance().getMyApi().placeholder().enqueue(new Callback<List<BodyModel>>() {
            @Override
            public void onResponse(Call<List<BodyModel>> call, Response<List<BodyModel>> response) {
                try {
                    binding.recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
                    binding.recycler.setAdapter(new BodyAdapter(getApplicationContext(),response.body()));
                }catch (Exception e){
                    Log.e("TAGG", "onResponse: ", e);
                }

            }

            @Override
            public void onFailure(Call<List<BodyModel>> call, Throwable t) {

            }
        });
    }
}