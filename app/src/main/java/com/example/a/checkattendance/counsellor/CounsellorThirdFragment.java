package com.example.a.checkattendance.counsellor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.teacher.TeacherFeedback;
import com.example.a.checkattendance.teacher.TeacherMyAttendanceChooseCourse;
import com.example.a.checkattendance.teacher.TeacherMyCourse;
import com.example.a.checkattendance.teacher.TeacherPersoninfo;
import com.example.a.checkattendance.teacher.TeacherSettings;

public class CounsellorThirdFragment extends Fragment implements View.OnClickListener{
    ImageView settings_up;
    LinearLayout personInfo;
    RelativeLayout classes;
    RelativeLayout feedback;
    RelativeLayout settings;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.counsellor_third_fragment,container,false);
        settings_up=(ImageView) view.findViewById(R.id.up_setting_button);
        personInfo=(LinearLayout)view.findViewById(R.id.person_info);
        classes=(RelativeLayout)view.findViewById(R.id.classes);
        feedback=(RelativeLayout)view.findViewById(R.id.feedback_icon);
        settings=(RelativeLayout)view.findViewById(R.id.settings);

        settings.setOnClickListener(this);
        settings_up.setOnClickListener(this);
        personInfo.setOnClickListener(this);
        classes.setOnClickListener(this);
        feedback.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.up_setting_button:
                intent = new Intent(getActivity(), TeacherSettings.class);
                startActivity(intent);
                break;
            case R.id.person_info:
                intent = new Intent(getActivity(), TeacherPersoninfo.class);
                startActivity(intent);
                break;
            case R.id.settings:
                intent = new Intent(getActivity(), TeacherSettings.class);
                startActivity(intent);
                break;
            case R.id.feedback_icon:
                intent = new Intent(getActivity(),TeacherFeedback.class);
                startActivity(intent);
                break;
//            case R.id.classes:
//                intent = new Intent(getActivity(),TeacherMyCourse.class);
//                startActivity(intent);
//                break;
            default:
                break;
        }
    }
}
