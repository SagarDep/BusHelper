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
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.android.bushelper.MyApplication;
import com.android.bushelper.R;
import com.android.bushelper.adapter.LineAdapter;
import com.android.bushelper.bean.LineBean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineFragment extends Fragment {

    private EditText lineSearchET;
    private Button lineSearchBtn;
    private ExpandableListView lineList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_line, container, false);
        lineSearchET = (EditText)root.findViewById(R.id.line_search_et);
        lineSearchBtn = (Button)root.findViewById(R.id.line_search_btn);
        lineList = (ExpandableListView)root.findViewById(R.id.line_list);
        lineSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchLine();
            }
        });
        return root;
    }

    public void searchLine() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(lineSearchET.getWindowToken(), 0);

        String lineStr = lineSearchET.getText().toString();
        if (TextUtils.isEmpty(lineStr)) {
            Toast.makeText(getActivity(), "请输入线路", Toast.LENGTH_SHORT).show();
        } else {
            RequestParams requestParams = new RequestParams("http://op.juhe.cn/189/bus/busline");
            requestParams.addQueryStringParameter("key", "46d4d4c80489aaf4d9ba264ec8627faa");
            requestParams.addQueryStringParameter("city", MyApplication.City);
            requestParams.addQueryStringParameter("bus", lineStr);
            x.http().get(requestParams, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    Gson gson = new Gson();
                    LineBean lineBean = gson.fromJson(result, LineBean.class);
                    initLineList(lineBean);
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

    public void initLineList(LineBean lineBean) {
        if (lineBean.getResult() != null) {
            List<LineBean.ResultEntity> parent = lineBean.getResult();
            Map<String, List<LineBean.ResultEntity.StationdesEntity>> child = new HashMap<>();
            for (LineBean.ResultEntity line : parent) {
                child.put(line.getLine_id(), line.getStationdes());
            }
            LineAdapter lineAdapter = new LineAdapter(getActivity(), parent, child);
            lineList.setAdapter(lineAdapter);
        } else {
            Toast.makeText(getActivity(), "未搜索到该线路", Toast.LENGTH_SHORT).show();
        }
    }

}
