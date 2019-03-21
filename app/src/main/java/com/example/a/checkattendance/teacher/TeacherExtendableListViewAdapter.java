package com.example.a.checkattendance.teacher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.gsonitem.GetSingleLessonCondtion;

import java.util.ArrayList;


public class TeacherExtendableListViewAdapter extends BaseExpandableListAdapter {
    private Context mcontext;
    public ArrayList<ClassBean> parentData;
    public ArrayList<ArrayList<GetSingleLessonCondtion.Data>> childData;

    @Override
    // 获取分组的个数
    public int getGroupCount() {
        return parentData.size();
    }

    //获取指定分组中的子选项的个数
    @Override
    public int getChildrenCount(int groupPosition)
    {
        return childData.get(groupPosition).size();
    }

    //        获取指定的分组数据
    @Override
    public Object getGroup(int groupPosition) {
        return parentData.get(groupPosition);
    }

    //获取指定分组中的指定子选项数据
    @Override
    public Object getChild(int groupPosition, int childPosition) {

        return childData.get(groupPosition).get(childPosition);
    }

    //获取指定分组的ID, 这个ID必须是唯一的
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    //获取子选项的ID, 这个ID必须是唯一的
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //分组和子选项是否持有稳定的ID, 就是说底层数据的改变会不会影响到它们
    @Override
    public boolean hasStableIds() {
        return true;
    }
    /**
     *
     * 获取显示指定组的视图对象
     *
     * @param groupPosition 组位置
     * @param isExpanded 该组是展开状态还是伸缩状态
     * @param convertView 重用已有的视图对象
     * @param parent 返回的视图对象始终依附于的视图组
     */
// 获取显示指定分组的视图
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_item,parent,false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.className = (TextView)convertView.findViewById(R.id.class_name);
            groupViewHolder.classStatus=(TextView)convertView.findViewById(R.id.class_status);
            convertView.setTag(groupViewHolder);
        }else {
            groupViewHolder = (GroupViewHolder)convertView.getTag();
        }
        groupViewHolder.className.setText(parentData.get(groupPosition).getGroupClass());
        groupViewHolder.classStatus.setText(parentData.get(groupPosition).getGroupNum());
        return convertView;
    }
    /**
     *
     * 获取一个视图对象，显示指定组中的指定子元素数据。
     *
     * @param groupPosition 组位置
     * @param childPosition 子元素位置
     * @param isLastChild 子元素是否处于组中的最后一个
     * @param convertView 重用已有的视图(View)对象
     * @param parent 返回的视图(View)对象始终依附于的视图组
     * @return
     * @see android.widget.ExpandableListAdapter#getChildView(int, int, boolean, android.view.View,
     *      android.view.ViewGroup)
     */

    //取得显示给定分组给定子位置的数据用的视图
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (convertView==null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.children_item,parent,false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.studentName = (TextView)convertView.findViewById(R.id.student_name);
            childViewHolder.studentId = (TextView)convertView.findViewById(R.id.student_id);
            childViewHolder.renzhenCount = (TextView)convertView.findViewById(R.id.renzhen_count);
            childViewHolder.burenzhenCount = (TextView)convertView.findViewById(R.id.burenzhen_count);
            childViewHolder.shuijiaoCount = (TextView)convertView.findViewById(R.id.shuijiao_count);
            childViewHolder.studentComment = (TextView)convertView.findViewById(R.id.student_comment);
            convertView.setTag(childViewHolder);

        }else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        childViewHolder.studentName.setText(childData.get(groupPosition).get(childPosition).getStudentname());
        childViewHolder.studentId.setText(childData.get(groupPosition).get(childPosition).getStudentid());
        childViewHolder.renzhenCount.setText(String.valueOf(childData.get(groupPosition).get(childPosition).getSseriousnum()));
        childViewHolder.burenzhenCount.setText(String.valueOf(childData.get(groupPosition).get(childPosition).getSlazynum()));
        childViewHolder.shuijiaoCount.setText(String.valueOf(childData.get(groupPosition).get(childPosition).getSsleepnum()));
        int temp= childData.get(groupPosition).get(childPosition).getIsserious()
                +childData.get(groupPosition).get(childPosition).getIslazy()
                +childData.get(groupPosition).get(childPosition).getIssleep();
        String tempText;
        switch(temp){
            case 1:
                tempText="认真";
                break;
            case 2:
                tempText="睡觉";
                break;
            case 3:
                tempText="不认真";
                break;
            default:
                tempText="没有评价";
                break;
        }
        childViewHolder.studentComment.setText(tempText);
        return convertView;
    }

    //指定位置上的子元素是否可选中
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    static class GroupViewHolder {
        TextView className;
        TextView classStatus;
    }

    static class ChildViewHolder {
        TextView studentName;
        TextView studentId;
        TextView renzhenCount;
        TextView burenzhenCount;
        TextView shuijiaoCount;
        TextView studentComment;
    }
}
