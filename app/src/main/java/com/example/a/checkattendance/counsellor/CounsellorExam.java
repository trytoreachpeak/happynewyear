package com.example.a.checkattendance.counsellor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.example.a.checkattendance.R;

public class CounsellorExam extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counsellor_exam);
        LinearLayout ExamCondition = (LinearLayout)findViewById(R.id.exam_condition);
        LinearLayout ExamRoomCondition = (LinearLayout)findViewById(R.id.exam_room_condition);
        ExamCondition.setOnClickListener(this);
        ExamRoomCondition.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.exam_condition:
                intent = new Intent(CounsellorExam.this,CounsellorExamCondition.class);
                startActivity(intent);
                break;
            case R.id.exam_room_condition:
                intent = new Intent(CounsellorExam.this,CounsellorExamroomCondition.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
