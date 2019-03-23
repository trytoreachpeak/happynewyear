package com.example.a.checkattendance.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.a.checkattendance.R;

import java.util.ArrayList;
import java.util.List;

public class StudentStatisticActivity extends AppCompatActivity {
    private List<Class> classList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_statistic);

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
        ClassAdapter adapter=new ClassAdapter(StudentStatisticActivity.this,R.layout.class_item,classList);
        ListView listview =(ListView) findViewById(R.id.list_course);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Class class1=classList.get(position);
                String data=class1.getName();
                Intent intent=new Intent(StudentStatisticActivity.this,StudentPersonalStatisticActivity.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);
            }
        });
    }
    private void initclasses(){
        for (int i=0;i<1;i++) {
            Class shuxue=new Class ("操作系统",R.drawable.kecheng);
            classList.add(shuxue);
            Class yingyu=new Class ("数据库原理",R.drawable.kecheng);
            classList.add(yingyu);
            Class shuju=new Class ("数据结构",R.drawable.kecheng);
            classList.add(shuju);
            Class java=new Class ("JAVA编程设计",R.drawable.kecheng);
            classList.add(java);
        }
    }

}
