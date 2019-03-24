package com.example.a.checkattendance.counsellor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.teacher.TeacherMessageItem;
import com.example.a.checkattendance.teacher.TeacherRealtimeClassroom;
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
        holder.CCView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                TeacherMessageItem teacherStudyItem = mCounsellorCCItem.get(position);
                switch(position){
                    case 0:
                        TeacherRealtimeClassroom.actionStart(v.getContext(), "操作系统",
                                "正在上课","2019-04-01 6-8节","2/2节");
                        break;
                    case 1:
                        TeacherRealtimeClassroom.actionStart(v.getContext(), "操作系统",
                                "正在上课","2019-04-01 6-8节","2/2节");
                        break;
                    case 2:
                        Toast toast = Toast.makeText(v.getContext(), null, Toast.LENGTH_SHORT);
                        toast.setText("该课程还未开始");
                        toast.show();
                        break;
                    case 3:
                        Toast toast1 = Toast.makeText(v.getContext(), null, Toast.LENGTH_SHORT);
                        toast1.setText("该课程还未开始");
                        toast1.show();
                        break;
                }
            }
        });
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
