package com.example.a.checkattendance.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.a.checkattendance.R;


public class StudentWodeFragment extends Fragment implements View.OnClickListener{
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.student_wode_fragment, container, false);

            Button button_xuexiao=(Button) view.findViewById(R.id.xuexiao);
            button_xuexiao.setOnClickListener(this);
            Button button_kecheng=(Button) view.findViewById(R.id.kecheng);
            button_kecheng.setOnClickListener(this);
            Button button_banji=(Button) view.findViewById(R.id.banji);
            button_banji.setOnClickListener(this);
            Button button_guanyu=(Button) view.findViewById(R.id.guanyu);
            button_guanyu.setOnClickListener(this);
            Button button_fankui=(Button) view.findViewById(R.id.fankui);
            button_fankui.setOnClickListener(this);
            ImageView image_set=(ImageView) view.findViewById(R.id.set);
            image_set.setOnClickListener(this);
            ImageView image_information=(ImageView) view.findViewById(R.id.information);
            image_information.setOnClickListener(this);
            return view;
        }
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.xuexiao:
                    Intent intent1 = new Intent(getActivity(), StudentMobanActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.kecheng:
                    Intent intent2 = new Intent(getActivity(), StudentMobanActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.banji:
                    Intent intent3 = new Intent(getActivity(), StudentMobanActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.guanyu:
                    Intent intent5 = new Intent(getActivity(), StudentMobanActivity.class);
                    startActivity(intent5);
                    break;
                case R.id.fankui:
                    Intent intent6 = new Intent(getActivity(), StudentMobanActivity.class);
                    startActivity(intent6);
                    break;
                case R.id.set:
                    Intent intent7 = new Intent(getActivity(), StudentSetActivity.class);
                    startActivity(intent7);
                    break;
                case  R.id.information:
                    Intent intent8 = new Intent(getActivity(), StudentInformationActivity.class);
                    startActivity(intent8);
                    break;
                default:
                    break;
            }
        }
    }
