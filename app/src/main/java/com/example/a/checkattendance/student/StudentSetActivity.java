package com.example.a.checkattendance.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.a.checkattendance.R;

public class StudentSetActivity extends BaseActivity implements View.OnClickListener{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_student_set);
            Button button_back=(Button) findViewById(R.id.back);
            button_back.setOnClickListener(this);
            Button button_finish=(Button) findViewById(R.id.finish);
            button_finish.setOnClickListener(this);
            ImageView image_mima=(ImageView) findViewById(R.id.mima);
            image_mima.setOnClickListener(this);
            ImageView image_shenfen=(ImageView) findViewById(R.id.shenfen);
            image_shenfen.setOnClickListener(this);
            ImageView image_phone=(ImageView) findViewById(R.id.phone);
            image_phone.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.back:
                    finish();
                    break;
                case R.id.mima:
                    Intent intent1 = new Intent(StudentSetActivity.this, StudentpasswordActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.shenfen:
                    Intent intent2 = new Intent(StudentSetActivity.this, StudentShenfenActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.phone:
                    Intent intent3 = new Intent(StudentSetActivity.this, StudentPhoneActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.finish:
                    ActivityCollector.finishAll();
                    break;
                default:
                    break;
            }
        }


    }