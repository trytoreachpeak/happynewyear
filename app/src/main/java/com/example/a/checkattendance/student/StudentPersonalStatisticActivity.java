package com.example.a.checkattendance.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;
import com.example.a.checkattendance.teacher.TeacherExtendableListViewAdapter;
import com.example.a.checkattendance.teacher.TeacherRealtimeClassroom;
import com.example.a.checkattendance.teacher.TeacherRealtimeTotalAttendance;

public class StudentPersonalStatisticActivity extends BaseActivity implements View.OnClickListener{

    String[] str = {"第1节课", "第2节课","汇总"};
    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_personal_statistic);

        TextView t_halfheartedness=(TextView)findViewById(R.id.halfheartedness);
        TextView t_earnest=(TextView)findViewById(R.id.earnest);
        TextView t_sleep=(TextView)findViewById(R.id.sleep);


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

        TextView t_classname=(TextView)findViewById(R.id.classname);
        Intent intent = getIntent();
        String showdata = intent.getStringExtra("extra_data");
        t_classname.setText(showdata);
        ImageView i_chart=(ImageView)findViewById(R.id.chart);
        i_chart.setOnClickListener(this);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setDropDownHorizontalOffset(100); //下拉的横向偏移
        spinner.setDropDownVerticalOffset(50);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.drop_item, str);
        spinner.setAdapter(arrayAdapter);
        //spinner添加数据
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView t_halfheartedness=(TextView)findViewById(R.id.halfheartedness);
                TextView t_earnest=(TextView)findViewById(R.id.earnest);
                TextView t_sleep=(TextView)findViewById(R.id.sleep);
                String selected = parent.getItemAtPosition(position).toString();
                switch (position){
                    case 0:
                        t_earnest.setText("10次");
                        t_halfheartedness.setText("8次");
                        t_sleep.setText("6次");
                        break;
                    case 1:
                        t_earnest.setText("13次");
                        t_halfheartedness.setText("9次");
                        t_sleep.setText("2次");
                        break;
                    case 2:
                        t_earnest.setText("23次");
                        t_halfheartedness.setText("17次");
                        t_sleep.setText("8次");
                        break;
                    default:
                        break;
                }

    }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.chart:
                Intent intent = new Intent(StudentPersonalStatisticActivity.this, StudentChartActivity.class);
                startActivity(intent);
           default:
               break;
        }
    }
}