package com.example.a.checkattendance.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.student.Chat;
import com.example.a.checkattendance.student.ChatAdapter;
import com.example.a.checkattendance.student.StudentChatingActivity;

import java.util.ArrayList;
import java.util.List;

public class AdminChatFragment extends Fragment implements View.OnClickListener{
    private List<Chat> chatList=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.admin_chat_fragment, container, false);

        initclasses();
        ChatAdapter adapter=new ChatAdapter(getActivity(),R.layout.chat_item,chatList);
        ListView listview =(ListView) view.findViewById(R.id.list_chat);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Chat chat=chatList.get(position);
                String data=chat.getName();
                Intent intent=new Intent(getActivity(),StudentChatingActivity.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);
            }
        });

        return view;

    }

    private void initclasses(){
        for (int i=0;i<1;i++) {
            Chat shuxue=new Chat ("小红",R.drawable.kecheng);
            chatList.add(shuxue);
            Chat yingyu=new Chat ("小明",R.drawable.kecheng);
            chatList.add(yingyu);
        }
    }
    @Override
    public void onClick(View v){
        switch(v.getId()){
            default:
                break;
        }
    }

}