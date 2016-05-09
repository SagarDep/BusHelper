package com.android.bushelper.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.bushelper.R;
import com.android.bushelper.bean.TicketBean;

public class OutTicketActivity extends AppCompatActivity {

    private RelativeLayout payInfoRL;
    private Animation anim;

    private TextView infoTV;
    private TextView startDateTV;
    private TextView orderBumTV;
    private TextView moneyTV;
    private TextView dateTV;

    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 1:
                    startAnimation();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_ticket);
        Bundle bundle = getIntent().getExtras();
        TicketBean.ResultEntity.ListEntity ticket = bundle.getParcelable("ticket");
        payInfoRL = (RelativeLayout) findViewById(R.id.rl_payInfo);
        infoTV = (TextView)findViewById(R.id.info_tv);
        infoTV.setText(ticket.getStart() + " -- " + ticket.getArrive());
        startDateTV = (TextView)findViewById(R.id.start_date_tv);
        startDateTV.setText(ticket.getDate());
        orderBumTV = (TextView)findViewById(R.id.order_num_tv);
        orderBumTV.setText("123123321321");
        moneyTV = (TextView)findViewById(R.id.money_tv);
        moneyTV.setText(ticket.getPrice());
        dateTV = (TextView)findViewById(R.id.date_tv);
        dateTV.setText("2016-05-09");
        newThread();
    }

    private void newThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message msg = new Message();
                msg.what = 1;
                handler.sendMessage(msg);
            }
        }).start();
    }

    private void startAnimation() {
        anim = AnimationUtils.loadAnimation(this, R.anim.slide_down_in);
        anim.setDuration(1000);
        anim.setFillAfter(true);
        payInfoRL.startAnimation(anim);
    }
}
