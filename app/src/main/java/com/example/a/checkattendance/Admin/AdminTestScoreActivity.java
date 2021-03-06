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

public class AdminTestScoreActivity extends BaseActivity implements View.OnClickListener{
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_test_score);
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
                String data[]={data_class,data_couse};
                Intent intent = new Intent(AdminTestScoreActivity.this, AdminScoreActivity.class);
                intent.putExtra("extra_data1", data_class);

                startActivity(intent);

                //这里return true的话子列表不会展开  return false才展开
                return false;
            }
        });


    }






    public  class  ExpandableAdapter extends BaseExpandableListAdapter {

        public String[] groups;
        public String[][] children;

        public ExpandableAdapter(String[] groups, String[][] children) {
            this.groups = groups;
            this.children = children;
        }

        //获取与给定的组相关的数据，得到数组groups中元素的数据
        public Object getGroup(int groupPosition) {
            return groups[groupPosition];
        }

        //获取与孩子在给定的组相关的数据,得到数组children中元素的数据
        public Object getChild(int groupPosition, int childPosition) {
            return children[groupPosition][childPosition];
        }

        //获取的群体数量，得到groups里元素的个数
        public int getGroupCount() {
            return groups.length;
        }

        //取得指定组中的children个数，就是groups中每一个条目中的个数
        public int getChildrenCount(int groupPosition) {
            return children[groupPosition].length;
        }

        //获取组在给定的位置编号，即groups中元素的ID
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        //获取在给定的组的children的ID，也就是children中元素的ID
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        //获取一个视图显示给定组，存放groups
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                                 ViewGroup parent) {
            TextView textView = getGenericView1(24);
            textView.setText(getGroup(groupPosition).toString());
            return textView;
        }

        //获取一个视图显示在给定的组 的儿童的数据，就是存放children
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                                 View convertView, ViewGroup parent) {
            TextView textView = getGenericView2(18);
            textView.setText(getChild(groupPosition, childPosition).toString());
            return textView;
        }

        //孩子在指定的位置是可选的，即：children中的元素是可点击的
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        //表示孩子是否和组ID是跨基础数据的更改稳定
        public boolean hasStableIds() {
            return true;
        }


        //自定义的创建TextView
        public TextView getGenericView1(int mTextSize) {
            // Layout parameters for the ExpandableListView
            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            TextView textView = new TextView(AdminTestScoreActivity.this);
            textView.setLayoutParams(lp);
            textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
            textView.setPadding(42, 12, 12, 12);
            textView.setTextSize(mTextSize);
            textView.setTextColor(Color.BLACK);
            return textView;
        }

        public TextView getGenericView2(int mTextSize) {
            // Layout parameters for the ExpandableListView
            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            TextView textView = new TextView(AdminTestScoreActivity.this);
            textView.setLayoutParams(lp);
            textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
            textView.setPadding(100, 12, 12, 12);
            textView.setTextSize(mTextSize);
            textView.setTextColor(Color.BLACK);
            return textView;
        }

    }
}
