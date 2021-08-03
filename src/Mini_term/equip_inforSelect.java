package Mini_term;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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

import java.util.Vector;

public class equip_inforSelect implements ActionListener {
    JFrame main_Frame ;
    JFrame temp_Frame,light_Frame;
    Add_picture pic_panel = new Add_picture();
    JPanel title_Panel,startDate_Panel,endDate_Panel,typeCheck_Panel,Graph_Panel,button_Panel;
    JComboBox<String> dataType_ComboBox,id_ComboBox,
            startY_ComboBox,startM_ComboBox,startD_ComboBox,
            endY_ComboBox,endM_ComboBox,endD_ComboBox;
    JLabel start = new JLabel("开始时间");
    JLabel end = new JLabel("结束时间");
    JLabel dateY_Label,dateM_Label,dateD_Label;
    JTextField id_TextField;
    JLabel label;
    JPanel panel;
    JComboBox<String> equip_ComboBox;

    JLabel title_Label;
    JButton check_Button,temp_Button,light_Button;
    JTextField temp_TextField,light_TextField;
    
    JFrame superFrame;
	String identity;
	int id;

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
    
    String[]  equipStrings;
    
    Object[][] data_rowData;
    String[] data_columnNames = {"设备编号","设备类别编号","设备类别名称","设备名称","设备信息"};
    int guide = 0;
    
    public equip_inforSelect(JFrame aFrame, int a) {
		this.superFrame = aFrame;
		this.id = a;
        main_Frame = new JFrame("设备数据查询");
        pic_panel.setLayout(new GridLayout(5,1));

        title_Label = new JLabel("请输入相关信息",JLabel.CENTER);
        title_Label.setFont(new Font("微软雅黑",0,25));
        title_Panel = new JPanel();
        title_Panel.setOpaque(false);
        //title_Panel.setLayout(null);
        title_Panel.setPreferredSize(new Dimension(70, 400));
        title_Panel.add(title_Label);
        pic_panel.add(title_Panel);

        //��ʼʱ�����
        startDate_Panel = new JPanel();
        startDate_Panel.setLayout(new GridLayout(1,7));
        startDate_Panel.add(start);
        startY_ComboBox = new JComboBox<String>(year);
        JPanel startDate_PanelY = new JPanel();
        //startDate_PanelY.setLayout(null);
        startDate_PanelY.setPreferredSize(new Dimension(70, 80));
        startDate_PanelY.add(startY_ComboBox,BorderLayout.CENTER);
        startDate_Panel.add(startDate_PanelY);
        dateY_Label = new JLabel("年");
        dateY_Label.setFont(new Font("微软雅黑",0,18));
        startDate_Panel.add(dateY_Label);
        startM_ComboBox = new JComboBox<String>(month);
        startDate_Panel.add(startM_ComboBox);
        dateM_Label = new JLabel("月");
        dateM_Label.setFont(new Font("微软雅黑",0,18));
        startDate_Panel.add(dateM_Label);
        startD_ComboBox = new JComboBox<String>(date);
        startDate_Panel.add(startD_ComboBox);
        dateD_Label = new JLabel("日");
        dateD_Label.setFont(new Font("微软雅黑",0,18));
        startDate_Panel.add(dateD_Label);
        pic_panel.add(startDate_Panel);

        //����ʱ�����
        endDate_Panel = new JPanel();
        endDate_Panel.setLayout(new GridLayout(1,7));
        endDate_Panel.add(end);
        endY_ComboBox = new JComboBox<String>(year);
        endDate_Panel.add(endY_ComboBox);
        dateY_Label = new JLabel("年");
        dateY_Label.setFont(new Font("微软雅黑",0,18));
        endDate_Panel.add(dateY_Label);
        endM_ComboBox = new JComboBox<String>(month);
        endDate_Panel.add(endM_ComboBox);
        dateM_Label = new JLabel("月");
        dateM_Label.setFont(new Font("微软雅黑",0,18));
        endDate_Panel.add(dateM_Label);
        endD_ComboBox = new JComboBox<String>(date);
        endDate_Panel.add(endD_ComboBox);
        dateD_Label = new JLabel("日");
        dateD_Label.setFont(new Font("微软雅黑",0,18));
        endDate_Panel.add(dateD_Label);
        pic_panel.add(endDate_Panel);

        //���ͽ���
        typeCheck_Panel = new JPanel();
        JLabel label2 = new JLabel("请输入想要查询的设备id");
        typeCheck_Panel.add(label2);
        id_TextField = new JTextField();
        id_TextField.setPreferredSize(new Dimension (80,30));
        typeCheck_Panel.add(id_TextField);
        pic_panel.add(typeCheck_Panel);
        
        button_Panel = new JPanel();
		button_Panel.setOpaque(false);
		check_Button = new JButton("增加");
		button_Panel.add(check_Button);
		pic_panel.add(button_Panel);
		check_Button.addActionListener(this);

        main_Frame.add(pic_panel);

        main_Frame.setSize(500,650);
        main_Frame.setVisible(true);
        main_Frame.setLocationRelativeTo(null);
    }
    
