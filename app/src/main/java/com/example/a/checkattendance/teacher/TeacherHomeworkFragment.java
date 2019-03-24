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

public class TeacherHomeworkFragment extends Fragment {
    TeacherHomeworkAdapter adapter;
    RecyclerView homeworkList;
    RelativeLayout createHomework;
    RelativeLayout scoreSummary;
    private List<TeacherHomeworkItem> mList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.teacher_homework,container,false);
        createHomework = (RelativeLayout)view.findViewById(R.id.create_homework);
        scoreSummary = (RelativeLayout)view.findViewById(R.id.score_summary);

        initData();
        homeworkList = (RecyclerView)view.findViewById(R.id.homework_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        homeworkList.setLayoutManager(layoutManager);
        adapter = new TeacherHomeworkAdapter(mList);
        homeworkList.setAdapter(adapter);

        return view;
    }
    private void initData(){
        TeacherHomeworkItem item =
                new TeacherHomeworkItem("完成课后作业","自由格式",
                "截止于2019-03-27 12:00",28,
                        1,0,28);
        mList.add(item);
        TeacherHomeworkItem item1 =
                new TeacherHomeworkItem("完成预习作业","自由格式",
                        "截止于2019-03-27 12:00",28,
                        1,0,28);
        mList.add(item1);
    }
}
