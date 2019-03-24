package com.example.a.checkattendance.counsellor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.teacher.TeacherMessageAdapter;
import com.example.a.checkattendance.teacher.TeacherMessageItem;

import java.util.ArrayList;
import java.util.List;

public class CounsellorDataStatistics extends AppCompatActivity {
    private List<TeacherMessageItem> CounsellorDSItemList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counsellor_data_statistics);
        initCounsellorDSItem();

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

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.counsellor_data_statis_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        CounsellorDataStatisticsAdapter adapter = new CounsellorDataStatisticsAdapter(CounsellorDSItemList);
        recyclerView.setAdapter(adapter);
    }
    private void initCounsellorDSItem(){
        TeacherMessageItem testExample=new TeacherMessageItem("计161",
                R.drawable.banji_img,"出勤率90%");
        CounsellorDSItemList.add(testExample);
        TeacherMessageItem testExample1=new TeacherMessageItem("计162",
                R.drawable.banji_img,"出勤率87%");
        CounsellorDSItemList.add(testExample1);
        TeacherMessageItem testExample2=new TeacherMessageItem("软工161",
                R.drawable.banji_img,"出勤率97%");
        CounsellorDSItemList.add(testExample2);
        TeacherMessageItem testExample3=new TeacherMessageItem("软工162",
                R.drawable.banji_img,"出勤率80%");
        CounsellorDSItemList.add(testExample3);
    }
}
