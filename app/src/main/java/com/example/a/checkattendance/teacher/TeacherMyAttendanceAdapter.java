package com.example.a.checkattendance.teacher;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a.checkattendance.R;

import org.w3c.dom.Text;

import java.util.List;

public class TeacherMyAttendanceAdapter extends
        RecyclerView.Adapter<TeacherMyAttendanceAdapter.ViewHolder> {
    private List<TeacherMyAttendanceItem> mList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView dateTime;
        TextView weekText;
        TextView attendanceStatus;
        public ViewHolder(View view){
            super(view);
            dateTime = (TextView)view.findViewById(R.id.datetime);
            weekText = (TextView)view.findViewById(R.id.week_text);
            attendanceStatus = (TextView)view.findViewById(R.id.attendance_status);
        }
    }
    public TeacherMyAttendanceAdapter(List<TeacherMyAttendanceItem> list){
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.teacher_my_attendance_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TeacherMyAttendanceItem teacherMyAttendanceItem = mList.get(position);
        holder.dateTime.setText(teacherMyAttendanceItem.getDateTime());
        holder.weekText.setText(teacherMyAttendanceItem.getWeek());
        if(teacherMyAttendanceItem.getAttendanceStatus()==0){
            holder.attendanceStatus.setText("出勤");
        }
        else if(teacherMyAttendanceItem.getAttendanceStatus()==1){
            holder.attendanceStatus.setText("缺勤");
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
