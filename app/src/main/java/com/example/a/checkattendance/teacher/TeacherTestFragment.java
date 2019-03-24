package com.example.a.checkattendance.teacher;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.a.checkattendance.R;

import java.util.ArrayList;
import java.util.List;

public class TeacherTestFragment extends Fragment {
    TeacherTestAdapter adapter;
    RecyclerView testList;
    RelativeLayout scoreSummary;
    private List<TeacherTestItem> mList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.teacher_test,container,false);
        scoreSummary = (RelativeLayout)view.findViewById(R.id.score_summary);

        initData();
        testList = (RecyclerView)view.findViewById(R.id.test_list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        testList.setLayoutManager(manager);
        adapter = new TeacherTestAdapter(mList);
        testList.setAdapter(adapter);
        return view;
    }
    private void initData(){
        TeacherTestItem item = new TeacherTestItem("练习卷1","限时60分钟",
                "发布于2019-03-27 11:30","截止于2019-03-27 12:30",
                29,0);
        mList.add(item);
        TeacherTestItem item1 = new TeacherTestItem("练习卷2","限时60分钟",
                "发布于2019-03-27 11:30","截止于2019-03-27 12:30",
                29,0);
        mList.add(item1);
    }
}
