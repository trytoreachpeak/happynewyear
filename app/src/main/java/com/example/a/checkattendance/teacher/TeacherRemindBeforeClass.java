package com.example.a.checkattendance.teacher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a.checkattendance.R;
import com.hh.timeselector.timeutil.datedialog.DateListener;
import com.hh.timeselector.timeutil.datedialog.TimeConfig;
import com.hh.timeselector.timeutil.datedialog.TimeSelectorDialog;

public class TeacherRemindBeforeClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_remind_before_class);
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

        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.set_time);
        final TextView textView = (TextView)findViewById(R.id.time_text);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeSelectorDialog dialog = new TimeSelectorDialog(TeacherRemindBeforeClass.this);
                //设置标题
                dialog.setTimeTitle("选择时间:");
                //显示类型
                dialog.setIsShowtype(TimeConfig.HOUR_MINUTE);
                //默认时间
                dialog.setCurrentDate("07:30");
                //隐藏清除按钮
                dialog.setEmptyIsShow(false);
                //设置起始时间
                dialog.setStartYear(1888);
                dialog.setDateListener(new DateListener() {
                    @Override
                    public void onReturnDate(String time,int year, int month, int day, int hour, int minute, int isShowType) {
                        textView.setText(time);
                    }
                    @Override
                    public void onReturnDate(String empty) {
                        textView.setText(empty);
                    }
                });
                dialog.show();
            }
        });
    }
}
