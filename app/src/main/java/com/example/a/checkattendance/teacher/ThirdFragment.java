package com.example.a.checkattendance.teacher;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.teacher.TeacherMessageItem;
import com.example.a.checkattendance.teacher.TeacherStudyAdapter;

import java.util.ArrayList;
import java.util.List;

public class ThirdFragment extends Fragment {

    private List<TeacherMessageItem> studyItemList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third_fragment,container,false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.teacher_study_recycler);
        initTeacherStudyItem();
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        TeacherStudyAdapter adapter = new TeacherStudyAdapter(studyItemList);
        recyclerView.setAdapter(adapter);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_third_fragment);
        toolbar.setTitle("");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        return view;
    }

    private void initTeacherStudyItem(){
        TeacherMessageItem testExample=new TeacherMessageItem("课程名称",
                R.drawable.shenqing_img,"某某班","某某班");
        studyItemList.add(testExample);
    }

}
