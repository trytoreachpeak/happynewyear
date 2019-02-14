package com.example.a.checkattendance.teacher;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a.checkattendance.R;

import java.util.List;

public class TeacherStudyAdapter
        extends RecyclerView.Adapter<TeacherStudyAdapter.ViewHolder> {
    private List<TeacherMessageItem> mTeacherStudyItem;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View studyView;
        ImageView teacher_study_left_img;
        TextView teacher_study_cat;
        TextView teacher_study_class;
        TextView teacher_study_name;

        public ViewHolder(View view) {
            super(view);
            studyView = view;
            teacher_study_left_img = (ImageView) view.findViewById(R.id.teacher_message_left_img);
            teacher_study_cat = (TextView) view.findViewById(R.id.teacher_message_cat);
            teacher_study_class = (TextView) view.findViewById(R.id.teacher_message_class);
            teacher_study_name = (TextView) view.findViewById(R.id.teacher_message_name);
        }
    }
    public TeacherStudyAdapter(List<TeacherMessageItem>teacherStudyItem){
        mTeacherStudyItem = teacherStudyItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.teacher_message_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.studyView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                TeacherMessageItem teacherStudyItem = mTeacherStudyItem.get(position);
                Intent intent = new Intent(v.getContext(),TeacherStudy.class);
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TeacherMessageItem teacherStudyItem=mTeacherStudyItem.get(position);
        holder.teacher_study_left_img.setImageResource(teacherStudyItem.getMessageLeftImageId());
        holder.teacher_study_cat.setText(teacherStudyItem.getMessageCategory());
        holder.teacher_study_class.setText(teacherStudyItem.getMessageClass());
        holder.teacher_study_name.setText(teacherStudyItem.getMessageName());
    }

    @Override
    public int getItemCount() {
        return mTeacherStudyItem.size();
    }
}
