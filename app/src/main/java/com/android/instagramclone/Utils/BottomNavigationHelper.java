package com.android.instagramclone.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.android.instagramclone.Home.HomeActivity;
import com.android.instagramclone.Likes.LikesActivity;
import com.android.instagramclone.Profile.ProfileActivity;
import com.android.instagramclone.R;
import com.android.instagramclone.Search.SearchActivity;
import com.android.instagramclone.Share.ShareActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by kamalshree on 5/7/2018.
 */

public class BottomNavigationHelper {
    private static final String TAG = "BottomNavigationHelper";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx) {
        Log.d(TAG, "setupBottomNavigationView: settingup navigationView");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    /**
     * Enable Navigation
     */
    public static void enableNavigation(final Context context, BottomNavigationViewEx viewEx) {
        viewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_house:
                        Intent homeintent = new Intent(context, HomeActivity.class);
                        homeintent.putExtra("activity_number",0);
                        context.startActivity(homeintent);
                        break;
                    case R.id.ic_circle:
                        Intent shareintent = new Intent(context, ShareActivity.class);
                        shareintent.putExtra("activity_number",3);
                        context.startActivity(shareintent);
                        break;
                    case R.id.ic_android:
                        Intent profileintent = new Intent(context, ProfileActivity.class);
                        profileintent.putExtra("activity_number",1);
                        context.startActivity(profileintent);
                        break;
                    case R.id.ic_search:
                        Intent searchintent = new Intent(context, SearchActivity.class);
                        searchintent.putExtra("activity_number",2);
                        context.startActivity(searchintent);
                        break;
                    case R.id.ic_notification:
                        Intent likeintent = new Intent(context, LikesActivity.class);
                        likeintent.putExtra("activity_number",4);
                        context.startActivity(likeintent);
                        break;
                }

                return false;
            }
        });
    }
}
