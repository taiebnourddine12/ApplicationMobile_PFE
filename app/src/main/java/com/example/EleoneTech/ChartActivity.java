package com.example.EleoneTech;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ekn.gruzer.gaugelibrary.HalfGauge;
import com.ekn.gruzer.gaugelibrary.Range;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ChartActivity extends AppCompatActivity {
    PieChart fpyPie, pie;
    TextView textView;
    HalfGauge quality;
    int pass_total, pass_date, faild_date, count_date, count_total, total_faild ;
    float val, fpy, coefqualite, tauxqualite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Statistique Par Testeurs");

        textView=(TextView)findViewById(R.id.textView);
        textView.setText("PASS / FAILD");
        textView.setVisibility(View.VISIBLE);

        count_date = SearchTester.count_date;
        pass_date = SearchTester.pass_date;
        faild_date = SearchTester.faild_date;
        count_total = SearchTester.count_total;
        pass_total = SearchTester.pass_total;
        total_faild = SearchTester.faild_total;

        val = (float) pass_date /(float) pass_total;
        fpy = val * 100;
        coefqualite = (float) pass_total / (float) count_total ;
        tauxqualite = coefqualite * 100;

        fpyPie = (PieChart) findViewById(R.id.piechart1);
        quality = (HalfGauge) findViewById(R.id.piechart2);
        pie = (PieChart) findViewById(R.id.piechart3);


        fpyPie.setVisibility(View.VISIBLE);
        fpyPie();
        quality();
        pie();

    }


    private void fpyPie() {
        ArrayList<PieEntry> records = new ArrayList<>();
        records.add(new PieEntry(fpy, "%"));
        records.add(new PieEntry(100 - fpy, "%"));

        PieDataSet dataSet = new PieDataSet(records, "");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(22f);

        PieData pieData = new PieData(dataSet);

        fpyPie.setData(pieData);
        fpyPie.getDescription().setEnabled(false);
        fpyPie.setCenterText("FPY");
        fpyPie.animate();

    }

    private void quality() {
        Range range = new Range();
        range.setColor(Color.parseColor("#ce0000"));
        range.setFrom(0.0);
        range.setTo(33.0);

        Range range2 = new Range();
        range2.setColor(Color.parseColor("#E3E500"));
        range2.setFrom(33.0);
        range2.setTo(66.0);

        Range range3 = new Range();
        range3.setColor(Color.parseColor("#00b20b"));
        range3.setFrom(66.0);
        range3.setTo(100.0);


        //add color ranges to gauge
        quality.addRange(range);
        quality.addRange(range2);
        quality.addRange(range3);
        quality.getNeedleAngle();

        //set min max and current value
        quality.setMinValue(0.0);
        quality.setMaxValue(100.0);
        quality.setValue(tauxqualite);

        quality.animate();
    }

    private void pie() {
        ArrayList<PieEntry> records = new ArrayList<>();
        records.add(new PieEntry(pass_date, "pass"));
        records.add(new PieEntry(faild_date, "faild"));

        PieDataSet dataSet = new PieDataSet(records, "");
        dataSet.setColors(ColorTemplate.PASTEL_COLORS);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(22f);

        PieData pieData = new PieData(dataSet);

        pie.setData(pieData);
        pie.getDescription().setEnabled(false);
        pie.setCenterText("");
        pie.animate();
    }

    public void click(View view) {
        if (fpyPie.getVisibility() == View.VISIBLE) {
            quality.setVisibility(View.VISIBLE);
            pie.setVisibility(View.INVISIBLE);
            fpyPie.setVisibility(View.INVISIBLE);
            textView.setText("Quality");
            textView.setVisibility(View.VISIBLE);
        } else if (quality.getVisibility() == View.VISIBLE) {
            pie.setVisibility(View.VISIBLE);
            fpyPie.setVisibility(View.INVISIBLE);
            quality.setVisibility(View.INVISIBLE);
            textView.setText("PASS / FAILD");
            textView.setVisibility(View.VISIBLE);
        } else {
            fpyPie.setVisibility(View.VISIBLE);
            quality.setVisibility(View.INVISIBLE);
            pie.setVisibility(View.INVISIBLE);
            textView.setText("FPY");
            textView.setVisibility(View.VISIBLE);
        }
    }
}