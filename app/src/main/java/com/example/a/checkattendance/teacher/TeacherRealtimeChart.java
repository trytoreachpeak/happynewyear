package com.example.a.checkattendance.teacher;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

public class TeacherRealtimeChart extends AppCompatActivity implements View.OnClickListener{
    MultiScrollNumber scrollNumber1;
    MultiScrollNumber scrollNumber2;
    LineChart lineChart;
    BarChart barChart;
    BarChart barChart1;
    ImageView firstLeftArrow;
    ImageView firstRightArrow;
    ImageView secondLeftArrow;
    ImageView secondRightArrow;
    ImageView thirdLeftArrow;
    ImageView thirdRightArrow;
    ImageView forthLeftArrow;
    ImageView forthRightArrow;
    List<String> category;
    TextView firstText;
    TextView secondText;
    TextView thirdText;
    TextView forthText;
    List<Entry> entries;
    List<Entry> entries1;
    List<Entry> entries2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_realtime_chart);
        scrollNumber1=(MultiScrollNumber)findViewById(R.id.scroll_number_1);
        scrollNumber1.setTextColors(new int[]{R.color.whilecolor,R.color.whilecolor});
        scrollNumber1.setScrollVelocity(25);
        scrollNumber1.setNumber(16);
        scrollNumber2=(MultiScrollNumber)findViewById(R.id.scroll_number_2);
        scrollNumber2.setTextColors(new int[]{R.color.whilecolor,R.color.whilecolor});
        scrollNumber2.setScrollVelocity(25);
        scrollNumber2.setNumber(7);

        firstLeftArrow = (ImageView)findViewById(R.id.first_left_arrow);
        firstRightArrow = (ImageView)findViewById(R.id.first_right_arrow);
        secondLeftArrow = (ImageView)findViewById(R.id.second_left_arrow);
        secondRightArrow = (ImageView)findViewById(R.id.second_right_arrow);
        thirdLeftArrow = (ImageView)findViewById(R.id.third_left_arrow);
        thirdRightArrow = (ImageView)findViewById(R.id.third_right_arrow);
        forthLeftArrow = (ImageView)findViewById(R.id.forth_left_arrow);
        forthRightArrow = (ImageView)findViewById(R.id.forth_right_arrow);

        firstLeftArrow.setOnClickListener(this);
        firstRightArrow.setOnClickListener(this);
        secondLeftArrow.setOnClickListener(this);
        secondRightArrow.setOnClickListener(this);
        thirdLeftArrow.setOnClickListener(this);
        thirdRightArrow.setOnClickListener(this);
        forthLeftArrow.setOnClickListener(this);
        forthRightArrow.setOnClickListener(this);

        firstText = (TextView)findViewById(R.id.first_text);
        secondText = (TextView)findViewById(R.id.second_text);
        thirdText = (TextView)findViewById(R.id.third_text);
        forthText = (TextView)findViewById(R.id.forth_text);

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
        entries = new ArrayList<>();
        for (int i = 0; i < 8; i++)
            entries.add(new Entry(i, 48+new Random().nextInt(10)));
        entries1 = new ArrayList<>();
        for (int i = 0; i < 8; i++)
            entries1.add(new Entry(i, 18+new Random().nextInt(10)));
        entries2 = new ArrayList<>();
        for (int i = 0; i < 8; i++)
            entries2.add(new Entry(i, 18+new Random().nextInt(10)));
        initFirstChart();
        initSecondChart();
        initThirdChart();
        category = new ArrayList<>();
        category.add("汇总");
        category.add("第1节课");
        category.add("第2节课");
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
        xAxis.setDrawGridLines(false);

        YAxis yAxis = lineChart.getAxisLeft();
        YAxis rightYAxis = lineChart.getAxisRight();
        //设置Y轴是否显示
        rightYAxis.setEnabled(false); //右侧Y轴不显示
        yAxis.setAxisLineColor(Color.parseColor("#888888"));
        yAxis.setTextColor(Color.parseColor("#ffffff"));
        yAxis.setTextSize(12f);
        yAxis.setDrawGridLines(false);


        lineChart.setScaleEnabled(false);//禁止缩放x和y轴
        lineChart.animateX(2000);
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
    yVals.add(new BarEntry(1f, 4f));
    yVals.add(new BarEntry(2f, 0f));
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
        yVals.add(new BarEntry(1f, 90f));
        yVals.add(new BarEntry(2f, 30f));
        yVals.add(new BarEntry(3f, 10f));
        String label = "";
        barChartManager.showBarChart1(yVals, label, Color.parseColor("#36a16b"));
    }

    @Override
    public void onClick(View v) {
        int locate;
        switch(v.getId()){
            case R.id.first_left_arrow:
                locate = category.indexOf(firstText.getText().toString());
                if(locate>0){
                    firstText.setText(category.get(locate-1));
                    if(firstText.getText().equals("汇总")){
                        scrollNumber1.setNumber(16);
                        scrollNumber2.setNumber(7);
                    }else if(firstText.getText().equals("第1节课")){
                        scrollNumber1.setNumber(6);
                        scrollNumber2.setNumber(3);
                    }
                }
                break;
            case R.id.first_right_arrow:
                locate = category.indexOf(firstText.getText().toString());
                if(locate<category.size()-1){
                    firstText.setText(category.get(locate+1));
                    if(firstText.getText().toString().equals("第1节课")){
                        scrollNumber1.setNumber(6);
                        scrollNumber2.setNumber(3);
                    }else if(firstText.getText().toString().equals("第2节课")){
                        scrollNumber1.setNumber(10);
                        scrollNumber2.setNumber(4);
                    }
                }
                break;
            case R.id.second_left_arrow:
                locate = category.indexOf(secondText.getText().toString());
                if(locate>0){
                    secondText.setText(category.get(locate-1));
                    if(secondText.getText().equals("汇总")){
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
                        xAxis.setDrawGridLines(false);
                        LineDataSet dataSet = new LineDataSet(entries, "Label");
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
                        LineData lineData = new LineData(dataSet);
                        lineChart.animateX(1300);
                        lineChart.setData(lineData);
                        lineChart.invalidate();
                        break;
                    }else if(secondText.getText().equals("第1节课")){
                        XAxis xAxis = lineChart.getXAxis();
                        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置x轴的显示位置
                        xAxis.setAxisLineColor(Color.parseColor("#888888"));
                        xAxis.setTextColor(Color.parseColor("#ffffff"));
                        xAxis.setTextSize(12f);
                        xAxis.setAvoidFirstLastClipping(true);//图表将避免第一个和最后一个标签条目被减掉在图表或屏幕的边缘
                        xAxis.setValueFormatter(new IAxisValueFormatter() {
                            @Override
                            public String getFormattedValue(float value, AxisBase axis) {
                                return String.valueOf((int)value*5).concat("min");
                            }

                            @Override
                            public int getDecimalDigits() {
                                return 0;
                            }
                        });
                        xAxis.setDrawGridLines(false);
                        LineDataSet dataSet = new LineDataSet(entries1, "Label");
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
                        LineData lineData = new LineData(dataSet);
                        lineChart.animateX(1300);
                        lineChart.setData(lineData);
                        lineChart.invalidate();
                    }
                }
                break;
            case R.id.second_right_arrow:
                locate = category.indexOf(secondText.getText().toString());
                Log.d("testabc",locate+"");
                if(locate<category.size()-1){
                    Log.d("testabc","success");
                    secondText.setText(category.get(locate+1));
                    if(secondText.getText().equals("第1节课")){
                        XAxis xAxis = lineChart.getXAxis();
                        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置x轴的显示位置
                        xAxis.setAxisLineColor(Color.parseColor("#888888"));
                        xAxis.setTextColor(Color.parseColor("#ffffff"));
                        xAxis.setTextSize(12f);
                        xAxis.setAvoidFirstLastClipping(true);//图表将避免第一个和最后一个标签条目被减掉在图表或屏幕的边缘
                        xAxis.setValueFormatter(new IAxisValueFormatter() {
                            @Override
                            public String getFormattedValue(float value, AxisBase axis) {
                                return String.valueOf((int)value*5).concat("min");
                            }

                            @Override
                            public int getDecimalDigits() {
                                return 0;
                            }
                        });
                        xAxis.setDrawGridLines(false);
                        LineDataSet dataSet = new LineDataSet(entries1, "Label");
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
                        LineData lineData = new LineData(dataSet);
                        lineChart.animateX(1300);
                        lineChart.setData(lineData);
                        lineChart.invalidate();
                        break;
                    }else if(secondText.getText().equals("第2节课")){
                        XAxis xAxis = lineChart.getXAxis();
                        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置x轴的显示位置
                        xAxis.setAxisLineColor(Color.parseColor("#888888"));
                        xAxis.setTextColor(Color.parseColor("#ffffff"));
                        xAxis.setTextSize(12f);
                        xAxis.setAvoidFirstLastClipping(true);//图表将避免第一个和最后一个标签条目被减掉在图表或屏幕的边缘
                        xAxis.setValueFormatter(new IAxisValueFormatter() {
                            @Override
                            public String getFormattedValue(float value, AxisBase axis) {
                                return String.valueOf((int)value*5).concat("min");
                            }

                            @Override
                            public int getDecimalDigits() {
                                return 0;
                            }
                        });
                        xAxis.setDrawGridLines(false);
                        LineDataSet dataSet = new LineDataSet(entries2, "Label");
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
                        LineData lineData = new LineData(dataSet);
                        lineChart.animateX(1300);
                        lineChart.setData(lineData);
                        lineChart.invalidate();
                    }
                }
                break;
            case R.id.third_left_arrow:
                locate = category.indexOf(thirdText.getText().toString());
                if(locate>0){
                    thirdText.setText(category.get(locate-1));
                    if(thirdText.getText().equals("汇总")){
                        BarChartManager barChartManager = new BarChartManager(barChart);

                        List<BarEntry> yVals = new ArrayList<>();
                        yVals.add(new BarEntry(1f, 4f));
                        yVals.add(new BarEntry(2f, 0f));
                        yVals.add(new BarEntry(3f, 0f));
                        yVals.add(new BarEntry(4f, 1f));
                        yVals.add(new BarEntry(5f, 0f));
                        String label = "";
                        barChartManager.showBarChart(yVals, label, Color.parseColor("#36a16b"));
                    }else if(thirdText.getText().equals("第1节课")){
                        BarChartManager barChartManager = new BarChartManager(barChart);

                        List<BarEntry> yVals = new ArrayList<>();
                        yVals.add(new BarEntry(1f, 3f));
                        yVals.add(new BarEntry(2f, 0f));
                        yVals.add(new BarEntry(3f, 1f));
                        yVals.add(new BarEntry(4f, 0f));
                        yVals.add(new BarEntry(5f, 0f));
                        String label = "";
                        barChartManager.showBarChart(yVals, label, Color.parseColor("#36a16b"));
                    }
                }
                break;
            case R.id.third_right_arrow:
                locate = category.indexOf(thirdText.getText().toString());
                if(locate<category.size()-1){
                    thirdText.setText(category.get(locate+1));
                    if(thirdText.getText().toString().equals("第1节课")){
                        BarChartManager barChartManager = new BarChartManager(barChart);

                        List<BarEntry> yVals = new ArrayList<>();
                        yVals.add(new BarEntry(1f, 3f));
                        yVals.add(new BarEntry(2f, 0f));
                        yVals.add(new BarEntry(3f, 1f));
                        yVals.add(new BarEntry(4f, 0f));
                        yVals.add(new BarEntry(5f, 0f));
                        String label = "";
                        barChartManager.showBarChart(yVals, label, Color.parseColor("#36a16b"));
                    }else if(thirdText.getText().toString().equals("第2节课")){
                        BarChartManager barChartManager = new BarChartManager(barChart);

                        List<BarEntry> yVals = new ArrayList<>();
                        yVals.add(new BarEntry(1f, 3f));
                        yVals.add(new BarEntry(2f, 0f));
                        yVals.add(new BarEntry(3f, 0f));
                        yVals.add(new BarEntry(4f, 0f));
                        yVals.add(new BarEntry(5f, 0f));
                        String label = "";
                        barChartManager.showBarChart(yVals, label, Color.parseColor("#36a16b"));
                    }
                }
                break;
            case R.id.forth_left_arrow:
                locate = category.indexOf(thirdText.getText().toString());
                if(locate>0){
                    thirdText.setText(category.get(locate-1));
                    if(thirdText.getText().equals("汇总")){
                        BarChartManager barChartManager = new BarChartManager(barChart1);

                        List<BarEntry> yVals = new ArrayList<>();
                        yVals.add(new BarEntry(1f, 90f));
                        yVals.add(new BarEntry(2f, 30f));
                        yVals.add(new BarEntry(3f, 10f));
                        String label = "";
                        barChartManager.showBarChart1(yVals, label, Color.parseColor("#36a16b"));
                    }else if(thirdText.getText().equals("第1节课")){
                        BarChartManager barChartManager = new BarChartManager(barChart1);

                        List<BarEntry> yVals = new ArrayList<>();
                        yVals.add(new BarEntry(1f, 45f));
                        yVals.add(new BarEntry(2f, 15f));
                        yVals.add(new BarEntry(3f, 10f));
                        String label = "";
                        barChartManager.showBarChart1(yVals, label, Color.parseColor("#36a16b"));
                    }
                }
                break;
            case R.id.forth_right_arrow:
                locate = category.indexOf(forthText.getText().toString());
                if(locate<category.size()-1){
                    forthText.setText(category.get(locate+1));
                    if(forthText.getText().toString().equals("第1节课")){
                        BarChartManager barChartManager = new BarChartManager(barChart1);

                        List<BarEntry> yVals = new ArrayList<>();
                        yVals.add(new BarEntry(1f, 45f));
                        yVals.add(new BarEntry(2f, 15f));
                        yVals.add(new BarEntry(3f, 10f));
                        String label = "";
                        barChartManager.showBarChart1(yVals, label, Color.parseColor("#36a16b"));
                    }else if(thirdText.getText().toString().equals("第2节课")){
                        BarChartManager barChartManager = new BarChartManager(barChart1);

                        List<BarEntry> yVals = new ArrayList<>();
                        yVals.add(new BarEntry(1f, 45f));
                        yVals.add(new BarEntry(2f, 15f));
                        yVals.add(new BarEntry(3f, 0f));
                        String label = "";
                        barChartManager.showBarChart1(yVals, label, Color.parseColor("#36a16b"));
                    }
                }
                break;
        }
    }
}
