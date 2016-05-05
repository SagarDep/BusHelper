package com.android.bushelper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.bushelper.R;
import com.android.bushelper.bean.StationBean;

public class StationAdapter extends BaseAdapter {

    private Context context;
    private StationBean datas;

    public StationAdapter(Context context, StationBean datas) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_station_list, parent, false);
            viewHolder.station_text = (TextView)convertView.findViewById(R.id.station_text);
            viewHolder.address_text = (TextView)convertView.findViewById(R.id.address_text);
            viewHolder.tel_text = (TextView)convertView.findViewById(R.id.tel_text);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.station_text.setText(datas.getResult().getList().get(position).getName());
        viewHolder.address_text.setText(datas.getResult().getList().get(position).getAdds());
        viewHolder.tel_text.setText(datas.getResult().getList().get(position).getTel());

        return convertView;
    }

    public class ViewHolder {
        private TextView station_text;
        private TextView address_text;
        private TextView tel_text;
    }
}
