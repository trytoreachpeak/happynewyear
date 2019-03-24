package com.example.a.checkattendance.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;
import com.example.a.checkattendance.student.StudentPhoneActivity;
import com.example.a.checkattendance.student.StudentSetActivity;
import com.example.a.checkattendance.student.StudentShenfenActivity;
import com.example.a.checkattendance.student.StudentpasswordActivity;
import com.example.a.checkattendance.teacher.TeacherPersoninfo;
import com.example.a.checkattendance.teacher.TeacherRemindBeforeClass;
import com.example.a.checkattendance.teacher.TeacherSettingsBindphone;
import com.example.a.checkattendance.teacher.TeacherSettingsIdentityverifi;
import com.example.a.checkattendance.teacher.TeacherSettingsModifypassword;
import com.example.a.checkattendance.teacher.TeacherSoftwareVersion;

public class AdminSettingsActivity extends BaseActivity implements View.OnClickListener{
    RelativeLayout personInfo;
    RelativeLayout modifyPassword;
    RelativeLayout identityVerifi;
    RelativeLayout bindPhone;

    RelativeLayout softwareVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_settings);
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

        personInfo=(RelativeLayout)findViewById(R.id.person_info);
        modifyPassword=(RelativeLayout)findViewById(R.id.modify_password);
        identityVerifi=(RelativeLayout)findViewById(R.id.identity_verifi);
        bindPhone=(RelativeLayout)findViewById(R.id.bind_phone);

        softwareVersion=(RelativeLayout)findViewById(R.id.software_version);

        personInfo.setOnClickListener(this);
        modifyPassword.setOnClickListener(this);
        identityVerifi.setOnClickListener(this);
        bindPhone.setOnClickListener(this);

        softwareVersion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.person_info:
                intent = new Intent(this, AdminInformationActivity.class);
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

            case R.id.software_version:
                intent = new Intent(this,TeacherSoftwareVersion.class);
                startActivity(intent);
                break;
            default:
                break;

        }
    }
}
