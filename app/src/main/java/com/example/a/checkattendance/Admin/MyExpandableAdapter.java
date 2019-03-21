package com.example.a.checkattendance.Admin;

import java.util.List;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a.checkattendance.R;

public class MyExpandableAdapter extends BaseExpandableListAdapter {

    private  View blank;
    private Context mContext;
    private List<GroupInfo> mGroup;
    private List<List<ChildInfo>> mChild;
    private LayoutInflater mInflater;
    public MyExpandableAdapter(List<GroupInfo> mGroup,List<List<ChildInfo>> mChild,Context mContext){
        super();
        this.mContext = mContext;
        this.mGroup = mGroup;
        this.mChild = mChild;
        this.mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void updateListView(List<GroupInfo> mGroup,List<List<ChildInfo>> mChild) {
        this.mGroup = mGroup;
        this.mChild = mChild;
        notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        // TODO Auto-generated method stub
        return mGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // TODO Auto-generated method stub
        return mChild.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        // TODO Auto-generated method stub
        return mGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return mChild.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        // TODO Auto-generated method stub
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        GroupHolderView groupHolderView;
        if(convertView == null){
            groupHolderView = new GroupHolderView();
            convertView = (View) mInflater.inflate(R.layout.group_item, null);
            groupHolderView.groupName = (TextView) convertView.findViewById(R.id.gName);
            groupHolderView.count=(TextView) convertView.findViewById(R.id.gCount);
            convertView.setTag(groupHolderView);
        }else{
            groupHolderView = (GroupHolderView) convertView.getTag();
        }
        groupHolderView.groupName.setText(mGroup.get(groupPosition).getName());

        if(groupPosition==0)
        {

            groupHolderView.count.setText(""+mChild.get(groupPosition).size());
        }
        else
        {
            groupHolderView.count.setText("0");
        }


        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub



        ChildHolderView childHolderView;


            if(convertView == null){
                childHolderView = new ChildHolderView();
                convertView = (View) mInflater.inflate(R.layout.child_item, null);
                childHolderView.pic = (ImageView) convertView.findViewById(R.id.my_child_iv);
                childHolderView.childName = (TextView) convertView.findViewById(R.id.my_child_tv);
                childHolderView.childLl = (LinearLayout) convertView.findViewById(R.id.my_child_ll);
                convertView.setTag(childHolderView);
            }else{
                childHolderView = (ChildHolderView) convertView.getTag();
            }
            childHolderView.childName.setText(mChild.get(groupPosition).get(childPosition).getChildName());
            childHolderView.pic.setImageBitmap(mChild.get(groupPosition).get(childPosition).getChildPic());


            return convertView;



    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return true;
    }

    class GroupHolderView{
        TextView groupName;
        TextView count;
    }

    class ChildHolderView{
        ImageView pic;
        TextView childName;
        LinearLayout childLl;
    }





}