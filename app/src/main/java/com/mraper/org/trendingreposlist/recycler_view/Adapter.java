package com.mraper.org.trendingreposlist.recycler_view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mraper.org.trendingreposlist.ItemActivity;
import com.mraper.org.trendingreposlist.R;

import java.util.List;

import com.mraper.org.datarepo.model.Item;

public class Adapter extends RecyclerView.Adapter<Adapter.ItemViewHolder> {

    private static final String ITEM = "Item";
    private List<Item> items;
    private Context context;

    public Adapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
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
                Intent intent = new Intent(context, ItemActivity.class);
                intent.putExtra(ITEM, item);
                context.startActivity(intent);
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

    interface OnItemClickListener {
        void onItemClick(Item item);
    }
}
