package com.example.a.checkattendance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ClassAdapter extends ArrayAdapter<Class> {
    private int resourceId;

    public ClassAdapter(Context context,int textViewResourceId, List <Class> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Class class1=getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView==null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder=new ViewHolder();
            viewHolder.classImage=(ImageView) view.findViewById(R.id.class_image);
            viewHolder.className= (TextView) view.findViewById(R.id.class_name);
            view.setTag(viewHolder);
        }
        else{
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.classImage.setImageResource(class1.getImageId());
        viewHolder.className.setText(class1.getName());
        return view;
    }
    class ViewHolder
    {
        ImageView classImage;
        TextView className;
    }

}
