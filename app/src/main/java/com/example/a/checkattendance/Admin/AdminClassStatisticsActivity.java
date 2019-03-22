package com.example.a.checkattendance.Admin;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;

import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendForm;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import org.feezu.liuli.timeselector.TimeSelector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdminClassStatisticsActivity extends BaseActivity implements View.OnClickListener{

    private TextView t_time1;
    private TextView t_time2;

    private BarChart mbarChart1;
    private BarChart mbarChart2;
    private BarChart mbarChart3;
    private String[] xValues1 = {"高等数学(一)", "英语(二)", "数据结构", "JAVA编程设计", "海淀区"};
    private String[] yValues1 = {"91"};
    private String[] xValues2 = {"高等数学(一)", "英语(二)", "数据结构", "JAVA编程设计", "海淀区"};
    private String[] yValues2 = {"91"};
    private String[] xValues3 = {"高等数学(一)", "英语(二)", "数据结构", "JAVA编程设计", "海淀区"};
    private String[] yValues3 = {"91"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_class_statistics);

        TextView t_classname = (TextView) findViewById(R.id.class_name);

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

        LinearLayout l_firsttitle = (LinearLayout) findViewById(R.id.first_title);
        l_firsttitle.setOnClickListener(this);
        LinearLayout l_first = (LinearLayout) findViewById(R.id.first_linearlayout);
        l_first.setOnClickListener(this);
        ImageView i_first = (ImageView) findViewById(R.id.first_change);

        LinearLayout l_secondtitle = (LinearLayout) findViewById(R.id.second_title);
        l_secondtitle.setOnClickListener(this);
        LinearLayout l_second = (LinearLayout) findViewById(R.id.second_linearlayout);
        l_second.setOnClickListener(this);
        ImageView i_second = (ImageView) findViewById(R.id.second_change);


        i_first.setImageResource(R.mipmap.upflod);
        l_first.setVisibility(View.GONE);
        i_second.setImageResource(R.mipmap.upflod);
        l_second.setVisibility(View.GONE);

        Intent intent = getIntent();
        String showdata = intent.getStringExtra("extra_data");
        t_classname.setText(showdata);

        init();
        initData(t_time1);
        initData(t_time2);

        mbarChart1 = (BarChart) findViewById(R.id.mBarChart1);
        showBarChartAlong1(mbarChart1,xValues1,yValues1);
        mbarChart2 = (BarChart) findViewById(R.id.mBarChart2);
        showBarChartAlong2(mbarChart2,xValues2,yValues2);
        mbarChart3 = (BarChart) findViewById(R.id.mBarChart3);
        showBarChartAlong3(mbarChart3,xValues3,yValues3);


        LineChart lineChart1 = (LineChart) findViewById(R.id.mLineChart1);
        initLineChart4(lineChart1);

        LineChart lineChart2 = (LineChart) findViewById(R.id.mLineChart2);
        initLineChart4(lineChart2);

        LineChart lineChart3 = (LineChart) findViewById(R.id.mLineChart3);
        initLineChart4(lineChart3);
    }



    @Override
    public void onClick(View v){
        LinearLayout l_first=(LinearLayout) findViewById(R.id.first_linearlayout);
        ImageView i_first=(ImageView)findViewById(R.id.first_change);
        LinearLayout l_second=(LinearLayout) findViewById(R.id.second_linearlayout);
        ImageView i_second=(ImageView)findViewById(R.id.second_change);
        switch(v.getId()){
            case R.id.first_title:
                if(l_first.getVisibility()==View.GONE) {
                    i_first.setImageResource(R.mipmap.shrink);
                    l_first.setVisibility(View.VISIBLE);
                }
                else{
                    i_first.setImageResource(R.mipmap.upflod);
                    l_first.setVisibility(View.GONE);
                }
                break;
            case R.id.second_title:
                if(l_second.getVisibility()==View.GONE) {
                    i_second.setImageResource(R.mipmap.shrink);
                    l_second.setVisibility(View.VISIBLE);
                }
                else{
                    i_second.setImageResource(R.mipmap.upflod);
                    l_second.setVisibility(View.GONE);
                }
                break;
            case R.id.back:
                finish();
                break;
            default:
                break;
        }
    }

    private void initData(final TextView t_time) {
        t_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeSelector timeSelector = new TimeSelector(AdminClassStatisticsActivity.this, new TimeSelector.ResultHandler() {
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



    private void initLineChart4(LineChart lineChart){
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置x轴的显示位置
        xAxis.setAxisLineColor(Color.parseColor("#66cc99"));
        xAxis.setTextColor(Color.parseColor("#66cc99"));
        xAxis.setTextSize(10f);
        xAxis.setAvoidFirstLastClipping(true);//图表将避免第一个和最后一个标签条目被减掉在图表或屏幕的边缘
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return String.valueOf((int)value*3).concat("天");
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
        yAxis.setAxisLineColor(Color.parseColor("#66cc99"));
        yAxis.setTextColor(Color.parseColor("#66cc99"));
        yAxis.setTextSize(12f);

        xAxis.setDrawGridLines(false);
        yAxis.setDrawGridLines(false);

        lineChart.setScaleEnabled(false);//禁止缩放x和y轴
        lineChart.animateXY(1300,1300);
        lineChart.setTouchEnabled(true);
        lineChart.setDragEnabled(true);
        lineChart.setHighlightPerDragEnabled(false);
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            entries.add(new Entry(i, new Random().nextInt(100)));
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

        dataSet.setColor(Color.parseColor("#66cc99"));//线条颜色
        dataSet.setCircleColor(Color.parseColor("#66cc99"));//圆点颜色
        dataSet.setValueTextColor(Color.parseColor("#66cc99"));
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

    private void initLineChart5(LineChart lineChart){
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置x轴的显示位置
        xAxis.setAxisLineColor(Color.parseColor("#66cc99"));
        xAxis.setTextColor(Color.parseColor("#66cc99"));
        xAxis.setTextSize(12f);
        xAxis.setAvoidFirstLastClipping(true);//图表将避免第一个和最后一个标签条目被减掉在图表或屏幕的边缘
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return String.valueOf((int)value*3).concat("天");
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
        yAxis.setAxisLineColor(Color.parseColor("#66cc99"));
        yAxis.setTextColor(Color.parseColor("#66cc99"));
        yAxis.setTextSize(12f);

        xAxis.setDrawGridLines(false);
        yAxis.setDrawGridLines(false);

        lineChart.setScaleEnabled(false);//禁止缩放x和y轴
        lineChart.animateXY(1300,1300);
        lineChart.setTouchEnabled(true);
        lineChart.setDragEnabled(true);
        lineChart.setHighlightPerDragEnabled(false);
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            entries.add(new Entry(i, new Random().nextInt(100)));
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

        dataSet.setColor(Color.parseColor("#66cc99"));//线条颜色
        dataSet.setCircleColor(Color.parseColor("#66cc99"));//圆点颜色
        dataSet.setValueTextColor(Color.parseColor("#66cc99"));
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

    private void initLineChart6(LineChart lineChart){
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置x轴的显示位置
        xAxis.setAxisLineColor(Color.parseColor("#66cc99"));
        xAxis.setTextColor(Color.parseColor("#66cc99"));
        xAxis.setTextSize(12f);
        xAxis.setAvoidFirstLastClipping(true);//图表将避免第一个和最后一个标签条目被减掉在图表或屏幕的边缘
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return String.valueOf((int)value*3).concat("天");
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
        yAxis.setAxisLineColor(Color.parseColor("#66cc99"));
        yAxis.setTextColor(Color.parseColor("#66cc99"));
        yAxis.setTextSize(12f);

        xAxis.setDrawGridLines(false);
        yAxis.setDrawGridLines(false);

        lineChart.setScaleEnabled(false);//禁止缩放x和y轴
        lineChart.animateXY(1300,1300);
        lineChart.setTouchEnabled(true);
        lineChart.setDragEnabled(true);
        lineChart.setHighlightPerDragEnabled(false);
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            entries.add(new Entry(i, new Random().nextInt(100)));
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

        dataSet.setColor(Color.parseColor("#66cc99"));//线条颜色
        dataSet.setCircleColor(Color.parseColor("#66cc99"));//圆点颜色
        dataSet.setValueTextColor(Color.parseColor("#66cc99"));
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
}
