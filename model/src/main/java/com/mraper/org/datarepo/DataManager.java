package com.mraper.org.datarepo;

import com.mraper.org.datarepo.entity.Item;

import java.util.List;

/**
 * All data providers must implement thi interface.
 */
public interface DataManager {

    interface DataListener {
        void onDataUpdateSuccess(List<Item> items);

        void onDataUpdateFailure(Throwable t);
    }

    void startFetchingDataList();

    void registerListener(DataListener dataListener);

    void unregisterListener();
}
