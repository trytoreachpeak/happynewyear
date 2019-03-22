package com.example.a.checkattendance.teacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.a.checkattendance.R;

import java.util.ArrayList;
import java.util.List;

public class TeacherMyCourse extends AppCompatActivity {
    private List<TeacherMyCourseItem> mlist = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_my_course);
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

        initData();
        recyclerView=(RecyclerView)findViewById(R.id.course_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        TeacherMyCourseAdapter adapter = new TeacherMyCourseAdapter(mlist);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_my_course, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_1:
                Intent intent = new Intent(TeacherMyCourse.this,TeacherAddCourse.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void initData(){
        TeacherMyCourseItem data1 = new TeacherMyCourseItem("1-16周","JX02-302",
                "周一 1-2节","操作系统","-计161 计162","58人");
        mlist.add(data1);
        TeacherMyCourseItem data2 = new TeacherMyCourseItem("1-16周","JX08-514",
                "周二 3-5节","数据库原理","-计161 计162","58人");
        mlist.add(data2);
        TeacherMyCourseItem data3 = new TeacherMyCourseItem("1-16周","JX03-303",
                "周三 1-2节","数据结构","-计161 计162","58人");
        mlist.add(data3);
        TeacherMyCourseItem data4 = new TeacherMyCourseItem("1-16周","JX18-205",
                "周五 6-8节","JAVA程序设计","-计161 计162","58人");
        mlist.add(data4);
    }
}
