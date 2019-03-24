package com.example.a.checkattendance.counsellor;

import android.content.Intent;
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
import android.widget.LinearLayout;

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.teacher.TeacherMessageItem;
import com.example.a.checkattendance.teacher.TeacherStudyAdapter;

import java.util.ArrayList;
import java.util.List;


public class CounsellorFirstFragment extends Fragment implements View.OnClickListener{
    private List<TeacherMessageItem> CounsellorCCItemList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.counsellor_first_fragment,container,false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.counsellor_class_condition_recyc);
        initCounsellorCCItem();
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        CounsellorClassConditionAdapter adapter = new CounsellorClassConditionAdapter(CounsellorCCItemList);
        recyclerView.setAdapter(adapter);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        //toolbar.setTitle("");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        LinearLayout DataStatistics = (LinearLayout)view.findViewById(R.id.data_statistics_button);
        DataStatistics.setOnClickListener(this);
        LinearLayout DataAnalysis = (LinearLayout)view.findViewById(R.id.data_analysis_button);
        DataAnalysis.setOnClickListener(this);
        LinearLayout Exam = (LinearLayout)view.findViewById(R.id.exam_button);
        Exam.setOnClickListener(this);
        return view;
    }
    private void initCounsellorCCItem(){
        TeacherMessageItem testExample=new TeacherMessageItem("计161",
                R.drawable.banji_img,"正在上课中:操作系统");
        CounsellorCCItemList.add(testExample);
        TeacherMessageItem testExample1=new TeacherMessageItem("计162",
                R.drawable.banji_img,"正在上课中:操作系统");
        CounsellorCCItemList.add(testExample1);
        TeacherMessageItem testExample2=new TeacherMessageItem("软工161",
                R.drawable.banji_img,"未上课中");
        CounsellorCCItemList.add(testExample2);
        TeacherMessageItem testExample3=new TeacherMessageItem("软工162",
                R.drawable.banji_img,"未上课中");
        CounsellorCCItemList.add(testExample3);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.data_statistics_button:
                intent = new Intent(getActivity(),CounsellorDataStatistics.class);
                startActivity(intent);
                break;
            case R.id.data_analysis_button:
                intent = new Intent(getActivity(),CounsellorDataAnalysis.class);
                startActivity(intent);
                break;
            case R.id.exam_button:
                intent = new Intent(getActivity(),CounsellorExam.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
