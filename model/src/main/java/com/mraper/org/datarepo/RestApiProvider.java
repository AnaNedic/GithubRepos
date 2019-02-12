package com.mraper.org.datarepo;

import com.mraper.org.datarepo.entity.ItemList;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * REST API for Retrofit.
 */
interface RestApiProvider {

    @GET(UrlsUtil.KOTLIN_REPO)
    Call<ItemList> getItemList();
}
