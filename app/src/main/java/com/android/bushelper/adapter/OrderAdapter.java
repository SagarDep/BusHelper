package com.android.bushelper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.bushelper.R;
import com.android.bushelper.bean.OrderBean;

import java.util.List;

public class OrderAdapter extends BaseAdapter {

    private Context context;
    private List<OrderBean> datas;

    public OrderAdapter(Context context, List<OrderBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_order_list, parent, false);
            viewHolder.order_no_tv = (TextView)convertView.findViewById(R.id.order_no_tv);
            viewHolder.order_date_tv = (TextView)convertView.findViewById(R.id.order_date_tv);
            viewHolder.from_text = (TextView)convertView.findViewById(R.id.from_text);
            viewHolder.to_text = (TextView)convertView.findViewById(R.id.to_text);
            viewHolder.date_text = (TextView)convertView.findViewById(R.id.date_text);
            viewHolder.price_text = (TextView)convertView.findViewById(R.id.price_text);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.order_no_tv.setText(datas.get(position).getOrder_no());
        viewHolder.order_date_tv.setText(datas.get(position).getOrder_time());
        viewHolder.order_date_tv = (TextView)convertView.findViewById(R.id.order_date_tv);
        viewHolder.from_text.setText(datas.get(position).getStart());
        viewHolder.to_text.setText(datas.get(position).getArrive());
        viewHolder.date_text.setText(datas.get(position).getDate() + "　发车");
        viewHolder.price_text.setText("票价　" + datas.get(position).getPrice());

        return convertView;
    }

    public class ViewHolder {
        private TextView order_no_tv;
        private TextView order_date_tv;
        private TextView from_text;
        private TextView to_text;
        private TextView date_text;
        private TextView price_text;
    }
}