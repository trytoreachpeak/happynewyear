package com.example.a.checkattendance.teacher;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.a.checkattendance.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import top.wuhaojie.library.MultiScrollNumber;

public class TeacherRealtimeChart extends AppCompatActivity {
    MultiScrollNumber scrollNumber1;
    MultiScrollNumber scrollNumber2;
    LineChart lineChart;
    BarChart barChart;
    BarChart barChart1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_realtime_chart);
        scrollNumber1=(MultiScrollNumber)findViewById(R.id.scroll_number_1);
        scrollNumber1.setTextColors(new int[]{R.color.whilecolor,R.color.whilecolor});
        scrollNumber1.setScrollVelocity(25);
        scrollNumber1.setNumber(9);
        scrollNumber2=(MultiScrollNumber)findViewById(R.id.scroll_number_2);
        scrollNumber2.setTextColors(new int[]{R.color.whilecolor,R.color.whilecolor});
        scrollNumber2.setScrollVelocity(25);
        scrollNumber2.setNumber(58);

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

        initFirstChart();
        initSecondChart();
        initThirdChart();

    }
    private void initFirstChart(){
        lineChart=(LineChart)findViewById(R.id.line_chart_2);
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置x轴的显示位置
        xAxis.setAxisLineColor(Color.parseColor("#888888"));
        xAxis.setTextColor(Color.parseColor("#ffffff"));
        xAxis.setTextSize(12f);
        xAxis.setAvoidFirstLastClipping(true);//图表将避免第一个和最后一个标签条目被减掉在图表或屏幕的边缘
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                    return String.valueOf((int)value*10).concat("min");
            }

            @Override
            public int getDecimalDigits() {
                return 0;
            }
        });
        YAxis yAxis = lineChart.getAxisLeft();
        YAxis rightYAxis = lineChart.getAxisRight();
        //设置Y轴是否显示
        rightYAxis.setEnabled(false); //右侧Y轴不显示
        yAxis.setAxisLineColor(Color.parseColor("#888888"));
        yAxis.setTextColor(Color.parseColor("#ffffff"));
        yAxis.setTextSize(12f);

        xAxis.setDrawGridLines(false);
        yAxis.setDrawGridLines(false);
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < 12; i++)
            entries.add(new Entry(i, new Random().nextInt(57)));

        lineChart.setScaleEnabled(false);//禁止缩放x和y轴
        lineChart.animateXY(1300,1300);
        lineChart.setTouchEnabled(true);
        lineChart.setDragEnabled(true);
        lineChart.setHighlightPerDragEnabled(false);
        float ratio = (float) entries.size()/(float) 10;
        //显示的时候是按照多大的比率缩放显示,1f表示不放大缩小
        lineChart.zoom(ratio,1f,0,0);
        LineDataSet dataSet = new LineDataSet(entries, "Label");
        LineData lineData = new LineData(dataSet);

        //隐藏x轴描述
        Description description = new Description();
        description.setEnabled(false);
        lineChart.setDescription(description);

        Legend legend = lineChart.getLegend();
        //隐藏Lengend
        legend.setEnabled(false);

        dataSet.setColor(Color.parseColor("#ffffff"));//线条颜色
        dataSet.setCircleColor(Color.parseColor("#ffffff"));//圆点颜色
        dataSet.setValueTextColor(Color.parseColor("#ffffff"));
        dataSet.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return String.valueOf((int)value);
            }
        });
        dataSet.setValueTextSize(10f);
        dataSet.setLineWidth(2f);//线条宽度
        lineChart.setData(lineData);
        lineChart.invalidate();
    }
    private void initSecondChart(){
        barChart=(BarChart)findViewById(R.id.line_chart_3);
        BarChartManager barChartManager = new BarChartManager(barChart);

        List<BarEntry> yVals = new ArrayList<>();
        yVals.add(new BarEntry(1f, 80f));
        yVals.add(new BarEntry(2f, 50f));
        yVals.add(new BarEntry(3f, 60f));
        yVals.add(new BarEntry(4f, 60f));
        yVals.add(new BarEntry(5f, 70f));
        String label = "";
        barChartManager.showBarChart(yVals, label, Color.parseColor("#36a16b"));
    }
    private void initThirdChart(){
        barChart1=(BarChart)findViewById(R.id.line_chart_4);
        BarChartManager barChartManager = new BarChartManager(barChart1);

        List<BarEntry> yVals = new ArrayList<>();
        yVals.add(new BarEntry(1f, 80f));
        yVals.add(new BarEntry(2f, 50f));
        yVals.add(new BarEntry(3f, 60f));
        String label = "";
        barChartManager.showBarChart1(yVals, label, Color.parseColor("#36a16b"));
    }
}
