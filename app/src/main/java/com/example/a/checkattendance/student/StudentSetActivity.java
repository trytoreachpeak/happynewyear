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

public class StudentSetActivity extends BaseActivity implements View.OnClickListener{

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

            RelativeLayout r_password=(RelativeLayout)findViewById(R.id.password);
            r_password.setOnClickListener(this);
            RelativeLayout r_identity=(RelativeLayout)findViewById(R.id.identity);
            r_identity.setOnClickListener(this);
            RelativeLayout r_bindpone=(RelativeLayout)findViewById(R.id.bindpone);
            r_bindpone.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.password:
                    Intent intent1 = new Intent(StudentSetActivity.this, StudentpasswordActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.identity:
                    Intent intent2 = new Intent(StudentSetActivity.this, StudentShenfenActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.bindpone:
                    Intent intent3 = new Intent(StudentSetActivity.this, StudentPhoneActivity.class);
                    startActivity(intent3);
                    break;
                default:
                    break;
            }
        }


    }