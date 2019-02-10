package com.mraper.org.datarepo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    /**
     * Create an instance of Retrofit object
     * */
    public static Retrofit getRetrofitInstance(String url) {

            return new retrofit2.Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }
}
