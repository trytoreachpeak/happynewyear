package com.example.a.checkattendance.teacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.a.checkattendance.R;

import java.io.Serializable;
import java.util.ArrayList;

public class TeacherRealtimeClassroom extends AppCompatActivity implements View.OnClickListener{
    private Spinner spinner;
    private NestedExpandableListView  expendList;
    String[] str = {"第1节课", "第2节课", "第3节课", "汇总"};
    private ArrayAdapter<String> arrayAdapter;
    private   ArrayList<ClassBean> parentData = new ArrayList<>();
    public static  ArrayList<ArrayList<StudentBean>> childData = new ArrayList<>();
    private Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_realtime_classroom);
        spinner = (Spinner)findViewById(R.id.spinner);

        spinner.setDropDownHorizontalOffset(100); //下拉的横向偏移
        spinner.setDropDownVerticalOffset(50);
        arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.drop_item, str);
        spinner.setAdapter(arrayAdapter);
        //spinner添加数据
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
           });
        ClassBean classBean = new ClassBean();
        classBean.setGroupClass("计171");
        classBean.setGroupNum("28/29");
        parentData.add(classBean);
        ClassBean classBean1 = new ClassBean();
        classBean1.setGroupClass("计172");
        classBean1.setGroupNum("30/31");
        parentData.add(classBean1);
        ClassBean classBean3 = new ClassBean();
        classBean3.setGroupClass("计172");
        classBean3.setGroupNum("30/31");
        parentData.add(classBean3);
        final StudentBean studentBean = new StudentBean();
        studentBean.setChildName("大黄瓜");
        studentBean.setChildId("1713071050");
        studentBean.setGeneralComment("认真");
        studentBean.setRenzhen("1");
        studentBean.setBurenzhen("1");
        studentBean.setShuijiao("0");
        studentBean.setJiaotoujieer("3");
        studentBean.setAttendanceStatus(0);
        final StudentBean studentBean1 = new StudentBean();
        studentBean1.setChildName("蔡周宇");
        studentBean1.setChildId("1713071049");
        studentBean1.setGeneralComment("认真");
        studentBean1.setRenzhen("100");
        studentBean1.setBurenzhen("1");
        studentBean1.setShuijiao("0");
        studentBean1.setJiaotoujieer("3");
        studentBean1.setAttendanceStatus(1);
        childData.add(new ArrayList<StudentBean>(){{add(studentBean);add(studentBean1);}});
        childData.add(new ArrayList<StudentBean>(){{add(studentBean);}});
        childData.add(new ArrayList<StudentBean>());
        expendList=(NestedExpandableListView)findViewById(R.id.expend_list);
        TeacherExtendableListViewAdapter teacherExtendableListViewAdapter = new TeacherExtendableListViewAdapter();
        teacherExtendableListViewAdapter.parentData = parentData;
        teacherExtendableListViewAdapter.childData = childData;
        expendList.setAdapter(teacherExtendableListViewAdapter);
        expendList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                //Toast.makeText(getApplicationContext(), groupString[groupPosition], Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        expendList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //Toast.makeText(getApplicationContext(), childString[groupPosition][childPosition], Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        update =(Button)findViewById(R.id.update);
        update.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.update:
                Intent intent = new Intent(TeacherRealtimeClassroom.this,
                        TeacherRealtimeTotalAttendance.class);

                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST",(Serializable)childData);
                intent.putExtra("BUNDLE",args);
                startActivity(intent);
        }
    }
}
