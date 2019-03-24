package com.example.a.checkattendance.teacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a.checkattendance.ActivityLogin;
import com.example.a.checkattendance.R;

public class TeacherPersoninfo extends AppCompatActivity {
    Button exit;
    TextView setName;
    TextView setNum;
    TextView setPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_personinfo);

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

        setName = (TextView)findViewById(R.id.set_name);
        setNum = (TextView)findViewById(R.id.set_num);
        setPhone = (TextView)findViewById(R.id.set_phone);

        Intent intent = getIntent();
        setName.setText(intent.getStringExtra("name"));
        setNum.setText(intent.getStringExtra("num"));
        setPhone.setText(intent.getStringExtra("phone"));
        exit = (Button)findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intentmain=new Intent(TeacherPersoninfo.this,ActivityLogin.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentmain);
            }
        });
    }

}
