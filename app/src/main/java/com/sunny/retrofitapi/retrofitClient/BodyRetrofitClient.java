package com.sunny.retrofitapi.retrofitClient;

import androidx.constraintlayout.widget.Placeholder;

import com.sunny.retrofitapi.BodyApi;
import com.sunny.retrofitapi.apiInterface.bodyInterface;
import com.sunny.retrofitapi.model.ImageModel;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BodyRetrofitClient {

    public static String body_url ="https://jsonplaceholder.typicode.com/";

    private static BodyRetrofitClient instance = null;
    private bodyInterface myApi;


    private BodyRetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(body_url)
                .addConverterFactory(GsonConverterFactory.create()).build();

        myApi = retrofit.create(bodyInterface.class);
    }

    public static synchronized BodyRetrofitClient getInstance() {
        if (instance == null){
            instance = new BodyRetrofitClient();
        }
        return instance;
    }

    public bodyInterface getMyApi() {
        return myApi;
    }
}
