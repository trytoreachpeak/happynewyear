package com.example.a.checkattendance.counsellor;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.teacher.BarChartManager;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public class CounsellorDAStudent extends AppCompatActivity {
    BarChart barChart;
    BarChart barChart1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counsellor_ds_student);

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

        Intent intent = getIntent();
        TextView title = (TextView)findViewById(R.id.title);
        title.setText(intent.getStringExtra("name"));

        initSecondChart();
        initThirdChart();
    }
    private void initSecondChart(){
        barChart=(BarChart)findViewById(R.id.line_chart_3);
        BarChartManager barChartManager = new BarChartManager(barChart);

        List<BarEntry> yVals = new ArrayList<>();
        yVals.add(new BarEntry(1f, 15f));
        yVals.add(new BarEntry(2f, 1f));
        yVals.add(new BarEntry(3f, 0f));
        yVals.add(new BarEntry(4f, 1f));
        yVals.add(new BarEntry(5f, 0f));
        String label = "";
        barChartManager.showBarChart(yVals, label, Color.parseColor("#36a16b"));
    }
    private void initThirdChart(){
        barChart1=(BarChart)findViewById(R.id.line_chart_4);
        BarChartManager barChartManager = new BarChartManager(barChart1);

        List<BarEntry> yVals = new ArrayList<>();
        yVals.add(new BarEntry(1f, 20f));
        yVals.add(new BarEntry(2f, 5f));
        yVals.add(new BarEntry(3f, 3f));
        String label = "";
        barChartManager.showBarChart1(yVals, label, Color.parseColor("#36a16b"));
    }
}
