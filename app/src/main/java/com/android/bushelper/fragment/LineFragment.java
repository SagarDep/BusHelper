package com.android.bushelper.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.bushelper.R;

public class LineFragment extends Fragment {

    private ListView lineList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_line, container, false);
        lineList = (ListView)root.findViewById(R.id.line_list);
        return root;
    }

}
