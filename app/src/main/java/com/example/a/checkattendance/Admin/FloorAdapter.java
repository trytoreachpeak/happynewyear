package com.example.a.checkattendance.Admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.student.Chat;

import java.util.List;

public class FloorAdapter extends ArrayAdapter<Floor> {
    private int resourceId;

    public FloorAdapter(Context context, int textViewResourceId, List<Floor> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Floor floor=getItem(position);
        View view;
        com.example.a.checkattendance.Admin.FloorAdapter.ViewHolder viewHolder;
        if (convertView==null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder=new com.example.a.checkattendance.Admin.FloorAdapter.ViewHolder();

            viewHolder.FloorName= (TextView) view.findViewById(R.id.floor_name);
            view.setTag(viewHolder);
        }
        else{
            view=convertView;
            viewHolder= (com.example.a.checkattendance.Admin.FloorAdapter.ViewHolder) view.getTag();
        }

        viewHolder.FloorName.setText(floor.getName());
        return view;
    }
    class ViewHolder
    {

        TextView FloorName;
    }

}