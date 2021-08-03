package Mini_term;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;




import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;
import java.util.Vector;

public class select_Distribution {
JFrame jf1 = new JFrame("数据分布统计");
    
    Add_picture pic_panel = new Add_picture();
    JPanel title_Panel,startDate_Panel,endDate_Panel,typeCheck_Panel,
    			dataName_Panel,data_Panel,button_Panel;

    JLabel start = new JLabel("开始时间（年/月/日）：");
    JLabel end = new JLabel("结束时间（年/月/日）：");
    
    JLabel dateY_Label,dateM_Label,dateD_Label;
    JTextField id_TextField;

    JLabel title_Label;
    JButton check_Button;
    JTextField jt1 = new JTextField();
    
    final Vector<String> title = new Vector<String>();
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();
    JPanel jp3 = new JPanel();
    JPanel jp4 = new JPanel();
    

    
    JLabel jl3=new JLabel("设备类型： ");
    JLabel jl4=new JLabel("测量数值名称：");
    JLabel jl5=new JLabel("请输入分段上限（如：1，2，3）");
    String[] str1 = {"2019","2020", "2021"};
    String[] str2 = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    String[] str3 = {"01", "02", "03", "04", "05", "06", "07", "08", "90", "10", "11", "12", "13",
            "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
            "30", "31"};
    String[] str4 = {"humidity", "temperature", "state","brightness"};
    String[] str5 = {"温湿监测","灯", "门"};

    JComboBox<String> jc1 = new JComboBox<String>(str1);
    JComboBox<String> jc2 = new JComboBox<String>(str2);
    JComboBox<String> jc3 = new JComboBox<String>(str3);
    JComboBox<String> jc4 = new JComboBox<String>(str1);
    JComboBox<String> jc5 = new JComboBox<String>(str2);
    JComboBox<String> jc6 = new JComboBox<String>(str3);
    JComboBox<String> jc7 = new JComboBox<String>(str5);
    JComboBox<String> jc8 = new JComboBox<String>(str4);
    
    JButton jb1 = new JButton("查询");
                
    public static int[] converttoInt(String str){
        int i=0;
        int[] a = new int[500];
        int j=0;
        int stop=1;
        str=str.trim();
        String str2="";
        if(str != null && !"".equals(str)){
            for(i=0;i<str.length();i++){
                if(str.charAt(i)>=48 && str.charAt(i)<=57){
                    str2+=str.charAt(i);
                    //System.out.println(str2);
                }else
                {   if(!str2.equals(""))
                    stop = 0;
                }
                if(i==str.length()-1)
                    stop = 0;
                //System.out.println(stop);
                if(stop==0&&!str2.equals("")){
                    a[j] = Integer.parseInt(str2);;
                    j++;
                    stop = 1;
                    //System.out.println(j);
                    str2 = new String();
                }
            }
        }
        int[] last = new int[j];
        for(int x = 0;x<j;x++)
            last[x]=a[x];
        return last;
    }

    public static String[][] vectortoString(Vector<Vector<Object>> a){
    	String[][] string = new String[100][10];

        for (int i = 0; i < a.size(); i++) {
            for(int j=0;a.get(i).size() > j;j++){
                string[i][j] = (String) a.get(i).get(j);
            }
        }
        return string;
    }

    public select_Distribution() {
    	jf1.add(pic_panel);
    	pic_panel.setLayout(new GridLayout(7,1));
    	
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
        jc7.setPreferredSize(new Dimension (80,30));
        typeCheck_Panel.add(jc7);
        pic_panel.add(typeCheck_Panel);
        
        dataName_Panel = new JPanel();
        jl4.setFont(new Font("微软雅黑",0,18));
        dataName_Panel.add(jl4);
        jc8.setPreferredSize(new Dimension (80,30));
        dataName_Panel.add(jc8);
        dataName_Panel.setOpaque(false);
        pic_panel.add(dataName_Panel);
        
        
        /*jp1.add(jl4);
    	jp1.add(jl5);
    	jp1.add(jt1);*/
        //
        data_Panel = new JPanel();
        jl5.setFont(new Font("微软雅黑",0,18));
        data_Panel.add(jl5);
        jt1.setPreferredSize(new Dimension (100,30));
        data_Panel.add(jt1);
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
        jf1.setSize(600,700);
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
                //if (Objects.requireNonNull(jc7.getSelectedItem()).toString().equals("humidity")) {
                   // System.out.println(jt2.getText());
                    //System.out.println(st);
                   // System.out.println(ed);
            		int[]a=converttoInt(jt1.getText());

            		Vector value = inquire.inquireC(jc7.getSelectedItem().toString(),jc8.getSelectedItem().toString(),a, st, ed);

            		JTable t1 = new JTable();
            		//System.out.println(value);
            		JScrollPane scr1 = new JScrollPane(t1);
            		Vector v= (Vector) value.get(0);
                // System.out.println((Vector) vector.get(0));
            		int r=v.size();
            		Vector title=new Vector();
            		for(int i=0;i<a.length;i++) {
            			title.add("分段"+i);
            		}
            		//System.out.println(title);
            		final DefaultTableModel model = new DefaultTableModel(value,title);
            		t1.setModel(model);
            		if(t1.getRowCount() > 0){
            			t1.setRowSelectionInterval(0, 0);
            		}

            		String[][] rowData = select_NumberCount.vectortoString(value);
            		System.out.println(value);
            		String[]columnNames=new String[a.length];
            		System.out.println(a.length);
            		for(int i=0;i<a.length;i++){
            			columnNames[i]="分段"+i;
                    //title.add("分段"+i);
                   // System.out.println("分段"+i);
            		}
            		JTable table = new JTable(rowData, columnNames);
            		table.setRowHeight(30);
            		table.setFont(new Font("微软雅黑", 2, 15));//���������ʽ
            		SetTableColumnCenter set = new SetTableColumnCenter();
            		set.setTableColumnCenter(table);

            		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            		for(int n=0;n<r;n++){
            			String[ ] greater =new String[2];
            			greater[0] = (String) t1.getValueAt(0, n);
            			dataset.addValue(Double.parseDouble(greater[0]), "分段"+n, "分段"+n);
            			System.out.println(n);
            			System.out.println(r);
            		}
            		JFreeChart chart = ChartFactory.createBarChart(
                        "某个测量值的数据分布",
                        "分段",
                        "数值",
                        dataset,
                        PlotOrientation.VERTICAL,
                        true,
                        true,
                        false);
            		CategoryPlot plot = chart.getCategoryPlot();
                CategoryAxis domainAxis=plot.getDomainAxis();
                domainAxis.setLabelFont(new Font("Arial",Font.BOLD,14));
                domainAxis.setTickLabelFont(new Font("Arial",Font.BOLD,12));
                ValueAxis rangeAxis=plot.getRangeAxis();
                rangeAxis.setLabelFont(new Font("Arial",Font.BOLD,15));
                chart.getLegend().setItemFont(new Font("Arial", Font.BOLD, 15));
                chart.getTitle().setFont(new Font("Arial",Font.BOLD,20));

                ChartFrame mChartFrame = new ChartFrame("柱状图", chart);
                mChartFrame.pack();
                mChartFrame.setVisible(true);

            }}});}}
