package com.android.bushelper.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.bushelper.R;
import com.android.bushelper.bean.TicketBean;

public class TicketDetailActivity extends AppCompatActivity {

    private TextView fromTV;
    private TextView toTV;
    private TextView dateTV;
    private TextView priceTV;
    private Button buyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_detail);
        Bundle bundle = getIntent().getExtras();
        final TicketBean.ResultEntity.ListEntity ticket = bundle.getParcelable("ticket");
        fromTV = (TextView)findViewById(R.id.from_text);
        fromTV.setText(ticket.getStart());
        toTV = (TextView)findViewById(R.id.to_text);
        toTV.setText(ticket.getArrive());
        dateTV = (TextView)findViewById(R.id.date_text);
        dateTV.setText(ticket.getDate() + "　发车");
        priceTV = (TextView)findViewById(R.id.price_text);
        priceTV.setText("票价　" + ticket.getPrice());
        buyBtn = (Button)findViewById(R.id.buy_btn);
        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TicketDetailActivity.this, OutTicketActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("ticket", ticket);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
