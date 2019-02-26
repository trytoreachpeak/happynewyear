package com.example.a.checkattendance.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;

import org.feezu.liuli.timeselector.TimeSelector;

public class AdminPersonalStatisticsActivity extends BaseActivity implements View.OnClickListener{
    private TextView t_time1;
    private TextView t_time2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_personal_statistics);

        TextView t_name=(TextView) findViewById(R.id.person_name) ;
        Button button_back=(Button)findViewById(R.id.back);
        button_back.setOnClickListener(this);



        Intent intent = getIntent();
        String showdata = intent.getStringExtra("extra_data");
        t_name.setText(showdata);

        init();
        initData(t_time1);
        initData(t_time2);
    }
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.back:
                finish();
                break;
            default:
                break;
        }
    }

    private void initData(final TextView t_time) {
        t_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeSelector timeSelector = new TimeSelector(AdminPersonalStatisticsActivity.this, new TimeSelector.ResultHandler() {
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
        t_time1 = (TextView) findViewById(R.id.time1);
        t_time2 = (TextView) findViewById(R.id.time2);
    }
}
