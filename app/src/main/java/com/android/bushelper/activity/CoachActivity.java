package com.android.bushelper.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.android.bushelper.R;
import com.android.bushelper.adapter.FragmentAdapter;
import com.android.bushelper.app.Activitys;
import com.android.bushelper.fragment.StationFragment;
import com.android.bushelper.fragment.TicketFragment;

import java.util.ArrayList;
import java.util.List;

public class CoachActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach);

        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        List<String> titles = new ArrayList<>();
        titles.add(getResources().getString(R.string.ticket_title));
        titles.add(getResources().getString(R.string.station_title));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)));

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new TicketFragment());
        fragments.add(new StationFragment());
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(adapter);

        Activitys.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Activitys.removeActivity(this);
    }
}
