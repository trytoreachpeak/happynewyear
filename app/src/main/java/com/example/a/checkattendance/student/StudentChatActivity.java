package com.example.a.checkattendance.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.a.checkattendance.R;

import java.util.ArrayList;
import java.util.List;

    public class StudentChatActivity extends BaseActivity implements View.OnClickListener{
        private List<Chat> chatList=new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_student_chat);
            Button button_back=(Button) findViewById(R.id.back) ;
            button_back.setOnClickListener(this);

            initclasses();
            ChatAdapter adapter=new ChatAdapter(StudentChatActivity.this,R.layout.chat_item,chatList);
            ListView listview =(ListView) findViewById(R.id.list_chat);
            listview.setAdapter(adapter);

            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Chat chat=chatList.get(position);
                    String data=chat.getName();
                    Intent intent=new Intent(StudentChatActivity.this,StudentChatingActivity.class);
                    intent.putExtra("extra_data",data);
                    startActivity(intent);
                }
            });

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
                case R.id.back:
                    finish();
                    break;
                default:
                    break;
            }
        }

    }