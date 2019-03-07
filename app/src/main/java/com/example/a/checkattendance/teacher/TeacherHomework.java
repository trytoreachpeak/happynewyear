package com.example.a.checkattendance.teacher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.a.checkattendance.R;

public class TeacherHomework extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_homework);
        Button abc=(Button)findViewById(R.id.abc);
        abc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TeacherHomework.this, "abc", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
