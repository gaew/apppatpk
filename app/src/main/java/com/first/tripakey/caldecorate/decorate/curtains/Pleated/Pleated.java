package com.first.tripakey.caldecorate.decorate.curtains.Pleated;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.first.tripakey.caldecorate.R;
import com.first.tripakey.caldecorate.decorate.curtains.Eyelet.Eyelet;
import com.first.tripakey.caldecorate.decorate.curtains.Eyelet.EyeletPagerAdapter;
import com.first.tripakey.caldecorate.main.AnalyticsApplication;
import com.first.tripakey.caldecorate.main.MainActivity;
import com.first.tripakey.caldecorate.main.SlidingTabLayout;


import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
public class Pleated extends AppCompatActivity {
    ViewPager pager;
    PleatdePagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[] =  {"Calculate","Setting"};
    int Numboftabs = 2;


    private Tracker mTracker;
    String name = "pleated curtain";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pleated);
        setTitle(R.string.pleated);
/*
///////////beging analysis
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();

        mTracker.setScreenName("Image~" + name);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Action")
                .setAction("Share")
                .build());
////////////////end analysis
*/
        ////
        adapter = new PleatdePagerAdapter(getSupportFragmentManager(), Titles, Numboftabs);

        // Assigning ViewPager View and settingPleatedCurtain the adapter
        pager = (ViewPager) findViewById(R.id.pager_peated);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tab_pleated);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);
    }

    public void onBackPressed() {

        super.onBackPressed();
        Intent i = new Intent(Pleated.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }
}