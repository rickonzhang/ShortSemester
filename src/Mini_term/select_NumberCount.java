package Mini_term;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;
import java.util.Vector;

public class select_NumberCount {
    JFrame jf1 = new JFrame("数据个数统计");
    
    Add_picture pic_panel = new Add_picture();
    JPanel title_Panel,startDate_Panel,endDate_Panel,typeCheck_Panel,data_Panel,button_Panel;

    JLabel start = new JLabel("开始时间（年/月/日）：");
    JLabel end = new JLabel("结束时间（年/月/日）：");
    
    JLabel dateY_Label,dateM_Label,dateD_Label;
    JTextField id_TextField;

    JLabel title_Label;
    JButton check_Button;
    JTextField jt1 = new JTextField();
    JTextField jt2 = new JTextField();
    
    final Vector<String> title = new Vector<String>();
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();
    JPanel jp3 = new JPanel();
    JPanel jp4 = new JPanel();
    

    
    JLabel jl3=new JLabel("设备ID： ");
    JLabel jl4=new JLabel("想要比较的数值： ");
    //JLabel jl1 = new JLabel("开始时间（年/月/日）： ");
    //JLabel jl2 = new JLabel("结束时间（年/月/日）： ");
    String[] str1 = {"2019","2020", "2021"};
    String[] str2 = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    String[] str3 = {"01", "02", "03", "04", "05", "06", "07", "08", "90", "10", "11", "12", "13",
            "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
            "30", "31"};
    String[] str4 = {"humidity", "temperature", "state","brightness"};

    JComboBox<String> jc1 = new JComboBox<String>(str1);
    JComboBox<String> jc2 = new JComboBox<String>(str2);
    JComboBox<String> jc3 = new JComboBox<String>(str3);
    JComboBox<String> jc4 = new JComboBox<String>(str1);
    JComboBox<String> jc5 = new JComboBox<String>(str2);
    JComboBox<String> jc6 = new JComboBox<String>(str3);
    JComboBox<String> jc7 = new JComboBox<String>(str4);

    JButton jb1 = new JButton("查询");
    public static String[][] vectortoString(Vector<Vector<Object>> a){
        String[][] string = new String[100][10];
        for (int i = 0; i < a.size(); i++) {
            for(int j=0;a.get(i).size() > j;j++){
                string[i][j] = (String) a.get(i).get(j);
            }
        }
        return string;
    }

