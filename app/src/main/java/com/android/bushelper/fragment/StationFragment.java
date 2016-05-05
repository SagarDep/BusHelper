package com.android.bushelper.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.bushelper.MyApplication;
import com.android.bushelper.R;
import com.android.bushelper.adapter.StationAdapter;
import com.android.bushelper.bean.StationBean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class StationFragment extends Fragment {

    private EditText stationSearchET;
    private Button stationSearchBtn;
    private ListView stationList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_station, container, false);
        stationSearchET = (EditText)root.findViewById(R.id.station_search_et);
        stationSearchBtn = (Button)root.findViewById(R.id.station_search_btn);
        stationList = (ListView)root.findViewById(R.id.station_list);
        stationSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchStation();
            }
        });
        return root;
    }

    public void searchStation() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(stationSearchET.getWindowToken(), 0);

        String stationStr = stationSearchET.getText().toString();
        if (TextUtils.isEmpty(stationStr)) {
            Toast.makeText(getActivity(), "请输入站点", Toast.LENGTH_SHORT).show();
        } else {
            RequestParams requestParams = new RequestParams("http://op.juhe.cn/189/bus/station");
            requestParams.addQueryStringParameter("key", "46d4d4c80489aaf4d9ba264ec8627faa");
            requestParams.addQueryStringParameter("city", MyApplication.City);
            requestParams.addQueryStringParameter("station", stationStr);
            x.http().get(requestParams, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    Gson gson = new Gson();
                    StationBean stationBean = gson.fromJson(result, StationBean.class);
                    initStationList(stationBean);
                }

                @Override
                public void onError(Throwable ex, boolean isOnCallback) {

                }

                @Override
                public void onCancelled(CancelledException cex) {

                }

                @Override
                public void onFinished() {

                }
            });
        }
    }

    public void initStationList(StationBean stationBean) {
        if (stationBean.getResult() != null) {
            StationAdapter stationAdapter = new StationAdapter(getActivity(), stationBean);
            stationList.setAdapter(stationAdapter);
        } else {
            Toast.makeText(getActivity(), "未搜索到该站点", Toast.LENGTH_SHORT).show();
        }
    }

}
