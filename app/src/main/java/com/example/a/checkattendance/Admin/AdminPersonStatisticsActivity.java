package com.example.a.checkattendance.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;

public class AdminPersonStatisticsActivity extends BaseActivity implements View.OnClickListener{

    private String[] data= {"林梅","韩天","吴林"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_person_statistics);
        Button button_back=(Button)findViewById(R.id.back);
        button_back.setOnClickListener(this);

        ArrayAdapter<String>adapter =new ArrayAdapter<String>(AdminPersonStatisticsActivity.this,android.R.layout.simple_list_item_1,data);
        final ListView listView=(ListView) findViewById(R.id.list_person);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name=data[position];
                Intent intent=new Intent(AdminPersonStatisticsActivity.this,AdminPersonalStatisticsActivity.class);
                intent.putExtra("extra_data",name);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            default:
                break;
        }
    }

}
