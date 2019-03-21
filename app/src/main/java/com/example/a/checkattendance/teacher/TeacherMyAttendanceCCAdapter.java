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

public class TeacherMyAttendanceCCAdapter
        extends RecyclerView.Adapter<TeacherMessageAdapter.ViewHolder>{
    private List<TeacherMessageItem> mTeacherMessageItem;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View messageView;
        ImageView teacher_message_left_img;
        TextView teacher_message_cat;
        TextView teacher_message_class;
        //TextView teacher_message_name;

        public ViewHolder(View view){
            super(view);
            messageView=view;
            teacher_message_left_img =(ImageView)view.findViewById(R.id.teacher_message_left_img);
            teacher_message_cat=(TextView)view.findViewById(R.id.teacher_message_cat);
            teacher_message_class=(TextView)view.findViewById(R.id.teacher_message_class);
            //teacher_message_name=(TextView)view.findViewById(R.id.teacher_message_name);
        }
    }
    public TeacherMyAttendanceCCAdapter(List<TeacherMessageItem>teacherMessageItem){
        mTeacherMessageItem=teacherMessageItem;
    }

    @NonNull
    @Override
    public TeacherMessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.teacher_message_item,parent,false);
        final TeacherMessageAdapter.ViewHolder holder = new TeacherMessageAdapter.ViewHolder(view);
        holder.messageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                TeacherMessageItem teacherMessageItem=mTeacherMessageItem.get(position);
                Intent intent = new Intent(v.getContext(),TeacherMyAttendance.class);
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherMessageAdapter.ViewHolder holder, int position) {
        TeacherMessageItem teacherMessageItem=mTeacherMessageItem.get(position);
        holder.teacher_message_left_img.setImageResource(teacherMessageItem.getMessageLeftImageId());
        holder.teacher_message_cat.setText(teacherMessageItem.getMessageCategory());
        holder.teacher_message_class.setText(teacherMessageItem.getMessageClass());
        //holder.teacher_message_name.setText(teacherMessageItem.getMessageName());
    }

    @Override
    public int getItemCount() {
        return mTeacherMessageItem.size();
    }
}
