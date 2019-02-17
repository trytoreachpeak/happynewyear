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
        TeacherStudyAdapter adapter = new TeacherStudyAdapter(CounsellorCCItemList);
        recyclerView.setAdapter(adapter);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_first_fragment);
        toolbar.setTitle("");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        LinearLayout DataStatistics = (LinearLayout)view.findViewById(R.id.data_statistics_button);
        DataStatistics.setOnClickListener(this);
        return view;
    }
    private void initCounsellorCCItem(){
        TeacherMessageItem testExample=new TeacherMessageItem("班级1",
                R.drawable.shenqing_img,"某某班");
        CounsellorCCItemList.add(testExample);
        TeacherMessageItem testExample1=new TeacherMessageItem("我",
                R.drawable.shenqing_img,"我");
        CounsellorCCItemList.add(testExample1);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.data_statistics_button:
                intent = new Intent(getActivity(),CounsellorDataStatistics.class);
                startActivity(intent);
                break;
        }
    }
}
