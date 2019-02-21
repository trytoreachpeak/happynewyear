package com.example.a.checkattendance.Admin;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.Legend;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.Legend;

import org.feezu.liuli.timeselector.TimeSelector;

import java.util.ArrayList;

public class AdminClassAnalysisActivity extends BaseActivity implements View.OnClickListener{
    private TextView t_time1;
    private TextView t_time2;
    private PieChart mPiechart1;
    private PieChart mPiechart2;
    private PieChart mPiechart3;
    private PieChart mPiechart4;
    private PieChart mPiechart5;
    private ArrayList<String> xContents;
    private ArrayList<Entry> yContent;
    private ArrayList<Integer> colors;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_class_analysis);

        mPiechart1= (PieChart) findViewById(R.id.mPieChart1);
        PieData mPieData1 = getPieData1(4, 100);
        showChart(mPiechart1, mPieData1);

        mPiechart2= (PieChart) findViewById(R.id.mPieChart2);
        PieData mPieData2 = getPieData2(4, 100);
        showChart(mPiechart2, mPieData2);

        mPiechart3= (PieChart) findViewById(R.id.mPieChart3);
        PieData mPieData3 = getPieData3(4, 100);
        showChart(mPiechart3, mPieData3);

        mPiechart4= (PieChart) findViewById(R.id.mPieChart4);
        PieData mPieData4 = getPieData4(4, 100);
        showChart(mPiechart4, mPieData4);

        mPiechart5= (PieChart) findViewById(R.id.mPieChart5);
        PieData mPieData5 = getPieData5(4, 100);
        showChart(mPiechart5, mPieData5);


        TextView t_classname=(TextView) findViewById(R.id.class_name) ;
        Button button_back=(Button)findViewById(R.id.back);
        button_back.setOnClickListener(this);
        Button button_person=(Button)findViewById(R.id.person);
        button_person.setOnClickListener(this);
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
            case R.id.person:
                Intent intent = new Intent(AdminClassAnalysisActivity.this,AdminPersonAnalysisActivity.class);
                startActivity(intent);
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








    //关键方法在这里-主要用于饼图的画图
    private void showChart(PieChart pieChart, PieData pieData) {

//           pieChart.setHoleColorTransparent(true);

        pieChart.setUsePercentValues(true);


        pieChart.setTransparentCircleRadius(0f); // 半透明圈

        pieChart.setHoleRadius(60f);//半径

        pieChart.setHoleRadius(0);  //实心圆

        pieChart.setValueTextSize(10f);

        pieChart.setDescriptionTextSize(15f);
        pieChart.setDescription("");

        pieChart.setDrawHoleEnabled(true);

        pieChart.setRotationAngle(90); // 初始旋转角度

        pieChart.setRotationEnabled(true); // 可以手动旋转

        pieChart.setUsePercentValues(true);  //显示成百分比


        //设置数据
        pieChart.setData(pieData);


        Legend mLegend = pieChart.getLegend();  //设置比例图
//          mLegend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);  //最右边显示
//          mLegend.setForm(Legend.LegendForm.LINE);  //设置比例图的形状，默认是方形
        mLegend.setXEntrySpace(7f);
        mLegend.setTextSize(15f);

        pieChart.animateXY(1000, 1000);  //设置动画
//        pieChart.spin(2000, 0, 360);
    }

    private PieData getPieData1(int count,float range){


        initData1();

        PieDataSet pieDataSet= new PieDataSet(yContent,null);
        //设置饼状图之间的距离
        pieDataSet.setSliceSpace(0f);
        //设置饼状图之间的颜色
        pieDataSet.setColors(colors);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float px = 5 * (metrics.densityDpi / 160f);
        pieDataSet.setSelectionShift(px); // 选中态多出的长度
        PieData pieData = new PieData(xContents, pieDataSet);

        return pieData;
    }
    //数据源咯，这里我们看预定义饼图区域的颜色、大小、介绍，其中框架会自动计算百分比
    private void initData1() {

        // 饼图颜色
        colors = new ArrayList<Integer>();

        colors.add(Color.rgb(205,205,205));
        colors.add(Color.rgb(114,188,223));
        colors.add(Color.rgb(255,123,124));
        colors.add(Color.rgb(57, 135, 200));
        colors.add(Color.rgb(57, 135, 20));
        colors.add(Color.rgb(77, 105, 20));

        /**展示内容*/
        xContents = new ArrayList<String>();
        xContents.add("手机");
        xContents.add("发呆");
        xContents.add("睡觉");
        float m1=121;
        float m2=41;
        float m3=421;
        //将数据展示

        //展示比例
        yContent = new ArrayList<Entry>();
        yContent.add(new Entry(m1,0));
        yContent.add(new Entry(m2,1));
        yContent.add(new Entry(m3,2));

    }




    private PieData getPieData2(int count,float range){


        initData2();

        PieDataSet pieDataSet= new PieDataSet(yContent,null);
        //设置饼状图之间的距离
        pieDataSet.setSliceSpace(0f);
        //设置饼状图之间的颜色
        pieDataSet.setColors(colors);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float px = 5 * (metrics.densityDpi / 160f);
        pieDataSet.setSelectionShift(px); // 选中态多出的长度
        PieData pieData = new PieData(xContents, pieDataSet);

        return pieData;
    }
    //数据源咯，这里我们看预定义饼图区域的颜色、大小、介绍，其中框架会自动计算百分比
    private void initData2() {

        // 饼图颜色
        colors = new ArrayList<Integer>();

        colors.add(Color.rgb(205,205,205));
        colors.add(Color.rgb(114,188,223));
        colors.add(Color.rgb(255,123,124));
        colors.add(Color.rgb(57, 135, 200));
        colors.add(Color.rgb(57, 135, 20));
        colors.add(Color.rgb(77, 105, 20));

        /**展示内容*/
        xContents = new ArrayList<String>();
        xContents.add("10分钟");
        xContents.add("20分钟");
        xContents.add("30分钟");
        float m1=121;
        float m2=41;
        float m3=421;
        //将数据展示

        //展示比例
        yContent = new ArrayList<Entry>();
        yContent.add(new Entry(m1,0));
        yContent.add(new Entry(m2,1));
        yContent.add(new Entry(m3,2));

    }




    private PieData getPieData3(int count,float range){


        initData3();

        PieDataSet pieDataSet= new PieDataSet(yContent,null);
        //设置饼状图之间的距离
        pieDataSet.setSliceSpace(0f);
        //设置饼状图之间的颜色
        pieDataSet.setColors(colors);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float px = 5 * (metrics.densityDpi / 160f);
        pieDataSet.setSelectionShift(px); // 选中态多出的长度
        PieData pieData = new PieData(xContents, pieDataSet);

        return pieData;
    }
    //数据源咯，这里我们看预定义饼图区域的颜色、大小、介绍，其中框架会自动计算百分比
    private void initData3() {

        // 饼图颜色
        colors = new ArrayList<Integer>();

        colors.add(Color.rgb(205,205,205));
        colors.add(Color.rgb(114,188,223));
        colors.add(Color.rgb(255,123,124));
        colors.add(Color.rgb(57, 135, 200));
        colors.add(Color.rgb(57, 135, 20));
        colors.add(Color.rgb(77, 105, 20));

        /**展示内容*/
        xContents = new ArrayList<String>();
        xContents.add("10分钟");
        xContents.add("20分钟");
        xContents.add("30分钟");
        float m1=121;
        float m2=41;
        float m3=421;
        //将数据展示

        //展示比例
        yContent = new ArrayList<Entry>();
        yContent.add(new Entry(m1,0));
        yContent.add(new Entry(m2,1));
        yContent.add(new Entry(m3,2));

    }


    private PieData getPieData4(int count,float range){


        initData4();

        PieDataSet pieDataSet= new PieDataSet(yContent,null);
        //设置饼状图之间的距离
        pieDataSet.setSliceSpace(0f);
        //设置饼状图之间的颜色
        pieDataSet.setColors(colors);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float px = 5 * (metrics.densityDpi / 160f);
        pieDataSet.setSelectionShift(px); // 选中态多出的长度
        PieData pieData = new PieData(xContents, pieDataSet);

        return pieData;
    }
    //数据源咯，这里我们看预定义饼图区域的颜色、大小、介绍，其中框架会自动计算百分比
    private void initData4() {

        // 饼图颜色
        colors = new ArrayList<Integer>();

        colors.add(Color.rgb(205,205,205));
        colors.add(Color.rgb(114,188,223));
        colors.add(Color.rgb(255,123,124));
        colors.add(Color.rgb(57, 135, 200));
        colors.add(Color.rgb(57, 135, 20));
        colors.add(Color.rgb(77, 105, 20));

        /**展示内容*/
        xContents = new ArrayList<String>();
        xContents.add("有兴趣");
        xContents.add("没兴趣");
        xContents.add("一般");
        float m1=121;
        float m2=41;
        float m3=421;
        //将数据展示

        //展示比例
        yContent = new ArrayList<Entry>();
        yContent.add(new Entry(m1,0));
        yContent.add(new Entry(m2,1));
        yContent.add(new Entry(m3,2));

    }


    private PieData getPieData5(int count,float range){


        initData5();

        PieDataSet pieDataSet= new PieDataSet(yContent,null);
        //设置饼状图之间的距离
        pieDataSet.setSliceSpace(0f);
        //设置饼状图之间的颜色
        pieDataSet.setColors(colors);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float px = 5 * (metrics.densityDpi / 160f);
        pieDataSet.setSelectionShift(px); // 选中态多出的长度
        PieData pieData = new PieData(xContents, pieDataSet);

        return pieData;
    }
    //数据源咯，这里我们看预定义饼图区域的颜色、大小、介绍，其中框架会自动计算百分比
    private void initData5() {

        // 饼图颜色
        colors = new ArrayList<Integer>();

        colors.add(Color.rgb(205,205,205));
        colors.add(Color.rgb(114,188,223));
        colors.add(Color.rgb(255,123,124));
        colors.add(Color.rgb(57, 135, 200));
        colors.add(Color.rgb(57, 135, 20));
        colors.add(Color.rgb(77, 105, 20));

        /**展示内容*/
        xContents = new ArrayList<String>();
        xContents.add("有兴趣");
        xContents.add("没心情");
        xContents.add("一般");
        float m1=121;
        float m2=41;
        float m3=421;
        //将数据展示

        //展示比例
        yContent = new ArrayList<Entry>();
        yContent.add(new Entry(m1,0));
        yContent.add(new Entry(m2,1));
        yContent.add(new Entry(m3,2));

    }


}
