package com.android.bushelper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.bushelper.R;
import com.android.bushelper.bean.PlatformBean;

public class PlatformAdapter extends BaseAdapter {

    private Context context;
    private PlatformBean datas;

    public PlatformAdapter(Context context, PlatformBean datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.getResult().size();
    }

    @Override
    public Object getItem(int position) {
        return datas.getResult().get(position);
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_platform_list, parent, false);
            viewHolder.platform_text = (TextView)convertView.findViewById(R.id.platform_text);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.platform_text.setText(datas.getResult().get(position).getName());

        return convertView;
    }

    public class ViewHolder {
        private TextView platform_text;
    }
}
