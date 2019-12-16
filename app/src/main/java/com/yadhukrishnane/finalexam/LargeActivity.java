package com.yadhukrishnane.finalexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;

public class LargeActivity extends AppCompatActivity {

    public static final String POI_DETAILS = "poi_details";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large);

        Toolbar toolbar = findViewById(R.id.toolbar_large);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        POI poi = getIntent().getParcelableExtra(POI_DETAILS);

        AppCompatTextView tvName = findViewById(R.id.tv_poi_name);
        AppCompatImageView ivImage = findViewById(R.id.iv_large_view);


        if (poi != null) {
            tvName.setText(poi.getName());
            ivImage.setImageResource(poi.getResID());
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
