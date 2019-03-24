package com.example.a.checkattendance.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.a.checkattendance.ActivityCollector;
import com.example.a.checkattendance.ActivityLogin;
import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;

public class AdminInformationActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_information);


        Button b_exit=(Button)findViewById(R.id.exit);
        b_exit.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void onClick(View v){
        switch(v.getId()){

            case R.id.exit:
                ActivityCollector.finishAll();
                Intent intent = new Intent(this, ActivityLogin.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}
