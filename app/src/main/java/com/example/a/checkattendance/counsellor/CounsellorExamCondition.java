package com.example.a.checkattendance.counsellor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.example.a.checkattendance.R;

public class CounsellorExamCondition extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counsellor_exam_condition);
        LinearLayout ClassNumberOne = (LinearLayout)findViewById(R.id.class_number_one);
        LinearLayout ClassNumberTwo = (LinearLayout)findViewById(R.id.class_number_two);
        ClassNumberOne.setOnClickListener(this);
        ClassNumberTwo.setOnClickListener(this);

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
        String className;
        switch(v.getId()){
            case R.id.class_number_one:
                className="班级1";
                intent = new Intent(CounsellorExamCondition.this,CounsellorExamConditionDetail.class);
                intent.putExtra("className",className);
                startActivity(intent);
                break;
            case R.id.class_number_two:
                className="班级2";
                intent = new Intent(CounsellorExamCondition.this,CounsellorExamConditionDetail.class);
                intent.putExtra("className",className);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
