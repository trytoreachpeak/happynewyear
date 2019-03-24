package com.example.a.checkattendance.Admin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.a.checkattendance.R;

public class AdminTeacherFragment extends Fragment implements View.OnClickListener {
    private String[] data = {"秦高", "苗丽丽", "华含", "谢红", "何丽",  "钱强"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.admin_teacher_fragment, container, false);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data);
        final ListView listView = (ListView) view.findViewById(R.id.list_teacher);
        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
        }
    }
}