    public equip_inforSelect(JFrame frame1, int a, String manu_Id) {
		this.superFrame = frame1;
		this.id = a;
		this.identity = manu_Id;
		
		main_Frame = new JFrame("设备数据查询");
		pic_panel.setLayout(new GridLayout(5,1));
	     
		title_Label = new JLabel("请输入相关信息",JLabel.CENTER);
		title_Label.setFont(new Font("微软雅黑",0,25));
		title_Panel = new JPanel();
		title_Panel.setOpaque(false);
		//title_Panel.setLayout(null);
		title_Panel.setPreferredSize(new Dimension(70, 400));
		title_Panel.add(title_Label);
		pic_panel.add(title_Panel);

	        //��ʼʱ�����
	 	startDate_Panel = new JPanel();
		startDate_Panel.setLayout(new GridLayout(1,7));
		startDate_Panel.add(start);
	    startY_ComboBox = new JComboBox<String>(year);
	    JPanel startDate_PanelY = new JPanel();
	    //startDate_PanelY.setLayout(null);
	    startDate_PanelY.setPreferredSize(new Dimension(70, 80));
	    startDate_PanelY.add(startY_ComboBox,BorderLayout.CENTER);
	    startDate_Panel.add(startDate_PanelY);
	    dateY_Label = new JLabel("年");
	    dateY_Label.setFont(new Font("微软雅黑",0,18));
	    startDate_Panel.add(dateY_Label);
	    startM_ComboBox = new JComboBox<String>(month);
	    startDate_Panel.add(startM_ComboBox);
	    dateM_Label = new JLabel("月");
	    dateM_Label.setFont(new Font("微软雅黑",0,18));
	    startDate_Panel.add(dateM_Label);
	    startD_ComboBox = new JComboBox<String>(date);
	    startDate_Panel.add(startD_ComboBox);
	    dateD_Label = new JLabel("日");
	    dateD_Label.setFont(new Font("微软雅黑",0,18));
	    startDate_Panel.add(dateD_Label);
	    pic_panel.add(startDate_Panel);

	        //����ʱ�����
	    endDate_Panel = new JPanel();
	    endDate_Panel.setLayout(new GridLayout(1,7));
	    endDate_Panel.add(end);
	    endY_ComboBox = new JComboBox<String>(year);
	    endDate_Panel.add(endY_ComboBox);
	    dateY_Label = new JLabel("年");
	    dateY_Label.setFont(new Font("微软雅黑",0,18));
	    endDate_Panel.add(dateY_Label);
	    endM_ComboBox = new JComboBox<String>(month);
	    endDate_Panel.add(endM_ComboBox);
	    dateM_Label = new JLabel("月");
	    dateM_Label.setFont(new Font("微软雅黑",0,18));
	    endDate_Panel.add(dateM_Label);
	    endD_ComboBox = new JComboBox<String>(date);
	    endDate_Panel.add(endD_ComboBox);
	    dateD_Label = new JLabel("日");
	    dateD_Label.setFont(new Font("微软雅黑",0,18));
	    endDate_Panel.add(dateD_Label);
	    pic_panel.add(endDate_Panel);
	    
        //���ͽ���
	    label = new JLabel("请选择修改设备的设备编号",JLabel.CENTER);
		label.setFont(new Font("微软雅黑",0,15));
		equip_ComboBox = new JComboBox<String>(Manufmanage.inquery(manu_Id));
		equip_ComboBox.setPreferredSize(new Dimension (100,30));
		panel = new JPanel();
		panel.add(label);
		panel.add(equip_ComboBox);
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(80,400));
		pic_panel.add(panel,BorderLayout.NORTH);
        
