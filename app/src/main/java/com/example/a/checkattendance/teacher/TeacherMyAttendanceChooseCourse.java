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

public class TeacherMyAttendanceChooseCourse extends AppCompatActivity {
    private List<TeacherMessageItem> courseList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_my_attendance_choose_course);

        initItem();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.course_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        TeacherMyAttendanceCCAdapter adapter = new TeacherMyAttendanceCCAdapter(courseList);
        recyclerView.setAdapter(adapter);

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
    }
    private void initItem(){
        TeacherMessageItem item1
                = new TeacherMessageItem("高等数学",R.mipmap.subject_icon,"计161 计162");
        courseList.add(item1);
    }
}
