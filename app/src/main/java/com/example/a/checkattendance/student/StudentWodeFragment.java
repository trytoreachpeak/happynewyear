package com.example.a.checkattendance.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.teacher.TeacherFeedback;
import com.example.a.checkattendance.teacher.TeacherPersoninfo;
import com.example.a.checkattendance.teacher.TeacherSchool;
import com.example.a.checkattendance.teacher.TeacherSettings;

import de.hdodenhof.circleimageview.CircleImageView;


public class StudentWodeFragment extends Fragment implements View.OnClickListener{
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
        View view = inflater.inflate(R.layout.student_wode_fragment,container,false);

        settings_up=(ImageView) view.findViewById(R.id.up_setting_button);
        personInfo=(LinearLayout)view.findViewById(R.id.person_info);
        subject=(RelativeLayout)view.findViewById(R.id.subject);
        myAttendance=(RelativeLayout)view.findViewById(R.id.my_attendance);
        feedback=(RelativeLayout)view.findViewById(R.id.feedback_icon);
        settings=(RelativeLayout)view.findViewById(R.id.settings);

        settings.setOnClickListener(this);
        settings_up.setOnClickListener(this);
        personInfo.setOnClickListener(this);
        feedback.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.up_setting_button:
                intent = new Intent(getActivity(),StudentSetActivity.class);
                startActivity(intent);
                break;
            case R.id.settings:
                intent = new Intent(getActivity(),StudentSetActivity.class);
                startActivity(intent);
                break;

            case R.id.person_info:
                intent = new Intent(getActivity(),StudentInformationActivity.class);
                startActivity(intent);
                break;
            case R.id.feedback_icon:
                intent = new Intent(getActivity(),StudentFeedbackActivity.class);
                startActivity(intent);
                break;
                default:
                    break;
        }
    }
}
