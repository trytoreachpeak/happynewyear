package com.example.a.checkattendance;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class FirstFragment extends Fragment implements View.OnClickListener{
    LinearLayout teacherMessage;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment,container,false);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_first_fragment);
        toolbar.setTitle("");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        teacherMessage=(LinearLayout)view.findViewById(R.id.teacher_message);
        teacherMessage.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.teacher_message:
                intent = new Intent(getActivity(),teacherMessage.class);
                startActivity(intent);
                break;
        }
    }
}
