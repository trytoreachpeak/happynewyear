package com.example.a.checkattendance.student;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.a.checkattendance.R;

import java.util.List;

public class ZuoyeAdapter extends ArrayAdapter<Zuoye> {
    private int resourceId;

    public ZuoyeAdapter(Context context,int textViewResourceId, List <Zuoye> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Zuoye zuoye=getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView==null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder=new ViewHolder();
            viewHolder.ZuoyeImage=(ImageView) view.findViewById(R.id.zuoye_image);
            viewHolder.ZuoyeName= (TextView) view.findViewById(R.id.zuoye_name);
            view.setTag(viewHolder);
        }
        else{
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.ZuoyeImage.setImageResource(zuoye.getImageId());
        viewHolder.ZuoyeName.setText(zuoye.getName());
        return view;
    }
    class ViewHolder
    {
        ImageView ZuoyeImage;
        TextView ZuoyeName;
    }

}
