package com.example.a.checkattendance.teacher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
    }
    private void initTeacherMessageItem(){
        TeacherMessageItem testExample=new TeacherMessageItem("请假申请",
                R.drawable.shenqing_img,"某某班","某某某");
        messageItemList.add(testExample);
    }
}
