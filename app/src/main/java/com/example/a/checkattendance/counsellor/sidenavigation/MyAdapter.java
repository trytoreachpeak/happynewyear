package com.example.a.checkattendance.counsellor.sidenavigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.example.a.checkattendance.R;

import java.util.List;

public class MyAdapter extends BaseAdapter implements SectionIndexer {
    private List<User> list;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_item, null);
            holder = new ViewHolder();
            holder.showLetter = (TextView) convertView.findViewById(R.id.show_letter);
            holder.username = (TextView) convertView.findViewById(R.id.username);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        User user = list.get(position);
        holder.username.setText(user.getUsername());
        //获得当前position是属于哪个分组
        int sectionForPosition = getSectionForPosition(position);
        //获得该分组第一项的position
        int positionForSection = getPositionForSection(sectionForPosition);

        //查看当前position是不是当前item所在分组的第一个item
        //如果是，则显示showLetter，否则隐藏
        if (position == positionForSection) {
            holder.showLetter.setVisibility(View.VISIBLE);
            holder.showLetter.setText(user.getFirstLetter());
        } else {
            holder.showLetter.setVisibility(View.GONE);
        }
        return convertView;
    }

    @Override
    public Object[] getSections() {
        return new Object[0];
    }

    //传入一个分组值[A....Z],获得该分组的第一项的position
    @Override
    public int getPositionForSection(int sectionIndex) {

        if (list!=null && list.size()>0) {

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getFirstLetter().charAt(0) == sectionIndex) {
                    return i;
                }
            }

        }
        return -1;
    }

    //传入一个position，获得该position所在的分组
    @Override
    public int getSectionForPosition(int position) {
        if (list!=null && list.size()>0) {
            return list.get(position).getFirstLetter().charAt(0);
        }
        return 0;
    }

    class ViewHolder {
        TextView username, showLetter;
    }
}
