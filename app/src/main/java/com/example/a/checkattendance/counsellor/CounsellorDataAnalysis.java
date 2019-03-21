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
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //setHasOptionsMenu(true);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(CounsellorDataAnalysis.this,
                        CounsellorClassmateList.class);
                startActivity(intent);
                return false;
            }
        });
        toolbar.setOverflowIcon(getResources().getDrawable(R.mipmap.classmate_icon));
    }
    private void initCounsellorDAItem(){
        TeacherMessageItem testExample=new TeacherMessageItem("班级名",
                R.drawable.shenqing_img,"出勤率？% 专注度 高/中/低");
        CounsellorDAItemList.add(testExample);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_1:
                //Toast.makeText(getActivity(), "我是第一个", Toast.LENGTH_SHORT).show();
                break;
            /*case R.id.menu_2:
                //Toast.makeText(getActivity(), "我是第二个", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_3:
                //Toast.makeText(getActivity(), "我是第三个", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_4:
                //Toast.makeText(getActivity(), "我是第四个", Toast.LENGTH_SHORT).show();
                break;*/
        }
        return super.onOptionsItemSelected(item);
    }
}
