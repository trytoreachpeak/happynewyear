package com.example.a.checkattendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

    public class StudentpasswordActivity extends BaseActivity implements View.OnClickListener{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_studentpassword);
            Button button_back=(Button) findViewById(R.id.back);
            button_back.setOnClickListener(this);
            Button button_confirm=(Button) findViewById(R.id.confirm);
            button_confirm.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.back:
                    finish();
                    break;
                case R.id.confirm:
                    finish();
                    Toast.makeText(StudentpasswordActivity.this,"完成",Toast.LENGTH_SHORT).show();
                default:
                    break;
            }
        }
    }