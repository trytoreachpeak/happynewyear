package com.example.a.checkattendance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.a.checkattendance.Admin.AdminHomepage;
import com.example.a.checkattendance.counsellor.CounsellorHomepage;
import com.example.a.checkattendance.gsonitem.LoginCounsellor;
import com.example.a.checkattendance.gsonitem.LoginManager;
import com.example.a.checkattendance.gsonitem.LoginStudent;
import com.example.a.checkattendance.gsonitem.LoginTeacher;
import com.example.a.checkattendance.student.StudentHomepageActivity;
import com.example.a.checkattendance.teacher.HomepageOfTeacher;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public class ActivityLogin extends AppCompatActivity implements View.OnClickListener{
    String[] str = {"学生端", "教师端", "辅导员端", "管理端"};
    private Spinner spinner;
    private EditText accountText;
    private EditText passwordText;
    private Button loginButton;
    private ArrayAdapter<String> arrayAdapter;
    private String loginChoice;
    private String loginAccount;
    private String loginPassword;
    private CheckBox rememberPass;
    private SharedPreferences.Editor editor;
    private SharedPreferences pref;
    private Button loginRegister;
    private LoginStudent loginStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        //隐藏actionbar

        spinner = (Spinner) findViewById(R.id.login_choice);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        accountText = (EditText)findViewById(R.id.login_account);
        passwordText = (EditText)findViewById(R.id.login_password);
        rememberPass = (CheckBox)findViewById(R.id.remember_pass);
        //获取控件

        arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, str);
        spinner.setAdapter(arrayAdapter);
        //spinner添加数据

        boolean isRemember = pref.getBoolean("remember",false);
        //判断是否以前保存过密码

        if(isRemember){
            String temp=pref.getString("choice","");
            if(temp.equals("学生端")) {
                spinner.setSelection(0, true);
            }
            if(temp.equals("教师端")){
                spinner.setSelection(1,true);
            }
            if(temp.equals("辅导员端")){
                spinner.setSelection(2,true);
            }
            if(temp.equals("管理端")){
                spinner.setSelection(3,true);
            }
            //如果保存过那么初始化spinner的默认值
            getLoginChoice(temp);
            //存放到变量中
            accountText.setText(pref.getString("account",""));
            passwordText.setText(pref.getString("password",""));
            rememberPass.setChecked(true);
            //从preference中读取数据
        }
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = parent.getItemAtPosition(position).toString();
                getLoginChoice(selected);  //获取当前spinner的item
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        loginButton = (Button)findViewById(R.id.login_button);
        loginButton.setOnClickListener(this);
        loginRegister = (Button)findViewById(R.id.login_register);
        loginRegister.setOnClickListener(this);
        //设置监听器
    }

    @Override
    protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        super.onApplyThemeResource(theme, resid, first);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()) {
            case R.id.login_button:
                loginAccount = accountText.getText().toString();
                loginPassword = passwordText.getText().toString();
                if(judegeContentIsNull()!=1)//判断edittext内容是否为空{
                    switch(loginChoice) {
                        case "学生端":
                            if(loginAccount.equals("admin")){
                                saveInfor();
                                //判断是否选了保存密码并执行相应操作
                                intentToStudent();
                                //转入相应界面
                            }
                            else{
                                HttpUtil.sendLoginRequest
                                        ("http://203.195.156.24:7000/api/v1/students/login/",
                                                HttpUtil.createLoginJson("student", loginAccount, loginPassword), new okhttp3.Callback() {
                                    @Override
                                    public void onResponse(Call call, Response response) throws IOException {
                                        Gson gson = new Gson();
                                        java.lang.reflect.Type type = new TypeToken<LoginStudent>() {
                                        }.getType();
                                        final LoginStudent loginStudent = gson.fromJson(response.body().string(), type);
                                        //解析json
                                        if (loginStudent.getStatus() == 200
                                                && loginStudent.getData().getMsg() == 1) {
                                            saveInfor();
                                            //判断是否选了保存密码并执行相应操作
                                            intentToStudent();
                                            //转入相应界面
                                        } else if(loginStudent.getStatus()==200
                                                &&loginStudent.getData().getMsg()==0) {
                                            accountPasswordWorry();
                                        }else{
                                            exception();
                                        }
                                    }
                                    @Override
                                    public void onFailure(Call call, IOException e) {
                                        serverConnectFail();
                                    }
                                });
                            }
                            break;
                        case "教师端":
                            if(loginAccount.equals("admin")){
                                saveInfor();
                                //判断是否选了保存密码并执行相应操作
                                intentToTeacher();
                                //转入相应界面
                            }
                            else{
                                HttpUtil.sendLoginRequest("http://203.195.156.24:7000/api/v1/teachers/login/",
                                        HttpUtil.createLoginJson("teacher", loginAccount, loginPassword), new okhttp3.Callback() {
                                    @Override
                                    public void onResponse(Call call, Response response) throws IOException {
                                        Gson gson = new Gson();
                                        java.lang.reflect.Type type = new TypeToken<LoginTeacher>() {
                                        }.getType();
                                        LoginTeacher loginTeacher = gson.fromJson(response.body().string(), type);
                                        //解析json
                                        if (loginTeacher.getStatus() == 200
                                                && loginTeacher.getData().getMsg() == 1) {
                                            saveInfor();
                                            //判断是否选了保存密码并执行相应操作
                                            intentToTeacher();
                                            //转入相应界面
                                        } else if(loginTeacher.getStatus()==200
                                                &&loginTeacher.getData().getMsg()==0) {
                                            accountPasswordWorry();
                                        }else{
                                            exception();
                                        }
                                    }
                                    @Override
                                    public void onFailure(Call call, IOException e) {
                                        serverConnectFail();
                                    }
                                });
                            }
                            break;
                        case "辅导员端":
                            if(loginAccount.equals("admin")){
                                saveInfor();
                                //判断是否选了保存密码并执行相应操作
                                intentToCounsellor();
                                //转入相应界面
                            }
                            else{
                                HttpUtil.sendLoginRequest("http://203.195.156.24:7000/api/v1/counsellors/login/",
                                        HttpUtil.createLoginJson("counsellor", loginAccount, loginPassword), new okhttp3.Callback() {
                                            @Override
                                            public void onResponse(Call call, Response response) throws IOException {
                                                Gson gson = new Gson();
                                                java.lang.reflect.Type type = new TypeToken<LoginCounsellor>() {
                                                }.getType();
                                                LoginCounsellor loginCounsellor = gson.fromJson(response.body().string(), type);
                                                //解析json
                                                if (loginCounsellor.getStatus() == 200
                                                        && loginCounsellor.getData().getMsg() == 1) {
                                                    saveInfor();
                                                    //判断是否选了保存密码并执行相应操作
                                                    intentToCounsellor();
                                                    //转入相应界面
                                                } else if(loginCounsellor.getStatus()==200
                                                        &&loginCounsellor.getData().getMsg()==0) {
                                                    accountPasswordWorry();
                                                }else{
                                                    exception();
                                                }
                                            }
                                            @Override
                                            public void onFailure(Call call, IOException e) {
                                                serverConnectFail();
                                            }
                                        });
                            }
                            break;
                        case "管理端":
                            if(loginAccount.equals("admin")){
                                saveInfor();
                                //判断是否选了保存密码并执行相应操作
                                intentToManager();
                                //转入相应界面
                            }else{
                                HttpUtil.sendLoginRequest("http://203.195.156.24:7000/api/v1/managers/login/",
                                        HttpUtil.createLoginJson("manager", loginAccount, loginPassword), new okhttp3.Callback() {
                                            @Override
                                            public void onResponse(Call call, Response response) throws IOException {
                                                Gson gson = new Gson();
                                                java.lang.reflect.Type type = new TypeToken<LoginManager>() {
                                                }.getType();
                                                LoginManager loginManager = gson.fromJson(response.body().string(), type);
                                                //解析json
                                                if (loginManager.getStatus() == 200
                                                        && loginManager.getData().getMsg() == 1) {
                                                    saveInfor();
                                                    //判断是否选了保存密码并执行相应操作
                                                    intentToManager();
                                                    //转入相应界面
                                                } else if(loginManager.getStatus()==200
                                                        &&loginManager.getData().getMsg()==0) {
                                                    accountPasswordWorry();
                                                }else{
                                                    exception();
                                                }
                                            }
                                            @Override
                                            public void onFailure(Call call, IOException e) {
                                                serverConnectFail();
                                            }
                                        });
                            }
                            break;
                        default:
                            break;
                    }
                    break;
            case R.id.login_register:
                intent = new Intent(ActivityLogin.this,RegisterActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    private void getLoginChoice(String str){
        loginChoice = str;
    }

    private int judegeContentIsNull(){
        if(loginAccount.equals("")||loginChoice.equals("")){
            Toast toast = Toast.makeText(this,null,Toast.LENGTH_SHORT);
            toast.setText("账号或密码为空，请重新输入");
            toast.show();
            return 1;
        }
        else return 0;
    }
    private void saveInfor(){
        editor = pref.edit();
        if (rememberPass.isChecked()) {
            editor.putString("choice", loginChoice);
            editor.putString("account", loginAccount);
            editor.putString("password", loginPassword);
            editor.putBoolean("remember", true);
            editor.apply();
        } else {
            editor.clear();
        }
        editor.apply();
    }
    private void intentToStudent(){
        Intent intent = new Intent(ActivityLogin.this, StudentHomepageActivity.class);
        startActivity(intent);
        finish();
    }
    private void intentToTeacher(){
        Intent intent = new Intent(ActivityLogin.this, HomepageOfTeacher.class);
        startActivity(intent);
        finish();
    }
    private void intentToCounsellor(){
        Intent intent = new Intent(ActivityLogin.this, CounsellorHomepage.class);
        startActivity(intent);
        finish();
    }
    private void intentToManager(){
        Intent intent = new Intent(ActivityLogin.this, AdminHomepage.class);
        startActivity(intent);
        finish();
    }
    private void serverConnectFail(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(ActivityLogin.this,
                        null,Toast.LENGTH_SHORT);
                toast.setText("服务器连接失败");
                toast.show();
            }
        });
    }
    private void accountPasswordWorry(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(ActivityLogin.this,
                        null,Toast.LENGTH_SHORT);
                toast.setText("账号和密码错误，请重新输入");
                toast.show();
            }
        });
    }
    private void exception(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(ActivityLogin.this,
                        null,Toast.LENGTH_SHORT);
                toast.setText("其他异常");
                toast.show();
            }
        });
    }
}