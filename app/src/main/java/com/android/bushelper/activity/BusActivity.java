package com.android.bushelper.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.android.bushelper.R;
import com.android.bushelper.adapter.BusFragmentAdapter;
import com.android.bushelper.fragment.LineFragment;
import com.android.bushelper.fragment.StationFragment;

import java.util.ArrayList;
import java.util.List;

public class BusActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        List<String> titles = new ArrayList<>();
        titles.add("线路");
        titles.add("站点");
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)));

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new LineFragment());
        fragments.add(new StationFragment());
        BusFragmentAdapter adapter = new BusFragmentAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(adapter);
    }
}
