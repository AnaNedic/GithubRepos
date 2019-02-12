package com.mraper.org.trendingreposlist.view;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.mraper.org.datarepo.entity.Item;
import com.mraper.org.trendingreposlist.R;

/**
 * Displays single repo details.
 */
public class ItemActivity extends AppCompatActivity implements BaseView {

    private static final String ITEM = "Item";
    private static final String HEADLINE = "Repo Details";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        customizeActionBar();

        Item item = getIntent().getParcelableExtra(ITEM);

        ((TextView) findViewById(R.id.item_full_name)).setText(item.getFull_name());
        ((TextView) findViewById(R.id.item_description)).setText(item.getDescription());
        loadImage(item);
    }

    private void loadImage(Item item) {
        GlideApp.with(this)
                .load(item.getOwner().getAvatar_url()) // Image URL
                // these drawables should be replaced with appropriate resources from designer
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .override(300, 300)
                .into((ImageView) findViewById(R.id.item_image)); // ImageView to display image
    }

    private void customizeActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setTitle(HEADLINE);
        }
    }
}
