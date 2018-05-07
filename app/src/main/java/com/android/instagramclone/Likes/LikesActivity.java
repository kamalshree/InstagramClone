package com.android.instagramclone.Likes;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.instagramclone.R;
import com.android.instagramclone.Utils.BottomNavigationHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by kamalshree on 5/7/2018.
 */

public class LikesActivity extends AppCompatActivity {
    private static final String TAG = "LikesActivity";
    private Context mContext=LikesActivity.this;
    private int activity_number;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: Like ativity started");
        activity_number=getIntent().getIntExtra("activity_number",activity_number);
        setupBottomNavigationView();
    }


    /**
     * Bottom Navigation View
     */
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: calling bottom nvaigation view function");
        BottomNavigationViewEx bottomNavigationViewEx= (BottomNavigationViewEx)findViewById(R.id.bottom_navigation_bar);
        BottomNavigationHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationHelper.enableNavigation(mContext,bottomNavigationViewEx);
        Menu menu=bottomNavigationViewEx.getMenu();
        MenuItem menuItem=menu.getItem(activity_number);
        menuItem.setChecked(true);
    }
}
