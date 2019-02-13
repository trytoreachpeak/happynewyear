package com.example.a.checkattendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class TeacherSettings extends AppCompatActivity implements View.OnClickListener{
    CardView modifyPassword;
    CardView identityVerifi;
    CardView bindPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_settings);
        modifyPassword = (CardView)findViewById(R.id.modify_password);
        identityVerifi = (CardView)findViewById(R.id.identity_verifi);
        bindPhone = (CardView)findViewById(R.id.bind_phone);
        modifyPassword.setOnClickListener(this);
        identityVerifi.setOnClickListener(this);
        bindPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.modify_password:
                intent = new Intent(TeacherSettings.this,TeacherSettingsModifypassword.class);
                startActivity(intent);
                break;
            case R.id.identity_verifi:
                intent = new Intent(TeacherSettings.this,TeacherSettingsIdentityverifi.class);
                startActivity(intent);
                break;
            case R.id.bind_phone:
                intent = new Intent(TeacherSettings.this,TeacherSettingsBindphone.class);
                startActivity(intent);
                break;
        }
    }
}