        button_Panel = new JPanel();
		button_Panel.setOpaque(false);
		check_Button = new JButton("增加");
		button_Panel.add(check_Button);
		pic_panel.add(button_Panel);
		check_Button.addActionListener(this);
        main_Frame.add(pic_panel);

        main_Frame.setSize(500,650);
        main_Frame.setVisible(true);
        main_Frame.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e) {
        guide = 0;
        JButton source = (JButton)e.getSource();
        if (source.equals(check_Button)) {
   			if(id == 0){
   				check[0] = id_TextField.getText();
   			}
   			else {
   				check[0] = (String) equip_ComboBox.getSelectedItem();
   			}
    		
            check[1] = (String) startY_ComboBox.getSelectedItem();
            check[2] = (String) startM_ComboBox.getSelectedItem();
            check[3] = (String) startD_ComboBox.getSelectedItem();
            check[4] = (String) endY_ComboBox.getSelectedItem();
            check[5] = (String) endM_ComboBox.getSelectedItem();
            check[6] = (String) endD_ComboBox.getSelectedItem();
            for(int i = 0; i < 7 ; i++) {
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
                infor[1]=check[1]+"-"+check[2]+"-"+check[3]+" "+"00:00:00";
                infor[2]=check[4]+"-"+check[5]+"-"+check[6]+" "+"00:00:00";
                
                JFrame aFrame = new JFrame();
    			Object[][] rowData = Equipmanage.cIDinquery(infor[0]);
    			
    			Vector title=new Vector();
                title.add("fid");
                title.add("fid");
                title.add("fid");
                title.add("fid");
                title.add("fid");
                title.add("fid");
                title.add("fid");
                title.add("fid");
                title.add("fid");
                
                JTable t1=new JTable(menufinquire.minquire1(infor[0], infor[1], infor[2]),title);
                t1.setRowHeight(30);//�����и�
                t1.setRowHeight(30);//�����и�
                t1.setFont(new Font("微软雅黑",2,15));//设置字体格式
                SetTableColumnCenter set = new SetTableColumnCenter();
                set.setTableColumnCenter(t1);
                JPanel aJPanel = new JPanel();
                aJPanel.setLayout(new BorderLayout());
                aJPanel.add(t1.getTableHeader(),BorderLayout.NORTH);
                aJPanel.add(t1, BorderLayout.CENTER); 
                data_ScrollPane = new JScrollPane(aJPanel,
        				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    			
    			aJPanel.add(t1.getTableHeader(),BorderLayout.NORTH);
    			aJPanel.add(t1, BorderLayout.CENTER);
    			aFrame.add(aJPanel);
    			
    			aFrame.setSize(700,400);
    			aFrame.setVisible(true);
    			aFrame.setLocationRelativeTo(null);
                //data_Panel.add(data_ScrollPane,BorderLayout.CENTER);
    			if(id == 0 ){
        			new Admin();
        		}
        		else {
    				new Manu(identity);
    			}
                }
            }         
        }
    }