package com.mraper.org.datarepo.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * List of items.
 */
public class ItemList {

    private List<Item> items;

    // Public constructor is necessary in order for Gson to work with collections.
    public ItemList() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
