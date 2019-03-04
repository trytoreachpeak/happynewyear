package com.example.a.checkattendance.teacher;

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

import com.example.a.checkattendance.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ForthFragment extends Fragment implements View.OnClickListener{
    ImageView settings;
    CardView teacherSchool;
    CircleImageView headPortrait;
    CardView teacherFeedback;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.forth_fragment,container,false);
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
