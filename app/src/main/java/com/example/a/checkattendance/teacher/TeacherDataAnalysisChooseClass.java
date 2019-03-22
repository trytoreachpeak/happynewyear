package com.example.a.checkattendance.teacher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.a.checkattendance.R;

import java.util.ArrayList;
import java.util.List;

public class TeacherDataAnalysisChooseClass extends AppCompatActivity {
    private List<TeacherMessageItem> courseList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_data_analysis_choose_class);
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
        TeacherMyAttendanceCCAdapter adapter = new TeacherMyAttendanceCCAdapter(courseList);
        recyclerView.setAdapter(adapter);
    }
    private void initItem(){
        TeacherMessageItem item1
                = new TeacherMessageItem("操作系统",R.mipmap.subject_icon,"计161 计162");
        courseList.add(item1);
        TeacherMessageItem item2
                = new TeacherMessageItem("数据库原理",R.mipmap.subject_icon,"计161 计162");
        courseList.add(item2);
        TeacherMessageItem item3
                = new TeacherMessageItem("数据结构",R.mipmap.subject_icon,"计161 计162");
        courseList.add(item3);
        TeacherMessageItem item4
                = new TeacherMessageItem("JAVA程序设计",R.mipmap.subject_icon,"计161 计162");
        courseList.add(item4);
    }
}
