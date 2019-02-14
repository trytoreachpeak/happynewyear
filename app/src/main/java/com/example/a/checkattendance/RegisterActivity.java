package com.example.a.checkattendance;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a.checkattendance.student.BaseActivity;
import com.example.a.checkattendance.student.StudentHomepageActivity;


public class RegisterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button button1=(Button)findViewById(R.id.button_1);
        Button button2=(Button)findViewById(R.id.button_2);
        EditText edittext_1=(EditText) findViewById(R.id.edittext_1);
        EditText edittext_2=(EditText) findViewById(R.id.edittext_2);
        EditText edittext_3=(EditText) findViewById(R.id.edittext_3);
        EditText edittext_4=(EditText) findViewById(R.id.edittext_4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this,"注册",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(RegisterActivity.this,ActivityLogin.class);
                startActivity(intent);
                finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this,"获取验证码",Toast.LENGTH_SHORT).show();
            }
        });

    }
}