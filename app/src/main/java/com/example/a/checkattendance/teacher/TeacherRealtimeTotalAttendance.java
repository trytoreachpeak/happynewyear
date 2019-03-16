package com.example.a.checkattendance.teacher;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a.checkattendance.R;

import java.util.ArrayList;

public class TeacherRealtimeTotalAttendance extends AppCompatActivity implements View.OnClickListener{
    private ArrayList<StudentBean> childData = new ArrayList<>();
    private  ArrayList<ArrayList<StudentBean>> mchildData = new ArrayList<>();
    private ArrayList<StudentBean> attendList = new ArrayList<>();
    private ArrayList<StudentBean> absencelist = new ArrayList<>();
    private ArrayList<StudentBean> lateattendList = new ArrayList<>();
    private ArrayList<StudentBean> earlyleaveList = new ArrayList<>();
    private ArrayList<StudentBean> leaveList = new ArrayList<>();

    private LinearLayout attendBackground;
    private LinearLayout absenceBackground;
    private LinearLayout lateattendground;
    private LinearLayout earlyleaveground;
    private LinearLayout leaveBackground;
    private TextView attendText;
    private TextView absenceText;
    private TextView lateattendText;
    private TextView earlyleaveText;
    private TextView leaveText;
    TeacherRealtimeTotalAttendanceAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_realtime_total_attendance);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        mchildData = (ArrayList<ArrayList<StudentBean>>) args.getSerializable("ARRAYLIST");
        initData();
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

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new TeacherRealtimeTotalAttendanceAdapter(attendList);
        recyclerView.setAdapter(adapter);

        attendBackground=(LinearLayout)findViewById(R.id.attend_background);
        absenceBackground=(LinearLayout)findViewById(R.id.absence_background);
        lateattendground=(LinearLayout)findViewById(R.id.lateattend_background);
        earlyleaveground=(LinearLayout)findViewById(R.id.earlyleave_background);
        leaveBackground=(LinearLayout)findViewById(R.id.leave_background);
        attendText=(TextView)findViewById(R.id.attend_text);
        absenceText=(TextView)findViewById(R.id.absence_text);
        lateattendText=(TextView)findViewById(R.id.lateattend_text);
        earlyleaveText=(TextView)findViewById(R.id.earlyleave_text);
        leaveText=(TextView)findViewById(R.id.leave_text);

        attendBackground.setOnClickListener(this);
        absenceBackground.setOnClickListener(this);
        lateattendground.setOnClickListener(this);
        earlyleaveground.setOnClickListener(this);
        leaveBackground.setOnClickListener(this);

    }
    private void initData(){
        for (ArrayList<StudentBean> arrayStudentBean:TeacherRealtimeClassroom.childData){
            for(StudentBean studentBean:arrayStudentBean){//到时候RealClassRoom的数据可以联网更新。这里传数据上去。
                switch(studentBean.getAttendanceStatus()){
                    case 0:
                        attendList.add(studentBean);
                        break;
                    case 1:
                        absencelist.add(studentBean);
                        break;
                    case 2:
                        lateattendList.add(studentBean);
                        break;
                    case 3:
                        earlyleaveList.add(studentBean);
                        break;
                    case 4:
                        leaveList.add(studentBean);
                        break;
                    default:
                        break;
                }
            }
        }
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.attend_background:
                attendBackground.setBackgroundColor(Color.parseColor("#66cc99"));
                absenceBackground.setBackgroundResource(R.drawable.choose_button);
                lateattendground.setBackgroundResource(R.drawable.choose_button);
                earlyleaveground.setBackgroundResource(R.drawable.choose_button);
                leaveBackground.setBackgroundResource(R.drawable.choose_button);

                attendText.setTextColor(Color.parseColor("#ffffff"));
                absenceText.setTextColor(Color.parseColor("#333333"));
                lateattendText.setTextColor(Color.parseColor("#333333"));
                earlyleaveText.setTextColor(Color.parseColor("#333333"));
                leaveText.setTextColor(Color.parseColor("#333333"));
                adapter.updateData(attendList);
                break;
            case R.id.absence_background:
                attendBackground.setBackgroundResource(R.drawable.choose_button);
                absenceBackground.setBackgroundColor(Color.parseColor("#ee3322"));
                lateattendground.setBackgroundResource(R.drawable.choose_button);
                earlyleaveground.setBackgroundResource(R.drawable.choose_button);
                leaveBackground.setBackgroundResource(R.drawable.choose_button);

                attendText.setTextColor(Color.parseColor("#333333"));
                absenceText.setTextColor(Color.parseColor("#ffffff"));
                lateattendText.setTextColor(Color.parseColor("#333333"));
                earlyleaveText.setTextColor(Color.parseColor("#333333"));
                leaveText.setTextColor(Color.parseColor("#333333"));
                adapter.updateData(absencelist);
                break;
            case R.id.lateattend_background:
                attendBackground.setBackgroundResource(R.drawable.choose_button);
                absenceBackground.setBackgroundResource(R.drawable.choose_button);
                lateattendground.setBackgroundColor(Color.parseColor("#ffcc00"));
                earlyleaveground.setBackgroundResource(R.drawable.choose_button);
                leaveBackground.setBackgroundResource(R.drawable.choose_button);

                attendText.setTextColor(Color.parseColor("#333333"));
                absenceText.setTextColor(Color.parseColor("#333333"));
                lateattendText.setTextColor(Color.parseColor("#ffffff"));
                earlyleaveText.setTextColor(Color.parseColor("#333333"));
                leaveText.setTextColor(Color.parseColor("#333333"));
                adapter.updateData(lateattendList);
                break;
            case R.id.earlyleave_background:
                attendBackground.setBackgroundResource(R.drawable.choose_button);
                absenceBackground.setBackgroundResource(R.drawable.choose_button);
                lateattendground.setBackgroundResource(R.drawable.choose_button);
                earlyleaveground.setBackgroundColor(Color.parseColor("#ffa500"));
                leaveBackground.setBackgroundResource(R.drawable.choose_button);

                attendText.setTextColor(Color.parseColor("#333333"));
                absenceText.setTextColor(Color.parseColor("#333333"));
                lateattendText.setTextColor(Color.parseColor("#333333"));
                earlyleaveText.setTextColor(Color.parseColor("#ffffff"));
                leaveText.setTextColor(Color.parseColor("#333333"));
                adapter.updateData(earlyleaveList);
                break;
            case R.id.leave_background:
                attendBackground.setBackgroundResource(R.drawable.choose_button);
                absenceBackground.setBackgroundResource(R.drawable.choose_button);
                lateattendground.setBackgroundResource(R.drawable.choose_button);
                earlyleaveground.setBackgroundResource(R.drawable.choose_button);
                leaveBackground.setBackgroundColor(Color.parseColor("#4ba9e6"));

                attendText.setTextColor(Color.parseColor("#333333"));
                absenceText.setTextColor(Color.parseColor("#333333"));
                lateattendText.setTextColor(Color.parseColor("#333333"));
                earlyleaveText.setTextColor(Color.parseColor("#333333"));
                leaveText.setTextColor(Color.parseColor("#ffffff"));
                adapter.updateData(leaveList);
                break;
                default:break;

        }
    }
}
