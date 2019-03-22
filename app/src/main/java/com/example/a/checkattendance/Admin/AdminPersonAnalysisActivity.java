package com.example.a.checkattendance.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;

public class AdminPersonAnalysisActivity extends BaseActivity implements View.OnClickListener {
    private String[] data= {"林梅","韩天","吴林","李刚","何敏","蔡茂","赵敏","钱东","孙鑫","李伟"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_person_analysis);
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

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(AdminPersonAnalysisActivity.this,android.R.layout.simple_list_item_1,data);
        final ListView listView=(ListView) findViewById(R.id.list_person);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name=data[position];
                Intent intent=new Intent(AdminPersonAnalysisActivity.this,AdminPersonalAnalysisActivity.class);
                intent.putExtra("extra_data",name);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            default:
                break;
        }
    }
}
