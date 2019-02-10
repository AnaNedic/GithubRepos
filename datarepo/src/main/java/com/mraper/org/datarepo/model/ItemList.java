package com.mraper.org.datarepo.model;

import java.util.ArrayList;
import java.util.List;

public class ItemList {

    private List<Item> items;

    // public constructor is necessary for collections
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
