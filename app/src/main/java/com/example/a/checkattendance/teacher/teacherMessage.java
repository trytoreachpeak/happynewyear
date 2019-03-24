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

public class teacherMessage extends AppCompatActivity {
    private List<TeacherMessageItem> messageItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_message);

        initTeacherMessageItem();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.teacher_message_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        TeacherMessageAdapter adapter = new TeacherMessageAdapter(messageItemList);
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
    private void initTeacherMessageItem(){
        TeacherMessageItem testExample=new TeacherMessageItem("请假申请",
                R.drawable.shenqing_img,"计161 蔡周宇");
        messageItemList.add(testExample);
        TeacherMessageItem testExample1=new TeacherMessageItem("请假申请",
                R.drawable.shenqing_img,"计162 邵正宇");
        messageItemList.add(testExample1);
    }
}
