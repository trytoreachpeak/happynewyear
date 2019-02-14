package com.example.a.checkattendance.student;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.student.BaseActivity;

public class StudentHomepageActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_homepage);

        LinearLayout button_wode=(LinearLayout) findViewById(R.id.wode);
        button_wode.setOnClickListener(this);
        LinearLayout button_zhuye=(LinearLayout) findViewById(R.id.zhuye);
        button_zhuye.setOnClickListener(this);
        LinearLayout button_xuexi=(LinearLayout) findViewById(R.id.xuexi);
        button_xuexi.setOnClickListener(this);

        replaceFragment(new StudentZhuyeFragment());


    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.wode:
                replaceFragment(new StudentWodeFragment());
                break;
            case R.id.zhuye:
                replaceFragment(new StudentZhuyeFragment());
                break;
            case R.id.xuexi:
                replaceFragment(new StudentXuexiFragment());
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