package com.example.a.checkattendance.counsellor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.teacher.TeacherAddCourse;
import com.example.a.checkattendance.teacher.TeacherMessageItem;
import com.example.a.checkattendance.teacher.TeacherMyCourse;

import java.util.ArrayList;
import java.util.List;

public class CounsellorMyClass extends AppCompatActivity {
    List<TeacherMessageItem> mList = new ArrayList<>();
    RecyclerView recyclerView;
    CounsellorMyClassAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counsellor_my_class);

        initData();
        recyclerView = (RecyclerView)findViewById(R.id.class_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CounsellorMyClassAdapter(mList);
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
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_my_course, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_1:
                Toast toast = Toast.makeText(CounsellorMyClass.this, null, Toast.LENGTH_SHORT);
                toast.setText("暂时不能添加新班级,添加班级请联系管理员");
                toast.show();
        }
        return super.onOptionsItemSelected(item);
    }
    private void initData(){
        TeacherMessageItem item = new TeacherMessageItem("计161",R.drawable.banji_img,"人数28");
        mList.add(item);
        TeacherMessageItem item1 = new TeacherMessageItem("计162",R.drawable.banji_img,"人数28");
        mList.add(item1);
        TeacherMessageItem item2 = new TeacherMessageItem("软工161",R.drawable.banji_img,"人数30");
        mList.add(item2);
        TeacherMessageItem item3 = new TeacherMessageItem("软工162",R.drawable.banji_img,"人数30");
        mList.add(item3);
    }
}
