package com.example.a.checkattendance.teacher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a.checkattendance.R;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeacherClassHistory extends AppCompatActivity implements CalendarView.OnDateSelectedListener{
    private List<TeacherMessageItem> courseList;
    private RecyclerView recyclerView;
    private Date date;
    private TeacherClassHistoryAdapter adapter;
    private TextView month;
    private TextView year;
    private TextView week;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_class_history);

        month = (TextView)findViewById(R.id.month);
        year = (TextView)findViewById(R.id.year);
        week = (TextView)findViewById(R.id.week);
        CalendarView calendarView =(CalendarView)findViewById(R.id.calendarView);
        month.setText(calendarView.getCurMonth()+"月");
        year.setText(String.valueOf(calendarView.getCurYear()));
        Log.d("testabc",calendarView.getSelectedCalendar().toString());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        try{
         date = simpleDateFormat.parse(calendarView.getSelectedCalendar().toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        int weekday=c.get(java.util.Calendar.DAY_OF_WEEK);
        switch (weekday){
            case 1:
                week.setText("周日");
                courseList = new ArrayList<>();
                break;
            case 2:
                week.setText("周一");
                initItem1();
                break;
            case 3:
                week.setText("周二");
                initItem2();
                break;
            case 4:
                week.setText("周三");
                initItem3();
                break;
            case 5:
                week.setText("周四");
                courseList = new ArrayList<>();
                break;
            case 6:
                week.setText("周五");
                initItem4();
                break;
            case 7:
                week.setText("周六");
                courseList = new ArrayList<>();
                break;
            default:
                courseList = new ArrayList<>();
                break;
        }
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


        recyclerView = (RecyclerView)findViewById(R.id.course_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new TeacherClassHistoryAdapter(courseList);
        recyclerView.setAdapter(adapter);

        calendarView.setOnDateSelectedListener(this);
    }
    private void initItem1(){
        courseList= new ArrayList<>();
        TeacherMessageItem item1
                = new TeacherMessageItem("操作系统",R.mipmap.subject_icon,"计161 计162");
        courseList.add(item1);
    }
    private void initItem2(){
        courseList= new ArrayList<>();
        TeacherMessageItem item2
                = new TeacherMessageItem("数据库原理",R.mipmap.subject_icon,"计161 计162");
        courseList.add(item2);
    }
    private void initItem3(){
        courseList= new ArrayList<>();
        TeacherMessageItem item3
                = new TeacherMessageItem("数据结构",R.mipmap.subject_icon,"计161 计162");
        courseList.add(item3);
    }
    private void initItem4(){
        courseList= new ArrayList<>();
        TeacherMessageItem item4
                = new TeacherMessageItem("JAVA编程设计",R.mipmap.subject_icon,"计161 计162");
        courseList.add(item4);
    }

    @Override
    public void onDateSelected(Calendar calendar, boolean isClick) {
        Log.d("testabc",calendar.getWeek()+"");
        int temp=calendar.getWeek();
        adapter.setWhichDay(calendar.getYear()+"-"
        +calendar.getMonth()+"-"+calendar.getDay());
        List<TeacherMessageItem> messageItems;
        month.setText(calendar.getMonth()+"月");
        year.setText(String.valueOf(calendar.getYear()));
        switch(temp){
            case 1:
                week.setText("星期一");
                break;
            case 2:
                week.setText("星期二");
                break;
            case 3:
                week.setText("星期三");
                break;
            case 4:
                week.setText("星期四");
                break;
            case 5:
                week.setText("星期五");
                break;
            case 6:
                week.setText("星期六");
                break;
            case 7:
                week.setText("星期日");
                break;
            default:
                break;
        }
        switch (temp){
            case 1:
                messageItems = new ArrayList<>();
                TeacherMessageItem item1
                        = new TeacherMessageItem("操作系统",R.mipmap.subject_icon,"计161 计162");
                messageItems.add(item1);
                adapter.changeDataSet(messageItems);
                adapter.notifyDataSetChanged();
                break;
            case 2:
               messageItems = new ArrayList<>();
                TeacherMessageItem item2
                        = new TeacherMessageItem("数据库原理",R.mipmap.subject_icon,"计161 计162");
                messageItems.add(item2);
                adapter.changeDataSet(messageItems);
                adapter.notifyDataSetChanged();
                break;
            case 3:
                messageItems = new ArrayList<>();
                TeacherMessageItem item3
                        = new TeacherMessageItem("数据结构",R.mipmap.subject_icon,"计161 计162");
                messageItems.add(item3);
                adapter.changeDataSet(messageItems);
                adapter.notifyDataSetChanged();
                break;
            case 5:
                messageItems = new ArrayList<>();
                TeacherMessageItem item4
                        = new TeacherMessageItem("JAVA程序设计",R.mipmap.subject_icon,"计161 计162");
                messageItems.add(item4);
                adapter.changeDataSet(messageItems);
                adapter.notifyDataSetChanged();
                break;

            default:
                messageItems = new ArrayList<>();
                adapter.changeDataSet(messageItems);
                adapter.notifyDataSetChanged();
                break;
        }
    }
}
