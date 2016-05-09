package com.android.bushelper.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.bushelper.R;
import com.android.bushelper.bean.TicketBean;

public class TicketDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_detail);
        Bundle bundle = getIntent().getExtras();
        TicketBean.ResultEntity.ListEntity ticket = bundle.getParcelable("ticket");

        Toast.makeText(this, ticket.getStart()+ticket.getArrive()+ticket.getDate()+ticket.getPrice(), Toast.LENGTH_SHORT).show();
    }
}
