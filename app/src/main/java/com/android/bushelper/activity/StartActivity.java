package com.android.bushelper.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;

import com.android.bushelper.R;
import com.android.bushelper.app.Activitys;

public class StartActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_DURATION = 1500;//启动页显示时长
    private Looper looper = Looper.myLooper();
    private Handler handler = new Handler(looper);

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(StartActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        handler.postDelayed(runnable, SPLASH_DISPLAY_DURATION);
        View rootView = findViewById(R.id.app_icon_iv);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(rootView, "alpha", 0f, 1f);
        objectAnimator.setDuration(1000);
        objectAnimator.start();

        Activitys.addActivity(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            handler.removeCallbacks(runnable);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Activitys.removeActivity(this);
    }
}
