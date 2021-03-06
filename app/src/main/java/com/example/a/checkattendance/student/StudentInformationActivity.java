package com.example.a.checkattendance.student;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a.checkattendance.ActivityCollector;
import com.example.a.checkattendance.ActivityLogin;
import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;

import org.feezu.liuli.timeselector.TimeSelector;

    public class StudentInformationActivity extends BaseActivity implements View.OnClickListener{

        private TextView t_time;
        private TextView t_sex;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_student_information);


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


            Button b_exit=(Button)findViewById(R.id.exit);
            b_exit.setOnClickListener(this);

        }

        @Override
        public void onClick(View v){
            switch(v.getId()){

                case R.id.exit:
                    ActivityCollector.finishAll();
                    Intent intent = new Intent(this, ActivityLogin.class);
                    startActivity(intent);
                    break;

                default:
                    break;
            }
        }


        private void initData() {
            t_time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TimeSelector timeSelector = new TimeSelector(StudentInformationActivity.this, new TimeSelector.ResultHandler() {
                        @Override
                        public void handle(String time) {
                            //截取字符串长度，只需要年月日
                            String substring = time.substring(0,10);
                            t_time.setText(substring);
                        }

                    }, "1800-1-1 00:00", "2050-12-31 00:00");
                    timeSelector.setMode(TimeSelector.MODE.YMD);
                    //小时分钟不现实
                    timeSelector.disScrollUnit(TimeSelector.SCROLLTYPE.HOUR, TimeSelector.SCROLLTYPE.MINUTE);
                    //dialog的弹出

                    timeSelector.show();

                }
            });
        }

        private void init() {
            t_time = (TextView) findViewById(R.id.time);
        }

        private void ShowChoise() {

            AlertDialog.Builder builder = new AlertDialog.Builder(StudentInformationActivity.this, android.R.style.Theme_Holo_Light_Dialog);
            //builder.setIcon(R.drawable.ic_launcher);
            builder.setTitle("选择性别");
            //    指定下拉列表的显示数据
            final String[] cities = { "男", "女"};
            //    设置一个下拉的列表选择项
            builder.setItems(cities, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    t_sex.setText(cities[which]);
                }
            });
            builder.show();
        }

    }