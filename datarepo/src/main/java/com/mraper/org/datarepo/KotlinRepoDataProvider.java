package com.mraper.org.datarepo;

import com.mraper.org.datarepo.model.ItemList;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * REST API for Retrofit.
 */
public interface KotlinRepoDataProvider {

    @GET("search/repositories?q=kotlin&since=today/")
    Call<ItemList> getItemList();
}
