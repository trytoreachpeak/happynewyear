package com.example.a.checkattendance.teacher;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.student.StudentChatFragment;

public class HomepageOfTeacher extends AppCompatActivity implements View.OnClickListener {
    private  Fragment  currentFragment = new Fragment();
    private FirstFragment firstFragment = new FirstFragment();
    private StudentChatFragment secondFragment = new StudentChatFragment();
    private ThirdFragment thirdFragment = new ThirdFragment();
    private ForthFragment forthFragment = new ForthFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage_of_teacher);
        //Toolbar toolbar_teacher_main = (Toolbar) findViewById(R.id.toolbar_homepage);
        //setSupportActionBar(toolbar_teacher_main);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);
        //toolbar_teacher_main.setTitle("");
        //toolbar_teacher_main.setVisibility(View.GONE);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.lay_fragment, firstFragment);
        ft.add(R.id.lay_fragment, secondFragment);
        ft.add(R.id.lay_fragment, thirdFragment);
        ft.add(R.id.lay_fragment, forthFragment);
        ft.hide(secondFragment);
        ft.hide(thirdFragment);
        ft.hide(forthFragment);
        ft.commit();


        ImageView firstguideImage = (ImageView) findViewById(R.id.firstguide_img);
        TextView firstguideTxt = (TextView) findViewById(R.id.firstguide_txt);
        firstguideImage.setImageResource(R.mipmap.firstguide_light);
        firstguideTxt.setTextColor(getResources().getColor(R.color.colorPrimary));

        LinearLayout firstguide = (LinearLayout)findViewById(R.id.firstguide);
        LinearLayout secondguide = (LinearLayout)findViewById(R.id.secondguide);
        LinearLayout thirdguide = (LinearLayout)findViewById(R.id.thirdguide);
        LinearLayout forthguide = (LinearLayout)findViewById(R.id.forthguide);
        firstguide.setOnClickListener(this);
        secondguide.setOnClickListener(this);
        thirdguide.setOnClickListener(this);
        forthguide.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        ImageView firstguideImage = (ImageView) findViewById(R.id.firstguide_img);
        ImageView secondguideImage = (ImageView) findViewById(R.id.secondguide_img);
        ImageView thirdguideImage = (ImageView) findViewById(R.id.thirdguide_img);
        ImageView forthguideImage = (ImageView) findViewById(R.id.forthguide_img);

        TextView firstguideTxt = (TextView) findViewById(R.id.firstguide_txt);
        TextView secondguideTxt = (TextView) findViewById(R.id.secondguide_txt);
        TextView thirdTxt = (TextView) findViewById(R.id.thirdguide_txt);
        TextView forthTxt = (TextView) findViewById(R.id.forthguide_txt);
        //Toolbar toolbar_teacher_main=view.findViewById(R.id.toolbar_homepage);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        switch (view.getId()){
            case R.id.firstguide://点击“联系人”触发的监听事件
                //---------------------------联系人处高亮，其他灰色---------------------------------
                firstguideImage.setImageResource(R.mipmap.firstguide_light);
                secondguideImage.setImageResource(R.mipmap.chat_icon_dark);
                thirdguideImage.setImageResource(R.mipmap.thirdguide_dark);
                forthguideImage.setImageResource(R.mipmap.forthguide_dark);
                firstguideTxt.setTextColor(getResources().getColor(R.color.colorPrimary));
                secondguideTxt.setTextColor(getResources().getColor(R.color.huiSe));
                thirdTxt.setTextColor(getResources().getColor(R.color.huiSe));
                forthTxt.setTextColor(getResources().getColor(R.color.huiSe));
                //----------------------------------------------------------------------------------
                //---------------------------添加联系人Fragment-------------------------------------

                ft.show(firstFragment)
                        .hide(secondFragment)
                        .hide(thirdFragment)
                        .hide(forthFragment)
                        .commit();
                //getSupportActionBar().show();
                //----------------------------------------------------------------------------------
                break;
            case R.id.secondguide://点击“联系人”触发的监听事件
                //---------------------------联系人处高亮，其他灰色---------------------------------
                firstguideImage.setImageResource(R.mipmap.firstguide_dark);
                secondguideImage.setImageResource(R.mipmap.chat_icon_light);
                thirdguideImage.setImageResource(R.mipmap.thirdguide_dark);
                forthguideImage.setImageResource(R.mipmap.forthguide_dark);
                firstguideTxt.setTextColor(getResources().getColor(R.color.huiSe));
                secondguideTxt.setTextColor(getResources().getColor(R.color.colorPrimary));
                thirdTxt.setTextColor(getResources().getColor(R.color.huiSe));
                forthTxt.setTextColor(getResources().getColor(R.color.huiSe));
                //----------------------------------------------------------------------------------
                //---------------------------添加联系人Fragment-------------------------------------

                ft.show(secondFragment)
                        .hide(firstFragment)
                        .hide(thirdFragment)
                        .hide(forthFragment)
                        .commit();
                //getSupportActionBar().show();
                //----------------------------------------------------------------------------------
                break;
            case R.id.thirdguide://点击“知识”触发的监听事件
                //---------------------------知识处高亮，其他灰色-----------------------------------
                firstguideImage.setImageResource(R.mipmap.firstguide_dark);
                secondguideImage.setImageResource(R.mipmap.chat_icon_dark);
                thirdguideImage.setImageResource(R.mipmap.thirdguide_light);
                forthguideImage.setImageResource(R.mipmap.forthguide_dark);
                firstguideTxt.setTextColor(getResources().getColor(R.color.huiSe));
                secondguideTxt.setTextColor(getResources().getColor(R.color.huiSe));
                thirdTxt.setTextColor(getResources().getColor(R.color.colorPrimary));
                forthTxt.setTextColor(getResources().getColor(R.color.huiSe));
                //----------------------------------------------------------------------------------
                //---------------------------添加知识Fragment---------------------------------------
                //getSupportActionBar().show();
                ft.show(thirdFragment)
                        .hide(secondFragment)
                        .hide(firstFragment)
                        .hide(forthFragment)
                        .commit();

                //----------------------------------------------------------------------------------
                break;
            case R.id.forthguide://点击“我的”触发的监听事件
                //---------------------------我的处高亮，其他灰色-----------------------------------
                firstguideImage.setImageResource(R.mipmap.firstguide_dark);
                secondguideImage.setImageResource(R.mipmap.chat_icon_dark);
                thirdguideImage.setImageResource(R.mipmap.thirdguide_dark);
                forthguideImage.setImageResource(R.mipmap.forthguide_light);
                firstguideTxt.setTextColor(getResources().getColor(R.color.huiSe));
                secondguideTxt.setTextColor(getResources().getColor(R.color.huiSe));
                thirdTxt.setTextColor(getResources().getColor(R.color.huiSe));
                forthTxt.setTextColor(getResources().getColor(R.color.colorPrimary));
                //----------------------------------------------------------------------------------
                //getSupportActionBar().hide();
                ft.show(forthFragment)
                        .hide(secondFragment)
                        .hide(thirdFragment)
                        .hide(firstFragment)
                        .commit();


                break;
            default:break;
        }
    }
}
