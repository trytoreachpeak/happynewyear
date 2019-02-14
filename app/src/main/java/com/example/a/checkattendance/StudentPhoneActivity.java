package com.example.a.checkattendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

    public class StudentPhoneActivity extends BaseActivity implements View.OnClickListener{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_student_phone);
            Button button_back=(Button) findViewById(R.id.back);
            button_back.setOnClickListener(this);
            Button button_confirm=(Button) findViewById(R.id.confirm);
            button_confirm.setOnClickListener(this);
            TextView t_yan=(TextView) findViewById(R.id.yan);
            t_yan.setOnClickListener(this);
        }


        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.back:
                    finish();
                    break;
                case R.id.confirm:
                    finish();
                    Toast.makeText(StudentPhoneActivity.this,"完成",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.yan:
                    Toast.makeText(StudentPhoneActivity.this,"发送验证码",Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }

    }