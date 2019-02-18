package com.example.a.checkattendance.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;
import com.example.a.checkattendance.student.Chat;
import com.example.a.checkattendance.student.ChatAdapter;
import com.example.a.checkattendance.student.StudentChatingActivity;

import java.util.ArrayList;
import java.util.List;

public class AdminTestclassroomActivity extends BaseActivity implements View.OnClickListener{

    private List<Floor> floorList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_testclassroom);
        Button button_back=(Button)findViewById(R.id.back);
        button_back.setOnClickListener(this);


        initclasses();
        FloorAdapter adapter=new FloorAdapter(AdminTestclassroomActivity.this,R.layout.floor_item,floorList);
        ListView listview =(ListView) findViewById(R.id.list_floor);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Floor floor=floorList.get(position);
                String data=floor.getName();
                Intent intent=new Intent(AdminTestclassroomActivity.this,AdminTestTimeActivity.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);
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
