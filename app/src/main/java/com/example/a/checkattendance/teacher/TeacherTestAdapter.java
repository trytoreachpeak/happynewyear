package com.example.a.checkattendance.teacher;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a.checkattendance.R;

import org.w3c.dom.Text;

import java.util.List;

public class TeacherTestAdapter
        extends RecyclerView.Adapter<TeacherTestAdapter.ViewHolder> {
    private List<TeacherTestItem> mList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView testName;
        TextView testFormat;
        TextView testReleaseTime;
        TextView testDeadline;
        TextView hasCompleted;
        TextView notCompleted;
        View testView;
        public ViewHolder(View view){
            super(view);
            testView = view;
            testName = (TextView)view.findViewById(R.id.test_name);
            testFormat = (TextView)view.findViewById(R.id.test_format);
            testReleaseTime = (TextView)view.findViewById(R.id.test_release_time);
            testDeadline = (TextView)view.findViewById(R.id.test_deadline);
            hasCompleted = (TextView)view.findViewById(R.id.has_completed);
            notCompleted = (TextView)view.findViewById(R.id.not_completed);
        }
    }
    public TeacherTestAdapter(List <TeacherTestItem> list){
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teacher_test_item,
                parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.testView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                TeacherTestItem item = mList.get(position);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TeacherTestItem item = mList.get(position);
        holder.testName.setText(item.getTestName());
        holder.testFormat.setText(item.getTestFormat());
        holder.testReleaseTime.setText(item.getTestReleaseTime());
        holder.testDeadline.setText(item.getTestDeadline());
        holder.hasCompleted.setText(item.getHasCompleted()+"人");
        holder.notCompleted.setText(item.getNotCompleted()+"人");
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
