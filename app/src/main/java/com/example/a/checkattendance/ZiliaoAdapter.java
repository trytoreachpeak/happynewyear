package com.example.a.checkattendance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.List;

public class ZiliaoAdapter extends ArrayAdapter<Ziliao> {
    private int resourceId;

    public ZiliaoAdapter(Context context,int textViewResourceId, List <Ziliao> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Ziliao ziliao=getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView==null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder=new ViewHolder();
            viewHolder.ZiliaoImage=(ImageView) view.findViewById(R.id.ziliao_image);
            viewHolder.ZiliaoName= (TextView) view.findViewById(R.id.ziliao_name);
            view.setTag(viewHolder);
        }
        else{
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.ZiliaoImage.setImageResource(ziliao.getImageId());
        viewHolder.ZiliaoName.setText(ziliao.getName());
        return view;
    }
    class ViewHolder
    {
        ImageView ZiliaoImage;
        TextView ZiliaoName;
    }

}
