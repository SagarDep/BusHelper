package com.android.bushelper.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.android.bushelper.app.Activitys;
import com.android.bushelper.app.MyApplication;
import com.android.bushelper.R;
import com.android.bushelper.adapter.CityAdapter;
import com.android.bushelper.bean.CityBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SelectCityActivity extends AppCompatActivity {

    private EditText searchET;
    private ListView cityList;
    private CityBean cityBean;
    private CityBean tempCityBean;
    private CityAdapter cityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);
        searchET = (EditText)findViewById(R.id.search_et);
        getCity();
        initCityList();
        searchET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchCity(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Activitys.addActivity(this);
    }

    public void getCity() {
        try {
            InputStream inputStream = getResources().getAssets().open("city.json");
            byte [] buffer = new byte[inputStream.available()] ;
            inputStream.read(buffer);
            String cityJson = new String(buffer,"utf-8");
            Gson gson = new Gson();
            cityBean = gson.fromJson(cityJson, CityBean.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initCityList() {
        cityAdapter = new CityAdapter(this, cityBean);
        cityList = (ListView)findViewById(R.id.city_list);
        cityList.setAdapter(cityAdapter);
        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyApplication.setCity(cityBean.getCity_info().get(position).getCity());
                setResult(RESULT_OK);
                finish();
            }
        });
    }

    public void searchCity(String city_name) {
        tempCityBean = new CityBean();
        List<CityBean.CityInfoEntity> tempCityInfoEntity = new ArrayList<>();
        for (CityBean.CityInfoEntity city : cityBean.getCity_info()) {
            if (TextUtils.isEmpty(city_name)) {
                tempCityInfoEntity.add(city);
            } else if (city.getCity().contains(city_name)) {
                tempCityInfoEntity.add(city);
            }
        }
        tempCityBean.setCity_info(tempCityInfoEntity);
        cityAdapter = new CityAdapter(this, tempCityBean);
        cityList.setAdapter(cityAdapter);
        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyApplication.setCity(tempCityBean.getCity_info().get(position).getCity());
                setResult(RESULT_OK);
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Activitys.removeActivity(this);
    }
}
