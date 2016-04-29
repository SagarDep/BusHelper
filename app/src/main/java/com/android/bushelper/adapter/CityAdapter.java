package com.android.bushelper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.bushelper.R;
import com.android.bushelper.bean.CityBean;

public class CityAdapter extends BaseAdapter {

    private Context context;
    private CityBean datas;
    private LayoutInflater mInflater;

    public CityAdapter(Context context, CityBean datas) {
        this.context = context;
        this.datas = datas;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.getCity_info().size();
    }

    @Override
    public Object getItem(int position) {
        return datas.getCity_info().get(position);
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
            convertView = mInflater.inflate(R.layout.item_city_list, parent, false);
            viewHolder.cityTV = (TextView)convertView.findViewById(R.id.city_tv);
            viewHolder.provTV = (TextView)convertView.findViewById(R.id.prov_tv);
            viewHolder.cntyTV = (TextView)convertView.findViewById(R.id.cnty_tv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.cityTV.setText(datas.getCity_info().get(position).getCity());
        viewHolder.provTV.setText(datas.getCity_info().get(position).getProv());
        viewHolder.cntyTV.setText(datas.getCity_info().get(position).getCnty());

        return convertView;
    }

    class ViewHolder {
        public TextView cityTV;
        public TextView provTV;
        public TextView cntyTV;
    }
}
