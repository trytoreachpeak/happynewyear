package com.example.a.checkattendance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

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
                Class shuxue=new Class ("数学",R.drawable.kecheng);
                classList.add(shuxue);
                Class yingyu=new Class ("英语",R.drawable.kecheng);
                classList.add(yingyu);
            }
        }
    }