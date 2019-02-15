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

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.teacher.TeacherFeedback;
import com.example.a.checkattendance.teacher.TeacherPersoninfo;
import com.example.a.checkattendance.teacher.TeacherSchool;
import com.example.a.checkattendance.teacher.TeacherSettings;

import de.hdodenhof.circleimageview.CircleImageView;


public class StudentWodeFragment extends Fragment implements View.OnClickListener{
    ImageView settings;
    CardView teacherSchool;
    CircleImageView headPortrait;
    CardView teacherFeedback;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.student_wode_fragment,container,false);
        settings=(ImageView)view.findViewById(R.id.teacher_setting_button);
        settings.setOnClickListener(this);
        teacherSchool=(CardView)view.findViewById(R.id.teacher_school);
        teacherSchool.setOnClickListener(this);
        headPortrait=(CircleImageView)view.findViewById(R.id.head_portrait);
        headPortrait.setOnClickListener(this);
        teacherFeedback=(CardView)view.findViewById(R.id.teacher_feedback);
        teacherFeedback.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.teacher_setting_button:
                intent = new Intent(getActivity(),StudentSetActivity.class);
                startActivity(intent);
                break;
            case R.id.teacher_school:
                intent = new Intent(getActivity(),TeacherSchool.class);
                startActivity(intent);
                break;
            case R.id.head_portrait:
                intent = new Intent(getActivity(),StudentInformationActivity.class);
                startActivity(intent);
                break;
            case R.id.teacher_feedback:
                intent = new Intent(getActivity(),StudentFeedbackActivity.class);
                startActivity(intent);
                break;
        }
    }
}
