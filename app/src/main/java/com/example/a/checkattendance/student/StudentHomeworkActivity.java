package com.example.a.checkattendance.student;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;

public class StudentHomeworkActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_homework);


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

        RelativeLayout r_firsttitle=(RelativeLayout)findViewById(R.id.first_title);
        r_firsttitle.setOnClickListener(this);
        LinearLayout l_first = (LinearLayout) findViewById(R.id.first_linearlayout);
        ImageView i_first = (ImageView) findViewById(R.id.first_change);

        Button b_confirm=(Button)findViewById(R.id.confirm);
        b_confirm.setOnClickListener(this);


    }
    @Override
    public void onClick(View v){
        LinearLayout l_first=(LinearLayout) findViewById(R.id.first_linearlayout);
        ImageView i_first=(ImageView)findViewById(R.id.first_change);

        switch(v.getId()){
            case R.id.first_title:
                if(l_first.getVisibility()==View.GONE) {
                    i_first.setImageResource(R.mipmap.shrink);
                    l_first.setVisibility(View.VISIBLE);
                }
                else{
                    i_first.setImageResource(R.mipmap.upflod);
                    l_first.setVisibility(View.GONE);
                }
                break;

            case R.id.confirm:
                finish();
            default:
                break;
        }
    }


}
