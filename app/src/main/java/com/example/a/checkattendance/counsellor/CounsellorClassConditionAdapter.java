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
import com.example.a.checkattendance.teacher.TeacherStudy;

import java.util.List;

public class CounsellorClassConditionAdapter
        extends RecyclerView.Adapter<CounsellorClassConditionAdapter.
        ViewHolder> {
    private List<TeacherMessageItem> mCounsellorCCItem;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View CCView;
        ImageView counsellor_CC_left_img;
        TextView counsellor_CC_cat;
        TextView counsellor_CC_class;

        public ViewHolder(@NonNull View view) {
            super(view);
            CCView= view;
            counsellor_CC_left_img = (ImageView) view.findViewById(R.id.teacher_message_left_img);
            counsellor_CC_cat = (TextView) view.findViewById(R.id.teacher_message_cat);
            counsellor_CC_class = (TextView) view.findViewById(R.id.teacher_message_class);
        }
    }
    public CounsellorClassConditionAdapter(List<TeacherMessageItem> CounsellorCCItem){
        mCounsellorCCItem = CounsellorCCItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.teacher_message_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        /*holder.studyView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                TeacherMessageItem teacherStudyItem = mTeacherStudyItem.get(position);
                Intent intent = new Intent(v.getContext(),TeacherStudy.class);
                v.getContext().startActivity(intent);
            }
        });*/
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TeacherMessageItem councellorCCItem = mCounsellorCCItem.get(position);
        holder.counsellor_CC_left_img.setImageResource(councellorCCItem.getMessageLeftImageId());
        holder.counsellor_CC_cat.setText(councellorCCItem.getMessageCategory());
        holder.counsellor_CC_class.setText(councellorCCItem.getMessageClass());
    }

    @Override
    public int getItemCount() {
        return mCounsellorCCItem.size();
    }
}
