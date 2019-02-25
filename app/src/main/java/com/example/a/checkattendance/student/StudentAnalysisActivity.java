package com.example.a.checkattendance.student;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import com.example.a.checkattendance.Admin.AdminClassAnalysisActivity;
import com.example.a.checkattendance.Admin.AdminPersonAnalysisActivity;
import com.example.a.checkattendance.BaseActivity;
import com.example.a.checkattendance.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.Legend;

import java.util.ArrayList;

public class StudentAnalysisActivity extends BaseActivity implements View.OnClickListener {
    private PieChart mPiechart1;
    private ArrayList<String> xContents;
    private ArrayList<Entry> yContent;
    private ArrayList<Integer> colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_analysis);

        mPiechart1= (PieChart) findViewById(R.id.mPieChart1);
        PieData mPieData1 = getPieData1(4, 100);
        showChart(mPiechart1, mPieData1);

        Button button_back=(Button)findViewById(R.id.back);
        button_back.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.back:
                finish();
                break;
            default:
                break;
        }
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

}
