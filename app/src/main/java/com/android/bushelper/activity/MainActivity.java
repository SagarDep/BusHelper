package com.android.bushelper.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.android.bushelper.MyApplication;
import com.android.bushelper.R;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private final int SELECT_CITY = 0x01;

    private CardView cityBtn;
    private TextView cityTV;
    private CardView busBtn;
    private CardView coachBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityBtn = (CardView)findViewById(R.id.city_btn);
        cityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectCityActivity.class);
                startActivityForResult(intent, SELECT_CITY);
            }
        });
        cityBtn.setOnTouchListener(this);

        cityTV = (TextView)findViewById(R.id.city_tv);
        String format = getResources().getString(R.string. city_text) ;
        String cityStr = String. format(format , MyApplication.City) ;
        cityTV.setText(cityStr) ;

        busBtn = (CardView)findViewById(R.id.bus_btn);
        busBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        busBtn.setOnTouchListener(this);

        coachBtn = (CardView)findViewById(R.id.coach_btn);
        coachBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        coachBtn.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                view.setScaleX((float)0.90);
                view.setScaleY((float)0.90);
                break;
            case MotionEvent.ACTION_UP:
                view.setScaleX(1);
                view.setScaleY(1);
                break;
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == SELECT_CITY && resultCode == RESULT_OK) {
            String format = getResources().getString(R.string. city_text) ;
            String cityStr = String. format(format , MyApplication.City) ;
            cityTV.setText(cityStr) ;
        }
    }
}
