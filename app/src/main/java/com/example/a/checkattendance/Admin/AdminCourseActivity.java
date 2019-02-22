package com.example.a.checkattendance.Admin;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;
import com.example.a.checkattendance.student.StudentZiliaoFragment;
import com.example.a.checkattendance.student.StudentZuoyeFragment;

public class AdminCourseActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_course);

        replaceFragment(new AdminCourseFragment());

        Button button_back=(Button) findViewById(R.id.back) ;
        button_back.setOnClickListener(this);

        TextView textView_course=(TextView) findViewById(R.id.course) ;
        textView_course.setOnClickListener(this);

        TextView textView_teacher=(TextView) findViewById(R.id.teacher) ;
        textView_teacher.setOnClickListener(this);

        textView_course.setTextColor(getResources().getColor(R.color.colorPrimary));
        textView_teacher.setTextColor(getResources().getColor(R.color.huiSe));



    }

    @Override
    public void onClick(View v){
        TextView textView_course=(TextView) findViewById(R.id.course) ;
        TextView textView_teacher=(TextView) findViewById(R.id.teacher) ;
        switch(v.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.teacher:
                replaceFragment(new AdminTeacherFragment());
                textView_teacher.setTextColor(getResources().getColor(R.color.colorPrimary));
                textView_course.setTextColor(getResources().getColor(R.color.huiSe));
                break;
            case R.id.course:
                replaceFragment(new AdminCourseFragment());
                textView_course.setTextColor(getResources().getColor(R.color.colorPrimary));
                textView_teacher.setTextColor(getResources().getColor(R.color.huiSe));
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
