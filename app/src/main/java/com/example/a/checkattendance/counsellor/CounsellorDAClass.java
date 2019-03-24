package com.example.a.checkattendance.counsellor;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.teacher.BarChartManager;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CounsellorDAClass extends AppCompatActivity
        implements OnChartValueSelectedListener,View.OnClickListener {
    LineChart lineChart;
    BarChart barChart;
    BarChart barChart1;
    List<Entry> entries;
    private PieChart mPieChart;
    //显示百分比
    private Button btn_show_percentage;
    //显示类型
    private Button btn_show_type;
    //x轴动画
    private Button btn_anim_x;
    //y轴动画
    private Button btn_anim_y;
    //xy轴动画
    private Button btn_anim_xy;
    //保存到sd卡
    private Button btn_save_pic;
    //显示中间文字
    private Button btn_show_center_text;
    //旋转动画
    private Button btn_anim_rotating;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counsellor_da_class);
        initView();
        title = (TextView)findViewById(R.id.title);
        Intent intent= getIntent();
        title.setText(intent.getStringExtra("title"));

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
        initFirstChart();
        initSecondChart();
        initThirdChart();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.counsellor_da_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.menu_1:
                intent = new Intent(CounsellorDAClass.this,CounsellorClassmateList.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void initView() {



        //饼状图
        mPieChart = (PieChart) findViewById(R.id.mPieChart);
        mPieChart.setUsePercentValues(true);
        mPieChart.getDescription().setEnabled(false);
        mPieChart.setExtraOffsets(5, 10, 5, 5);

        mPieChart.setDragDecelerationFrictionCoef(0.95f);
        //设置中间文件
        //mPieChart.setCenterText(generateCenterSpannableText());

        mPieChart.setDrawHoleEnabled(false);
        //mPieChart.setHoleColor(Color.WHITE);

        mPieChart.setTransparentCircleColor(Color.WHITE);
        mPieChart.setTransparentCircleAlpha(110);

        mPieChart.setHoleRadius(58f);
        mPieChart.setTransparentCircleRadius(61f);

        mPieChart.setDrawCenterText(true);

        mPieChart.setRotationAngle(0);
        // 触摸旋转
        mPieChart.setRotationEnabled(true);
        mPieChart.setHighlightPerTapEnabled(true);

        //变化监听
        mPieChart.setOnChartValueSelectedListener(this);

        //模拟数据
        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
        entries.add(new PieEntry(40, "优秀"));
        entries.add(new PieEntry(20, "良好"));
        entries.add(new PieEntry(30, "及格"));
        entries.add(new PieEntry(10, "不及格"));

        //设置数据
        setData(entries);

        mPieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);

        Legend l = mPieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

        // 输入标签样式
        mPieChart.setEntryLabelColor(Color.WHITE);
        mPieChart.setEntryLabelTextSize(12f);

        Legend legend =mPieChart.getLegend();

        legend.setEnabled(false);


    }

    //设置中间文字
    private SpannableString generateCenterSpannableText() {
        //原文：MPAndroidChart\ndeveloped by Philipp Jahoda
        SpannableString s = new SpannableString("刘某人程序员\n我仿佛听到有人说我帅");
        //s.setSpan(new RelativeSizeSpan(1.7f), 0, 14, 0);
        //s.setSpan(new StyleSpan(Typeface.NORMAL), 14, s.length() - 15, 0);
        // s.setSpan(new ForegroundColorSpan(Color.GRAY), 14, s.length() - 15, 0);
        //s.setSpan(new RelativeSizeSpan(.8f), 14, s.length() - 15, 0);
        // s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 14, s.length(), 0);
        // s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 14, s.length(), 0);
        return s;
    }

    //设置数据
    private void setData(ArrayList<PieEntry> entries) {
        PieDataSet dataSet = new PieDataSet(entries, "三年级一班");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);

        //数据和颜色
        ArrayList<Integer> colors = new ArrayList<Integer>();
        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);
        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);
        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(14f);
        data.setValueTextColor(Color.WHITE);
        mPieChart.setData(data);
        mPieChart.highlightValues(null);
        //刷新
        mPieChart.invalidate();
    }


    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    @Override
    public void onClick(View v) {

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
}

