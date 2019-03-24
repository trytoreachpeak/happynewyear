package com.example.a.checkattendance.counsellor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.teacher.TeacherMessageAdapter;
import com.example.a.checkattendance.teacher.TeacherMessageItem;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;

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
        //setHasOptionsMenu(true);

//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                Intent intent = new Intent(CounsellorDataAnalysis.this,
//                        CounsellorClassmateList.class);
//                startActivity(intent);
//                return false;
//            }
//        });
//        toolbar.setOverflowIcon(getResources().getDrawable(R.mipmap.classmate_icon));
    }
    private void initCounsellorDAItem(){
        TeacherMessageItem testExample=new TeacherMessageItem("计161",
                R.drawable.banji_img,"");
        CounsellorDAItemList.add(testExample);
        TeacherMessageItem testExample1=new TeacherMessageItem("计162",
                R.drawable.banji_img,"");
        CounsellorDAItemList.add(testExample1);
        TeacherMessageItem testExample2=new TeacherMessageItem("软工161",
                R.drawable.banji_img,"");
        CounsellorDAItemList.add(testExample2);
        TeacherMessageItem testExample3=new TeacherMessageItem("软工162",
                R.drawable.banji_img,"");
        CounsellorDAItemList.add(testExample3);
    }


}
