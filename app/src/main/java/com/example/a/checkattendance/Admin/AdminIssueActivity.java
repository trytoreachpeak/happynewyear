package com.example.a.checkattendance.Admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a.checkattendance.R;

public class AdminIssueActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_issue);
        Button button_back=(Button)findViewById(R.id.back);
        button_back.setOnClickListener(this);
        Button button_issue=(Button)findViewById(R.id.issue);
        button_issue.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.issue:
                finish();
                break;
            default:
                break;
        }
    }
}
