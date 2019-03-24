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
import com.example.a.checkattendance.gsonitem.GetSingleLessonCondtion;

import java.util.ArrayList;

public class TeacherRealtimeTotalAttendance extends AppCompatActivity
        implements View.OnClickListener,ModifyInnerData{
    private ArrayList<GetSingleLessonCondtion.Data> attendList = new ArrayList<>();
    private ArrayList<GetSingleLessonCondtion.Data> absencelist = new ArrayList<>();
    private ArrayList<GetSingleLessonCondtion.Data> lateattendList = new ArrayList<>();
    private ArrayList<GetSingleLessonCondtion.Data> earlyleaveList = new ArrayList<>();
    private ArrayList<GetSingleLessonCondtion.Data> leaveList = new ArrayList<>();

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

    private TextView totalNum;
    TeacherRealtimeTotalAttendanceAdapter adapter;
    {
        classifyData();
    }
    @Override
    public void change(GetSingleLessonCondtion.Data data,int i){
        switch(i){
            case 0:
                attendList.add(data);
                break;
            case 1:
                absencelist.add(data);
                break;
            case 2:
                lateattendList.add(data);
                break;
            case 3:
                earlyleaveList.add(data);
                break;
            case 4:
                leaveList.add(data);
                break;
                default:break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_realtime_total_attendance);

        Intent intent = getIntent();
        TextView title =(TextView)findViewById(R.id.title);
        title.setText(intent.getStringExtra("title"));


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        totalNum = (TextView)findViewById(R.id.total_num);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("出勤共").append(String.valueOf(attendList.size())).append("人");
        totalNum.setText(stringBuilder.toString());

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new TeacherRealtimeTotalAttendanceAdapter(attendList,0,this);
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
    private void classifyData(){
        for (GetSingleLessonCondtion.Data data:TeacherRealtimeClassroom.secondlessonData){
            switch(data.getSstate()){
                case 0:
                    attendList.add(data);
                    break;
                case 1:
                    absencelist.add(data);
                    break;
                case 2:
                    lateattendList.add(data);
                    break;
                case 3:
                    earlyleaveList.add(data);
                    break;
                case 4:
                    leaveList.add(data);
                    break;
                default:
                    break;
            }
        }
    }


    @Override
    public void onClick(View v) {
        StringBuilder stringBuilder;
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
                stringBuilder = new StringBuilder();
                stringBuilder.append("出勤共").append(String.valueOf(attendList.size())).append("人");
                totalNum.setText(stringBuilder.toString());
                adapter.updateData(attendList,0);
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
                stringBuilder= new StringBuilder();
                stringBuilder.append("缺勤共").append(String.valueOf(absencelist.size())).append("人");
                totalNum.setText(stringBuilder.toString());
                adapter.updateData(absencelist,1);
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
                stringBuilder= new StringBuilder();
                stringBuilder.append("迟到共").append(String.valueOf(lateattendList.size())).append("人");
                totalNum.setText(stringBuilder.toString());
                adapter.updateData(lateattendList,2);
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
                stringBuilder= new StringBuilder();
                stringBuilder.append("早退共").append(String.valueOf(earlyleaveList.size())).append("人");
                totalNum.setText(stringBuilder.toString());
                adapter.updateData(earlyleaveList,3);
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
                stringBuilder= new StringBuilder();
                stringBuilder.append("请假共").append(String.valueOf(leaveList.size())).append("人");
                totalNum.setText(stringBuilder.toString());
                adapter.updateData(leaveList,4);
                break;
                default:break;

        }
    }
}
