package com.example.mpandroidxaxisasdate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import java.security.KeyStore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val linearLayout = findViewById<LinearLayout>(R.id.linear_layout)


        // Data : x:Float,y:Float pairs
        var indecies = listOf<Index>(
            Index(20191130f, 1f),
            Index(20191201f, 2f),
            Index(20191202f, 3f),
            Index(20191203f, 4f),
            Index(20191204f, 5f),
            Index(20191231f, 6f),
        )

        // List of Entry Object
        var entries1 = ArrayList<Entry>()

        // Make Entry Objects from data(indecies)
        for (index in indecies)
        {
            entries1.add(Entry(index.xVal, index.yVal))
        }

        // LineDataSet : include data
        // Can be customized separately
        val lineDataSet : LineDataSet = LineDataSet(entries1, "No Conversion")

        //add LineDataSets on LineData Object
        val datasets1 : ArrayList<ILineDataSet> = ArrayList()
        // for this example, add 1 data set
        datasets1.add(lineDataSet)
        val data1 = LineData(datasets1)

        val lineChart1: LineChart = findViewById(R.id.chart1)
        lineChart1.data = data1

        lineChart1.invalidate() // refresh


    }
}

data class Index(val xVal: Float, val yVal:Float)