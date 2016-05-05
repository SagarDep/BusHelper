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
import com.android.bushelper.adapter.PlatformAdapter;
import com.android.bushelper.bean.PlatformBean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class PlatformFragment extends Fragment {

    private EditText platformSearchET;
    private Button platformSearchBtn;
    private ListView platformList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_platform, container, false);
        platformSearchET = (EditText)root.findViewById(R.id.platform_search_et);
        platformSearchBtn = (Button)root.findViewById(R.id.platform_search_btn);
        platformList = (ListView)root.findViewById(R.id.platform_list);
        platformSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchPlatform();
            }
        });
        return root;
    }

    public void searchPlatform() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(platformSearchET.getWindowToken(), 0);

        String platformStr = platformSearchET.getText().toString();
        if (TextUtils.isEmpty(platformStr)) {
            Toast.makeText(getActivity(), "请输入站点", Toast.LENGTH_SHORT).show();
        } else {
            RequestParams requestParams = new RequestParams("http://op.juhe.cn/189/bus/station");
            requestParams.addQueryStringParameter("key", "46d4d4c80489aaf4d9ba264ec8627faa");
            requestParams.addQueryStringParameter("city", MyApplication.City);
            requestParams.addQueryStringParameter("station", platformStr);
            x.http().get(requestParams, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    Gson gson = new Gson();
                    PlatformBean platformBean = gson.fromJson(result, PlatformBean.class);
                    initPlatformList(platformBean);
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

    public void initPlatformList(PlatformBean platformBean) {
        if (platformBean.getResult() != null) {
            PlatformAdapter platformAdapter = new PlatformAdapter(getActivity(), platformBean);
            platformList.setAdapter(platformAdapter);
        } else {
            Toast.makeText(getActivity(), "未搜索到该站点", Toast.LENGTH_SHORT).show();
        }
    }

}
