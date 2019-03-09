package com.example.a.checkattendance.student;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

            ImageView imageView_member=(ImageView)findViewById(R.id.member);
            imageView_member.setOnClickListener(this);
            Button button_back=(Button) findViewById(R.id.back) ;
            button_back.setOnClickListener(this);
            init();
            TextView textView_chatname=(TextView) findViewById(R.id.chatname);
            Intent intent = getIntent();
            String showdata = intent.getStringExtra("extra_data");
            textView_chatname.setText(showdata);

           final  Button sendBtn=(Button)findViewById(R.id.send);

           final  Button b_more=(Button)findViewById(R.id.more);
           final EditText inputText=(EditText)findViewById(R.id.input);


           inputText.setOnClickListener(this);


            inputText.addTextChangedListener(new TextWatcher() {
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    String serch_textip=inputText.getText().toString().trim();
                    if(!serch_textip.isEmpty())                                  //判断IP输入框是否为空
                    {sendBtn.setVisibility(View.VISIBLE);
                        b_more.setVisibility(View.GONE); }
                    else if(serch_textip.isEmpty())                                  //判断IP输入框是否为空
                    {sendBtn.setVisibility(View.GONE);
                        b_more.setVisibility(View.VISIBLE); }
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count,int after) {

                }

                @Override
                public void afterTextChanged(Editable s) {


                }
            });








            final RecyclerView msgRecyclerView=(RecyclerView)findViewById(R.id.msg);
            msgRecyclerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hideSoftKeyboard(StudentChatingActivity.this);
                    finish();
                }
            });

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
                case R.id.member:
                    Intent intent1 = new Intent(StudentChatingActivity.this, StudentChatmemberActivity.class);
                    startActivity(intent1);
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

        }


        public static void hideSoftKeyboard(Activity activity) {
              InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
              inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
             }
    }