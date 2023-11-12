package com.example.app_demo.Api;

import com.example.app_demo.Models.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiController {
    String BASE_URL = "https://640c82b9a3e07380e8f64da1.mockapi.io/api/v1/";
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    ApiController apiService = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiController.class);

    //products
    @GET("products")
    Call<List<Product>> getProducts();


    //accounts


    //comments
}
