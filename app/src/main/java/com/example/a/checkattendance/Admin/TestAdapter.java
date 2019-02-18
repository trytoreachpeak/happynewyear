package com.example.a.checkattendance.Admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.a.checkattendance.R;

import java.util.List;

public class TestAdapter extends ArrayAdapter<Test> {
    private int resourceId;

    public TestAdapter(Context context, int textViewResourceId, List<Test> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Test test=getItem(position);
        View view;
        com.example.a.checkattendance.Admin.TestAdapter.ViewHolder viewHolder;
        if (convertView==null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder=new com.example.a.checkattendance.Admin.TestAdapter.ViewHolder();

            viewHolder.TestTime= (TextView) view.findViewById(R.id.test_time);
            viewHolder.TestSubject= (TextView) view.findViewById(R.id.test_subject);
            view.setTag(viewHolder);
        }
        else{
            view=convertView;
            viewHolder= (com.example.a.checkattendance.Admin.TestAdapter.ViewHolder) view.getTag();
        }
        viewHolder.TestTime.setText(test.getTime());
        viewHolder.TestSubject.setText(test.getSubject());
        return view;
    }
    class ViewHolder
    {

        TextView TestTime;
        TextView TestSubject;
    }

}