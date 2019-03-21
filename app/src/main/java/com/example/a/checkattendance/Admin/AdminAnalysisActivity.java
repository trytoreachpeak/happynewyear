package com.example.a.checkattendance.Admin;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;

import java.util.ArrayList;
import java.util.List;

public class AdminAnalysisActivity extends BaseActivity implements View.OnClickListener{

    private List<Teacher> teacherList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_analysis);
        Button button_back=(Button)findViewById(R.id.back);
        button_back.setOnClickListener(this);
        initclasses();
        TeacherAdapter adapter=new TeacherAdapter(AdminAnalysisActivity.this,R.layout.teacher_item,teacherList);
        ListView listview =(ListView) findViewById(R.id.list_teacher);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Teacher teacher=teacherList.get(position);
                String data=teacher.getName();
                Intent intent=new Intent(AdminAnalysisActivity.this,AdminClassAnalysisActivity .class);
                intent.putExtra("extra_data",data);
                startActivity(intent);
            }
        });
    }

    private void initclasses(){
        for (int i=0;i<1;i++) {
            Teacher teacher1=new Teacher ("高等数学(一)","95%",R.drawable.kecheng);
            teacherList.add(teacher1);
            Teacher teacher2=new Teacher ("英语(二)","92.2%",R.drawable.kecheng);
            teacherList.add(teacher2);
            Teacher teacher3=new Teacher ("数据结构","90%",R.drawable.kecheng);
            teacherList.add(teacher3);
            Teacher teacher4=new Teacher ("JAVA编程设计","95.2%",R.drawable.kecheng);
            teacherList.add(teacher4);

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
