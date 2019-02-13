package com.example.a.checkattendance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //默认方法
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





        arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, str);
        spinner.setAdapter(arrayAdapter);


        boolean isRemember = pref.getBoolean("remember",false);
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
            //Toast.makeText(ActivityLogin.this,temp,Toast.LENGTH_LONG).show();
            getLoginChoice(temp);
            accountText.setText(pref.getString("account",""));
            passwordText.setText(pref.getString("password",""));
            rememberPass.setChecked(true);
        }
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = parent.getItemAtPosition(position).toString();
                getLoginChoice(selected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        loginButton = (Button)findViewById(R.id.login_button);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        loginAccount=accountText.getText().toString();
        loginPassword=passwordText.getText().toString();
        if(loginChoice.equals("教师端")&&loginAccount.equals("admin")&&loginPassword.equals("123456")){
            editor = pref.edit();
            if(rememberPass.isChecked()) {
                editor.putString("choice", loginChoice);
                editor.putString("account", loginAccount);
                editor.putString("password", loginPassword);
                editor.putBoolean("remember",true);
                editor.apply();
            }else{
                editor.clear();
            }
            editor.apply();
            //sharepreference保存密码
            Intent intent = new Intent(ActivityLogin.this,HomepageOfTeacher.class);
            startActivity(intent);
            finish();
        }
    }

    private void getLoginChoice(String str){
        loginChoice = str;
    }
}