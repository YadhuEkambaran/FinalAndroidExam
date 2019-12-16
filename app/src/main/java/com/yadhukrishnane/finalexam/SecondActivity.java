package com.yadhukrishnane.finalexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity implements POIAdapter.OnItemClickListener {

    private POIAdapter mAdapter;
    private List<POI> pois;

    private List<Country> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toolbar toolbar = findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        countries = Country.getCountries();

        final AppCompatSpinner spCountries = findViewById(R.id.sp_countries);
        final AppCompatImageView ivFlag = findViewById(R.id.iv_home_selected_country_flag);
        final AppCompatTextView tvCountryName = findViewById(R.id.tv_home_selected_country);
        RecyclerView rvPOIS = findViewById(R.id.rv_pois);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvPOIS.setLayoutManager(manager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, manager.getOrientation());
        rvPOIS.addItemDecoration(itemDecoration);
        pois = new ArrayList<>();
        mAdapter = new POIAdapter(pois);
        mAdapter.setItemClickListener(this);
        rvPOIS.setAdapter(mAdapter);


        spCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position != 0) {
                    Country country = countries.get(position - 1);
                    ivFlag.setImageResource(country.getResID());
                    tvCountryName.setText(country.getCapital());
                } else {
                    ivFlag.setImageResource(0);
                    tvCountryName.setText("");

                }

                POI.getPOIs(pois, position);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onItemClicked(POI poi) {
        Intent intent = new Intent(SecondActivity.this, LargeActivity.class);
        intent.putExtra(LargeActivity.POI_DETAILS, poi);
        startActivity(intent);
    }
}
