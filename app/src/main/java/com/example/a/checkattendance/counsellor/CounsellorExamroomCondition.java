package com.example.a.checkattendance.counsellor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.example.a.checkattendance.R;

public class CounsellorExamroomCondition extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counsellor_examroom_condition);

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

        LinearLayout itemFirst = (LinearLayout)findViewById(R.id.item_first);
        LinearLayout itemSecond = (LinearLayout)findViewById(R.id.item_second);
        LinearLayout itemThird = (LinearLayout)findViewById(R.id.item_third);
        LinearLayout itemForth = (LinearLayout)findViewById(R.id.item_forth);
        itemFirst.setOnClickListener(this);
        itemSecond.setOnClickListener(this);
        itemThird.setOnClickListener(this);
        itemForth.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.item_first:
                intent = new Intent(CounsellorExamroomCondition.this,CounsellorExamroomConditionDetail.class);
                startActivity(intent);
                break;
            case R.id.item_second:
                intent = new Intent(CounsellorExamroomCondition.this,CounsellorExamroomConditionDetail.class);
                startActivity(intent);
                break;
            case R.id.item_third:
                intent = new Intent(CounsellorExamroomCondition.this,CounsellorExamroomConditionDetail.class);
                startActivity(intent);
                break;
            case R.id.item_forth:
                intent = new Intent(CounsellorExamroomCondition.this,CounsellorExamroomConditionDetail.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
