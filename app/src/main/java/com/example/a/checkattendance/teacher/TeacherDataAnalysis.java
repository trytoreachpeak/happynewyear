package com.example.a.checkattendance.teacher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.a.checkattendance.R;

public class TeacherDataAnalysis extends AppCompatActivity {
    private int whichCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_data_analysis);

        Intent intent = getIntent();
        whichCourse = intent.getIntExtra("whichCourse",0);

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
}
