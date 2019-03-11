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
import com.example.a.checkattendance.student.Class;
import com.example.a.checkattendance.student.ClassAdapter;
import com.example.a.checkattendance.student.StudentKechengActivity;

import java.util.ArrayList;
import java.util.List;

    public class StudentXuexiFragment extends Fragment {

        private List<Class> classList=new ArrayList<>();

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.student_xuexi_fragment, container, false);

            initclasses();
            ClassAdapter adapter=new ClassAdapter(getActivity(),R.layout.class_item,classList);
            ListView listview =(ListView) view.findViewById(R.id.list_xuexi);
            listview.setAdapter(adapter);
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Class class1=classList.get(position);
                    String data=class1.getName();
                    Intent intent=new Intent(getActivity(),StudentKechengActivity.class);
                    intent.putExtra("extra_data",data);
                    startActivity(intent);
                }
            });
            return view;
        }

        private void initclasses(){
            for (int i=0;i<1;i++) {
                Class shuxue=new Class ("高等数学(一)",R.drawable.kecheng);
                classList.add(shuxue);
                Class yingyu=new Class ("英语(二)",R.drawable.kecheng);
                classList.add(yingyu);
                Class shuju=new Class ("数据结构",R.drawable.kecheng);
                classList.add(shuju);
                Class java=new Class ("JAVA编程设计",R.drawable.kecheng);
                classList.add(java);
            }
        }
    }