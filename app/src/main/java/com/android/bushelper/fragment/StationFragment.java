package com.android.bushelper.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.bushelper.R;
import com.android.bushelper.adapter.StationAdapter;
import com.android.bushelper.app.APIs;
import com.android.bushelper.app.MyApplication;
import com.android.bushelper.bean.StationBean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class StationFragment extends Fragment {

    private ListView stationList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_station, container, false);
        stationList = (ListView)root.findViewById(R.id.station_list);
        getStation();
        return root;
    }

    private void getStation() {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        RequestParams requestParams = new RequestParams(APIs.STATION);
        requestParams.addQueryStringParameter("key", APIs.COACH_KEY);
        requestParams.addQueryStringParameter("station", MyApplication.City);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                StationBean stationBean = gson.fromJson(result, StationBean.class);
                initStationList(stationBean);
                progressDialog.dismiss();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(CancelledException cex) {
                progressDialog.dismiss();
            }

            @Override
            public void onFinished() {
                progressDialog.dismiss();
            }
        });
    }

    public void initStationList(StationBean stationBean) {
        if (stationBean.getResult() != null) {
            StationAdapter stationAdapter = new StationAdapter(getActivity(), stationBean);
            stationList.setAdapter(stationAdapter);
        } else {
            Toast.makeText(getActivity(), "没有查到车站", Toast.LENGTH_SHORT).show();
        }
    }

}
