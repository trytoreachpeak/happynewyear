package com.example.a.checkattendance.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.student.StudentMobanActivity;
import com.example.a.checkattendance.student.Ziliao;
import com.example.a.checkattendance.student.ZiliaoAdapter;

import java.util.ArrayList;
import java.util.List;

    public class StudentZiliaoFragment extends Fragment {
        private List<Ziliao> ziliaoList=new ArrayList<>();
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.student_ziliao_fragment, container, false);

            initclasses();
            ZiliaoAdapter adapter=new ZiliaoAdapter(getActivity(),R.layout.ziliao_item,ziliaoList);
            ListView listview =(ListView) view.findViewById(R.id.list_ziliao);
            listview.setAdapter(adapter);
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Ziliao ziliao=ziliaoList.get(position);
                    Intent intent=new Intent(getActivity(),StudentMobanActivity.class);
                    startActivity(intent);
                }
            });
            return view;
        }

        private void initclasses(){
            for (int i=0;i<1;i++) {
                Ziliao shuxue=new Ziliao ("第一章测试",R.mipmap.student_kecheng);
                ziliaoList.add(shuxue);
                Ziliao yingyu=new Ziliao ("第二章测试",R.mipmap.student_kecheng);
                ziliaoList.add(yingyu);
                Ziliao three=new Ziliao ("第三章测试",R.mipmap.student_kecheng);
                ziliaoList.add(three);
                Ziliao four=new Ziliao ("第四章测试",R.mipmap.student_kecheng);
                ziliaoList.add(four);
            }
        }
    }