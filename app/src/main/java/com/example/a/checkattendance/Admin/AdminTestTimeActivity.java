package com.example.a.checkattendance.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdminTestTimeActivity extends BaseActivity implements View.OnClickListener{
    private List<Test> testList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_test_time);
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

        initclasses();
        TestAdapter adapter=new TestAdapter(AdminTestTimeActivity.this,R.layout.test_item,testList);
        ListView listview =(ListView) findViewById(R.id.list_test);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Test test=testList.get(position);

                Intent intent=new Intent(AdminTestTimeActivity.this,AdminTestSituationActivity.class);

                startActivity(intent);
            }
        });
    }


    private void initclasses(){
        for (int i=0;i<1;i++) {
            Test shuxue=new Test ("高等数学A（二）","2019-01-05 10:30-12:30");
            testList.add(shuxue);

        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            default:
                break;
        }
    }
}
