package com.example.a.checkattendance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

    public class StudentZuoyeFragment extends Fragment {
        private List<Zuoye> zuoyeList=new ArrayList<>();
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.student_zuoye_fragment, container, false);

            initclasses();
            ZuoyeAdapter adapter=new ZuoyeAdapter(getActivity(),R.layout.zuoye_item,zuoyeList);
            ListView listview =(ListView) view.findViewById(R.id.list_zuoye);
            listview.setAdapter(adapter);
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Zuoye zuoye=zuoyeList.get(position);
                    Intent intent=new Intent(getActivity(),StudentMobanActivity.class);
                    startActivity(intent);
                }
            });
            return view;
        }

        private void initclasses(){
            for (int i=0;i<1;i++) {
                Zuoye shuxue=new Zuoye("周一",R.drawable.kecheng);
                zuoyeList.add(shuxue);
                Zuoye yingyu=new Zuoye("周二",R.drawable.kecheng);
                zuoyeList.add(yingyu);
            }
        }
    }