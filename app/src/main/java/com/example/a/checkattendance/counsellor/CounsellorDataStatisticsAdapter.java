package com.example.a.checkattendance.counsellor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.teacher.TeacherMessageItem;

import java.util.List;

public class CounsellorDataStatisticsAdapter
        extends RecyclerView.Adapter<CounsellorDataStatisticsAdapter.
        ViewHolder>{
    private List<TeacherMessageItem> mCounsellorDSItem;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View DSView;
        ImageView counsellor_DS_left_img;
        TextView counsellor_DS_cat;
        TextView counsellor_DS_class;

        public ViewHolder(@NonNull View view) {
            super(view);
            DSView= view;
            counsellor_DS_left_img = (ImageView) view.findViewById(R.id.teacher_message_left_img);
            counsellor_DS_cat = (TextView) view.findViewById(R.id.teacher_message_cat);
            counsellor_DS_class = (TextView) view.findViewById(R.id.teacher_message_class);
        }
    }
    public CounsellorDataStatisticsAdapter(List<TeacherMessageItem> CounsellorDSItem){
        mCounsellorDSItem = CounsellorDSItem;
    }

    @NonNull
    @Override
    public CounsellorDataStatisticsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.teacher_message_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.DSView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                TeacherMessageItem teacherStudyItem = mCounsellorDSItem.get(position);
                Intent intent = new Intent(v.getContext(),CounsellorDSClass.class);
                intent.putExtra("title",teacherStudyItem.getMessageCategory());
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CounsellorDataStatisticsAdapter.ViewHolder holder, int position) {
        TeacherMessageItem councellorDSItem = mCounsellorDSItem.get(position);
        holder.counsellor_DS_left_img.setImageResource(councellorDSItem.getMessageLeftImageId());
        holder.counsellor_DS_cat.setText(councellorDSItem.getMessageCategory());
        holder.counsellor_DS_class.setText(councellorDSItem.getMessageClass());
    }

    @Override
    public int getItemCount() {
        return mCounsellorDSItem.size();
    }
}
