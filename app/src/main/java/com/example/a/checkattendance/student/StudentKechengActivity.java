package com.example.a.checkattendance.student;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.BaseActivity;

public class StudentKechengActivity extends BaseActivity implements View.OnClickListener{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_student_kecheng);

            Button button_back=(Button) findViewById(R.id.back) ;
            button_back.setOnClickListener(this);
            TextView textView_ziliao=(TextView) findViewById(R.id.ziliao) ;
            textView_ziliao.setOnClickListener(this);
            TextView textView_zuoye=(TextView) findViewById(R.id.zuoye) ;
            textView_zuoye.setOnClickListener(this);
            TextView textView_classname=(TextView) findViewById(R.id.classname);

            Intent intent = getIntent();
            String showdata = intent.getStringExtra("extra_data");
            textView_classname.setText(showdata);

            replaceFragment(new StudentZiliaoFragment());
            textView_ziliao.setTextColor(getResources().getColor(R.color.colorPrimary));
            textView_zuoye.setTextColor(getResources().getColor(R.color.huiSe));
        }

        @Override
        public void onClick(View v){
            TextView textView_ziliao=(TextView) findViewById(R.id.ziliao) ;
            TextView textView_zuoye=(TextView) findViewById(R.id.zuoye) ;
            switch(v.getId()){
                case R.id.back:
                    finish();
                    break;
                case R.id.ziliao:
                    replaceFragment(new StudentZiliaoFragment());
                    textView_ziliao.setTextColor(getResources().getColor(R.color.colorPrimary));
                    textView_zuoye.setTextColor(getResources().getColor(R.color.huiSe));
                    break;
                case R.id.zuoye:
                    replaceFragment(new StudentZuoyeFragment());
                    textView_zuoye.setTextColor(getResources().getColor(R.color.colorPrimary));
                    textView_ziliao.setTextColor(getResources().getColor(R.color.huiSe));
                    break;
                default:
                    break;
            }
        }

        private void replaceFragment(Fragment fragment){
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction transaction=fragmentManager.beginTransaction();
            transaction.replace(R.id.frameLayoutId,fragment);
            transaction.commit();
        }
    }
