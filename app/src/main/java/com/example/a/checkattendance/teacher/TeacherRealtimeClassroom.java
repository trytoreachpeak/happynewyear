package com.example.a.checkattendance.teacher;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a.checkattendance.ActivityLogin;
import com.example.a.checkattendance.HttpUtil;
import com.example.a.checkattendance.Loading_view;
import com.example.a.checkattendance.R;
import com.example.a.checkattendance.gsonitem.GetSingleLessonCondtion;
import com.example.a.checkattendance.gsonitem.LoginStudent;
import com.example.a.checkattendance.gsonitem.ManagerGetAllStudentAttendance;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class TeacherRealtimeClassroom extends AppCompatActivity implements View.OnClickListener{
    private Spinner spinner;
    private NestedExpandableListView  expendList;
    String[] str = {"第1节课", "第2节课","汇总"};
    public static ArrayList<GetSingleLessonCondtion.Data> firstlessonData;
    public static ArrayList<GetSingleLessonCondtion.Data> secondlessonData;
    private   ArrayList<ClassBean> firstparentData;
    public  static ArrayList<ArrayList<GetSingleLessonCondtion.Data>> firstchildData;
    private   ArrayList<ClassBean> secondparentData;
    public static ArrayList<ArrayList<GetSingleLessonCondtion.Data>> secondchildData ;
    private   ArrayList<ClassBean> mergedparentData;
    public static ArrayList<ArrayList<GetSingleLessonCondtion.Data>> mergedchildData;

    private int attendnum;
    private int attednlatenum;
    private int absencenum;
    private int leavenum;
    private int totalStudentNum;
    private ArrayAdapter<String> arrayAdapter;
    private Button check;
    private TextView totalNum;
    private TextView attendanceCondition;
    private TextView title;
    private TextView nowStatus;
    private TextView time;
    private TextView nowProgress;
    private Button update;
    private Loading_view loading;
    public static void initOutside(){
        firstlessonData= new ArrayList<>();
        secondlessonData= new ArrayList<>();
        initFakeData();
    }
    public static void actionStart(Context context, String title,String status,String time,String progress){
        Intent intent = new Intent(context,TeacherRealtimeClassroom.class);
        intent.putExtra("title",title);
        intent.putExtra("status",status);
        intent.putExtra("time",time);
        intent.putExtra("progress",progress);
        context.startActivity(intent);
    }
    public void loding(View v){//点击加载并按钮模仿网络请求
        loading = new Loading_view(this,R.style.CustomDialog);
        loading.show();
        new Handler().postDelayed(new Runnable() {//定义延时任务模仿网络请求
            @Override
            public void run() {
                loading.dismiss();//3秒后调用关闭加载的方法
                Toast toast = Toast.makeText(TeacherRealtimeClassroom.this, null, Toast.LENGTH_SHORT);
                toast.setText("更新成功");
                toast.show();
            }
        }, 3000);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_realtime_classroom);

        title=(TextView)findViewById(R.id.title);
        nowStatus=(TextView)findViewById(R.id.now_status);
        time=(TextView)findViewById(R.id.time);
        nowProgress=(TextView)findViewById(R.id.now_progress);

        Intent intent = getIntent();
        title.setText(intent.getStringExtra("title"));
        nowStatus.setText(intent.getStringExtra("status"));
        time.setText(intent.getStringExtra("time"));
        nowProgress.setText(intent.getStringExtra("progress"));
        firstlessonData= new ArrayList<>();
        secondlessonData= new ArrayList<>();
        firstparentData = new ArrayList<>();;
        firstchildData = new ArrayList<>();
        secondparentData = new ArrayList<>();
        secondchildData = new ArrayList<>();
        mergedparentData = new ArrayList<>();
        mergedchildData = new ArrayList<>();
            initFakeData();
//        initRealData();
        initbasicData();
        initFirstLessonData();
        initSecondLessonData();
        initMergedData();

        totalNum= (TextView)findViewById(R.id.total_num);
        attendanceCondition=(TextView)findViewById(R.id.attendance_condition);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(totalStudentNum).append("人");
        totalNum.setText(stringBuilder.toString());
        stringBuilder= new StringBuilder();
        stringBuilder.append("出勤").append(attendnum).append(" 迟到").append(attednlatenum)
                .append(" 缺勤").append(absencenum).append(" 请假").append(leavenum);
        attendanceCondition.setText(stringBuilder.toString());

        spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setDropDownHorizontalOffset(100); //下拉的横向偏移
        spinner.setDropDownVerticalOffset(50);
        arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.drop_item, str);
        spinner.setAdapter(arrayAdapter);
        //spinner添加数据
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = parent.getItemAtPosition(position).toString();
                TeacherExtendableListViewAdapter teacherExtendableListViewAdapter;
                switch (position){
                    case 0:
                        teacherExtendableListViewAdapter = new TeacherExtendableListViewAdapter();
                        teacherExtendableListViewAdapter.parentData = firstparentData;
                        teacherExtendableListViewAdapter.childData = firstchildData;
                        expendList.setAdapter(teacherExtendableListViewAdapter);
                        break;
                    case 1:
                        teacherExtendableListViewAdapter = new TeacherExtendableListViewAdapter();
                        teacherExtendableListViewAdapter.parentData = secondparentData;
                        teacherExtendableListViewAdapter.childData = secondchildData;
                        expendList.setAdapter(teacherExtendableListViewAdapter);
                        break;
                    case 2:
                        teacherExtendableListViewAdapter = new TeacherExtendableListViewAdapter();
                        teacherExtendableListViewAdapter.parentData = mergedparentData;
                        teacherExtendableListViewAdapter.childData = mergedchildData;
                        expendList.setAdapter(teacherExtendableListViewAdapter);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
           });
        expendList=(NestedExpandableListView)findViewById(R.id.expend_list);
        TeacherExtendableListViewAdapter teacherExtendableListViewAdapter = new TeacherExtendableListViewAdapter();
        teacherExtendableListViewAdapter.parentData = firstparentData;
        teacherExtendableListViewAdapter.childData = firstchildData;
        expendList.setAdapter(teacherExtendableListViewAdapter);
        expendList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                //Toast.makeText(getApplicationContext(), groupString[groupPosition], Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        expendList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //Toast.makeText(getApplicationContext(), childString[groupPosition][childPosition], Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        check =(Button)findViewById(R.id.check);
        check.setOnClickListener(this);
        update = (Button)findViewById(R.id.update);
        update.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.check:
                Intent intent = new Intent(TeacherRealtimeClassroom.this,
                        TeacherRealtimeTotalAttendance.class);
                intent.putExtra("title","操作系统");
                //Bundle args = new Bundle();
                //args.putSerializable("ARRAYLIST",(Serializable)firstchildData);
                //intent.putExtra("BUNDLE",args);
                startActivity(intent);
                break;
            case R.id.update:
                loding(v);
                break;
            default:
                break;
        }
    }
    private void initbasicData(){
        for(GetSingleLessonCondtion.Data data:secondlessonData){
            if(data.getSstate()==0){
                attendnum++;
            }
            else if(data.getSstate()==1){
                absencenum++;
            }
            else if(data.getSstate()==2){
                attednlatenum++;
            }
            else if(data.getSstate()==4){
                leavenum++;
            }
            totalStudentNum++;
        }
    }
    private void initFirstLessonData(){
        List<String> className = new ArrayList<>();
        List<Integer> totalNum = new ArrayList<>();
        List<Integer> realAttendNum = new ArrayList<>();
        for(GetSingleLessonCondtion.Data data:firstlessonData){
            if(!className.contains(data.getStudentclass())){
                className.add(data.getStudentclass());
            }
        }
        for(String str:className){
            int total=0;
            int realAttend=0;
            ArrayList<GetSingleLessonCondtion.Data> temp = new ArrayList<>();
            for(GetSingleLessonCondtion.Data data:firstlessonData){
                if(data.getStudentclass().equals(str)){
                    if(data.getSstate()==0
                            ||data.getSstate()==2
                            ||data.getSstate()==3){
                        realAttend++;
                        temp.add(data);
                    }
                    total++;
                }
            }
            totalNum.add(total);
            realAttendNum.add(realAttend);
            total=0;
            realAttend=0;
            firstchildData.add(temp);
        }
        for(int i=0;i<className.size();i++){
            ClassBean classBean = new ClassBean();
            classBean.setGroupClass(className.get(i));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(realAttendNum.get(i)).append("/").append(totalNum.get(i));
            classBean.setGroupNum(stringBuilder.toString());
            firstparentData.add(classBean);
        }
    }
    private void initSecondLessonData(){
        List<String> className = new ArrayList<>();
        List<Integer> totalNum = new ArrayList<>();
        List<Integer> realAttendNum = new ArrayList<>();
        for(GetSingleLessonCondtion.Data data:secondlessonData){
            if(!className.contains(data.getStudentclass())){
                className.add(data.getStudentclass());
            }
        }
        for(String str:className){
            int total=0;
            int realAttend=0;
            ArrayList<GetSingleLessonCondtion.Data> temp = new ArrayList<>();
            for(GetSingleLessonCondtion.Data data:secondlessonData){
                if(data.getStudentclass().equals(str)){
                    if(data.getSstate()==0
                            ||data.getSstate()==2
                            ||data.getSstate()==3){
                        realAttend++;
                        temp.add(data);
                    }
                    total++;
                }
            }
            totalNum.add(total);
            realAttendNum.add(realAttend);
            total=0;
            realAttend=0;
            secondchildData.add(temp);
        }
        for(int i=0;i<className.size();i++){
            ClassBean classBean = new ClassBean();
            classBean.setGroupClass(className.get(i));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(realAttendNum.get(i)).append("/").append(totalNum.get(i));
            classBean.setGroupNum(stringBuilder.toString());
            secondparentData.add(classBean);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_1:
                Intent intent = new Intent(TeacherRealtimeClassroom.this,TeacherRealtimeChart.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void initMergedData(){
        List<String> className = new ArrayList<>();
        List<Integer> totalNum = new ArrayList<>();
        ArrayList<GetSingleLessonCondtion.Data> temp;
        for(ArrayList<GetSingleLessonCondtion.Data> array:firstchildData){
            temp=new ArrayList<>();
            for(GetSingleLessonCondtion.Data data:array){
                temp.add(data);
            }
            mergedchildData.add(temp);
        }
        int count=0;
        for(int i =0;i<secondchildData.size();i++){
            for(int j=0;j<secondchildData.get(i).size();j++){
                for(int k=0;k<mergedchildData.get(i).size();k++){
                    if((mergedchildData.get(i).get(k).getStudentid()
                            .equals(secondchildData.get(i).get(j).getStudentid()))
                            &&(secondchildData.get(i).get(j).getSstate()!=1||secondchildData.get(i).get(j).getSstate()!=4)){
                        count++;
                    }
                }
                if(count==0)
                    mergedchildData.get(i).add(secondchildData.get(i).get(j));
                else count=0;
            }
        }
        for(GetSingleLessonCondtion.Data data:secondlessonData){
            if(!className.contains(data.getStudentclass())){
                className.add(data.getStudentclass());
            }
        }
        for(String str:className){
            int total=0;
            for(GetSingleLessonCondtion.Data data:secondlessonData){
                if(data.getStudentclass().equals(str)){
                    total++;
                }
            }
            totalNum.add(total);
            total=0;

        }
        for(int i=0;i<mergedchildData.size();i++){
            ClassBean classBean = new ClassBean();
            classBean.setGroupClass(className.get(i));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(mergedchildData.get(i).size()).append("/").append(totalNum.get(i));
            classBean.setGroupNum(stringBuilder.toString());
            mergedparentData.add(classBean);
        }

    }
    public static void initFakeData(){
//        GetSingleLessonCondtion.Data data1 =new GetSingleLessonCondtion.Data();
//        data1.setStudentname("杨玥");
//        data1.setStudentid("1001");
//        data1.setStudentclass("计161");
//        data1.setSstate(0);
//        data1.setSseriousnum(23);
//        data1.setSlazynum(1);
//        data1.setSsleepnum(0);
//        data1.setIsserious(1);
//        data1.setIssleep(0);
//        data1.setIslazy(0);
//        firstlessonData.add(data1);
//        GetSingleLessonCondtion.Data data2 =new GetSingleLessonCondtion.Data();
//        data2.setStudentname("蔡周宇");
//        data2.setStudentid("1002");
//        data2.setStudentclass("计161");
//        data2.setSstate(1);
//        data2.setSseriousnum(0);
//        data2.setSlazynum(0);
//        data2.setSsleepnum(0);
//        data2.setIsserious(0);
//        data2.setIssleep(0);
//        data2.setIslazy(0);
//        firstlessonData.add(data2);
//        GetSingleLessonCondtion.Data data3 =new GetSingleLessonCondtion.Data();
//        data3.setStudentname("吴俊瑶");
//        data3.setStudentid("1003");
//        data3.setStudentclass("计162");
//        data3.setSstate(2);
//        data3.setSseriousnum(12);
//        data3.setSlazynum(10);
//        data3.setSsleepnum(1);
//        data3.setIsserious(0);
//        data3.setIssleep(0);
//        data3.setIslazy(3);
//        firstlessonData.add(data3);
//        GetSingleLessonCondtion.Data data4 =new GetSingleLessonCondtion.Data();
//        data4.setStudentname("刘琦");
//        data4.setStudentid("1004");
//        data4.setStudentclass("计162");
//        data4.setSstate(3);
//        data4.setSseriousnum(2);
//        data4.setSlazynum(10);
//        data4.setSsleepnum(10);
//        data4.setIsserious(0);
//        data4.setIssleep(2);
//        data4.setIslazy(0);
//        firstlessonData.add(data4);
//        GetSingleLessonCondtion.Data data5 =new GetSingleLessonCondtion.Data();
//        data5.setStudentname("邵正宇");
//        data5.setStudentid("1005");
//        data5.setStudentclass("计162");
//        data5.setSstate(4);
//        data5.setSseriousnum(0);
//        data5.setSlazynum(0);
//        data5.setSsleepnum(0);
//        data5.setIsserious(0);
//        data5.setIssleep(0);
//        data5.setIslazy(0);
//        firstlessonData.add(data5);
//        GetSingleLessonCondtion.Data data6 =new GetSingleLessonCondtion.Data();
//        data6.setStudentname("杨玥");
//        data6.setStudentid("1001");
//        data6.setStudentclass("计161");
//        data6.setSstate(0);
//        data6.setSseriousnum(21);
//        data6.setSlazynum(1);
//        data6.setSsleepnum(1);
//        data6.setIsserious(1);
//        data6.setIssleep(0);
//        data6.setIslazy(0);
//        secondlessonData.add(data6);
//        GetSingleLessonCondtion.Data data7 =new GetSingleLessonCondtion.Data();
//        data7.setStudentname("蔡周宇");
//        data7.setStudentid("1002");
//        data7.setStudentclass("计161");
//        data7.setSstate(0);
//        data7.setSseriousnum(21);
//        data7.setSlazynum(1);
//        data7.setSsleepnum(1);
//        data7.setIsserious(1);
//        data7.setIssleep(0);
//        data7.setIslazy(0);
//        secondlessonData.add(data7);
//        GetSingleLessonCondtion.Data data8 =new GetSingleLessonCondtion.Data();
//        data8.setStudentname("吴俊瑶");
//        data8.setStudentid("1003");
//        data8.setStudentclass("计162");
//        data8.setSstate(0);
//        data8.setSseriousnum(21);
//        data8.setSlazynum(1);
//        data8.setSsleepnum(1);
//        data8.setIsserious(1);
//        data8.setIssleep(0);
//        data8.setIslazy(0);
//        secondlessonData.add(data8);
//        GetSingleLessonCondtion.Data data9 =new GetSingleLessonCondtion.Data();
//        data9.setStudentname("刘琦");
//        data9.setStudentid("1004");
//        data9.setStudentclass("计162");
//        data9.setSstate(3);
//        data9.setSseriousnum(0);
//        data9.setSlazynum(15);
//        data9.setSsleepnum(10);
//        data9.setIsserious(0);
//        data9.setIssleep(2);
//        data9.setIslazy(0);
//        secondlessonData.add(data9);
//        GetSingleLessonCondtion.Data data10 =new GetSingleLessonCondtion.Data();
//        data10.setStudentname("邵正宇");
//        data10.setStudentid("1005");
//        data10.setStudentclass("计162");
//        data10.setSstate(0);
//        data10.setSseriousnum(150);
//        data10.setSlazynum(0);
//        data10.setSsleepnum(0);
//        data10.setIsserious(1);
//        data10.setIssleep(0);
//        data10.setIslazy(0);
//        secondlessonData.add(data10);
        GetSingleLessonCondtion.Data data1 =new GetSingleLessonCondtion.Data();
        data1.setStudentname("邵正宇");
        data1.setStudentid("1613022001");
        data1.setStudentclass("计161");
        data1.setSstate(0);
        data1.setSseriousnum(0);
        data1.setSlazynum(4);
        data1.setSsleepnum(0);
        data1.setIsserious(0);
        data1.setIssleep(0);
        data1.setIslazy(3);
        firstlessonData.add(data1);
        secondlessonData.add(data1);
        GetSingleLessonCondtion.Data data2 =new GetSingleLessonCondtion.Data();
        data2.setStudentname("蔡周宇");
        data2.setStudentid("1613022002");
        data2.setStudentclass("计161");
        data2.setSstate(1);
        data2.setSseriousnum(0);
        data2.setSlazynum(0);
        data2.setSsleepnum(0);
        data2.setIsserious(0);
        data2.setIssleep(0);
        data2.setIslazy(0);
        firstlessonData.add(data2);
        secondlessonData.add(data2);
        GetSingleLessonCondtion.Data data3 =new GetSingleLessonCondtion.Data();
        data3.setStudentname("吴俊瑶");
        data3.setStudentid("1613022003");
        data3.setStudentclass("计161");
        data3.setSstate(1);
        data3.setSseriousnum(0);
        data3.setSlazynum(0);
        data3.setSsleepnum(0);
        data3.setIsserious(0);
        data3.setIssleep(0);
        data3.setIslazy(0);
        firstlessonData.add(data3);
        secondlessonData.add(data3);
        GetSingleLessonCondtion.Data data4 =new GetSingleLessonCondtion.Data();
        data4.setStudentname("李悦");
        data4.setStudentid("1613022004");
        data4.setStudentclass("计161");
        data4.setSstate(0);
        data4.setSseriousnum(4);
        data4.setSlazynum(0);
        data4.setSsleepnum(0);
        data4.setIsserious(1);
        data4.setIssleep(0);
        data4.setIslazy(0);
        firstlessonData.add(data4);
        secondlessonData.add(data4);
        GetSingleLessonCondtion.Data data5 =new GetSingleLessonCondtion.Data();
        data5.setStudentname("张洁");
        data5.setStudentid("1613022005");
        data5.setStudentclass("计161");
        data5.setSstate(0);
        data5.setSseriousnum(0);
        data5.setSlazynum(4);
        data5.setSsleepnum(0);
        data5.setIsserious(0);
        data5.setIssleep(0);
        data5.setIslazy(3);
        firstlessonData.add(data5);
        secondlessonData.add(data5);
        GetSingleLessonCondtion.Data data6 =new GetSingleLessonCondtion.Data();
        data6.setStudentname("付军");
        data6.setStudentid("1613022007");
        data6.setStudentclass("计161");
        data6.setSstate(0);
        data6.setSseriousnum(4);
        data6.setSlazynum(0);
        data6.setSsleepnum(0);
        data6.setIsserious(1);
        data6.setIssleep(0);
        data6.setIslazy(0);
        firstlessonData.add(data6);
        secondlessonData.add(data6);
        GetSingleLessonCondtion.Data data7 =new GetSingleLessonCondtion.Data();
        data7.setStudentname("杨玥");
        data7.setStudentid("1613022008");
        data7.setStudentclass("计161");
        data7.setSstate(0);
        data7.setSseriousnum(0);
        data7.setSlazynum(4);
        data7.setSsleepnum(0);
        data7.setIsserious(0);
        data7.setIssleep(0);
        data7.setIslazy(3);
        firstlessonData.add(data7);
        secondlessonData.add(data7);
        GetSingleLessonCondtion.Data data9 =new GetSingleLessonCondtion.Data();
        data9.setStudentname("刘琦");
        data9.setStudentid("1613022009");
        data9.setStudentclass("计161");
        data9.setSstate(0);
        data9.setSseriousnum(0);
        data9.setSlazynum(4);
        data9.setSsleepnum(0);
        data9.setIsserious(0);
        data9.setIssleep(0);
        data9.setIslazy(3);
        firstlessonData.add(data9);
        secondlessonData.add(data9);
        GetSingleLessonCondtion.Data data10 =new GetSingleLessonCondtion.Data();
        data10.setStudentname("张童");
        data10.setStudentid("1613022010");
        data10.setStudentclass("计161");
        data10.setSstate(0);
        data10.setSseriousnum(0);
        data10.setSlazynum(4);
        data10.setSsleepnum(0);
        data10.setIsserious(0);
        data10.setIssleep(0);
        data10.setIslazy(3);
        firstlessonData.add(data10);
        secondlessonData.add(data10);
        GetSingleLessonCondtion.Data data11 =new GetSingleLessonCondtion.Data();
        data11.setStudentname("沈悦");
        data11.setStudentid("1613022011");
        data11.setStudentclass("计161");
        data11.setSstate(0);
        data11.setSseriousnum(0);
        data11.setSlazynum(4);
        data11.setSsleepnum(0);
        data11.setIsserious(0);
        data11.setIssleep(0);
        data11.setIslazy(3);
        firstlessonData.add(data11);
        secondlessonData.add(data11);
        GetSingleLessonCondtion.Data data12 =new GetSingleLessonCondtion.Data();
        data12.setStudentname("杨光");
        data12.setStudentid("1613022012");
        data12.setStudentclass("计161");
        data12.setSstate(0);
        data12.setSseriousnum(0);
        data12.setSlazynum(4);
        data12.setSsleepnum(0);
        data12.setIsserious(0);
        data12.setIssleep(0);
        data12.setIslazy(3);
        firstlessonData.add(data12);
        secondlessonData.add(data12);
        GetSingleLessonCondtion.Data data13 =new GetSingleLessonCondtion.Data();
        data13.setStudentname("何宝");
        data13.setStudentid("1613022013");
        data13.setStudentclass("计161");
        data13.setSstate(0);
        data13.setSseriousnum(4);
        data13.setSlazynum(0);
        data13.setSsleepnum(0);
        data13.setIsserious(1);
        data13.setIssleep(0);
        data13.setIslazy(0);
        firstlessonData.add(data13);
        secondlessonData.add(data13);
        GetSingleLessonCondtion.Data data14 =new GetSingleLessonCondtion.Data();
        data14.setStudentname("刘军");
        data14.setStudentid("1613022014");
        data14.setStudentclass("计161");
        data14.setSstate(0);
        data14.setSseriousnum(0);
        data14.setSlazynum(4);
        data14.setSsleepnum(0);
        data14.setIsserious(0);
        data14.setIssleep(0);
        data14.setIslazy(3);
        firstlessonData.add(data14);
        secondlessonData.add(data14);
        GetSingleLessonCondtion.Data data15 =new GetSingleLessonCondtion.Data();
        data15.setStudentname("杨东海");
        data15.setStudentid("1613022015");
        data15.setStudentclass("计161");
        data15.setSstate(1);
        data15.setSseriousnum(0);
        data15.setSlazynum(0);
        data15.setSsleepnum(0);
        data15.setIsserious(0);
        data15.setIssleep(0);
        data15.setIslazy(0);
        firstlessonData.add(data15);
        secondlessonData.add(data15);
        GetSingleLessonCondtion.Data data16 =new GetSingleLessonCondtion.Data();
        data16.setStudentname("徐东");
        data16.setStudentid("1613022016");
        data16.setStudentclass("计161");
        data16.setSstate(1);
        data16.setSseriousnum(0);
        data16.setSlazynum(0);
        data16.setSsleepnum(0);
        data16.setIsserious(0);
        data16.setIssleep(0);
        data16.setIslazy(0);
        firstlessonData.add(data16);
        secondlessonData.add(data16);
    }
    private void initRealData(){
        HttpUtil.sendLoginRequest
                ("http://203.195.156.24:7000/api/v1/teachers/studentssign/",
                        HttpUtil.createSingleClassConditionJson("2019-03-23", 10, "001"), new okhttp3.Callback() {
                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                Gson gson = new Gson();
                                java.lang.reflect.Type type = new TypeToken<GetSingleLessonCondtion>() {
                                }.getType();
                                final GetSingleLessonCondtion condition = gson.fromJson(response.body().string(), type);
                                for(GetSingleLessonCondtion.Data data:condition.getData()){
                                    firstlessonData.add(data);
                                }
                                //解析json
                            }
                            @Override
                            public void onFailure(Call call, IOException e) {
                                serverConnectFail();
                            }
                        });
        HttpUtil.sendLoginRequest
                ("http://203.195.156.24:7000/api/v1/teachers/studentssign/",
                        HttpUtil.createSingleClassConditionJson("2019-03-23", 10, "002"), new okhttp3.Callback() {
                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                Gson gson = new Gson();
                                java.lang.reflect.Type type = new TypeToken<GetSingleLessonCondtion>() {
                                }.getType();
                                final GetSingleLessonCondtion condition = gson.fromJson(response.body().string(), type);
                                //解析json
                                for(GetSingleLessonCondtion.Data data:condition.getData()){
                                    secondlessonData.add(data);
                                }
                            }
                            @Override
                            public void onFailure(Call call, IOException e) {
                                serverConnectFail();
                            }
                        });
    }
    private void serverConnectFail(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(TeacherRealtimeClassroom.this,
                        null,Toast.LENGTH_SHORT);
                toast.setText("服务器连接失败");
                toast.show();
            }
        });
    }
}
