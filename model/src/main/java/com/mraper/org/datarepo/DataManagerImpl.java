package com.mraper.org.datarepo;

import com.mraper.org.datarepo.entity.ItemList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Data manager that retrieves data from the network and converts them using Gson.
 */
public class DataManagerImpl implements DataManager {

    private DataListener dataListener;
    private RestApiProvider restApiProvider;

    public DataManagerImpl() {

        restApiProvider = RetrofitFactory
                .getRetrofitInstance(UrlsUtil.BASE_URL)
                .create(RestApiProvider.class);
    }

    @Override
    public void startFetchingDataList() {

        Call<ItemList> callItemList = restApiProvider.getItemList();
        callItemList.enqueue(new Callback<ItemList>() {
            @Override
            public void onResponse(Call<ItemList> call, Response<ItemList> response) {

                if (dataListener != null && response.body() != null) {
                    dataListener.onDataUpdateSuccess(response.body().getItems());
                }
            }

            @Override
            public void onFailure(Call<ItemList> call, Throwable t) {
                if (dataListener != null) {
                    dataListener.onDataUpdateFailure(t);
                }
            }
        });
    }

    @Override
    public void registerListener(DataListener dataListener) {
        this.dataListener = dataListener;
    }

    @Override
    public void unregisterListener() {
        this.dataListener = null;
    }

    public DataListener getDataListener() {
        return dataListener;
    }

    public RestApiProvider getRestApiProvider() {
        return restApiProvider;
    }
}
