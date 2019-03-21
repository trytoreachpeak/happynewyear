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
import com.example.a.checkattendance.gsonitem.GetSingleLessonCondtion;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TeacherRealtimeTotalAttendanceAdapter
        extends RecyclerView.Adapter<TeacherRealtimeTotalAttendanceAdapter.ViewHolder> {
    private ArrayList<GetSingleLessonCondtion.Data> mchildData;
    private ModifyInnerData mmodifyInnerData;
    private int mchooseNow;
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
    public TeacherRealtimeTotalAttendanceAdapter(ArrayList<GetSingleLessonCondtion.Data> childData,int chooseNow,ModifyInnerData modifyInnerData){
        mchildData=childData;
        mchooseNow =chooseNow;
        mmodifyInnerData=modifyInnerData;
    }
    public void updateData(ArrayList<GetSingleLessonCondtion.Data> childData,int chooseNow){
        mchooseNow=chooseNow;
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
                GetSingleLessonCondtion.Data studentBean = mchildData.get(position);
                studentBean.setSstate(0);
                mmodifyInnerData.change(studentBean,0);
                mchildData.remove(position);
                notifyItemRemoved(position);
            }
        });
        holder.chooseAbsence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                GetSingleLessonCondtion.Data studentBean = mchildData.get(position);
                studentBean.setSstate(1);
                mmodifyInnerData.change(studentBean,1);
                mchildData.remove(position);
                notifyItemRemoved(position);
            }
        });
        holder.chooseLateattend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                GetSingleLessonCondtion.Data studentBean = mchildData.get(position);
                studentBean.setSstate(2);
                mmodifyInnerData.change(studentBean,2);
                mchildData.remove(position);
                notifyItemRemoved(position);
            }
        });
        holder.chooseEarlyleave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                GetSingleLessonCondtion.Data studentBean = mchildData.get(position);
                studentBean.setSstate(3);
                mmodifyInnerData.change(studentBean,3);
                mchildData.remove(position);
                notifyItemRemoved(position);
            }
        });
        holder.chooseLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                GetSingleLessonCondtion.Data studentBean = mchildData.get(position);
                studentBean.setSstate(4);
                mmodifyInnerData.change(studentBean,4);
                mchildData.remove(position);
                notifyItemRemoved(position);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetSingleLessonCondtion.Data studentBean = mchildData.get(position);
        holder.studentName.setText(studentBean.getStudentname());
        holder.studentId.setText(studentBean.getStudentid());
        switch (mchooseNow){
            case 0:
                holder.chooseAttend.setVisibility(View.GONE);
                holder.chooseAbsence.setVisibility(View.VISIBLE);
                holder.chooseLateattend.setVisibility(View.VISIBLE);
                holder.chooseEarlyleave.setVisibility(View.VISIBLE);
                holder.chooseLeave.setVisibility(View.VISIBLE);
                break;
            case 1:
                holder.chooseAttend.setVisibility(View.VISIBLE);
                holder.chooseAbsence.setVisibility(View.GONE);
                holder.chooseLateattend.setVisibility(View.VISIBLE);
                holder.chooseEarlyleave.setVisibility(View.VISIBLE);
                holder.chooseLeave.setVisibility(View.VISIBLE);
                break;
            case 2:
                holder.chooseAttend.setVisibility(View.VISIBLE);
                holder.chooseAbsence.setVisibility(View.VISIBLE);
                holder.chooseLateattend.setVisibility(View.GONE);
                holder.chooseEarlyleave.setVisibility(View.VISIBLE);
                holder.chooseLeave.setVisibility(View.VISIBLE);
                break;
            case 3:
                holder.chooseAttend.setVisibility(View.VISIBLE);
                holder.chooseAbsence.setVisibility(View.VISIBLE);
                holder.chooseLateattend.setVisibility(View.VISIBLE);
                holder.chooseEarlyleave.setVisibility(View.GONE);
                holder.chooseLeave.setVisibility(View.VISIBLE);
                break;
            case 4:
                holder.chooseAttend.setVisibility(View.VISIBLE);
                holder.chooseAbsence.setVisibility(View.VISIBLE);
                holder.chooseLateattend.setVisibility(View.VISIBLE);
                holder.chooseEarlyleave.setVisibility(View.VISIBLE);
                holder.chooseLeave.setVisibility(View.GONE);
                break;
            default:
                break;
        }
        switch(studentBean.getSstate()){
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
