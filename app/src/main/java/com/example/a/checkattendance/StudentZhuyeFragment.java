package com.example.a.checkattendance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

    public class StudentZhuyeFragment extends Fragment implements View.OnClickListener{
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.student_zhuye_fragment, container, false);


            Button button_qingjia=(Button) view.findViewById(R.id.qingjia);
            button_qingjia.setOnClickListener(this);
            ImageView image_chat=(ImageView) view.findViewById(R.id.chat);
            image_chat.setOnClickListener(this);
            return view;
        }
        @Override
        public void onClick(View v){
            switch (v.getId()){
                case R.id.qingjia:
                    Intent intent1= new Intent(getActivity(),StudentQingjiaActivity.class);
                    startActivity(intent1);
                    break;
                case  R.id.chat:
                    Intent intent2=new Intent(getActivity(),StudentChatActivity.class);
                    startActivity(intent2);
                default:
                    break;
            }
        }
    }