package com.example.a.checkattendance.student;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.os.Bundle;
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
            Button takephoto=(Button) findViewById(R.id.take_photo);
            picture=findViewById(R.id.picture);
            takephoto.setOnClickListener(this);

            Button button_back=(Button) findViewById(R.id.back);
            button_back.setOnClickListener(this);
            Button button_confirm=(Button) findViewById(R.id.confirm);
            button_confirm.setOnClickListener(this);
        }


        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.back:
                    finish();
                    break;
                case R.id.confirm:
                    finish();
                    Toast.makeText(StudentShenfenActivity.this,"完成",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.take_photo:
                    File outputImage=new File(getExternalCacheDir(),"output_image.jpg");
                    try{ //判断图片是否存在，存在则删除在创建，不存在则直接创建
                        if(outputImage.exists()) {
                            outputImage.delete();
                        }
                        outputImage.createNewFile();
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                    if(Build.VERSION.SDK_INT>=24) {
                        imageUri= FileProvider.getUriForFile(StudentShenfenActivity.this,
                                "com.example.gdzc.cameralbumtest.fileprovider",outputImage);
                    }
                    else {
                        imageUri=Uri.fromFile(outputImage);
                    }
                    Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                    startActivityForResult(intent,TAKE_PHOTO);
                    //调用会返回结果的开启方式，返回成功的话，则把它显示出来
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