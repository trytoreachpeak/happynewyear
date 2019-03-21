package com.example.a.checkattendance.teacher;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.a.checkattendance.HttpUtil;
import com.example.a.checkattendance.R;
import com.example.a.checkattendance.gsonitem.CounsellorGetStudentsOfClassAttendance;
import com.example.a.checkattendance.gsonitem.GetLessonConditionUntilNow;
import com.example.a.checkattendance.gsonitem.GetSingleLessonCondtion;
import com.example.a.checkattendance.gsonitem.GetSingleStudentIdentity;
import com.example.a.checkattendance.gsonitem.GetStudentsOfClassIdentity;
import com.example.a.checkattendance.gsonitem.GetTeacherAttendance;
import com.example.a.checkattendance.gsonitem.ManagerGetAllStudentAttendance;
import com.example.a.checkattendance.gsonitem.ManagerGetAllTeacherAttendance;
import com.example.a.checkattendance.gsonitem.ManagerGetSingleStudentCondition;
import com.example.a.checkattendance.gsonitem.ManagerGetSingleTeacherAttendance;
import com.example.a.checkattendance.gsonitem.StudentGetAllSubjectCondition;
import com.example.a.checkattendance.gsonitem.StudentGetLessonCondition;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public class SecondFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment,container,false);
        Button button = (Button)view.findViewById(R.id.abc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpUtil.sendLoginRequest(
                        "http://203.195.156.24:7000/api/v1/teachers/studentssign/",
                        HttpUtil.createSingleClassConditionJson("2019-03-18",5,"123456"),
                        //"http://192.168.137.1:80/test11.json",
                        //"http://10.0.2.2/test.json",
                        //HttpUtil.createTeacherIdJson("123456"),
                        new okhttp3.Callback(){
                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                Gson gson = new Gson();
                                java.lang.reflect.Type type = new TypeToken<GetSingleLessonCondtion>() {
                                }.getType();
                                GetSingleLessonCondtion getSingleLessonCondtion= gson.fromJson(response.body().string(), type);
                                Log.d("testabc",getSingleLessonCondtion.getStatus()+"");
                                Log.d("testabc",getSingleLessonCondtion.getData().size()+"");
                                Log.d("testabc",getSingleLessonCondtion.getData().get(0).getStudentname());
                                Log.d("testabc",getSingleLessonCondtion.getData().get(0).getSstate()+"");
                                Log.d("testabc",getSingleLessonCondtion.getData().get(0).getSignouttime()+"");
                                Log.d("testabc",getSingleLessonCondtion.getData().get(0).getIslazy()+"");
                            }
                            @Override
                            public void onFailure(Call call, IOException e) {
                                Log.d("testabc","connect fail");
                            }
                        }
                        );
            }
        });
        return view;
    }
}
