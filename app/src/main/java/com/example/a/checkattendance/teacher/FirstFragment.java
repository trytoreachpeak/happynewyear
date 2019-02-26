package com.example.a.checkattendance.teacher;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.a.checkattendance.R;

public class FirstFragment extends Fragment implements View.OnClickListener{
    LinearLayout teacherMessage;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment,container,false);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        toolbar.setOverflowIcon(getResources().getDrawable(R.mipmap.icon_add));     //设置菜单图标

        teacherMessage=(LinearLayout)view.findViewById(R.id.teacher_message);
        teacherMessage.setOnClickListener(this);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_1:
                Toast.makeText(getActivity(), "我是第一个", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_2:
                Toast.makeText(getActivity(), "我是第二个", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_3:
                Toast.makeText(getActivity(), "我是第三个", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_4:
                Toast.makeText(getActivity(), "我是第四个", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.teacher_message:
                intent = new Intent(getActivity(), com.example.a.checkattendance.teacher.teacherMessage.class);
                startActivity(intent);
                break;
        }
    }

}
