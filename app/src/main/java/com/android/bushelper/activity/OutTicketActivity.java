package com.android.bushelper.activity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.bushelper.R;
import com.android.bushelper.app.MyApplication;
import com.android.bushelper.bean.TicketBean;
import com.android.bushelper.db.MyDatabaseHelper;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class OutTicketActivity extends AppCompatActivity {

    private RelativeLayout payInfoRL;
    private Animation anim;

    private TextView infoTV;
    private TextView startDateTV;
    private TextView orderBumTV;
    private TextView moneyTV;
    private TextView dateTV;

    private MyDatabaseHelper myDatabaseHelper;
    private String orderTime;
    private String orderNo;

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

        myDatabaseHelper = new MyDatabaseHelper(this, "bus_helper.db", null, 1);

        Bundle bundle = getIntent().getExtras();
        TicketBean.ResultEntity.ListEntity ticket = bundle.getParcelable("ticket");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        long timestamp = System.currentTimeMillis();
        Date curDate = new Date(timestamp);
        orderTime = formatter.format(curDate);
        orderNo = timestamp + "";

        saveOrder(ticket);

        payInfoRL = (RelativeLayout) findViewById(R.id.rl_payInfo);
        infoTV = (TextView) findViewById(R.id.info_tv);
        infoTV.setText(ticket.getStart() + " -- " + ticket.getArrive());
        startDateTV = (TextView) findViewById(R.id.start_date_tv);
        startDateTV.setText(ticket.getDate());
        orderBumTV = (TextView) findViewById(R.id.order_num_tv);
        orderBumTV.setText(timestamp + "");
        moneyTV = (TextView) findViewById(R.id.money_tv);
        moneyTV.setText(ticket.getPrice());
        dateTV = (TextView) findViewById(R.id.date_tv);
        dateTV.setText(orderTime);
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
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(OutTicketActivity.this, R.string.order_tip, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void saveOrder(TicketBean.ResultEntity.ListEntity ticket) {
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("user_id", MyApplication.user.getUser_id());
            values.put("order_no", orderNo);
            values.put("order_time", orderTime);
            values.put("start", ticket.getStart());
            values.put("arrive", ticket.getArrive());
            values.put("date", ticket.getDate());
            values.put("price", ticket.getPrice());
            db.insert("orders", null, values);
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
