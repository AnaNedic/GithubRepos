package com.mraper.org.trendingreposlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.mraper.org.datarepo.model.Item;
import com.mraper.org.trendingreposlist.recycler_view.GlideApp;

public class ItemActivity extends AppCompatActivity {

    private static final String ITEM = "Item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Item item = getIntent().getParcelableExtra(ITEM);

        ImageView image = findViewById(R.id.item_image);

        ((TextView)findViewById(R.id.item_full_name)).setText(item.getFull_name());
        ((TextView)findViewById(R.id.item_description)).setText(item.getDescription());
        GlideApp.with(this)
                .load(item.getOwner().getAvatar_url()) // Image URL
                // these drawables should be replaced with appropriate resources from designer
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .override(300,300)
                .into(image); // ImageView to display image
    }
}
