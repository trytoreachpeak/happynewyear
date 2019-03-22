package com.example.a.checkattendance.teacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.a.checkattendance.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class TeacherMyAttendance extends AppCompatActivity {
    private List<TeacherMyAttendanceItem> itemList= new ArrayList<>();
    int whichCourse;
    TextView attendCount;
    TextView absenceCount;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_my_attendance);

        Intent intent = getIntent();
        whichCourse = intent.getIntExtra("whichCourse",0);

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
        attendCount=(TextView)findViewById(R.id.attend_count);
        absenceCount=(TextView)findViewById(R.id.absence_count);
        title=(TextView)findViewById(R.id.title);
        absenceCount.setText("0");
        switch(whichCourse){
            case 0:
                initItem1();
                attendCount.setText("3");
                title.setText("操作系统");
                break;
            case 1:
                initItem2();
                attendCount.setText("3");
                title.setText("数据库原理");
                break;
            case 2:
                initItem3();
                attendCount.setText("2");
                title.setText("数据结构");
                break;
            case 3:
                initItem4();
                attendCount.setText("2");
                title.setText("JAVA编程设计");
                break;
            default:
                break;
        }

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        TeacherMyAttendanceAdapter adapter = new TeacherMyAttendanceAdapter(itemList);
        recyclerView.setAdapter(adapter);
    }
    private void initItem1(){
        TeacherMyAttendanceItem item1 =
                new TeacherMyAttendanceItem("2019-03-04 07:50","星期一",0);
        itemList.add(item1);
        TeacherMyAttendanceItem item2 =
                new TeacherMyAttendanceItem("2019-03-11 07:49","星期一",0);
        itemList.add(item2);
        TeacherMyAttendanceItem item3 =
                new TeacherMyAttendanceItem("2019-03-18 07:52","星期一",0);
        itemList.add(item3);
    }
    private void initItem2(){
        TeacherMyAttendanceItem item1 =
                new TeacherMyAttendanceItem("2019-3-05 09:30","星期二",0);
        itemList.add(item1);
        TeacherMyAttendanceItem item2 =
                new TeacherMyAttendanceItem("2019-3-12 09:30","星期二",0);
        itemList.add(item2);
        TeacherMyAttendanceItem item3 =
                new TeacherMyAttendanceItem("2019-3-19 09:30","星期二",0);
        itemList.add(item3);
    }
    private void initItem3(){
        TeacherMyAttendanceItem item1 =
                new TeacherMyAttendanceItem("2019-3-13 7:51","星期三",0);
        itemList.add(item1);
        TeacherMyAttendanceItem item2 =
                new TeacherMyAttendanceItem("2019-3-20 7:51","星期三",0);
        itemList.add(item2);
    }
    private void initItem4(){
        TeacherMyAttendanceItem item1 =
                new TeacherMyAttendanceItem("2019-3-14 13:30","星期五",0);
        itemList.add(item1);
        TeacherMyAttendanceItem item2 =
                new TeacherMyAttendanceItem("2019-3-21 13:29","星期五",0);
        itemList.add(item2);
    }
}
