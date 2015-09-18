package com.first.tripakey.caldecorate.decorate.curtains.Eyelet;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import com.first.tripakey.caldecorate.R;
import com.first.tripakey.caldecorate.decorate.curtain;
import com.first.tripakey.caldecorate.main.SlidingTabLayout;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class Eyelet extends ActionBarActivity {
    ViewPager pager;
    EyeletPagerAdapter adapter;
    SlidingTabLayout tabs;
    ;CharSequence Titles[] = {"Calculate","Setting"};
    int Numboftabs = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eyelet);
        setTitle(R.string.eyelet);

        ////set page adaptor
        adapter = new EyeletPagerAdapter(getSupportFragmentManager(), Titles, Numboftabs);

        // Assigning ViewPager View and settingPleatedCurtain the adapter
        pager = (ViewPager) findViewById(R.id.pager_eye);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tab_eye);
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
        startActivity(new Intent(Eyelet.this, curtain.class));
    }
}


