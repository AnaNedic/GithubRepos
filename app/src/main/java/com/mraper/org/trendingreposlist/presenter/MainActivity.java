package com.mraper.org.trendingreposlist.presenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mraper.org.datarepo.DataManager;
import com.mraper.org.datarepo.DataManagerImpl;
import com.mraper.org.trendingreposlist.R;
import com.mraper.org.trendingreposlist.view.Adapter;

import java.util.List;

import com.mraper.org.datarepo.entity.Item;
import com.mraper.org.trendingreposlist.view.ItemActivity;

/**
 * This is presenter. It handles communication between View and Model.
 * It interacts with OS, maintains app state, and encapsulates business logic.
 */
public class MainActivity extends AppCompatActivity
        implements DataManager.DataListener, Presenter {

    private static final String ITEM = "Item";

    private DataManager dataManager;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataManager = new DataManagerImpl();
        dataManager.registerListener(this);
        dataManager.startFetchingDataList();
    }

    @Override
    protected void onStop() {
        super.onStop();
        dataManager.unregisterListener();
    }

    @Override
    public void onDataUpdateSuccess(List<Item> items) {
        if (adapter == null) {
            setUpRecyclerView(items);
        } else {
            adapter.setItems(items);
            adapter.notifyDataSetChanged();
        }
    }

    private void setUpRecyclerView(List<Item> items) {
        RecyclerView recyclerView = findViewById(R.id.items_recycler_view);
        adapter = new Adapter(this, items);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDataUpdateFailure(Throwable t) {
        //display error view, hide recycler view
    }

    @Override
    public void onItemClicked(Item item) {
        Intent intent = new Intent(this, ItemActivity.class);
        intent.putExtra(ITEM, item);
        this.startActivity(intent);
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
