package com.example.a.checkattendance.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;

import java.util.ArrayList;
import java.util.List;

public class AdminClassuseActivity extends BaseActivity implements View.OnClickListener {


    private List<Floor> floorList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_classuse);
        Button button_back=(Button)findViewById(R.id.back);
        button_back.setOnClickListener(this);


        initclasses();
        FloorAdapter adapter=new FloorAdapter(AdminClassuseActivity.this,R.layout.floor_item,floorList);
        ListView listview =(ListView) findViewById(R.id.list_floor);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Floor floor=floorList.get(position);
                String data=floor.getName();
                Toast.makeText(AdminClassuseActivity.this, "当前点击的是：："+floor.getName(), Toast.LENGTH_SHORT).show();


            }
        });
    }

    private void initclasses(){
        for (int i=0;i<1;i++) {
            Floor shuxue=new Floor ("8号楼301");
            floorList.add(shuxue);
            Floor yingyu=new Floor ("6号楼212");
            floorList.add(yingyu);
        }
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