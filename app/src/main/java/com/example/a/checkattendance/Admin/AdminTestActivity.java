package com.example.a.checkattendance.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;

public class AdminTestActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_test);
        LinearLayout l_score=(LinearLayout)findViewById(R.id.score);
        l_score.setOnClickListener(this);
        LinearLayout l_room=(LinearLayout)findViewById(R.id.testroom);
        l_room.setOnClickListener(this);
        Button button_back=(Button)findViewById(R.id.back);
        button_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.score:
                intent = new Intent(AdminTestActivity.this,AdminTestScoreActivity.class);
                startActivity(intent);
                break;
            case R.id.testroom:
                intent = new Intent(AdminTestActivity.this,AdminTestclassroomActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
