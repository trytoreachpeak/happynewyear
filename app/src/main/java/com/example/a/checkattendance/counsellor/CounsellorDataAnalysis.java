package com.example.a.checkattendance.counsellor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.teacher.TeacherMessageAdapter;
import com.example.a.checkattendance.teacher.TeacherMessageItem;

import java.util.ArrayList;
import java.util.List;

public class CounsellorDataAnalysis extends AppCompatActivity {
    private List<TeacherMessageItem> CounsellorDAItemList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counsellor_data_analysis);
        initCounsellorDAItem();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.counsellor_data_analysis_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        CounsellorDataAnalysisAdapter adapter = new CounsellorDataAnalysisAdapter(CounsellorDAItemList);
        recyclerView.setAdapter(adapter);
    }
    private void initCounsellorDAItem(){
        TeacherMessageItem testExample=new TeacherMessageItem("班级名",
                R.drawable.shenqing_img,"出勤率？% 专注度 高/中/低");
        CounsellorDAItemList.add(testExample);
    }
}
