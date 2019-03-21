package com.example.a.checkattendance.teacher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.example.a.checkattendance.R;
import com.haibin.calendarview.CalendarView;

import java.util.ArrayList;
import java.util.List;

public class TeacherClassHistory extends AppCompatActivity {
    private List<TeacherMessageItem> courseList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_class_history);
        CalendarView calendarView =(CalendarView)findViewById(R.id.calendarView);

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

        initItem();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.course_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        TeacherClassHistoryAdapter adapter = new TeacherClassHistoryAdapter(courseList);
        recyclerView.setAdapter(adapter);
    }
    private void initItem(){
        TeacherMessageItem item1
                = new TeacherMessageItem("高等数学",R.mipmap.subject_icon,"计161 计162");
        courseList.add(item1);
    }
}
