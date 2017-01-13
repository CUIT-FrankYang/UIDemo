package com.example.s420.uidemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.s420.uidemo.R;
import com.example.s420.uidemo.beans.MenuExpandChild;
import com.example.s420.uidemo.beans.MenuExpandParent;
import com.example.s420.uidemo.listener.ToNewActivityListener;

import java.util.List;

/**
 * Created by s420 on 2017/1/12.
 */
public class MenuExpandAdapter extends BaseExpandableListAdapter {
    private List<MenuExpandParent> parents;
    private Context context;

    public MenuExpandAdapter() {
    }

    public MenuExpandAdapter(List<MenuExpandParent> parents) {
        this.parents = parents;
    }

    public MenuExpandAdapter(Context context, List<MenuExpandParent> parents) {
        this.parents = parents;
        this.context = context;
    }


    @Override
    public int getGroupCount() {
        return parents.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (parents.get(groupPosition).getChilds() != null)
            return parents.get(groupPosition).getChilds().size();
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parents.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        if (parents.get(groupPosition).getChilds() != null)
            return parents.get(groupPosition).getChilds().get(childPosition);
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ParentViewHolder holder;
        if (convertView == null) {
            holder = new ParentViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.layout_menu_parent, null);
            holder.nameText = (TextView) convertView.findViewById(R.id.name);
            holder.iconView = (ImageView) convertView.findViewById(R.id.item_icon);
            convertView.setTag(holder);//绑定ViewHolder对象
        } else {
            holder = (ParentViewHolder) convertView.getTag();//取出ViewHolder对象
        }

        MenuExpandParent parentl = parents.get(groupPosition);
        //设置parentTitle显示的内容
        holder.nameText.setText(parentl.getName());
        if (parentl.getChilds() == null) {//为空加入点击事件
            holder.iconView.setImageResource(R.mipmap.item);
            if(parentl.getIntent()!=null)
              holder.nameText.setOnClickListener(new ToNewActivityListener(context, parentl.getIntent()));
        }else{
            if(isExpanded){
                holder.iconView.setImageResource(R.mipmap.up);
            }else{
                holder.iconView.setImageResource(R.mipmap.expand);
            }
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder holder;
        if (convertView == null) {
            holder = new ChildViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.layout_menu_child, null);
            holder.nameText = (TextView) convertView.findViewById(R.id.name);
            holder.iconView = (ImageView) convertView.findViewById(R.id.item_icon);
            holder.iconView.setImageResource(R.mipmap.item);
            convertView.setTag(holder);//绑定ViewHolder对象
        } else {
            holder = (ChildViewHolder) convertView.getTag();
        }
        if (parents.get(groupPosition).getChilds() != null) {
            MenuExpandChild child = parents.get(groupPosition).getChilds().get(childPosition);
            holder.nameText.setText(child.getName());

            if (child.getIntent() != null) {
                holder.nameText.setOnClickListener(new ToNewActivityListener(context, child.getIntent()));
            }
        }

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    /**
     * 存放控件
     */
    public final class ParentViewHolder {
        public TextView nameText;
        public ImageView iconView;
    }

    public final class ChildViewHolder {
        public TextView nameText;
        public ImageView iconView;
    }
}
