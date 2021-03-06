package com.laioffer.matrix;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ListFragment.OnItemSelectListener, GridFragment.OnItemSelectListener{
    private ListFragment listFragment;
    private GridFragment gridFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportFragmentManager().findFragmentById(R.id.list_container) == null) {
            listFragment = new ListFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.list_container, listFragment).commit();
        }

        //add Gridview
        if (getSupportFragmentManager().findFragmentById(R.id.grid_container) == null && isTablet()) {
            gridFragment = new GridFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.grid_container, gridFragment).commit();
        }
    }

    private boolean isTablet() {
        return (getApplicationContext().getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    @Override
    public void onItemSelected(int position) {
        gridFragment.onItemSelected(position);
    }

    @Override
    public void onCommentSelected(int position) {
        listFragment.onItemSelected(position);
    }

}
