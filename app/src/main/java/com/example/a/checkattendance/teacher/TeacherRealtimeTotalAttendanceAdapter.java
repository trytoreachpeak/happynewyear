package com.example.a.checkattendance.teacher;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.a.checkattendance.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TeacherRealtimeTotalAttendanceAdapter
        extends RecyclerView.Adapter<TeacherRealtimeTotalAttendanceAdapter.ViewHolder> {
    private ArrayList<StudentBean> mchildData;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView studentName;
        TextView attendanceStatus;
        TextView studentId;
        Button chooseAttend;
        Button chooseAbsence;
        Button chooseLateattend;
        Button chooseEarlyleave;
        Button chooseLeave;
        public ViewHolder(View view){
            super(view);
            studentName=(TextView)view.findViewById(R.id.student_name);
            studentId=(TextView)view.findViewById(R.id.student_id);
            attendanceStatus=(TextView)view.findViewById(R.id.attendance_status);
            chooseAttend=(Button)view.findViewById(R.id.choose_attend);
            chooseAbsence=(Button)view.findViewById(R.id.choose_absence);
            chooseLateattend=(Button)view.findViewById(R.id.choose_lateattend);
            chooseEarlyleave=(Button)view.findViewById(R.id.choose_earlyleave);
            chooseLeave=(Button)view.findViewById(R.id.choose_leave);
        }
    }
    public TeacherRealtimeTotalAttendanceAdapter(ArrayList<StudentBean> childData){
        mchildData=childData;
    }
    public void updateData(ArrayList<StudentBean> childData){
        mchildData=childData;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.realtime_attendance_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.chooseAttend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                StudentBean studentBean = mchildData.get(position);
                studentBean.setAttendanceStatus(0);
                notifyItemChanged(position);
            }
        });
        holder.chooseAbsence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                StudentBean studentBean = mchildData.get(position);
                studentBean.setAttendanceStatus(1);
                Log.d("testabc",mchildData.get(position).getAttendanceStatus()+"");
            }
        });
        holder.chooseLateattend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                StudentBean studentBean = mchildData.get(position);
                studentBean.setAttendanceStatus(2);
            }
        });
        holder.chooseEarlyleave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                StudentBean studentBean = mchildData.get(position);
                studentBean.setAttendanceStatus(3);
            }
        });
        holder.chooseLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                StudentBean studentBean = mchildData.get(position);
                studentBean.setAttendanceStatus(4);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StudentBean studentBean = mchildData.get(position);
        holder.studentName.setText(studentBean.getChildName());
        holder.studentId.setText(studentBean.getChildId());
        switch(studentBean.getAttendanceStatus()){
            case 0:
                holder.attendanceStatus.setText("出勤");
                break;
            case 1:
                holder.attendanceStatus.setText("缺勤");
                break;
            case 2:
                holder.attendanceStatus.setText("迟到");
                break;
            case 3:
                holder.attendanceStatus.setText("早退");
                break;
            case 4:
                holder.attendanceStatus.setText("请假");
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mchildData.size();
    }
}
