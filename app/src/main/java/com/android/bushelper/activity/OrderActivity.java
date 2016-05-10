package com.android.bushelper.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.android.bushelper.R;
import com.android.bushelper.adapter.OrderAdapter;
import com.android.bushelper.app.MyApplication;
import com.android.bushelper.bean.OrderBean;
import com.android.bushelper.db.MyDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    private ListView orderList;
    private List<OrderBean> orderDatas = new ArrayList<>();
    private MyDatabaseHelper myDatabaseHelper;
    private OrderAdapter orderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        myDatabaseHelper = new MyDatabaseHelper(this, "bus_helper.db", null, 1);
        orderList = (ListView)findViewById(R.id.order_list);
        getOrder();
        initOrderList();
    }

    public void getOrder() {
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
        try {
            String sql = "SELECT * FROM orders WHERE user_id = ?";
            Cursor cursor = db.rawQuery(sql, new String[]{MyApplication.user.getUser_id() + ""});
            if(cursor.moveToFirst()){
                OrderBean orderBean = new OrderBean();
                orderBean.setOrder_id(cursor.getInt(cursor.getColumnIndex("order_id")));
                orderBean.setUser_id(cursor.getInt(cursor.getColumnIndex("user_id")));
                orderBean.setOrder_time(cursor.getString(cursor.getColumnIndex("order_time")));
                orderBean.setStart(cursor.getString(cursor.getColumnIndex("start")));
                orderBean.setArrive(cursor.getString(cursor.getColumnIndex("arrive")));
                orderBean.setDate(cursor.getString(cursor.getColumnIndex("date")));
                orderBean.setPrice(cursor.getString(cursor.getColumnIndex("price")));
                orderDatas.add(orderBean);
            }
            cursor.close();
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void initOrderList() {
        orderAdapter = new OrderAdapter(this, orderDatas);
        orderList.setAdapter(orderAdapter);
    }
}
