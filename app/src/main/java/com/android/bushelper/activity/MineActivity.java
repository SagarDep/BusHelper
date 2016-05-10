package com.android.bushelper.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.bushelper.R;
import com.android.bushelper.app.MyApplication;

public class MineActivity extends AppCompatActivity {

    private TextView usernameTV;
    private LinearLayout myOrderLL;
    private LinearLayout resetPasswordLL;
    private Button logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        usernameTV = (TextView)findViewById(R.id.username_tv);
        usernameTV.setText(MyApplication.user.getNickname());
        myOrderLL = (LinearLayout)findViewById(R.id.my_order_ll);
        myOrderLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        resetPasswordLL = (LinearLayout)findViewById(R.id.reset_password_ll);
        resetPasswordLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        logoutBtn = (Button)findViewById(R.id.logout_btn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
