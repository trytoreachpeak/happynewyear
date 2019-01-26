package com.example.a.checkattendance;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ActivityLogin extends AppCompatActivity {
    String[] str = {"学生端", "教师端", "辅导员端", "管理端"};
    private Spinner spinner;
    private ArrayAdapter<String> arrayAdapter;
    boolean isSpinnerFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        spinner = (Spinner) findViewById(R.id.login_choice);
        arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, str);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (isSpinnerFirst) {
                    view.setVisibility(View.INVISIBLE);
                }
                isSpinnerFirst = false;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}