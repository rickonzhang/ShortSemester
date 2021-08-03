package Mini_term;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class select_Detail implements ActionListener {
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
    String[] infor = new String[5];//鏌ヨ鏃朵紶鍏�
    String[] check = new String[10];//濉啓瀹屾暣
    String id_String;
    Object[][] data_rowData;
    String[] data_columnNames = {"设备编号","设备类别编号","设备类别名称","设备名称","设备信息"};
    int guide = 0;
    JFrame superFrame;
    public select_Detail() {
        main_Frame = new JFrame("查询详细数据");
        pic_panel.setLayout(new GridLayout(5,1));
        
        title_Label = new JLabel("请输入相关信息",JLabel.CENTER);
        title_Label.setFont(new Font("微软雅黑",0,25));
        title_Panel = new JPanel();
        title_Panel.setOpaque(false);
        //title_Panel.setLayout(null);
        //title_Panel.setPreferredSize(new Dimension(70, 400));
        title_Panel.add(title_Label);
        pic_panel.add(title_Panel);

        //开始时间部分
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

        //结束时间部分
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

        //锟斤拷锟酵斤拷锟斤拷
        typeCheck_Panel = new JPanel();
        //typeCheck_Panel.setLayout(new GridLayout(5,1));
        //JLabel label = new JLabel("数据类型");
        JLabel label = new JLabel("查询类型");
        label.setFont(new Font("微软雅黑",0,18));
        typeCheck_Panel.add(label);
        dataType_ComboBox = new JComboBox<String>(dataType);
        typeCheck_Panel.add(dataType_ComboBox);
       // JLabel label2 = new JLabel("数据编号");
        JLabel label2 = new JLabel("ID");//设备IDor类别编号or家庭编号
        label2.setFont(new Font("微软雅黑",0,18));
        typeCheck_Panel.add(label2);
        id_TextField = new JTextField();
        id_TextField.setPreferredSize(new Dimension (100,30));
        typeCheck_Panel.add(id_TextField);
        check_Button = new JButton("查询");
        check_Button.addActionListener(this);
        typeCheck_Panel.add(check_Button);
        typeCheck_Panel.setOpaque(false);
        pic_panel.add(typeCheck_Panel);

        //锟斤拷湿锟饺帮拷钮锟斤拷锟斤拷锟饺诧拷锟斤拷
        Graph_Panel = new JPanel();
        temp_Button = new JButton("查询该时间段温湿度变化趋势");
        temp_Button.setFont(new Font("微软雅黑",0,15));
        light_Button = new JButton("查询该时间段亮度变化趋势");
        light_Button.setFont(new Font("微软雅黑",0,15));
        Graph_Panel.add(temp_Button);
        Graph_Panel.add(light_Button);
        temp_Button.addActionListener(this);
        light_Button.addActionListener(this);
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






              Vector vector = inquire.inquireA1(infor[0], infor[1], infor[2], infor[3]);

            //    Object[][] rowData = Goldenkey.vectortoString(inquire.inquireA1(infor[0], infor[1], infor[2], infor[3]));
//Vector value=Goldenkey.vectortoString(inquire.inquireA1(infor[0], infor[1], infor[2], infor[3]));
                //  System.out.println("鎵ц浜咥1");
             //   Vector vector=inquire.inquireD1(s, infor[2], infor[3]);


              //  JFrame aFrame = new JFrame();
                Vector title=new Vector();//对应列数
                /*title.add("数据编号");
                title.add("数据类别");
                title.add("湿度");
                title.add("温度");
                title.add("状态");
                title.add("亮度");
                title.add("时间");
                title.add("设备编号");

                 */
                title.add("数据ID");
                title.add("数据类别");
                title.add("湿度");
                title.add("温度");
                title.add("状态");
                title.add("亮度");
                title.add("时间");
                title.add("设备ID");
               // title.add("fid");

               // {"数据编号","数据类别","湿度","温度","状态","亮度","时间","设备编号"};


                JTable t1=new JTable(vector,title);
                t1.setRowHeight(30);//�����и�
                t1.setRowHeight(30);//�����и�
                TableColumn column;
              // t1.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);// 以下设置表格列宽
                for (int i = 0; i < 8; i++) {
                    column = t1.getColumnModel().getColumn(i);
                    if (i == 6) {
                        column.setPreferredWidth(200);
                    }
                }





t1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);



                t1.setFont(new Font("微软雅黑",2,15));
                t1.setBackground(new Color(245, 245, 245));
                JScrollPane sp=new JScrollPane(t1);

                sp.setPreferredSize(new Dimension(750,350));

              //  SetTableColumnCenter set = new SetTableColumnCenter();
              //  set.setTableColumnCenter(t1);
                JPanel aJPanel = new JPanel();
                aJPanel.add(sp,BorderLayout.CENTER);
              //  aJPanel.add(t1.getTableHeader(),BorderLayout.NORTH);
               // aJPanel.add(t1, BorderLayout.CENTER);


                aFrame.add(aJPanel);

                aFrame.setSize(800,400);
                aFrame.setVisible(true);
                aFrame.setLocationRelativeTo(null);











               /* String[] columnNames = {"数据编号","数据类别","湿度","温度","状态","亮度","时间","设备编号"};
                JTable table = new JTable(rowData,columnNames);
                table.setRowHeight(30);//锟斤拷锟斤拷锟叫革拷
                table.setFont(new Font("微软雅黑",2,15));//锟斤拷锟斤拷锟斤拷锟斤拷锟绞�
                SetTableColumnCenter set = new SetTableColumnCenter();
                set.setTableColumnCenter(table);
                JPanel aJPanel = new JPanel();

                */

               /* aJPanel.add(table.getTableHeader(),BorderLayout.NORTH);
                aJPanel.add(table, BorderLayout.CENTER);
                aFrame.add(aJPanel);

                aFrame.setSize(700,400);
                aFrame.setVisible(true);
                aFrame.setLocationRelativeTo(null);
                //data_Panel.add(data_ScrollPane,BorderLayout.CENTER);

                */
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
                Vector vector= inquire.inquireA2(check[1], infor[0], infor[1]);
                // Vector title=new Vector();




                JFrame aFrame = new JFrame();
                Vector title=new Vector();//瀵瑰簲鍒楁暟
                title.add("湿度");
                title.add("温度");
                title.add("时间");



                JTable t1=new JTable(vector,title);
                t1.setRowHeight(30);//锟斤拷锟斤拷锟叫革拷
                t1.setRowHeight(30);//锟斤拷锟斤拷锟叫革拷
                t1.setFont(new Font("微软雅黑",2,15));//璁剧疆瀛椾綋鏍煎紡
                JScrollPane sp=new JScrollPane(t1);

                //  SetTableColumnCenter set = new SetTableColumnCenter();
                //  set.setTableColumnCenter(t1);
                JPanel aJPanel = new JPanel();
                aJPanel.add(sp,BorderLayout.CENTER);
               // SetTableColumnCenter set = new SetTableColumnCenter();
                //set.setTableColumnCenter(t1);
                //JPanel aJPanel = new JPanel();
                //aJPanel.add(t1.getTableHeader(),BorderLayout.NORTH);
                //aJPanel.add(t1, BorderLayout.CENTER);


                aFrame.add(aJPanel);

                aFrame.setSize(800,400);
                aFrame.setVisible(true);
                aFrame.setLocationRelativeTo(null);





                //   JTable t1 = new JTable();
                //  JScrollPane scr1 = new JScrollPane(t1);
                // Vector value = Orderquery.queryM4(start, end);
                final DefaultTableModel model = new DefaultTableModel(vector,title);
                t1.setModel(model);
                if(t1.getRowCount() > 0)
                {
                    t1.setRowSelectionInterval(0, 0);
                }
                String[ ] humidity =new String[t1.getRowCount()];//琛屾暟
                for(int i = 1; i <= t1.getRowCount(); i++)
                {humidity[i-1] = (String) t1.getValueAt(i-1, 0);}//涓�鍒楃殑鏁板��

                String[ ] tempareture =new String[t1.getRowCount()];
                for(int i = 1; i <= t1.getRowCount(); i++)
                {tempareture[i-1] = (String) t1.getValueAt(i-1, 1);}//


                String[ ] time =new String[t1.getRowCount()];
                for(int i = 1; i <= t1.getRowCount(); i++)
                {time[i-1] = (String) t1.getValueAt(i-1, 2);}

                StandardChartTheme mChartTheme = new StandardChartTheme("CN");
                mChartTheme.setLargeFont(new Font("微软雅黑", Font.BOLD, 12));
                mChartTheme.setExtraLargeFont(new Font("微软雅黑", Font.PLAIN, 12));
                mChartTheme.setRegularFont(new Font("微软雅黑", Font.PLAIN, 12));
                ChartFactory.setChartTheme(mChartTheme);

                CategoryDataset mDataset1 = Chart.GetDataset(humidity,"brightness",time);
                CategoryDataset mDataset2 = Chart.GetDataset(tempareture,"brightness",time);

                JFreeChart mChart1 = ChartFactory.createLineChart(
                        "湿度变化趋势",//鍥惧悕瀛�
                        "时间",//妯潗鏍�
                        "湿度",//绾靛潗鏍�
                        mDataset1,//鏁版嵁闆�
                        PlotOrientation.VERTICAL,
                        true, // 鏄剧ず鍥句緥
                        true, // 閲囩敤鏍囧噯鐢熸垚鍣�
                        false);// 鏄惁鐢熸垚瓒呴摼鎺�

                JFreeChart mChart2 = ChartFactory.createLineChart(
                        "温度变化趋势",//鍥惧悕瀛�
                        "时间",//妯潗鏍�
                        "温度",//绾靛潗鏍�
                        mDataset2,//鏁版嵁闆�
                        PlotOrientation.VERTICAL,
                        true, // 鏄剧ず鍥句緥
                        true, // 閲囩敤鏍囧噯鐢熸垚鍣�
                        false);// 鏄惁鐢熸垚瓒呴摼鎺�
                CategoryPlot mPlot = (CategoryPlot)mChart1.getPlot();
                mPlot.setBackgroundPaint(Color.LIGHT_GRAY);
                mPlot.setRangeGridlinePaint(Color.BLUE);//鑳屾櫙搴曢儴妯櫄绾�
                mPlot.setOutlinePaint(Color.RED);//杈圭晫绾�
                CategoryPlot mPlot2 = (CategoryPlot)mChart2.getPlot();
                mPlot2.setBackgroundPaint(Color.LIGHT_GRAY);
                mPlot2.setRangeGridlinePaint(Color.BLUE);//鑳屾櫙搴曢儴妯櫄绾�
                mPlot2.setOutlinePaint(Color.RED);//杈圭晫绾�

               // ChartFrame mChartFrame = new ChartFrame("折线图", mChart1);
                ChartFrame mChartFrame = new ChartFrame("湿度折线图", mChart1);
                ChartFrame mChartFrame2=new ChartFrame("温度折线图",mChart2);
                mChartFrame.pack();
                mChartFrame.setVisible(true);

                mChartFrame2.pack();
                mChartFrame2.setVisible(true);
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
                JOptionPane.showMessageDialog(null, "请填写遗漏的信息", "信息不完整",JOptionPane.ERROR_MESSAGE);
            }
            else {
                infor[0]=check[2]+"-"+check[3]+"-"+check[4]+" "+"00:00:00";
                infor[1]=check[5]+"-"+check[6]+"-"+check[7]+" "+"00:00:00";

                Vector vector= inquire.inquireA3(check[1], infor[0], infor[1]);

                // Vector vector=inquire.inquireD1(s, infor[2], infor[3]);


                JFrame aFrame = new JFrame();
                Vector title=new Vector();//瀵瑰簲鍒楁暟
                title.add("亮度");
                title.add("时间");




                JTable t1=new JTable(vector,title);
                t1.setRowHeight(30);//锟斤拷锟斤拷锟叫革拷
                t1.setRowHeight(30);//锟斤拷锟斤拷锟叫革拷
                t1.setFont(new Font("微软雅黑",2,15));//璁剧疆瀛椾綋鏍煎紡
                JScrollPane sp=new JScrollPane(t1);

                //  SetTableColumnCenter set = new SetTableColumnCenter();
                //  set.setTableColumnCenter(t1);
                JPanel aJPanel = new JPanel();
                aJPanel.add(sp,BorderLayout.CENTER);
               // SetTableColumnCenter set = new SetTableColumnCenter();
               // set.setTableColumnCenter(t1);
               // JPanel aJPanel = new JPanel();
              //  aJPanel.add(t1.getTableHeader(),BorderLayout.NORTH);
               // aJPanel.add(t1, BorderLayout.CENTER);


                aFrame.add(aJPanel);

                aFrame.setSize(700,400);
                aFrame.setVisible(true);
                aFrame.setLocationRelativeTo(null);












                //  Vector title=new Vector();
                //   title.add("浜害");
                //  title.add("鏃堕棿");
                //  JTable t1 = new JTable();
                // JScrollPane scr1 = new JScrollPane(t1);
                // Vector value = Orderquery.queryM4(start, end);
                final DefaultTableModel model = new DefaultTableModel(vector,title);
                t1.setModel(model);
                if(t1.getRowCount() > 0)
                {
                    t1.setRowSelectionInterval(0, 0);
                }
                String[ ] brightness =new String[t1.getRowCount()];//琛屾暟
                for(int i = 1; i <= t1.getRowCount(); i++)
                {brightness[i-1] = (String) t1.getValueAt(i-1, 0);}//涓�鍒楃殑鏁板��

                String[ ] time =new String[t1.getRowCount()];
                for(int i = 1; i <= t1.getRowCount(); i++)
                {time[i-1] = (String) t1.getValueAt(i-1, 1);}//


                // String[ ] months =new String[t1.getRowCount()];
                //   for(int i = 1; i <= t1.getRowCount(); i++)
                //  {months[i-1] = (String) t1.getValueAt(i-1, 2);}

              /*  for(int i = 0; i < brightness.length;i++)
                {
                    System.out.print(brightness[i]+" ");
                }

                for(int i = 0; i < sums.length;i++)
                {
                    System.out.print(sums[i]+" ");
                }

               */



                StandardChartTheme mChartTheme = new StandardChartTheme("CN");
                mChartTheme.setLargeFont(new Font("微软雅黑", Font.BOLD, 12));
                mChartTheme.setExtraLargeFont(new Font("微软雅黑", Font.PLAIN, 12));
                mChartTheme.setRegularFont(new Font("微软雅黑", Font.PLAIN, 12));
                ChartFactory.setChartTheme(mChartTheme);

                //  DefaultCategoryDataset mDataset = new DefaultCategoryDataset();


                CategoryDataset mDataset = Chart.GetDataset(brightness,"brightness",time);
                //   CategoryDataset mDataset_c = Chart.GetDataset(counts,"count",months);

                //  CategoryDataset mDataset = GetDataset();
                JFreeChart mChart = ChartFactory.createLineChart(
                        "亮度变化趋势",//鍥惧悕瀛�
                        "时间",//妯潗鏍�
                        "亮度",//绾靛潗鏍�
                        mDataset,//鏁版嵁闆�
                        PlotOrientation.VERTICAL,
                        true, // 鏄剧ず鍥句緥
                        true, // 閲囩敤鏍囧噯鐢熸垚鍣�
                        false);// 鏄惁鐢熸垚瓒呴摼鎺�

                CategoryPlot mPlot = (CategoryPlot)mChart.getPlot();
                mPlot.setBackgroundPaint(Color.LIGHT_GRAY);
                mPlot.setRangeGridlinePaint(Color.BLUE);//鑳屾櫙搴曢儴妯櫄绾�
                mPlot.setOutlinePaint(Color.RED);//杈圭晫绾�

                ChartFrame mChartFrame = new ChartFrame("折线图", mChart);
                mChartFrame.pack();
                mChartFrame.setVisible(true);
            }
        }
    }
}
