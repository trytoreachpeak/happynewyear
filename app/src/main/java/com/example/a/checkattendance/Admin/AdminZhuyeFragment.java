package com.example.a.checkattendance.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.a.checkattendance.R;

import java.util.ArrayList;
import java.util.List;

public class AdminZhuyeFragment extends Fragment implements View.OnClickListener{

    private List<Floor> floorList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.admin_zhuye_fragment, container, false);


        Button button_issue=(Button) view.findViewById(R.id.issue);
        button_issue.setOnClickListener(this);
        LinearLayout L_admin_analysis=(LinearLayout)view.findViewById(R.id.Admin_analysis);
        L_admin_analysis.setOnClickListener(this);
        LinearLayout L_admin_statistics=(LinearLayout)view.findViewById(R.id.Admin_statistics);
        L_admin_statistics.setOnClickListener(this);
        LinearLayout L_admin_test=(LinearLayout)view.findViewById(R.id.Admin_test);
        L_admin_test.setOnClickListener(this);
        LinearLayout L_admin_class=(LinearLayout)view.findViewById(R.id.Admin_class);
        L_admin_class.setOnClickListener(this);
        LinearLayout L_admin_course=(LinearLayout)view.findViewById(R.id.Admin_course);
        L_admin_course.setOnClickListener(this);
        LinearLayout L_admin_attendance=(LinearLayout)view.findViewById(R.id.Admin_attendance);
        L_admin_attendance.setOnClickListener(this);


        initclasses();
        FloorAdapter adapter=new FloorAdapter(getActivity(),R.layout.floor_item,floorList);
        ListView listview =(ListView) view.findViewById(R.id.list_floor);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Floor floor=floorList.get(position);
                String data=floor.getName();

            }
        });


        return  view;
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.Admin_class:
                intent = new Intent(getActivity(),AdminClassuseActivity.class);
                startActivity(intent);
                break;
            case R.id.Admin_analysis:
                intent = new Intent(getActivity(),AdminAnalysisActivity.class);
                startActivity(intent);
                break;
            case R.id.Admin_course:
                intent = new Intent(getActivity(),AdminCourseActivity.class);
                startActivity(intent);
                break;
            case R.id.Admin_attendance:
                intent = new Intent(getActivity(),AdminTeacherAttendanceActivity.class);
                startActivity(intent);
                break;
            case R.id.issue:
                intent = new Intent(getActivity(),AdminIssueActivity.class);
                startActivity(intent);
                break;
            case R.id.Admin_statistics:
                intent = new Intent(getActivity(),AdminStatisticsActivity.class);
                startActivity(intent);
                break;
            case R.id.Admin_test:
                intent = new Intent(getActivity(),AdminTestActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }


    private void initclasses(){
        for (int i=0;i<1;i++) {
            Floor shuxue=new Floor ("清明节放假通知");
            floorList.add(shuxue);
            Floor yingyu=new Floor ("劳动节放假通知");
            floorList.add(yingyu);
        }
    }

}