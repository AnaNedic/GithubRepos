package com.mraper.org.trendingreposlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.mraper.org.datarepo.KotlinRepoDataProvider;
import com.mraper.org.datarepo.RetrofitInstance;
import com.mraper.org.datarepo.UrlsUtil;
import com.mraper.org.trendingreposlist.recycler_view.Adapter;

import java.util.List;

import com.mraper.org.datarepo.model.Item;
import com.mraper.org.datarepo.model.ItemList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        KotlinRepoDataProvider kotlinRepoDataProvider
                = RetrofitInstance.getRetrofitInstance(UrlsUtil.KOTLIN_REPO).create(KotlinRepoDataProvider.class);
        Call<ItemList> itemList = kotlinRepoDataProvider.getItemList();
        itemList.enqueue(new Callback<ItemList>() {
            @Override
            public void onResponse(Call<ItemList> call, Response<ItemList> response) {
                generateNoticeList(response.body().getItems());
                for (Item i: response.body().getItems()) {
                    Log.d("Yay", i.toString());
                }
                Log.d("Yay", response.body().toString());
            }

            @Override
            public void onFailure(Call<ItemList> call, Throwable t) {
                Log.d("Yay", t.toString());

            }
        });
    }

    private void generateNoticeList(List<Item> items) {
        RecyclerView recyclerView = findViewById(R.id.items_recycler_view);
        Adapter adapter = new Adapter(items, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
