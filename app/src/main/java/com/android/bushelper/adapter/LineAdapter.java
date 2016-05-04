package com.android.bushelper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.bushelper.R;
import com.android.bushelper.bean.LineBean;

import java.util.List;
import java.util.Map;

public class LineAdapter extends BaseExpandableListAdapter {

    private List<LineBean.ResultEntity> parentDatas;
    private Map<String, List<LineBean.ResultEntity.StationdesEntity>> childDatas;
    private Context context;

    public LineAdapter(Context context, List<LineBean.ResultEntity> parentDatas, Map<String, List<LineBean.ResultEntity.StationdesEntity>> childDatas){
        this.parentDatas = parentDatas;
        this.childDatas = childDatas;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return parentDatas.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parentDatas.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ParentViewHolder parentViewHolder;
        if (convertView == null) {
            parentViewHolder = new ParentViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_line_list_parent, parent, false);
            parentViewHolder.parent_text = (TextView)convertView.findViewById(R.id.parent_text);
            parentViewHolder.from_text = (TextView)convertView.findViewById(R.id.from_text);
            parentViewHolder.to_text = (TextView)convertView.findViewById(R.id.to_text);
            parentViewHolder.arrow_iv = (ImageView)convertView.findViewById(R.id.arrow_iv);
            convertView.setTag(parentViewHolder);
        } else {
            parentViewHolder = (ParentViewHolder)convertView.getTag();
        }

        parentViewHolder.parent_text.setText(parentDatas.get(groupPosition).getKey_name());
        parentViewHolder.from_text.setText(parentDatas.get(groupPosition).getFront_name());
        parentViewHolder.to_text.setText(parentDatas.get(groupPosition).getTerminal_name());
        if (isExpanded) {
            parentViewHolder.arrow_iv.setImageResource(R.mipmap.arrow_open);
        } else {
            parentViewHolder.arrow_iv.setImageResource(R.mipmap.arrow_close);
        }

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        String key = parentDatas.get(groupPosition).getLine_id();
        return childDatas.get(key).size();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        String key = parentDatas.get(groupPosition).getLine_id();
        return childDatas.get(key).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String key = parentDatas.get(groupPosition).getLine_id();
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            childViewHolder = new ChildViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_line_list_child, parent, false);
            childViewHolder.child_text = (TextView)convertView.findViewById(R.id.child_text);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder)convertView.getTag();
        }

        childViewHolder.child_text.setText(childDatas.get(key).get(childPosition).getName());

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public class ParentViewHolder {
        private TextView parent_text;
        private TextView from_text;
        private TextView to_text;
        private ImageView arrow_iv;
    }

    public class ChildViewHolder {
        private TextView child_text;
    }
}