    public select_NumberCount() {
    	jf1.add(pic_panel);
    	pic_panel.setLayout(new GridLayout(6,1));
    	
    	title_Label = new JLabel("请输入相关信息",JLabel.CENTER);
        title_Label.setFont(new Font("微软雅黑",0,25));
        title_Panel = new JPanel();
        title_Panel.setOpaque(false);
        title_Panel.add(title_Label);
        pic_panel.add(title_Panel);
        
        //开始时间部分
        startDate_Panel = new JPanel();
        start.setFont(new Font("微软雅黑",0,18));
        //startDate_Panel.setLayout(new GridLayout(1,7));
        startDate_Panel.add(start);
        //jc1 = new JComboBox<String>(str1);
       
        jc1.setFont(new Font("微软雅黑",0,15));
        jc1.setPreferredSize(new Dimension (100,30));
        startDate_Panel.add(jc1);
        dateY_Label = new JLabel("年");
        dateY_Label.setFont(new Font("微软雅黑",0,18));
        startDate_Panel.add(dateY_Label);
        //jc2 = new JComboBox<String>(str2);
        
        jc2.setFont(new Font("微软雅黑",0,15));
        jc2.setPreferredSize(new Dimension (80,30));
        startDate_Panel.add(jc2);
        dateM_Label = new JLabel("月");
        dateM_Label.setFont(new Font("微软雅黑",0,18));
        startDate_Panel.add(dateM_Label);
        //jc3 = new JComboBox<String>(str3);
        
        jc3.setFont(new Font("微软雅黑",0,15));
        jc3.setPreferredSize(new Dimension (80,30));
        startDate_Panel.add(jc3);
        dateD_Label = new JLabel("日");
        dateD_Label.setFont(new Font("微软雅黑",0,18));
        startDate_Panel.add(dateD_Label);
        pic_panel.add(startDate_Panel);

        //结束时间部分
        endDate_Panel = new JPanel();
        end.setFont(new Font("微软雅黑",0,18));
        //endDate_Panel.setLayout(new GridLayout(1,7));
        endDate_Panel.add(end);

        jc4.setFont(new Font("微软雅黑",0,15));
        jc4.setPreferredSize(new Dimension (100,30));
        endDate_Panel.add(jc4);
        dateY_Label = new JLabel("年");
        dateY_Label.setFont(new Font("微软雅黑",0,18));
        endDate_Panel.add(dateY_Label);

        jc5.setFont(new Font("微软雅黑",0,15));
        jc5.setPreferredSize(new Dimension (80,30));
        endDate_Panel.add(jc5);
        dateM_Label = new JLabel("月");
        dateM_Label.setFont(new Font("微软雅黑",0,18));
        endDate_Panel.add(dateM_Label);

        jc6.setFont(new Font("微软雅黑",0,15));
        jc6.setPreferredSize(new Dimension (80,30));
        endDate_Panel.add(jc6);
        dateD_Label = new JLabel("日");
        dateD_Label.setFont(new Font("微软雅黑",0,18));
        endDate_Panel.add(dateD_Label);
        pic_panel.add(endDate_Panel);
		
        typeCheck_Panel = new JPanel();
        //typeCheck_Panel.setLayout(new GridLayout(5,1));
        jl3.setFont(new Font("微软雅黑",0,18));
        typeCheck_Panel.add(jl3);
        jl3.setFont(new Font("微软雅黑",0,18));
        typeCheck_Panel.add(jt1);
        jt1.setPreferredSize(new Dimension (100,30));
        typeCheck_Panel.add(jc7);
        jc7.setPreferredSize(new Dimension (80,30));
        pic_panel.add(typeCheck_Panel);
        
        data_Panel = new JPanel();
        data_Panel.add(jl4);
        jl4.setFont(new Font("微软雅黑",0,18));
        data_Panel.add(jt2);
        jt2.setPreferredSize(new Dimension (100,30));
        pic_panel.add(data_Panel);
        
        button_Panel = new JPanel();
        button_Panel.add(jb1);
        
        pic_panel.add(button_Panel);
    	
        title_Panel.setOpaque(false);
        startDate_Panel.setOpaque(false);
        endDate_Panel.setOpaque(false);
        typeCheck_Panel.setOpaque(false);
        data_Panel.setOpaque(false);
        button_Panel.setOpaque(false);

        jb1.setActionCommand("1");
        jf1.setSize(700,500);
        jf1.setVisible(true);
        jf1.setLocationRelativeTo(null);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("1")) {
                    String s1 = jc1.getSelectedItem().toString();
                    String s2 = jc2.getSelectedItem().toString();
                    String s3 = jc3.getSelectedItem().toString();
                    String st = s1 + "-" + s2 + "-" + s3 + " " + "00:00:00";

                    String s4 = jc4.getSelectedItem().toString();
                    String s5 = jc5.getSelectedItem().toString();
                    String s6 = jc6.getSelectedItem().toString();
                    String ed = s4 + "-" + s5 + "-" + s6 + " " + "00:00:00";
                    //switch(jc7.getSelectedItem().toString()) {
                    if (Objects.requireNonNull(jc7.getSelectedItem()).toString().equals("humidity")) {


                        //System.out.println(jt2.getText());
                        //System.out.println(st);
                        //System.out.println(ed);
                        Vector vector = inquire.inquireB1(jt1.getText(), Integer.parseInt(jt2.getText()), st, ed);


                        JFrame aFrame = new JFrame();
                        Vector title=new Vector();//对应列数
                        title.add("大于");
                        title.add("等于");
                        title.add("小于");

                        JTable t1=new JTable(vector,title);
                        t1.setRowHeight(30);//�����и�
                        t1.setRowHeight(30);//�����и�
                        t1.setFont(new Font("微软雅黑",2,15));//设置字体格式
                        JScrollPane sp=new JScrollPane(t1);

                        //  SetTableColumnCenter set = new SetTableColumnCenter();
                        //  set.setTableColumnCenter(t1);
                        JPanel aJPanel = new JPanel();
                        aJPanel.add(sp,BorderLayout.CENTER);
                       // SetTableColumnCenter set = new SetTableColumnCenter();
                       // set.setTableColumnCenter(t1);
                     //   JPanel aJPanel = new JPanel();
                     //   aJPanel.add(t1.getTableHeader(),BorderLayout.NORTH);
                       // aJPanel.add(t1, BorderLayout.CENTER);

                        aFrame.add(aJPanel);

                        aFrame.setSize(700,400);
                        aFrame.setVisible(true);
                        aFrame.setLocationRelativeTo(null);

                        //System.out.println("11111");
                        //System.out.println(t1.getRowCount());
                        String[] greater = new String[t1.getRowCount()];//行数
                        for (int i = 1; i <= t1.getRowCount(); i++) {
                            greater[i - 1] = (String) t1.getValueAt(i - 1, 0);
                            //System.out.println(greater[i - 1]);
                        }//一列的数值
                        //System.out.println("1111111");

                        String[] equil = new String[t1.getRowCount()];
                        for (int i = 1; i <= t1.getRowCount(); i++) {
                            equil[i - 1] = (String) t1.getValueAt(i - 1, 1);
                            //System.out.println(equil[i - 1]);
                        }//
                        String[] small = new String[t1.getRowCount()];
                        for (int i = 1; i <= t1.getRowCount(); i++) {
                            small[i - 1] = (String) t1.getValueAt(i - 1, 2);
                        }//

                        int g = Integer.parseInt(greater[0]);
                        int eq = Integer.parseInt(equil[0]);
                        int s = Integer.parseInt(small[0]);
                        DefaultPieDataset dataset = new DefaultPieDataset();
                        dataset.setValue("大于", g);
                        dataset.setValue("等于", eq);
                        dataset.setValue("小于", s);

                        JFreeChart chart = ChartFactory.createPieChart(
                                "湿度数值个数统计",
                                dataset,
                                true,
                                false,
                                false);
                        PiePlot plot = (PiePlot) chart.getPlot();
                        DecimalFormat df = new DecimalFormat("0.00%");
                        NumberFormat nf = NumberFormat.getNumberInstance();
                        StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象
                        plot.setLabelGenerator(sp1);

                        plot.setNoDataMessage("NO DATA");
                        plot.setCircular(false);
                        plot.setLabelGap(0.02D);

                        plot.setIgnoreNullValues(true);
                        plot.setIgnoreZeroValues(true);
                        chart.getTitle().setFont(new Font("Arial", Font.BOLD, 20));
                        PiePlot piePlot = (PiePlot) chart.getPlot();
                        piePlot.setLabelFont(new Font("Arial", Font.BOLD, 10));
                        chart.getLegend().setItemFont(new Font("Arial", Font.BOLD, 10));
                        ChartFrame mChartFrame = new ChartFrame("湿度数值个数饼状图", chart);
                        mChartFrame.pack();
                        mChartFrame.setVisible(true);
                    } else if (jc7.getSelectedItem().toString().equals("temperature")) {

                        Vector value = inquire.inquireB2(jt1.getText(), Integer.parseInt(jt2.getText()), st, ed);
                        String[][] rowData = select_NumberCount.vectortoString(value);
                        String[] columnNames = {"1", "2", "3"};
                        JTable table = new JTable(rowData, columnNames);
                        table.setRowHeight(30);//�����и�
                        table.setFont(new Font("微软雅黑", 2, 15));//���������ʽ
                        SetTableColumnCenter set = new SetTableColumnCenter();
                        set.setTableColumnCenter(table);
                        JPanel jp3 = new JPanel();
                        jp3.setOpaque(false);
                        jf1.add(jp3, BorderLayout.CENTER);
                        table.setOpaque(false);
                        jp3.add(table.getTableHeader(), BorderLayout.NORTH);
                        jp3.add(table, BorderLayout.CENTER);
                        //System.out.println("11111");
                        //System.out.println(table.getRowCount());
                        String[] greater = new String[table.getRowCount()];//行数
                        for (int i = 1; i <= table.getRowCount(); i++) {
                            greater[i - 1] = (String) table.getValueAt(i - 1, 0);
                            //System.out.println(greater[i - 1]);
                        }//一列的数值
                        //System.out.println("1111111");

                        String[] equil = new String[table.getRowCount()];
                        for (int i = 1; i <= table.getRowCount(); i++) {
                            equil[i - 1] = (String) table.getValueAt(i - 1, 1);
                            //System.out.println(equil[i - 1]);
                        }//
                        String[] small = new String[table.getRowCount()];
                        for (int i = 1; i <= table.getRowCount(); i++) {
                            small[i - 1] = (String) table.getValueAt(i - 1, 2);
                        }//

                        int g = Integer.parseInt(greater[0]);
                        int eq = Integer.parseInt(equil[0]);
                        int s = Integer.parseInt(small[0]);
                        DefaultPieDataset dataset = new DefaultPieDataset();
                        dataset.setValue("大于", g);
                        dataset.setValue("等于", eq);
                        dataset.setValue("小于", s);
                        JFreeChart chart = ChartFactory.createPieChart(
                                "温度数值个数统计",
                                dataset,
                                true,
                                false,
                                false);
                        PiePlot plot = (PiePlot) chart.getPlot();
                        DecimalFormat df = new DecimalFormat("0.00%");
                        NumberFormat nf = NumberFormat.getNumberInstance();
                        StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象
                        plot.setLabelGenerator(sp1);

                        plot.setNoDataMessage("NO DATA");
                        plot.setCircular(false);
                        plot.setLabelGap(0.02D);

                        plot.setIgnoreNullValues(true);
                        plot.setIgnoreZeroValues(true);
                        chart.getTitle().setFont(new Font("Arial", Font.BOLD, 20));
                        PiePlot piePlot = (PiePlot) chart.getPlot();
                        piePlot.setLabelFont(new Font("Arial", Font.BOLD, 10));
                        chart.getLegend().setItemFont(new Font("Arial", Font.BOLD, 10));
                        ChartFrame mChartFrame = new ChartFrame("温度数值个数饼状图", chart);
                        mChartFrame.pack();
                        mChartFrame.setVisible(true);
                    } else if (jc7.getSelectedItem().toString().equals("state")) {
                        Vector value = inquire.inquireB3(jt1.getText(), st, ed);
                        String[][] rowData = select_NumberCount.vectortoString(value);
                        String[] columnNames = {"1", "2", "3"};
                        JTable table = new JTable(rowData, columnNames);
                        table.setRowHeight(30);//�����и�
                        table.setFont(new Font("微软雅黑", 2, 15));//���������ʽ
                        SetTableColumnCenter set = new SetTableColumnCenter();
                        set.setTableColumnCenter(table);
                        JPanel jp3 = new JPanel();
                        jp3.setOpaque(false);
                        jf1.add(jp3, BorderLayout.CENTER);
                        table.setOpaque(false);
                        jp3.add(table.getTableHeader(), BorderLayout.NORTH);
                        jp3.add(table, BorderLayout.CENTER);
                        //System.out.println("11111");
                        //System.out.println(table.getRowCount());
                        String[] greater = new String[table.getRowCount()];//行数
                        for (int i = 1; i <= table.getRowCount(); i++) {
                            greater[i - 1] = (String) table.getValueAt(i - 1, 0);
                            //System.out.println(greater[i - 1]);
                        }//一列的数值
                        //System.out.println("1111111");

                        String[] equil = new String[table.getRowCount()];
                        for (int i = 1; i <= table.getRowCount(); i++) {
                            equil[i - 1] = (String) table.getValueAt(i - 1, 1);
                            //System.out.println(equil[i - 1]);
                        }
                        int g = Integer.parseInt(greater[0]);
                        int eq = Integer.parseInt(equil[0]);

                        DefaultPieDataset dataset = new DefaultPieDataset();
                        dataset.setValue("关", g);
                        dataset.setValue("开", eq);

                        JFreeChart chart = ChartFactory.createPieChart(
                                "开关状态数值个数统计",
                                dataset,
                                true,
                                false,
                                false);
                        PiePlot plot = (PiePlot) chart.getPlot();
                        DecimalFormat df = new DecimalFormat("0.00%");
                        NumberFormat nf = NumberFormat.getNumberInstance();
                        StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象
                        plot.setLabelGenerator(sp1);

                        plot.setNoDataMessage("NO DATA");
                        plot.setCircular(false);
                        plot.setLabelGap(0.02D);

                        plot.setIgnoreNullValues(true);
                        plot.setIgnoreZeroValues(true);
                        chart.getTitle().setFont(new Font("Arial", Font.BOLD, 20));
                        PiePlot piePlot = (PiePlot) chart.getPlot();
                        piePlot.setLabelFont(new Font("Arial", Font.BOLD, 10));
                        chart.getLegend().setItemFont(new Font("Arial", Font.BOLD, 10));
                        ChartFrame mChartFrame = new ChartFrame("开关状态数值个数饼状图", chart);
                        mChartFrame.pack();
                        mChartFrame.setVisible(true);

                    } else if (jc7.getSelectedItem().toString().equals("brightness")) {
                        Vector vector = inquire.inquireB2(jt1.getText(), Integer.parseInt(jt2.getText()), st, ed);

                        JFrame aFrame = new JFrame();
                        Vector title=new Vector();//对应列数
                        title.add("大于");
                        title.add("等于");
                        title.add("小于");

                        JTable t1=new JTable(vector,title);
                        t1.setRowHeight(30);//�����и�
                        t1.setRowHeight(30);//�����и�
                        t1.setFont(new Font("微软雅黑",2,15));//设置字体格式
                        SetTableColumnCenter set = new SetTableColumnCenter();
                        set.setTableColumnCenter(t1);
                        JPanel aJPanel = new JPanel();
                        aJPanel.add(t1.getTableHeader(),BorderLayout.NORTH);
                        aJPanel.add(t1, BorderLayout.CENTER);

                        aFrame.add(aJPanel);

                        aFrame.setSize(700,400);
                        aFrame.setVisible(true);
                        aFrame.setLocationRelativeTo(null);
                        
                        String[] greater = new String[t1.getRowCount()];//行数
                        for (int i = 1; i <= t1.getRowCount(); i++) {
                            greater[i - 1] = (String) t1.getValueAt(i - 1, 0);
                            //System.out.println(greater[i - 1]);
                        }//一列的数值
                        //System.out.println("1111111");

                        String[] equil = new String[t1.getRowCount()];
                        for (int i = 1; i <= t1.getRowCount(); i++) {
                            equil[i - 1] = (String) t1.getValueAt(i - 1, 1);
                            //System.out.println(equil[i - 1]);
                        }//
                        String[] small = new String[t1.getRowCount()];
                        for (int i = 1; i <= t1.getRowCount(); i++) {
                            small[i - 1] = (String) t1.getValueAt(i - 1, 2);
                        }//
                        int g = Integer.parseInt(greater[0]);
                        int eq = Integer.parseInt(equil[0]);
                        int s = Integer.parseInt(small[0]);
                        DefaultPieDataset dataset = new DefaultPieDataset();
                        dataset.setValue("大于", g);
                        dataset.setValue("等于", eq);
                        dataset.setValue("小于", s);

                        JFreeChart chart = ChartFactory.createPieChart(
                                "亮度数值个数统计",
                                dataset,
                                true,
                                false,
                                false);
                        PiePlot plot = (PiePlot) chart.getPlot();
                        DecimalFormat df = new DecimalFormat("0.00%");
                        NumberFormat nf = NumberFormat.getNumberInstance();
                        StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象
                        plot.setLabelGenerator(sp1);

                        plot.setNoDataMessage("NO DATA");
                        plot.setCircular(false);
                        plot.setLabelGap(0.02D);

                        plot.setIgnoreNullValues(true);
                        plot.setIgnoreZeroValues(true);
                        chart.getTitle().setFont(new Font("Arial", Font.BOLD, 20));
                        PiePlot piePlot = (PiePlot) chart.getPlot();
                        piePlot.setLabelFont(new Font("Arial", Font.BOLD, 10));
                        chart.getLegend().setItemFont(new Font("Arial", Font.BOLD, 10));
                        ChartFrame mChartFrame = new ChartFrame("亮度数值个数饼状图", chart);
                        mChartFrame.pack();
                        mChartFrame.setVisible(true);
                    }
                }
            }
        });
    }
}




