package com.example.a.checkattendance.teacher;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a.checkattendance.R;

import java.util.List;

public class TeacherHomeworkAdapter extends RecyclerView.Adapter<TeacherHomeworkAdapter.ViewHolder> {
    private List<TeacherHomeworkItem> mList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View homeworkView;
        TextView homeworkName;
        TextView homeworkFormat;
        TextView homeworkDeadline;
        TextView hasCommittedNum;
        TextView notCommittedNum;
        TextView hasCheckNum;
        TextView noCheckNum;

        public ViewHolder(View view){
            super(view);
            homeworkView = view;
            homeworkName = (TextView)view.findViewById(R.id.homework_name);
            homeworkFormat = (TextView)view.findViewById(R.id.homework_format);
            homeworkDeadline = (TextView)view.findViewById(R.id.homework_deadline);
            hasCommittedNum = (TextView)view.findViewById(R.id.has_committed_num);
            notCommittedNum = (TextView)view.findViewById(R.id.not_committed_num);
            hasCheckNum = (TextView)view.findViewById(R.id.has_check_num);
            noCheckNum = (TextView)view.findViewById(R.id.no_check_num);
        }
    }
    public TeacherHomeworkAdapter(List<TeacherHomeworkItem> list){
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.teacher_homework_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.homeworkView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                //TeacherHomeworkItem item = mList.get(position);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TeacherHomeworkItem item = mList.get(position);
        holder.homeworkName.setText(item.getHomeworkName());
        holder.homeworkFormat.setText(item.getFormat());
        holder.homeworkDeadline.setText(item.getDeadline());
        holder.hasCommittedNum.setText(item.getHasCommitted()+"人");
        holder.notCommittedNum.setText(item.getNotCommitted()+"人");
        holder.hasCheckNum.setText(item.getHasCheck()+"人");
        holder.noCheckNum.setText(item.getNoCheck()+"人");
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
