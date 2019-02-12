package com.mraper.org.trendingreposlist.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mraper.org.trendingreposlist.presenter.Presenter;
import com.mraper.org.trendingreposlist.R;

import java.util.List;

import com.mraper.org.datarepo.entity.Item;

/**
 * Adapter in the recycler view pattern displaying fetched repo data.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ItemViewHolder>
        implements BaseView {

    private List<Item> items;
    private Presenter presenter;

    public Adapter(Presenter presenter, List<Item> items) {
        this.presenter = presenter;
        this.items = items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        final Item item = items.get(position);
        holder.itemFullName.setText(item.getFull_name());
        holder.itemDescription.setText(item.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onItemClicked(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView itemFullName, itemDescription, itemOwner;

        ItemViewHolder(View itemView) {
            super(itemView);
            itemFullName = itemView.findViewById(R.id.item_full_name);
            itemDescription = itemView.findViewById(R.id.item_description);
            itemOwner = itemView.findViewById(R.id.item_owner);
        }
    }
}
