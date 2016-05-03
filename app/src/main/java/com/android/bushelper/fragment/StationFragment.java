package com.android.bushelper.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.bushelper.R;

public class StationFragment extends Fragment {

    private ListView stationList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_station, container, false);
        stationList = (ListView)root.findViewById(R.id.station_list);
        return root;
    }

}
