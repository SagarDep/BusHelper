package com.love_cookies.bushelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private CardView busBtn;
    private CardView coachBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

}
