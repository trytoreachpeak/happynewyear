package com.example.a.checkattendance.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;

import java.util.ArrayList;
import java.util.List;

public class AdminTeacherAttendanceActivity extends BaseActivity implements View.OnClickListener{

    private List<Teacher> teacherList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_teacher_attendance);
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


        initclasses();
        TeacherAdapter adapter=new TeacherAdapter(AdminTeacherAttendanceActivity.this,R.layout.teacher_item,teacherList);
        ListView listview =(ListView) findViewById(R.id.list_teacher);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Teacher teacher=teacherList.get(position);
                String data=teacher.getName();
                String data2=teacher.getAttend();
                Intent intent=new Intent(AdminTeacherAttendanceActivity.this,AdminClassAttendanceActivity .class);
                intent.putExtra("extra_data",data);
                intent.putExtra("extra_data2",data2);
                startActivity(intent);
            }
        });
    }

    private void initclasses(){
        for (int i=0;i<1;i++) {
            Teacher teacher1=new Teacher ("苗丽丽","98%",R.mipmap.teacher);
            teacherList.add(teacher1);
            Teacher teacher2=new Teacher ("秦高","98.2%",R.mipmap.teacher);
            teacherList.add(teacher2);
            Teacher teacher3=new Teacher ("华含","98%",R.mipmap.teacher);
            teacherList.add(teacher3);
            Teacher teacher4=new Teacher ("谢红","98.2%",R.mipmap.teacher);
            teacherList.add(teacher4);

        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            default:
                break;
        }
    }
}
