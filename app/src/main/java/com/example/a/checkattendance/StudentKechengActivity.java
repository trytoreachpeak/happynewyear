package com.example.a.checkattendance;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        }

        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.back:
                    finish();
                    break;
                case R.id.ziliao:
                    replaceFragment(new StudentZiliaoFragment());
                    break;
                case R.id.zuoye:
                    replaceFragment(new StudentZuoyeFragment());
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
