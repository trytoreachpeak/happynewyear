package com.example.a.checkattendance.teacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.a.checkattendance.R;

public class TeacherSettings extends AppCompatActivity implements View.OnClickListener{
    RelativeLayout personInfo;
    RelativeLayout modifyPassword;
    RelativeLayout identityVerifi;
    RelativeLayout bindPhone;
    RelativeLayout remindBeforeClass;
    RelativeLayout softwareVersion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_settings);

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
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.person_info:
                intent = new Intent(this, TeacherPersoninfo.class);
                startActivity(intent);
                break;
            case R.id.modify_password:
                intent = new Intent(this, TeacherSettingsModifypassword.class);
                startActivity(intent);
                break;
            case R.id.identity_verifi:
                intent = new Intent(this, TeacherSettingsIdentityverifi.class);
                startActivity(intent);
                break;
            case R.id.bind_phone:
                intent = new Intent(this, TeacherSettingsBindphone.class);
                startActivity(intent);
                break;
            case R.id.remind_before_class:
                intent = new Intent(this,TeacherRemindBeforeClass.class);
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
