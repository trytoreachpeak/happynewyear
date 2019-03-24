package com.example.a.checkattendance.Admin;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;

import java.util.ArrayList;
import java.util.List;

public class AdminClassAttendanceActivity extends BaseActivity implements View.OnClickListener{
    private ExpandableListView ep;
    private String data_teacher;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_class_attendance);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView t_teacher=(TextView)findViewById(R.id.teacher_name) ;
        Intent intent = getIntent();
        String date_teacher= intent.getStringExtra("extra_data");
        t_teacher.setText(date_teacher);

        ep = (ExpandableListView)findViewById(R.id.expandableListView);
        init();
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
        groupList.add(new GroupInfo("操作系统"));
        groupList.add(new GroupInfo("数据库原理"));
        groupList.add(new GroupInfo("数据结构"));
        groupList.add(new GroupInfo("JAVA程序设计"));

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


        myAdapter = new MyExpandableAdapter(groupList,childList,this);
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


                String data_class=childList.get(groupPosition).get(childPosition).getChildName();
                String data_couse=groupList.get(groupPosition).getName();

                Intent intent = new Intent(AdminClassAttendanceActivity.this, AdminPersonalAttendanceActivity.class);
                intent.putExtra("extra_data1", data_class);
                intent.putExtra("extra_data2", data_couse);

                Intent intent2 = getIntent();
                String date_teacher= intent2.getStringExtra("extra_data2");
                intent.putExtra("extra_data3", date_teacher);
                startActivity(intent);

                //这里return true的话子列表不会展开  return false才展开
                return false;
            }
        });


    }
}
