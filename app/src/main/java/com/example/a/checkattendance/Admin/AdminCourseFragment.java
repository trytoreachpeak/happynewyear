package com.example.a.checkattendance.Admin;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a.checkattendance.R;

import java.util.ArrayList;
import java.util.List;

public class AdminCourseFragment extends Fragment implements View.OnClickListener {
    private ExpandableListView ep;
    private MyExpandableAdapter myAdapter;
    /* 一级数据源 */
    List<GroupInfo> groupList;
    /* 二级数据源 */
    List<List<ChildInfo>> childList;

    List<ChildInfo>cList1;
    List<ChildInfo>cList2;
    List<ChildInfo>cList3;
    List<ChildInfo>cList4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.admin_course_fragment, container, false);


        ep = (ExpandableListView)view.findViewById(R.id.expandableListView1);

        init();
        return  view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
        }
    }



    public void init()
    {
        groupList = new ArrayList<GroupInfo>();
        groupList.add(new GroupInfo("2015级"));
        groupList.add(new GroupInfo("2016级"));
        groupList.add(new GroupInfo("2017级"));
        groupList.add(new GroupInfo("2018级"));

        cList1 = new ArrayList<ChildInfo>();
        cList2 = new ArrayList<ChildInfo>();
        cList3 = new ArrayList<ChildInfo>();
        cList4 = new ArrayList<ChildInfo>();

        cList2.add(new ChildInfo("软嵌161", BitmapFactory.decodeResource(getResources(), R.mipmap.admin_class)));
        cList2.add(new ChildInfo("计161", BitmapFactory.decodeResource(getResources(), R.mipmap.admin_class)));
        cList2.add(new ChildInfo("物联网161", BitmapFactory.decodeResource(getResources(), R.mipmap.admin_class)));
        cList2.add(new ChildInfo("网络工程161", BitmapFactory.decodeResource(getResources(), R.mipmap.admin_class)));
        cList2.add(new ChildInfo("计嵌161", BitmapFactory.decodeResource(getResources(), R.mipmap.admin_class)));
        cList2.add(new ChildInfo("软工161", BitmapFactory.decodeResource(getResources(), R.mipmap.admin_class)));

        cList3.add(new ChildInfo("软嵌171", BitmapFactory.decodeResource(getResources(), R.mipmap.admin_class)));
        cList3.add(new ChildInfo("计171", BitmapFactory.decodeResource(getResources(), R.mipmap.admin_class)));
        cList3.add(new ChildInfo("物联网171", BitmapFactory.decodeResource(getResources(), R.mipmap.admin_class)));
        cList3.add(new ChildInfo("网络工程171", BitmapFactory.decodeResource(getResources(), R.mipmap.admin_class)));
        cList3.add(new ChildInfo("计嵌171", BitmapFactory.decodeResource(getResources(), R.mipmap.admin_class)));
        cList3.add(new ChildInfo("软工171", BitmapFactory.decodeResource(getResources(), R.mipmap.admin_class)));


        childList = new ArrayList<List<ChildInfo>>();
        childList.add(cList1);
        childList.add(cList2);
        childList.add(cList3);
        childList.add(cList4);


        myAdapter = new MyExpandableAdapter(groupList,childList,getActivity());
        ep.setAdapter(myAdapter);

        ep.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });



        ep.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {


               

                //这里return true的话子列表不会展开  return false才展开
                return false;
            }
        });


    }
}