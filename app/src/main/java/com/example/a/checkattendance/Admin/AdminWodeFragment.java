package com.example.a.checkattendance.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.student.StudentFeedbackActivity;
import com.example.a.checkattendance.student.StudentInformationActivity;
import com.example.a.checkattendance.student.StudentSetActivity;
import com.example.a.checkattendance.teacher.TeacherSchool;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdminWodeFragment extends Fragment implements View.OnClickListener {
    ImageView settings_up;
    LinearLayout personInfo;
    RelativeLayout subject;
    RelativeLayout myAttendance;
    RelativeLayout feedback;
    RelativeLayout query;
    RelativeLayout settings;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.admin_wode_fragment,container,false);

        settings_up=(ImageView) view.findViewById(R.id.up_setting_button);
        personInfo=(LinearLayout)view.findViewById(R.id.person_info);
        subject=(RelativeLayout)view.findViewById(R.id.subject);
        myAttendance=(RelativeLayout)view.findViewById(R.id.my_attendance);
        feedback=(RelativeLayout)view.findViewById(R.id.feedback_icon);
        query=(RelativeLayout)view.findViewById(R.id.query);
        settings=(RelativeLayout)view.findViewById(R.id.settings);

        settings.setOnClickListener(this);
        settings_up.setOnClickListener(this);
        personInfo.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
          default:
              break;
        }
    }
}
