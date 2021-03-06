package com.example.a.checkattendance.Admin;

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

import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;
import com.example.a.checkattendance.counsellor.CounsellorFirstFragment;
import com.example.a.checkattendance.counsellor.CounsellorSecondFragment;
import com.example.a.checkattendance.counsellor.CounsellorThirdFragment;

public class AdminHomepage extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_homepage);

        replaceFragment(new AdminZhuyeFragment());

        ImageView firstguideImage = (ImageView) findViewById(R.id.firstguide_img);
        TextView firstguideTxt = (TextView) findViewById(R.id.firstguide_txt);
        firstguideImage.setImageResource(R.mipmap.firstguide_light);
        firstguideTxt.setTextColor(getResources().getColor(R.color.colorPrimary));

        LinearLayout firstguide = (LinearLayout)findViewById(R.id.firstguide);
        LinearLayout secondguide = (LinearLayout)findViewById(R.id.secondguide);
        LinearLayout thirdguide = (LinearLayout)findViewById(R.id.thirdguide);
        firstguide.setOnClickListener(this);
        secondguide.setOnClickListener(this);
        thirdguide.setOnClickListener(this);

    }
    //@Override
    //public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.toolbar,menu);
        //return true;
    //}
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.lay_fragment,fragment);
        transaction.commit();
    }
    @Override
    public void onClick(View view) {
        ImageView firstguideImage = (ImageView) findViewById(R.id.firstguide_img);
        ImageView secondguideImage = (ImageView) findViewById(R.id.secondguide_img);
        ImageView thirdguideImage = (ImageView) findViewById(R.id.thirdguide_img);
        //ImageView forthguideImage = (ImageView) findViewById(R.id.forthguide_img);

        TextView firstguideTxt = (TextView) findViewById(R.id.firstguide_txt);
        TextView secondguideTxt = (TextView) findViewById(R.id.secondguide_txt);
        TextView thirdguideTxt = (TextView) findViewById(R.id.thirdguide_txt);
        //TextView forthTxt = (TextView) findViewById(R.id.forthguide_txt);
        //Toolbar toolbar=view.findViewById(R.id.toolbar_homepage);
        switch (view.getId()){
            case R.id.firstguide://点击“联系人”触发的监听事件
                //---------------------------联系人处高亮，其他灰色---------------------------------
                firstguideImage.setImageResource(R.mipmap.firstguide_light);
                secondguideImage.setImageResource(R.mipmap.chat_icon_dark);
                thirdguideImage.setImageResource(R.mipmap.forthguide_dark);
                //forthguideImage.setImageResource(R.mipmap.forthguide_dark);
                firstguideTxt.setTextColor(getResources().getColor(R.color.colorPrimary));
                secondguideTxt.setTextColor(getResources().getColor(R.color.huiSe));
                thirdguideTxt.setTextColor(getResources().getColor(R.color.huiSe));
                //forthTxt.setTextColor(getResources().getColor(R.color.huiSe));
                //----------------------------------------------------------------------------------
                //---------------------------添加联系人Fragment-------------------------------------
                replaceFragment(new AdminZhuyeFragment());
                //getSupportActionBar().show();
                //----------------------------------------------------------------------------------
                break;
            case R.id.secondguide://点击“知识”触发的监听事件
                //---------------------------知识处高亮，其他灰色-----------------------------------
                firstguideImage.setImageResource(R.mipmap.firstguide_dark);
                secondguideImage.setImageResource(R.mipmap.chat_icon_light);
                thirdguideImage.setImageResource(R.mipmap.forthguide_dark);
                //forthguideImage.setImageResource(R.mipmap.forthguide_dark);
                firstguideTxt.setTextColor(getResources().getColor(R.color.huiSe));
                secondguideTxt.setTextColor(getResources().getColor(R.color.colorPrimary));
                thirdguideTxt.setTextColor(getResources().getColor(R.color.huiSe));
                //forthTxt.setTextColor(getResources().getColor(R.color.huiSe));
                //----------------------------------------------------------------------------------
                //---------------------------添加知识Fragment---------------------------------------
                //getSupportActionBar().show();
                replaceFragment(new AdminChatFragment());

                //----------------------------------------------------------------------------------
                break;
            case R.id.thirdguide://点击“我的”触发的监听事件
                //---------------------------我的处高亮，其他灰色-----------------------------------
                firstguideImage.setImageResource(R.mipmap.firstguide_dark);
                secondguideImage.setImageResource(R.mipmap.chat_icon_dark);
                thirdguideImage.setImageResource(R.mipmap.forthguide_light);
                //forthguideImage.setImageResource(R.mipmap.forthguide_light);
                firstguideTxt.setTextColor(getResources().getColor(R.color.huiSe));
                secondguideTxt.setTextColor(getResources().getColor(R.color.huiSe));
                thirdguideTxt.setTextColor(getResources().getColor(R.color.colorPrimary));
                //forthTxt.setTextColor(getResources().getColor(R.color.colorPrimary));
                //----------------------------------------------------------------------------------
                //getSupportActionBar().hide();
                replaceFragment(new AdminWodeFragment());
                break;
            default:break;
        }
    }
}