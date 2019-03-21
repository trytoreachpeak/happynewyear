package com.example.a.checkattendance.counsellor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.a.checkattendance.R;

public class CounsellorExamroomCondition extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counsellor_examroom_condition);

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

        RelativeLayout itemFirst = (RelativeLayout)findViewById(R.id.item_first);
        RelativeLayout itemSecond = (RelativeLayout)findViewById(R.id.item_second);
        RelativeLayout itemThird = (RelativeLayout)findViewById(R.id.item_third);
        RelativeLayout itemForth = (RelativeLayout)findViewById(R.id.item_forth);
        itemFirst.setOnClickListener(this);
        itemSecond.setOnClickListener(this);
        itemThird.setOnClickListener(this);
        itemForth.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        String classroomName;
        switch(v.getId()){
            case R.id.item_first:
                classroomName="1号楼101";
                intent = new Intent(CounsellorExamroomCondition.this,CounsellorExamroomConditionDetail.class);
                intent.putExtra("classroomName",classroomName);
                startActivity(intent);
                break;
            case R.id.item_second:
                classroomName="2号楼101";
                intent = new Intent(CounsellorExamroomCondition.this,CounsellorExamroomConditionDetail.class);
                intent.putExtra("classroomName",classroomName);
                startActivity(intent);
                break;
            case R.id.item_third:
                classroomName="3号楼101";
                intent = new Intent(CounsellorExamroomCondition.this,CounsellorExamroomConditionDetail.class);
                intent.putExtra("classroomName",classroomName);
                startActivity(intent);
                break;
            case R.id.item_forth:
                classroomName="4号楼101";
                intent = new Intent(CounsellorExamroomCondition.this,CounsellorExamroomConditionDetail.class);
                intent.putExtra("classroomName",classroomName);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
