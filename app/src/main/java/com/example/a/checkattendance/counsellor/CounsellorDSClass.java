package com.example.a.checkattendance.counsellor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a.checkattendance.HttpUtil;
import com.example.a.checkattendance.R;
import com.example.a.checkattendance.gsonitem.GetSingleLessonCondtion;
import com.example.a.checkattendance.gsonitem.StudentGetSubjectCondition;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.feezu.liuli.timeselector.TimeSelector;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public class CounsellorDSClass extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout detail;
    private TextView startTime;
    private TextView endTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counsellor_ds_class);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_first_fragment);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        detail = (LinearLayout)findViewById(R.id.detail_button);
        startTime=(TextView)findViewById(R.id.start_time);
        endTime = (TextView)findViewById(R.id.end_time);
        detail.setOnClickListener(this);
        startTime.setOnClickListener(this);
        endTime.setOnClickListener(this);

        init1();
        init2();
        initData1();
        initData2();

        Button button = (Button)findViewById(R.id.test_1);
        button.setOnClickListener(this);

    }
    private void initData1() {
        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeSelector timeSelector = new TimeSelector(CounsellorDSClass.this, new TimeSelector.ResultHandler() {
                    @Override
                    public void handle(String time) {
                        //截取字符串长度，只需要年月日
                        String substring = time.substring(0,10);
                        startTime.setText(substring);
                    }

                }, "2019-1-1 00:00", "2050-12-31 00:00");
                timeSelector.setMode(TimeSelector.MODE.YMD);
                //小时分钟不现实
                timeSelector.disScrollUnit(TimeSelector.SCROLLTYPE.HOUR, TimeSelector.SCROLLTYPE.MINUTE);
                //dialog的弹出

                timeSelector.show();

            }
        });
    }

    private void init1() {
        startTime = (TextView) findViewById(R.id.start_time);
    }
    private void initData2() {
        endTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeSelector timeSelector = new TimeSelector(CounsellorDSClass.this, new TimeSelector.ResultHandler() {
                    @Override
                    public void handle(String time) {
                        //截取字符串长度，只需要年月日
                        String substring = time.substring(0,10);
                        endTime.setText(substring);
                    }

                }, "2019-1-1 00:00", "2050-12-31 00:00");
                timeSelector.setMode(TimeSelector.MODE.YMD);
                //小时分钟不现实
                timeSelector.disScrollUnit(TimeSelector.SCROLLTYPE.HOUR, TimeSelector.SCROLLTYPE.MINUTE);
                //dialog的弹出

                timeSelector.show();

            }
        });
    }

    private void init2() {
        endTime = (TextView) findViewById(R.id.end_time);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.start_time:
                finish();
                Toast.makeText(CounsellorDSClass.this, "完成", Toast.LENGTH_SHORT).show();
                break;
            case R.id.end_time:
                finish();
                Toast.makeText(CounsellorDSClass.this, "完成", Toast.LENGTH_SHORT).show();
                break;
            case R.id.test_1:
                String temp = startTime.getText().toString();
                HttpUtil.sendLoginRequest(
                        "http://192.168.1.111:5000/api/v1/students/getsign/",
                        //"http://10.0.2.2/test.json",
                        HttpUtil.createStudentSubjectConditionJson("1613022047","123"),
                        new okhttp3.Callback(){
                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                Gson gson = new Gson();
                                java.lang.reflect.Type type = new TypeToken<StudentGetSubjectCondition>() {
                                }.getType();
                                StudentGetSubjectCondition getSubjectCondition= gson.fromJson(response.body().string(), type);
                                Log.d("testabc",getSubjectCondition.getStatus()+"");
                                Log.d("testabc",getSubjectCondition.getData().size()+"");
                                Log.d("testabc",getSubjectCondition.getData().get(0).getStudentid());
                                Log.d("testabc",getSubjectCondition.getData().get(0).getStudentname());
                                Log.d("testabc",getSubjectCondition.getData().get(0).getSignintime());
                            }
                            @Override
                            public void onFailure(Call call, IOException e) {
                                Log.d("testabc","connect fail");
                            }
                        }
                );
            default:
                break;
        }
    }
}
