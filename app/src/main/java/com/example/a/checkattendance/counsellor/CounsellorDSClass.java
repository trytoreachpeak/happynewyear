package com.example.a.checkattendance.counsellor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a.checkattendance.HttpUtil;
import com.example.a.checkattendance.R;
import com.example.a.checkattendance.gsonitem.GetSingleLessonCondtion;
import com.example.a.checkattendance.gsonitem.StudentGetSubjectCondition;
import com.example.a.checkattendance.teacher.TeacherClassHistoryAdapter;
import com.example.a.checkattendance.teacher.TeacherMessageItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;

import org.feezu.liuli.timeselector.TimeSelector;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class CounsellorDSClass extends AppCompatActivity implements CalendarView.OnDateSelectedListener{
    private List<TeacherMessageItem> courseList;
    private RecyclerView recyclerView;
    private Date date;
    private CounsellorDSClassAdapter adapter;
    private TextView month;
    private TextView year;
    private TextView week;
    private TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counsellor_ds_class);
        Intent intent = getIntent();
        String titleText = intent.getStringExtra("title");
        title = (TextView)findViewById(R.id.title);
        title.setText(titleText);

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
        recyclerView = (RecyclerView)findViewById(R.id.course_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CounsellorDSClassAdapter(courseList);
        recyclerView.setAdapter(adapter);

        calendarView.setOnDateSelectedListener(this);
    }

    private void initItem1(){
        courseList= new ArrayList<>();
        TeacherMessageItem item1
                = new TeacherMessageItem("操作系统",R.mipmap.subject_icon,"出勤率80%");
        courseList.add(item1);
    }
    private void initItem2(){
        courseList= new ArrayList<>();
        TeacherMessageItem item2
                = new TeacherMessageItem("数据库原理",R.mipmap.subject_icon,"出勤率80%");
        courseList.add(item2);
    }
    private void initItem3(){
        courseList= new ArrayList<>();
        TeacherMessageItem item3
                = new TeacherMessageItem("数据结构",R.mipmap.subject_icon,"出勤率80%");
        courseList.add(item3);
    }
    private void initItem4(){
        courseList= new ArrayList<>();
        TeacherMessageItem item4
                = new TeacherMessageItem("JAVA编程设计",R.mipmap.subject_icon,"出勤率80%");
        courseList.add(item4);
    }
    
    @Override
    public void onDateSelected(Calendar calendar, boolean isClick) {
        Log.d("testabc",calendar.getWeek()+"");
        int temp=calendar.getWeek();
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
                        = new TeacherMessageItem("操作系统",R.mipmap.subject_icon,"出勤4 缺勤0 迟到0 早退1 请假0");
                messageItems.add(item1);
                adapter.changeDataSet(messageItems);
                adapter.notifyDataSetChanged();
                break;
            case 2:
                messageItems = new ArrayList<>();
                TeacherMessageItem item2
                        = new TeacherMessageItem("数据库原理",R.mipmap.subject_icon,"出勤4 缺勤0 迟到0 早退1 请假0");
                messageItems.add(item2);
                adapter.changeDataSet(messageItems);
                adapter.notifyDataSetChanged();
                break;
            case 3:
                messageItems = new ArrayList<>();
                TeacherMessageItem item3
                        = new TeacherMessageItem("数据结构",R.mipmap.subject_icon,"出勤4 缺勤0 迟到0 早退1 请假0");
                messageItems.add(item3);
                adapter.changeDataSet(messageItems);
                adapter.notifyDataSetChanged();
                break;
            case 5:
                messageItems = new ArrayList<>();
                TeacherMessageItem item4
                        = new TeacherMessageItem("JAVA编程设计",R.mipmap.subject_icon,"出勤4 缺勤0 迟到0 早退1 请假0");
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
