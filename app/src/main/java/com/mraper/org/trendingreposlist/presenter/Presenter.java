package com.mraper.org.trendingreposlist.presenter;

import com.mraper.org.datarepo.entity.Item;

/**
 * Denotes that component belongs to presenter part of the architecture.
 */
public interface Presenter {

    void onItemClicked(Item item);
}
