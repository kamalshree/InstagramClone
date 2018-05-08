package com.android.instagramclone.Home;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.TableLayout;


import com.android.instagramclone.R;
import com.android.instagramclone.Utils.BottomNavigationHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";
    private Context mContext=HomeActivity.this;
    private int activity_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        activity_number=getIntent().getIntExtra("activity_number",activity_number);
        setupBottomNavigationView();
        setupViewPager();

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
     * Top Tabs in Home Fragment
     */
    private void setupViewPager(){
        SectionsPagerAdapter sectionsPagerAdapter=new SectionsPagerAdapter(getSupportFragmentManager());
        sectionsPagerAdapter.addFragments(new CameraFragment());
        sectionsPagerAdapter.addFragments(new HomeFragment());
        sectionsPagerAdapter.addFragments(new MessageFragment());

        ViewPager viewPager=(ViewPager)findViewById(R.id.container);
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_logo);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_arrow);
    }

}
