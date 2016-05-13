package com.android.bushelper.activity;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.android.bushelper.R;
import com.android.bushelper.adapter.OrderAdapter;
import com.android.bushelper.app.Activitys;
import com.android.bushelper.app.MyApplication;
import com.android.bushelper.bean.OrderBean;
import com.android.bushelper.custom.PullView;
import com.android.bushelper.db.MyDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity implements PullView.OnPullRefreshListener, PullView.OnPullLoadListener {

    private PullView pullView;
    private ListView orderList;
    private List<OrderBean> orderDatas = new ArrayList<>();
    private MyDatabaseHelper myDatabaseHelper;
    private OrderAdapter orderAdapter;

    private int offset = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        myDatabaseHelper = new MyDatabaseHelper(this, "bus_helper.db", null, 1);
        pullView = (PullView)findViewById(R.id.pull_view) ;
        pullView.setOnPullRefreshListener(this);
        pullView.setOnPullLoadListener(this);
        orderList = (ListView)findViewById(R.id.order_list);
        initOrderList();
        getOrder(offset);

        Activitys.addActivity(this);
    }

    public void getOrder(int offset) {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        if (offset == 0) {
            orderDatas.clear();
        }
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
        try {
            String sql = "SELECT * FROM orders WHERE user_id = ? ORDER BY order_no DESC LIMIT 10 OFFSET " + (offset * 10);
            Cursor cursor = db.rawQuery(sql, new String[]{MyApplication.user.getUser_id() + ""});
            while (cursor.moveToNext()) {
                OrderBean orderBean = new OrderBean();
                orderBean.setOrder_id(cursor.getInt(cursor.getColumnIndex("order_id")));
                orderBean.setUser_id(cursor.getInt(cursor.getColumnIndex("user_id")));
                orderBean.setOrder_no(cursor.getString(cursor.getColumnIndex("order_no")));
                orderBean.setOrder_time(cursor.getString(cursor.getColumnIndex("order_time")));
                orderBean.setStart(cursor.getString(cursor.getColumnIndex("start")));
                orderBean.setArrive(cursor.getString(cursor.getColumnIndex("arrive")));
                orderBean.setDate(cursor.getString(cursor.getColumnIndex("date")));
                orderBean.setPrice(cursor.getString(cursor.getColumnIndex("price")));
                orderDatas.add(orderBean);
            }
            cursor.close();
            pullComplete();
            progressDialog.dismiss();
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        }
    }

    public void initOrderList() {
        orderAdapter = new OrderAdapter(this, orderDatas);
        orderList.setAdapter(orderAdapter);
    }

    @Override
    public void onPullLoad(PullView view) {
        getOrder(++offset);
    }

    @Override
    public void onPullRefresh(PullView view) {
        offset = 0;
        getOrder(offset);
    }

    public void pullComplete() {
        orderAdapter.notifyDataSetChanged();
        pullView.onPullRefreshComplete();
        pullView.onPullLoadComplete();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Activitys.removeActivity(this);
    }
}
