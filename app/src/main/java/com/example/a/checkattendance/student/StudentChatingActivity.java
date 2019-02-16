package com.example.a.checkattendance.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;

import java.util.ArrayList;
import java.util.List;


    public class StudentChatingActivity extends BaseActivity implements View.OnClickListener{

        private List<Msg> msgList = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_student_chating);

            Button button_back=(Button) findViewById(R.id.back) ;
            button_back.setOnClickListener(this);
            init();
            TextView textView_chatname=(TextView) findViewById(R.id.chatname);
            Intent intent = getIntent();
            String showdata = intent.getStringExtra("extra_data");
            textView_chatname.setText(showdata);

            final EditText inputText=(EditText)findViewById(R.id.input);
            Button sendBtn=(Button)findViewById(R.id.send);

            final RecyclerView msgRecyclerView=(RecyclerView)findViewById(R.id.msg);
            LinearLayoutManager layoutManager=new LinearLayoutManager(this);
            msgRecyclerView.setLayoutManager(layoutManager);

            final MsgAdapter adapter=new MsgAdapter(msgList);
            msgRecyclerView.setAdapter(adapter);

            sendBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String content=inputText.getText().toString();
                    if("".equals(content))
                        return;

                    msgList.add(new Msg(content, Msg.TYPE.SENT));

                    //如果有新消息，则设置适配器的长度（通知适配器，有新的数据被插入），并让 RecyclerView 定位到最后一行
                    int newSize = msgList.size() - 1;
                    adapter.notifyItemInserted(newSize);
                    msgRecyclerView.scrollToPosition(newSize);

                    //清空输入框中的内容
                    inputText.setText("");


                }
            });

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


        /**
         * 初始化消息数据
         */
        private void init() {
            msgList.add(new Msg("你好", Msg.TYPE.RECEIVED));
            msgList.add(new Msg("你好，请问你是？", Msg.TYPE.SENT));
            msgList.add(new Msg("我是 deniro，很高兴认识你^_^", Msg.TYPE.RECEIVED));
        }
    }