package com.example.a.checkattendance.Admin;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;




import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;



import org.feezu.liuli.timeselector.TimeSelector;

import java.util.ArrayList;
import java.util.List;

public class AdminClassAnalysisActivity extends BaseActivity implements View.OnClickListener{
    private TextView t_time1;
    private TextView t_time2;

    private BarChart mbarChart1;
    private BarChart mbarChart2;
    private BarChart mbarChart3;
    private BarChart mbarChart4;
    private String[] xValues1 = {"软嵌161", "计161", "物联网161", "网工161", "海淀区"};
    private String[] yValues1 = {"91"};
    private String[] xValues2 = {"软嵌161", "计161", "物联网161", "网工161", "海淀区"};
    private String[] yValues2 = {"91"};
    private String[] xValues3 = {"软嵌161", "计161", "物联网161", "网工161", "海淀区"};
    private String[] yValues3 = {"91"};
    private String[] xValues4 = {"软嵌161", "计161", "物联网161", "网工161", "海淀区"};
    private String[] yValues4 = {"91"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_class_analysis);


        mbarChart1 = (BarChart) findViewById(R.id.mBarChart1);
        showBarChartAlong1(mbarChart1,xValues1,yValues1);
        mbarChart2 = (BarChart) findViewById(R.id.mBarChart2);
        showBarChartAlong2(mbarChart2,xValues2,yValues2);
        mbarChart3 = (BarChart) findViewById(R.id.mBarChart3);
        showBarChartAlong3(mbarChart3,xValues3,yValues3);
        mbarChart4 = (BarChart) findViewById(R.id.mBarChart4);
        showBarChartAlong3(mbarChart4,xValues4,yValues4);

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

        TextView t_classname=(TextView) findViewById(R.id.couse_name) ;



        Intent intent = getIntent();
        String showdata = intent.getStringExtra("extra_data");
        t_classname.setText(showdata);
        init();
        initData(t_time1);
        initData(t_time2);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){


            default:
                break;
        }
    }

    private void initData(final TextView t_time) {
        t_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeSelector timeSelector = new TimeSelector(AdminClassAnalysisActivity.this, new TimeSelector.ResultHandler() {
                    @Override
                    public void handle(String time) {
                        //截取字符串长度，只需要年月日
                        String substring = time.substring(0,10);
                        t_time.setText(substring);
                    }

                }, "1800-1-1 00:00", "2050-12-31 00:00");
                timeSelector.setMode(TimeSelector.MODE.YMD);
                //小时分钟不现实
                timeSelector.disScrollUnit(TimeSelector.SCROLLTYPE.HOUR, TimeSelector.SCROLLTYPE.MINUTE);
                //dialog的弹出

                timeSelector.show();

            }
        });
    }
    private void init() {
        t_time1 = (TextView) findViewById(R.id.time1);
        t_time2 = (TextView) findViewById(R.id.time2);
    }



    private void showBarChartAlong1(BarChart barChart,String[] xValues,String[] yValues) {
        BarChartManager barChartManager = new BarChartManager(barChart,xValues,yValues);

        List<BarEntry> yVals = new ArrayList<>();
        yVals.add(new BarEntry(1f, 80f));
        yVals.add(new BarEntry(2f, 50f));
        yVals.add(new BarEntry(3f, 60f));
        yVals.add(new BarEntry(4f, 70f));

        String label = "";
        barChartManager.showBarChart(yVals, label, Color.parseColor("#66cc99"));
    }

    private void showBarChartAlong2(BarChart barChart,String[] xValues,String[] yValues) {
        BarChartManager barChartManager = new BarChartManager(barChart,xValues,yValues);

        List<BarEntry> yVals = new ArrayList<>();
        yVals.add(new BarEntry(1f, 100f));
        yVals.add(new BarEntry(2f, 95f));
        yVals.add(new BarEntry(3f, 88f));
        yVals.add(new BarEntry(4f, 90f));

        String label = "";
        barChartManager.showBarChart(yVals, label, Color.parseColor("#66cc99"));
    }

    private void showBarChartAlong3(BarChart barChart,String[] xValues,String[] yValues) {
        BarChartManager barChartManager = new BarChartManager(barChart,xValues,yValues);

        List<BarEntry> yVals = new ArrayList<>();
        yVals.add(new BarEntry(1f, 80f));
        yVals.add(new BarEntry(2f, 64f));
        yVals.add(new BarEntry(3f, 74f));
        yVals.add(new BarEntry(4f, 70f));

        String label = "";
        barChartManager.showBarChart(yVals, label, Color.parseColor("#66cc99"));
    }

    private void showBarChartAlong4(BarChart barChart,String[] xValues,String[] yValues) {
        BarChartManager barChartManager = new BarChartManager(barChart,xValues,yValues);

        List<BarEntry> yVals = new ArrayList<>();
        yVals.add(new BarEntry(1f, 80f));
        yVals.add(new BarEntry(2f, 64f));
        yVals.add(new BarEntry(3f, 74f));
        yVals.add(new BarEntry(4f, 70f));

        String label = "";
        barChartManager.showBarChart(yVals, label, Color.parseColor("#66cc99"));
    }




}



