package Mini_term;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Chart {

    public Chart(){
    }
    public static CategoryDataset GetDataset(String[] data,String a,String []date)
    {
        DefaultCategoryDataset mDataset = new DefaultCategoryDataset();

        for(int i = 0;i < data.length;i++){
            mDataset.addValue(Float.valueOf(data[i]), a, date[i]);
        }

        return mDataset;
    }

}
