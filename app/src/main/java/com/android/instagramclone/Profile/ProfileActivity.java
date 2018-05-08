package com.android.instagramclone.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.instagramclone.Home.HomeActivity;
import com.android.instagramclone.R;
import com.android.instagramclone.Utils.BottomNavigationHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by kamalshree on 5/7/2018.
 */

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";
    private Context mContext=ProfileActivity.this;
    private int activity_number;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        activity_number=getIntent().getIntExtra("activity_number",activity_number);
        Log.d(TAG, "onCreate: Profile ativity started");
        //setupBottomNavigationView();
        setupProfileToolbar();
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

    /**
     * setup Toolbar
     *
     */
    private void setupProfileToolbar(){
        Toolbar toolbar=(Toolbar)findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.d(TAG, "onMenuItemClick: clicked menu item");
                switch (item.getItemId()) {
                    case R.id.profileMenu:
                        Log.d(TAG, "onMenuItemClick: navigating to settings page");
                        break;
                }
                return false;
            }
        });
    }

    /**
     * inflate the menu
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile,menu);
        return true;
    }
}
