package com.example.a.checkattendance;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomepageOfTeacher extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage_of_teacher);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_homepage);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);
        //toolbar.setTitle("");
        //toolbar.setVisibility(View.GONE);

       replaceFragment(new FirstFragment());

        ImageView firstguideImage = (ImageView) findViewById(R.id.firstguide_img);
        TextView firstguideTxt = (TextView) findViewById(R.id.firstguide_txt);
        firstguideImage.setImageResource(R.mipmap.firstguide_light);
        firstguideTxt.setTextColor(getResources().getColor(R.color.colorPrimary));

        LinearLayout firstguide = (LinearLayout)findViewById(R.id.firstguide);
        //LinearLayout secondguide = (LinearLayout)findViewById(R.id.secondguide);
        LinearLayout thirdguide = (LinearLayout)findViewById(R.id.thirdguide);
        LinearLayout forthguide = (LinearLayout)findViewById(R.id.forthguide);
        firstguide.setOnClickListener(this);
        //secondguide.setOnClickListener(this);
        thirdguide.setOnClickListener(this);
        forthguide.setOnClickListener(this);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.lay_fragment,fragment);
        transaction.commit();
    }
    @Override
    public void onClick(View view) {
        ImageView firstguideImage = (ImageView) findViewById(R.id.firstguide_img);
        //ImageView secondguideImage = (ImageView) findViewById(R.id.secondguide_img);
        ImageView thirdguideImage = (ImageView) findViewById(R.id.thirdguide_img);
        ImageView forthguideImage = (ImageView) findViewById(R.id.forthguide_img);

        TextView firstguideTxt = (TextView) findViewById(R.id.firstguide_txt);
        //TextView secondguideTxt = (TextView) findViewById(R.id.secondguide_txt);
        TextView thirdTxt = (TextView) findViewById(R.id.thirdguide_txt);
        TextView forthTxt = (TextView) findViewById(R.id.forthguide_txt);
        //Toolbar toolbar=view.findViewById(R.id.toolbar_homepage);
        switch (view.getId()){
            case R.id.firstguide://点击“联系人”触发的监听事件
                //---------------------------联系人处高亮，其他灰色---------------------------------
                firstguideImage.setImageResource(R.mipmap.firstguide_light);
                //secondguideImage.setImageResource(R.mipmap.secondguide_dark);
                thirdguideImage.setImageResource(R.mipmap.thirdguide_dark);
                forthguideImage.setImageResource(R.mipmap.forthguide_dark);
                firstguideTxt.setTextColor(getResources().getColor(R.color.colorPrimary));
                //secondguideTxt.setTextColor(getResources().getColor(R.color.huiSe));
                thirdTxt.setTextColor(getResources().getColor(R.color.huiSe));
                forthTxt.setTextColor(getResources().getColor(R.color.huiSe));
                //----------------------------------------------------------------------------------
                //---------------------------添加联系人Fragment-------------------------------------
                replaceFragment(new FirstFragment());
                //getSupportActionBar().show();
                //----------------------------------------------------------------------------------
                break;
            /*case R.id.secondguide://点击“生活”触发的监听事件
                //---------------------------生活处高亮，其他灰色-----------------------------------
                firstguideImage.setImageResource(R.mipmap.firstguide_dark);
                secondguideImage.setImageResource(R.mipmap.secondguide_light);
                thirdguideImage.setImageResource(R.mipmap.thirdguide_dark);
                forthguideImage.setImageResource(R.mipmap.forthguide_dark);
                firstguideTxt.setTextColor(getResources().getColor(R.color.huiSe));
                secondguideTxt.setTextColor(getResources().getColor(R.color.colorPrimary));
                thirdTxt.setTextColor(getResources().getColor(R.color.huiSe));
                forthTxt.setTextColor(getResources().getColor(R.color.huiSe));
                //----------------------------------------------------------------------------------
                //---------------------------添加美食Fragment---------------------------------------
                SecondFragment secondFragment= new SecondFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.lay_fragment,secondFragment);
                transaction.commit();
                //----------------------------------------------------------------------------------
                break;*/
            case R.id.thirdguide://点击“知识”触发的监听事件
                //---------------------------知识处高亮，其他灰色-----------------------------------
                firstguideImage.setImageResource(R.mipmap.firstguide_dark);
                //secondguideImage.setImageResource(R.mipmap.secondguide_dark);
                thirdguideImage.setImageResource(R.mipmap.thirdguide_light);
                forthguideImage.setImageResource(R.mipmap.forthguide_dark);
                firstguideTxt.setTextColor(getResources().getColor(R.color.huiSe));
                //secondguideTxt.setTextColor(getResources().getColor(R.color.huiSe));
                thirdTxt.setTextColor(getResources().getColor(R.color.colorPrimary));
                forthTxt.setTextColor(getResources().getColor(R.color.huiSe));
                //----------------------------------------------------------------------------------
                //---------------------------添加知识Fragment---------------------------------------
                //getSupportActionBar().show();
                replaceFragment(new ThirdFragment());

                //----------------------------------------------------------------------------------
                break;
            case R.id.forthguide://点击“我的”触发的监听事件
                //---------------------------我的处高亮，其他灰色-----------------------------------
                firstguideImage.setImageResource(R.mipmap.firstguide_dark);
                //secondguideImage.setImageResource(R.mipmap.secondguide_dark);
                thirdguideImage.setImageResource(R.mipmap.thirdguide_dark);
                forthguideImage.setImageResource(R.mipmap.forthguide_light);
                firstguideTxt.setTextColor(getResources().getColor(R.color.huiSe));
                //secondguideTxt.setTextColor(getResources().getColor(R.color.huiSe));
                thirdTxt.setTextColor(getResources().getColor(R.color.huiSe));
                forthTxt.setTextColor(getResources().getColor(R.color.colorPrimary));
                //----------------------------------------------------------------------------------
                //getSupportActionBar().hide();
                replaceFragment(new ForthFragment());


                break;
            default:break;
        }
    }
}
