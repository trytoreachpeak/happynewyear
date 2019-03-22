package com.example.a.checkattendance.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.bannerFunc.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class StudentZhuyeFragment extends Fragment implements View.OnClickListener{
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.student_zhuye_fragment, container, false);


            LinearLayout button_qingjia=(LinearLayout) view.findViewById(R.id.qingjia);
            button_qingjia.setOnClickListener(this);
            LinearLayout b_analysis=(LinearLayout) view.findViewById(R.id.analysis);
            b_analysis.setOnClickListener(this);
            CardView l_now_class=(CardView)  view.findViewById(R.id.now_class);
            l_now_class.setOnClickListener(this);

            List<Integer> images= new ArrayList<>();
            images.add(R.drawable.banner_img_1);
            images.add(R.drawable.banner_img_2);
            images.add(R.drawable.banner_img_3);
            Banner banner = (Banner) view.findViewById(R.id.banner);
            //设置图片加载器
            banner.setImageLoader(new GlideImageLoader());
            //设置图片集合
            banner.setImages(images);
            //banner设置方法全部调用完毕时最后调用
            banner.setDelayTime(3000);
            banner.start();

            //增加点击事件
            banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Toast.makeText(getActivity(), "position"+position, Toast.LENGTH_SHORT).show();
                }
            });

            CardView classNow = (CardView)view.findViewById(R.id.now_class);
            //classNow.setVisibility(View.GONE);

            return view;
        }
        @Override
        public void onClick(View v){
            switch (v.getId()){
                case R.id.qingjia:
                    Intent intent1= new Intent(getActivity(),StudentQingjiaActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.analysis:
                    Intent intent2= new Intent(getActivity(),StudentAnalysisActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.now_class:
                    Intent intent3= new Intent(getActivity(),StudentAnalysisActivity.class);
                    startActivity(intent3);
                    break;
                default:
                    break;
            }
        }
    }