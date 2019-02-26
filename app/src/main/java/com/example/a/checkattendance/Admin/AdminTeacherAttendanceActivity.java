package com.example.a.checkattendance.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        Button button_back=(Button)findViewById(R.id.back);
        button_back.setOnClickListener(this);


        initclasses();
        TeacherAdapter adapter=new TeacherAdapter(AdminTeacherAttendanceActivity.this,R.layout.teacher_item,teacherList);
        ListView listview =(ListView) findViewById(R.id.list_teacher);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Teacher teacher=teacherList.get(position);
                String data=teacher.getName();
                Intent intent=new Intent(AdminTeacherAttendanceActivity.this,AdminClassAttendanceActivity .class);
                intent.putExtra("extra_data",data);
                startActivity(intent);
            }
        });
    }

    private void initclasses(){
        for (int i=0;i<1;i++) {
            Teacher shuxue=new Teacher ("苗丽丽","98%",R.drawable.kecheng);
            teacherList.add(shuxue);
            Teacher yingyu=new Teacher ("秦高","98.2%",R.drawable.kecheng);
            teacherList.add(yingyu);
            Teacher shuxue2=new Teacher ("苗丽丽","98%",R.drawable.kecheng);
            teacherList.add(shuxue);
            Teacher yingyu3=new Teacher ("秦高","98.2%",R.drawable.kecheng);
            teacherList.add(yingyu);
            Teacher shuxue4=new Teacher ("苗丽丽","98%",R.drawable.kecheng);
            teacherList.add(shuxue);
            Teacher yingyu5=new Teacher ("秦高","98.2%",R.drawable.kecheng);
            teacherList.add(yingyu);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            default:
                break;
        }
    }
}
