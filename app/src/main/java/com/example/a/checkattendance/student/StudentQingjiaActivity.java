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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;

import org.feezu.liuli.timeselector.TimeSelector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

    public class StudentQingjiaActivity extends BaseActivity implements View.OnClickListener{
        String[] str = {"大学物理-华含", "体育-刚任强", "高数-苗丽丽", "英语-秦高"};


        public static final int TAKE_PHOTO=1;//声明一个请求码，用于识别返回的结果
        private ImageView picture;
        private Uri imageUri;

        private TextView t_time;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_student_qingjia);

            LinearLayout takephoto=(LinearLayout) findViewById(R.id.take_photo);
            picture=findViewById(R.id.picture);
            takephoto.setOnClickListener(this);

            Button button_back=(Button) findViewById(R.id.back);
            button_back.setOnClickListener(this);
            Button button_shenqing=(Button) findViewById(R.id.shenqing);
            button_shenqing.setOnClickListener(this);

            Spinner spinner = (Spinner) findViewById(R.id.couse_choice);
            ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this,
                    R.layout.support_simple_spinner_dropdown_item, str);
            spinner.setAdapter(arrayAdapter);


            init();
            initData();

        }

        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.back:
                    finish();
                    break;
                case R.id.take_photo:
                    File outputImage=new File(getExternalCacheDir(),"output_image.jpg");
                /*
                创建一个File文件对象，用于存放摄像头拍下的图片，我们把这个图片命名为output_image.jpg
                并把它存放在应用关联缓存目录下，调用getExternalCacheDir()可以得到这个目录，为什么要
                用关联缓存目录呢？由于android6.0开始，读写sd卡列为了危险权限，使用的时候必须要有权限，
                应用关联目录则可以跳过这一步
                 */
                    try//判断图片是否存在，存在则删除在创建，不存在则直接创建
                    {
                        if(outputImage.exists())
                        {
                            outputImage.delete();
                        }
                        outputImage.createNewFile();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    if(Build.VERSION.SDK_INT>=24)
                        //判断安卓的版本是否高于7.0，高于则调用高于的方法，低于则调用低于的方法
                        //把文件转换成Uri对象
                    /*
                    之所以这样，是因为android7.0以后直接使用本地真实路径是不安全的，会抛出异常。
                    FileProvider是一种特殊的内容提供器，可以对数据进行保护
                     */
                    {
                        imageUri= FileProvider.getUriForFile(StudentQingjiaActivity.this,
                                "com.example.gdzc.cameralbumtest.fileprovider",outputImage);
                    /*
                    第一个参数：context对象
                    第二个参数：任意唯一的字符串
                    第三个参数：文件对象
                     */

                    }
                    else {
                        imageUri=Uri.fromFile(outputImage);
                    }
                    //使用隐示的Intent，系统会找到与它对应的活动，即调用摄像头，并把它存储
                    Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                    startActivityForResult(intent,TAKE_PHOTO);
                    //调用会返回结果的开启方式，返回成功的话，则把它显示出来
                    break;
                case R.id.shenqing:
                    finish();
                    Toast.makeText(StudentQingjiaActivity.this,"完成",Toast.LENGTH_SHORT).show();
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
        private void initData() {
            t_time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TimeSelector timeSelector = new TimeSelector(StudentQingjiaActivity.this, new TimeSelector.ResultHandler() {
                        @Override
                        public void handle(String time) {
                            //截取字符串长度，只需要年月日
                            String substring = time.substring(0,10);
                            t_time.setText(substring);
                        }

                    }, "2019-1-1 00:00", "2050-12-31 00:00");
                    timeSelector.setMode(TimeSelector.MODE.YMD);
                    //小时分钟不现实
                    timeSelector.disScrollUnit(TimeSelector.SCROLLTYPE.HOUR, TimeSelector.SCROLLTYPE.MINUTE);
                    //dialog的弹出

                    timeSelector.show();

                }
            });
        }

        private void init() {
            t_time = (TextView) findViewById(R.id.time);
        }
    }
