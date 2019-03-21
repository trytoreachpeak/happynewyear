package com.example.a.checkattendance.teacher;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a.checkattendance.R;

import java.util.List;

public class TeacherMyCourseAdapter
        extends RecyclerView.Adapter<TeacherMyCourseAdapter.ViewHolder>{
    private List<TeacherMyCourseItem> mlist;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView courseName;
        TextView courseClass;
        TextView courseTotalNum;
        TextView courseSite;
        TextView courseWeek;
        TextView courseTime;
        public ViewHolder(View view){
            super(view);
            courseName = (TextView)view.findViewById(R.id.course_name);
            courseClass = (TextView)view.findViewById(R.id.course_class);
            courseTotalNum = (TextView)view.findViewById(R.id.course_total_num);
            courseSite = (TextView)view.findViewById(R.id.course_site);
            courseWeek = (TextView)view.findViewById(R.id.course_week);
            courseTime = (TextView)view.findViewById(R.id.course_time);
        }
    }
    public TeacherMyCourseAdapter(List<TeacherMyCourseItem> list){
        mlist=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.teacher_my_course_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TeacherMyCourseItem teacherMyCourseItem = mlist.get(position);
        holder.courseName.setText(teacherMyCourseItem.getCourseName());
        holder.courseTotalNum.setText(teacherMyCourseItem.getCourseTotalNum());
        holder.courseClass.setText(teacherMyCourseItem.getCourseClass());
        holder.courseSite.setText(teacherMyCourseItem.getSite());
        holder.courseWeek.setText(teacherMyCourseItem.getWeek());
        holder.courseTime.setText(teacherMyCourseItem.getTime());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
}
