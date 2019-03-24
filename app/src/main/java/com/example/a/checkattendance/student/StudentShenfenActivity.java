package com.example.a.checkattendance.student;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

    public class StudentShenfenActivity extends BaseActivity implements View.OnClickListener{

        public static final int TAKE_PHOTO=1;//声明一个请求码，用于识别返回的结果
        private ImageView picture;
        private Uri imageUri;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_student_shenfen);
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

            Button button_confirm=(Button) findViewById(R.id.confirm);
            button_confirm.setOnClickListener(this);
        }


        @Override
        public void onClick(View v){
            switch(v.getId()){

                case R.id.confirm:
                    finish();
                    Toast.makeText(StudentShenfenActivity.this,"完成",Toast.LENGTH_SHORT).show();
                    break;

                default:
                    break;
            }
        }

        @Override
        protected void onActivityResult(int requestCode,int resultCode,Intent data)
        {
            switch (requestCode)
            {
                case TAKE_PHOTO:
                    if(resultCode==RESULT_OK)
                    {
                        try{
                            Bitmap bitmap= BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                            picture.setImageBitmap(bitmap);
                        }catch (FileNotFoundException e)
                        {
                            e.printStackTrace();
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }