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
                Ziliao shuxue=new Ziliao ("总结",R.drawable.kecheng);
                ziliaoList.add(shuxue);
                Ziliao yingyu=new Ziliao ("提纲",R.drawable.kecheng);
                ziliaoList.add(yingyu);
            }
        }
    }