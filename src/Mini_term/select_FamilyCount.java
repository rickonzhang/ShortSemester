package Mini_term;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class select_FamilyCount implements ActionListener {
    JFrame main_Frame ;
    JFrame temp_Frame,light_Frame;
    Add_picture pic_panel = new Add_picture();
    JPanel title_Panel,startDate_Panel,endDate_Panel,typeCheck_Panel,Graph_Panel;
    JComboBox<String> dataType_ComboBox,id_ComboBox,
            startY_ComboBox,startM_ComboBox,startD_ComboBox,
            endY_ComboBox,endM_ComboBox,endD_ComboBox;
    JLabel start = new JLabel("开始时间（年/月/日）：");
    JLabel end = new JLabel("结束时间（年/月/日）：");
    JLabel dateY_Label,dateM_Label,dateD_Label;
    JTextField id_TextField;

    JLabel title_Label;
    JButton check_Button,temp_Button,light_Button;
    JTextField temp_TextField,light_TextField;

    JTable data_table;
    JScrollPane data_ScrollPane;
    String[] year = new String[] {" ","2020","2021"};
    String[] month = new String[] {" ","01","02","03","04","05","06","07","08","09","10","11","12"};
    String[] date = new String[] {" ","01","02","03","04","05","06","07","08","09","10","11","12","13",
            "14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29",
            "30","31",};;
    String[] dataType = new String[] {" ","equipment","type","family"};
    String[] infor = new String[5];//查询时传入
    String[] check = new String[10];//填写完整
    String id_String;
    Object[][] data_rowData;
    String[] data_columnNames = {"设备编号","设备类别编号","设备类别名称","设备名称","设备信息"};
    int guide = 0;
    JFrame superFrame;
    public select_FamilyCount() {
        main_Frame = new JFrame("统计多个家庭汇总数据");
        pic_panel.setLayout(new GridLayout(5,1));

        title_Label = new JLabel("请输入相关信息",JLabel.CENTER);
        title_Label.setFont(new Font("微软雅黑",0,25));
        title_Panel = new JPanel();
        title_Panel.setOpaque(false);
        //title_Panel.setLayout(null);
        //title_Panel.setPreferredSize(new Dimension(70, 400));
        title_Panel.add(title_Label);
        pic_panel.add(title_Panel);

        //锟斤拷始时锟斤拷锟斤拷锟�
        startDate_Panel = new JPanel();
        start.setFont(new Font("微软雅黑",0,18));
        //startDate_Panel.setLayout(new GridLayout(1,7));
        startDate_Panel.add(start);
        startY_ComboBox = new JComboBox<String>(year);
        startY_ComboBox.setFont(new Font("微软雅黑",0,15));
        startY_ComboBox.setPreferredSize(new Dimension (100,30));
        startDate_Panel.add(startY_ComboBox);
        dateY_Label = new JLabel("年");
        dateY_Label.setFont(new Font("微软雅黑",0,18));
        startDate_Panel.add(dateY_Label);
        startM_ComboBox = new JComboBox<String>(month);
        startM_ComboBox.setFont(new Font("微软雅黑",0,15));
        startM_ComboBox.setPreferredSize(new Dimension (80,30));
        startDate_Panel.add(startM_ComboBox);
        dateM_Label = new JLabel("月");
        dateM_Label.setFont(new Font("微软雅黑",0,18));
        startDate_Panel.add(dateM_Label);
        startD_ComboBox = new JComboBox<String>(date);
        startD_ComboBox.setFont(new Font("微软雅黑",0,15));
        startD_ComboBox.setPreferredSize(new Dimension (80,30));
        startDate_Panel.add(startD_ComboBox);
        dateD_Label = new JLabel("日");
        dateD_Label.setFont(new Font("微软雅黑",0,18));
        startDate_Panel.add(dateD_Label);
        startDate_Panel.setOpaque(false);
        pic_panel.add(startDate_Panel);

        //锟斤拷锟斤拷时锟斤拷锟斤拷锟�
        endDate_Panel = new JPanel();
        end.setFont(new Font("微软雅黑",0,18));
        //endDate_Panel.setLayout(new GridLayout(1,7));
        endDate_Panel.add(end);
        endY_ComboBox = new JComboBox<String>(year);
        endY_ComboBox.setFont(new Font("微软雅黑",0,15));
        endY_ComboBox.setPreferredSize(new Dimension (100,30));
        endDate_Panel.add(endY_ComboBox);
        dateY_Label = new JLabel("年");
        dateY_Label.setFont(new Font("微软雅黑",0,18));
        endDate_Panel.add(dateY_Label);
        endM_ComboBox = new JComboBox<String>(month);
        endM_ComboBox.setFont(new Font("微软雅黑",0,15));
        endM_ComboBox.setPreferredSize(new Dimension (80,30));
        endDate_Panel.add(endM_ComboBox);
        dateM_Label = new JLabel("月");
        dateM_Label.setFont(new Font("微软雅黑",0,18));
        endDate_Panel.add(dateM_Label);
        endD_ComboBox = new JComboBox<String>(date);
        endD_ComboBox.setFont(new Font("微软雅黑",0,15));
        endD_ComboBox.setPreferredSize(new Dimension (80,30));
        endDate_Panel.add(endD_ComboBox);
        dateD_Label = new JLabel("日");
        dateD_Label.setFont(new Font("微软雅黑",0,18));
        endDate_Panel.add(dateD_Label);
        endDate_Panel.setOpaque(false);
        pic_panel.add(endDate_Panel);

        //���ͽ���
        typeCheck_Panel = new JPanel();
        //typeCheck_Panel.setLayout(new GridLayout(3,1));
        dataType_ComboBox = new JComboBox<String>(dataType);
      //  typeCheck_Panel.add(dataType_ComboBox);
        JLabel label2 = new JLabel("请输入想要查询的多个家庭ID");
        label2.setFont(new Font("微软雅黑",0,18));
        typeCheck_Panel.add(label2);
        id_TextField = new JTextField();
        id_TextField.setPreferredSize(new Dimension (80,30));
        typeCheck_Panel.add(id_TextField);
        check_Button = new JButton("查询详细测量值");
        check_Button.addActionListener(this);
        typeCheck_Panel.add(check_Button);
        typeCheck_Panel.setOpaque(false);
        pic_panel.add(typeCheck_Panel);

        //
        Graph_Panel = new JPanel();
        temp_Button = new JButton("查询平均值");
        temp_Button.setFont(new Font("微软雅黑",0,18));
        Graph_Panel.add(temp_Button);
        temp_Button.addActionListener(this);
        Graph_Panel.setOpaque(false);
        pic_panel.add(Graph_Panel);

        main_Frame.add(pic_panel);

        main_Frame.setSize(700,500);
        main_Frame.setVisible(true);
        main_Frame.setLocationRelativeTo(null);
    }
    public void actionPerformed(ActionEvent e) {
        guide = 0;
        JButton source = (JButton)e.getSource();
        if (source.equals(check_Button)) {
            check[0] = (String) dataType_ComboBox.getSelectedItem();
            check[1] = id_TextField.getText();
            check[2] = (String) startY_ComboBox.getSelectedItem();
            check[3] = (String) startM_ComboBox.getSelectedItem();
            check[4] = (String) startD_ComboBox.getSelectedItem();
            check[5] = (String) endY_ComboBox.getSelectedItem();
            check[6] = (String) endM_ComboBox.getSelectedItem();
            check[7] = (String) endD_ComboBox.getSelectedItem();
            for(int i = 0; i < 8 ; i++) {
                if(check[i].equals("")){
                    guide = 1;
                    break;
                }
            }
            if( guide == 1 ) {
                JOptionPane.showMessageDialog(null, "请填写遗漏的信息", "信息不完整",JOptionPane.ERROR_MESSAGE);
            }
            else {
                infor[0]=check[0];
                infor[1]=check[1];
                infor[2]=check[2]+"-"+check[3]+"-"+check[4]+" "+"00:00:00";
                infor[3]=check[5]+"-"+check[6]+"-"+check[7]+" "+"00:00:00";
                System.out.println(infor[0]);
                JFrame aFrame = new JFrame();
                String[]s=Goldenkey.converttoString(check[1]);//串转成数组
                System.out.println(s.length);
                //================================
                System.out.println(s[0]);
                System.out.println(s[1]);
                System.out.println(s[2]);
                Vector vector=inquire.inquireD1(s, infor[2], infor[3]);
               // System.out.println("想运行D1");



                Vector title=new Vector();
                title.add("家庭ID");
                title.add("数据ID");
                title.add("设备类别");
                title.add("湿度");
                title.add("温度");
                title.add("状态");
                title.add("亮度");
                title.add("时间");
                title.add("设备ID");

                JTable t1=new JTable(vector,title);
                t1.setRowHeight(30);//�����и�
                t1.setRowHeight(30);//�����и�
                t1.setFont(new Font("微软雅黑",2,15));//设置字体格式
                t1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                t1.setBackground(new Color(245, 245, 245));

                TableColumn column;
                // t1.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);// 以下设置表格列宽
                for (int i = 0; i < 9; i++) {
                    column = t1.getColumnModel().getColumn(i);
                    if (i == 7) {
                        column.setPreferredWidth(200);
                    }
                }



                SetTableColumnCenter set = new SetTableColumnCenter();
                set.setTableColumnCenter(t1);
                JPanel aJPanel = new JPanel();
                aJPanel.setLayout(new BorderLayout());
                aJPanel.add(t1.getTableHeader(),BorderLayout.NORTH);
                aJPanel.add(t1, BorderLayout.CENTER);
                data_ScrollPane = new JScrollPane(aJPanel,
        				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

              //

                System.out.println("执行了D1");
                //============================
              //  Vector title=new Vector();
               // title.add("fid");
              //  title.add("");

                //=====================yu hanshu
              /*
              Object[][] rowData = Goldenkey.vectortoString(inquire.inquireD1(s, infor[2], infor[3]));
              String[] columnNames = {"fid","dId","类别","湿度","温度","状态","亮度","时间","eId"};
                        JTable table = new JTable(rowData,columnNames);
                table.setRowHeight(30);//�����и�
                table.setFont(new Font("微软雅黑",2,15));//设置字体格式
                SetTableColumnCenter set = new SetTableColumnCenter();
                set.setTableColumnCenter(table);
                JPanel aJPanel = new JPanel();
                 aJPanel.add(table.getTableHeader(),BorderLayout.NORTH);
                aJPanel.add(table, BorderLayout.CENTER);
               */
//===============================end ================

                aFrame.add(data_ScrollPane);

                aFrame.setSize(850,400);
                aFrame.setVisible(true);
                aFrame.setLocationRelativeTo(null);
                //data_Panel.add(data_ScrollPane,BorderLayout.CENTER);
                }
            }
            if (source.equals(temp_Button)) {
                check[1] = id_TextField.getText();
                check[2] = (String) startY_ComboBox.getSelectedItem();
                check[3] = (String) startM_ComboBox.getSelectedItem();
                check[4] = (String) startD_ComboBox.getSelectedItem();
                check[5] = (String) endY_ComboBox.getSelectedItem();
                check[6] = (String) endM_ComboBox.getSelectedItem();
                check[7] = (String) endD_ComboBox.getSelectedItem();
                for(int i = 2; i < 8 ; i++) {
                    if(check[i].equals("")){
                        guide = 1;
                        break;
                    }
                }
                if( guide == 1 ) {
                    JOptionPane.showMessageDialog(null, "请填写遗漏的信息", "信息不完整",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    infor[0]=check[2]+"-"+check[3]+"-"+check[4]+" "+"00:00:00";
                    infor[1]=check[5]+"-"+check[6]+"-"+check[7]+" "+"00:00:00";
                    String[]s=Goldenkey.converttoString(check[1]);


                    System.out.println("想运行D2");
                    System.out.println("sde changdu "+s.length);
 //===================================================================d2========
                    Vector value= inquire.inquireD2(s, infor[0], infor[1]);
                    System.out.println("运行了D2");

                    JFrame aFrame = new JFrame();
                    Vector title=new Vector();//对应列数
                    title.add("平均湿度");
                    title.add("平均温度");
                    title.add("平均亮度");





                    JTable t1=new JTable(value,title);
                    t1.setRowHeight(30);//�����и�
                    t1.setRowHeight(30);//�����и�
                    t1.setFont(new Font("微软雅黑",2,15));//设置字体格式
                    t1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    JScrollPane sp=new JScrollPane(t1);

                    //  SetTableColumnCenter set = new SetTableColumnCenter();
                    //  set.setTableColumnCenter(t1);
                    JPanel aJPanel = new JPanel();
                    aJPanel.add(sp,BorderLayout.CENTER);
                    //SetTableColumnCenter set = new SetTableColumnCenter();
                    //set.setTableColumnCenter(t1);
                    //JPanel aJPanel = new JPanel();
                   // aJPanel.setLayout(new GridLayout(0,1));
                   // aJPanel.add(t1.getTableHeader());
                 //   aJPanel.add(t1);
                 // aJPanel.add(t1.getTableHeader(),BorderLayout.NORTH);
                   // aJPanel.add(t1, BorderLayout.CENTER);


                    aFrame.add(aJPanel);

                    aFrame.setSize(600,400);
                    aFrame.setVisible(true);
                    aFrame.setLocationRelativeTo(null);




                   /* Vector title=new Vector();
                    title.add("1");
                    title.add("1");
                    title.add("1");

                    */


                   // JTable t1 = new JTable();
                 //   JScrollPane scr1 = new JScrollPane(t1);
                    final DefaultTableModel model = new DefaultTableModel(value,title);
                    t1.setModel(model);
                    if(t1.getRowCount() > 0)
                    {
                        t1.setRowSelectionInterval(0, 0);
                    }
                    String[ ] greater =new String[t1.getRowCount()];//行数
                    for(int i = 1; i <= t1.getRowCount(); i++)
                    {greater[i-1] = (String) t1.getValueAt(i-1, 0);}//一列的数值

                    String[ ] equil =new String[t1.getRowCount()];
                    for(int i = 1; i <= t1.getRowCount(); i++)
                    {equil[i-1] = (String) t1.getValueAt(i-1, 1);}//
                    String[ ] small =new String[t1.getRowCount()];
                    for(int i = 1; i <= t1.getRowCount(); i++)
                    {small[i-1] = (String) t1.getValueAt(i-1, 2);}//

                    // int g=Integer.parseInt(greater[0]);
                    //  int eq=Integer.parseInt(equil[0]);
                    // int s=Integer.parseInt(small[0]);
                    //DefaultPieDataset dataset = new DefaultPieDataset();
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                    // dataset.setValue("大于", g);
                    //  dataset.setValue("等于", eq);
                    //  dataset.setValue("小于", s);
                    dataset.addValue(Double.parseDouble(greater[0]), "平均湿度", "平均湿度");
                    dataset.addValue(Double.parseDouble(equil[0]), "平均温度", "平均温度");
                    dataset.addValue(Double.parseDouble(small[0]), "平均亮度", "平均亮度");

                    JFreeChart chart = ChartFactory.createBarChart(
                            "多个家庭平均湿度温度亮度",
                            "测量值种类",
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
                }
            }



            if (source.equals(light_Button)) {
                check[1] = id_TextField.getText();
                check[2] = (String) startY_ComboBox.getSelectedItem();
                check[3] =  (String) startM_ComboBox.getSelectedItem();
                check[4] = (String) startD_ComboBox.getSelectedItem();
                check[5] = (String) endY_ComboBox.getSelectedItem();
                check[6] = (String) endM_ComboBox.getSelectedItem();
                check[7] = (String) endD_ComboBox.getSelectedItem();
                for(int i = 2; i < 8 ; i++) {
                    if(check[i].equals("")){
                        guide = 1;
                        break;
                    }
                }
                if( guide == 1 ) {
                    JOptionPane.showMessageDialog(null, "����д��©����Ϣ", "��Ϣ������",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    infor[0]=check[2]+"-"+check[3]+"-"+check[4]+" "+"00:00:00";
                    infor[1]=check[5]+"-"+check[6]+"-"+check[7]+" "+"00:00:00";

                    Vector value= inquire.inquireA3(check[1], infor[0], infor[1]);
                    Vector title=new Vector();
                    title.add("亮度");
                    title.add("时间");
                    JTable t1 = new JTable();
                    JScrollPane scr1 = new JScrollPane(t1);
                    // Vector value = Orderquery.queryM4(start, end);
                    final DefaultTableModel model = new DefaultTableModel(value,title);
                    t1.setModel(model);
                    if(t1.getRowCount() > 0)
                    {
                        t1.setRowSelectionInterval(0, 0);
                    }
                    String[ ] brightness =new String[t1.getRowCount()];//行数
                    for(int i = 1; i <= t1.getRowCount(); i++)
                    {brightness[i-1] = (String) t1.getValueAt(i-1, 0);}//一列的数值

                    String[ ] time =new String[t1.getRowCount()];
                    for(int i = 1; i <= t1.getRowCount(); i++)
                    {time[i-1] = (String) t1.getValueAt(i-1, 1);}//

                    StandardChartTheme mChartTheme = new StandardChartTheme("CN");
                    mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 12));
                    mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 12));
                    mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 12));
                    ChartFactory.setChartTheme(mChartTheme);

                    //  DefaultCategoryDataset mDataset = new DefaultCategoryDataset();


                    CategoryDataset mDataset = Chart.GetDataset(brightness,"brightness",time);
                    //   CategoryDataset mDataset_c = Chart.GetDataset(counts,"count",months);

                    //  CategoryDataset mDataset = GetDataset();
                    JFreeChart mChart = ChartFactory.createLineChart(
                            "亮度折线图",//图名字
                            "时间",//横坐标
                            "亮度",//纵坐标
                            mDataset,//数据集
                            PlotOrientation.VERTICAL,
                            true, // 显示图例
                            true, // 采用标准生成器
                            false);// 是否生成超链接

                    CategoryPlot mPlot = (CategoryPlot)mChart.getPlot();
                    mPlot.setBackgroundPaint(Color.LIGHT_GRAY);
                    mPlot.setRangeGridlinePaint(Color.BLUE);//背景底部横虚线
                    mPlot.setOutlinePaint(Color.RED);//边界线

                    ChartFrame mChartFrame = new ChartFrame("折线图", mChart);
                    mChartFrame.pack();
                    mChartFrame.setVisible(true);
                }
            }
        }
    }

