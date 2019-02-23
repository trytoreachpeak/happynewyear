package com.example.a.checkattendance.counsellor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.a.checkattendance.R;

public class CounsellorExamConditionDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counsellor_exam_condition_detail);
        Intent intent = getIntent();
        String className = intent.getStringExtra("className");
        TextView title = (TextView)findViewById(R.id.title);
        TextView examTime = (TextView)findViewById(R.id.exam_time);
        TextView examLesson = (TextView)findViewById(R.id.exam_lesson);
        title.setText(className);
        if(className.equals("班级2")){
            examTime.setText("2019-01-06 8:30-10:30");
            examLesson.setText("英语（二）");
        }

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
}
