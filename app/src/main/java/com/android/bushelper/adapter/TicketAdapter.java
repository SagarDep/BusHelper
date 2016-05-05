package com.android.bushelper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.bushelper.R;
import com.android.bushelper.bean.TicketBean;

public class TicketAdapter extends BaseAdapter {

    private Context context;
    private TicketBean datas;

    public TicketAdapter(Context context, TicketBean datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.getResult().getList().size();
    }

    @Override
    public Object getItem(int position) {
        return datas.getResult().getList().get(position);
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_ticket_list, parent, false);
            viewHolder.from_text = (TextView)convertView.findViewById(R.id.from_text);
            viewHolder.to_text = (TextView)convertView.findViewById(R.id.to_text);
            viewHolder.date_text = (TextView)convertView.findViewById(R.id.date_text);
            viewHolder.price_text = (TextView)convertView.findViewById(R.id.price_text);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.from_text.setText(datas.getResult().getList().get(position).getStart());
        viewHolder.to_text.setText(datas.getResult().getList().get(position).getArrive());
        viewHolder.date_text.setText(datas.getResult().getList().get(position).getDate());
        viewHolder.price_text.setText(datas.getResult().getList().get(position).getPrice());

        return convertView;
    }

    public class ViewHolder {
        private TextView from_text;
        private TextView to_text;
        private TextView date_text;
        private TextView price_text;
    }
}
