package com.sunny.retrofitapi.apiInterface;

import androidx.core.view.accessibility.AccessibilityEventCompat;

import com.sunny.retrofitapi.model.BodyModel;
import com.sunny.retrofitapi.model.ImageModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface bodyInterface {

    @GET ("posts")
    Call<List<BodyModel>> placeholder();

    @GET ("users")
    Call<List<ImageModel>> imageholder();

}
