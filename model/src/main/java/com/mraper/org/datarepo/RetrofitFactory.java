package com.mraper.org.datarepo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Provides instance of Retrofit object.
 */
class RetrofitFactory {
    /**
     * Create an instance of Retrofit object
     * */
    static Retrofit getRetrofitInstance(String url) {

            return new retrofit2.Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }
}
