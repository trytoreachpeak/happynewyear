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

public class CounsellorDataAnalysisAdapter
        extends RecyclerView.Adapter<CounsellorDataAnalysisAdapter.
        ViewHolder> {
    private List<TeacherMessageItem> mCounsellorDAItem;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View DAView;
        ImageView counsellor_DA_left_img;
        TextView counsellor_DA_cat;
        TextView counsellor_DA_class;

        public ViewHolder(@NonNull View view) {
            super(view);
            DAView= view;
            counsellor_DA_left_img = (ImageView) view.findViewById(R.id.teacher_message_left_img);
            counsellor_DA_cat = (TextView) view.findViewById(R.id.teacher_message_cat);
            counsellor_DA_class = (TextView) view.findViewById(R.id.teacher_message_class);
        }
    }
    public CounsellorDataAnalysisAdapter(List<TeacherMessageItem> CounsellorDAItem){
        mCounsellorDAItem = CounsellorDAItem;
    }

    @NonNull
    @Override
    public CounsellorDataAnalysisAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.teacher_message_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.DAView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                TeacherMessageItem teacherStudyItem = mCounsellorDAItem.get(position);
                Intent intent = new Intent(v.getContext(),CounsellorDAClass.class);
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CounsellorDataAnalysisAdapter.ViewHolder holder, int position) {
        TeacherMessageItem councellorDAItem = mCounsellorDAItem.get(position);
        holder.counsellor_DA_left_img.setImageResource(councellorDAItem.getMessageLeftImageId());
        holder.counsellor_DA_cat.setText(councellorDAItem.getMessageCategory());
        holder.counsellor_DA_class.setText(councellorDAItem.getMessageClass());
    }

    @Override
    public int getItemCount() {
        return mCounsellorDAItem.size();
    }
}
