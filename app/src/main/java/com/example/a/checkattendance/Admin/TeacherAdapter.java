package com.example.a.checkattendance.Admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a.checkattendance.R;

import java.util.List;

public class TeacherAdapter extends ArrayAdapter<Teacher> {
    private int resourceId;

    public TeacherAdapter(Context context, int textViewResourceId, List<Teacher> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Teacher teacher=getItem(position);
        View view;
        com.example.a.checkattendance.Admin.TeacherAdapter.ViewHolder viewHolder;
        if (convertView==null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder=new com.example.a.checkattendance.Admin.TeacherAdapter.ViewHolder();

            viewHolder.TeacherName= (TextView) view.findViewById(R.id.teacher_name);
            viewHolder.TeacherAttend= (TextView) view.findViewById(R.id.teacher_attend);
            viewHolder.TeacherImageId= (ImageView) view.findViewById(R.id.teacher_image);
            view.setTag(viewHolder);
        }
        else{
            view=convertView;
            viewHolder= (com.example.a.checkattendance.Admin.TeacherAdapter.ViewHolder) view.getTag();
        }
        viewHolder.TeacherName.setText(teacher.getName());
        viewHolder.TeacherAttend.setText(teacher.getAttend());
        viewHolder.TeacherImageId.setImageResource(teacher.getImageId());
        return view;
    }
    class ViewHolder
    {

        TextView TeacherName;
        TextView TeacherAttend;
        ImageView TeacherImageId;
    }

}