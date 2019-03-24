package com.example.a.checkattendance.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.a.checkattendance.ActivityCollector;
import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;
import com.example.a.checkattendance.teacher.TeacherRemindBeforeClass;
import com.example.a.checkattendance.teacher.TeacherSettingsBindphone;
import com.example.a.checkattendance.teacher.TeacherSoftwareVersion;

public class StudentSetActivity extends BaseActivity implements View.OnClickListener{
    RelativeLayout personInfo;
    RelativeLayout modifyPassword;
    RelativeLayout identityVerifi;
    RelativeLayout bindPhone;
    RelativeLayout remindBeforeClass;
    RelativeLayout softwareVersion;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_student_set);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("");
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.mipmap.ic_back);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

            personInfo=(RelativeLayout)findViewById(R.id.person_info);
            modifyPassword=(RelativeLayout)findViewById(R.id.modify_password);
            identityVerifi=(RelativeLayout)findViewById(R.id.identity_verifi);
            bindPhone=(RelativeLayout)findViewById(R.id.bind_phone);
            remindBeforeClass=(RelativeLayout)findViewById(R.id.remind_before_class);
            softwareVersion=(RelativeLayout)findViewById(R.id.software_version);

            personInfo.setOnClickListener(this);
            modifyPassword.setOnClickListener(this);
            identityVerifi.setOnClickListener(this);
            bindPhone.setOnClickListener(this);
            remindBeforeClass.setOnClickListener(this);
            softwareVersion.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            Intent intent;
            switch(v.getId()){
                case R.id.person_info:
                    intent = new Intent(this, StudentInformationActivity.class);
                    startActivity(intent);
                    break;
                case R.id.modify_password:
                    intent = new Intent(this, StudentpasswordActivity.class);
                    startActivity(intent);
                    break;
                case R.id.identity_verifi:
                    intent = new Intent(this, StudentShenfenActivity.class);
                    startActivity(intent);
                    break;
                case R.id.bind_phone:
                    intent = new Intent(this, StudentPhoneActivity.class);
                    startActivity(intent);
                    break;
                case R.id.remind_before_class:
                    intent = new Intent(StudentSetActivity.this,TeacherRemindBeforeClass.class);
                    startActivity(intent);
                    break;
                case R.id.software_version:
                    intent = new Intent(StudentSetActivity.this,TeacherSoftwareVersion.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }
        }


    }