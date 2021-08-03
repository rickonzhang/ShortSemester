package Mini_term;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Admin implements ActionListener {
	JFrame frame1;
	//家庭界面
	Add_picture family_panel = new Add_picture();
	JButton family_button,family_button2,family_button3,family_button4;//设备界面按钮
	JPanel family_buttonPanel,family_buttonPanel_mini;//按钮面板
	String[] family_columnNames = {"家庭编号","家庭名称","家庭地址"};
	String[][] family_rowData = Goldenkey.Get("family");
	JScrollPane family_ScrollPane;//表格界面
	JPanel family_tablePanel;//表格面板
	
	//用户界面
	Add_picture user_panel = new Add_picture();
	JButton user_button,user_button2,user_button3,user_button4,user_button5;//设备界面按钮
	JPanel user_buttonPanel,user_buttonPanel_mini;//按钮面板
	String[] user_columnNames = {"用户编号","用户姓名","登录密码","性别","电话号码","邮箱"
								,"所属家庭"};
	Object[][] user_rowData = Goldenkey.Get("user");
	JScrollPane user_ScrollPane;//表格界面
	JPanel user_tablePanel;//表格面板
	
	//设备界面
	Add_picture equip_panel = new Add_picture(); 
	JButton equip_button,equip_button2,equip_button3,equip_button4;//设备界面按钮
	JPanel equip_buttonPanel,equip_buttonPanel_mini;//按钮面板
	String[] equip_columnNames = {"设备编号","设备类别编号","设备类别名称","设备名称","设备信息"};
	Object[][] equip_rowData = Goldenkey.Get("equipment");
	JScrollPane equip_ScrollPane;//表格界面
	JPanel equip_tablePanel;//表格面板
	
	//设备类别界面
	Add_picture class_panel = new Add_picture();
	JButton class_button,class_button2,class_button3,class_button4;
	JPanel class_buttonPanel,class_buttonPanel_mini;
	JScrollPane class_ScrollPane;
	JPanel class_tablePanel;
	String[] class_columnNames = {"设备类别编号","设备类别名称"};
	Object[][] class_rowData = Goldenkey.Get("class");
	
	//数据界面
	Add_picture data_panel = new Add_picture();
	JButton data_button,data_button2,data_button3,data_button4;//设备界面按钮
	JPanel data_buttonPanel,data_buttonPanel_mini;//按钮面板
	String[] data_columnNames = {"设备编号","设备类别编号","设备类别名称","设备名称","设备信息"};
	Object[][] data_rowData = Goldenkey.Get("data");
	JScrollPane data_ScrollPane;//表格界面
	JPanel data_tablePanel;//表格面板
	//JPanel 
	
	public Admin() {
		frame1 = new JFrame("Administrator");
		
		family_panel.setLayout(new BorderLayout());
		user_panel.setLayout(new BorderLayout());
		equip_panel.setLayout(new BorderLayout());
		class_panel.setLayout(new BorderLayout());
		data_panel.setLayout(new BorderLayout());
		//家庭界面
		family_buttonPanel = new JPanel();
		family_buttonPanel.setOpaque(false);
		family_buttonPanel.setLayout(new GridLayout(4,1));
		family_buttonPanel_mini = new JPanel();
		family_buttonPanel_mini.setOpaque(false);
		family_buttonPanel_mini.setLayout(new GridLayout(4,1,5,5));
		family_buttonPanel.add(family_buttonPanel_mini);
		family_button = new JButton("增加家庭");	family_buttonPanel_mini.add(family_button);
		family_button2 = new JButton("删除家庭");	family_buttonPanel_mini.add(family_button2);
		family_button3 = new JButton("更改家庭信息"); family_buttonPanel_mini.add(family_button3);
		family_button4 = new JButton("查询家庭数据"); family_buttonPanel_mini.add(family_button4);
		family_panel.add(family_buttonPanel);
		//表格部分
		family_tablePanel = new JPanel();
		family_tablePanel.setOpaque(false);
		family_tablePanel.setLayout(new BorderLayout());
		JTable family_table = new JTable(family_rowData,family_columnNames);
		family_table.setOpaque(false);
		family_table.setRowHeight(30);//设置行高
		family_table.setFont(new Font("微软雅黑",2,15));//设置字体格式
		SetTableColumnCenter family_TableSet = new SetTableColumnCenter();
		family_TableSet.setTableColumnCenter(family_table);//字体居中
		family_table.setEnabled(false);//不可更改
		family_tablePanel.add(family_table.getTableHeader(), BorderLayout.NORTH);
		family_tablePanel.add(family_table, BorderLayout.CENTER);
		family_ScrollPane = new JScrollPane(family_tablePanel,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		family_panel.add(family_buttonPanel,BorderLayout.WEST);
		family_panel.add(family_ScrollPane,BorderLayout.CENTER);
		family_button.addActionListener(this);
		family_button2.addActionListener(this);
		family_button3.addActionListener(this);
		family_button4.addActionListener(this);
		
		//用户界面
		user_buttonPanel = new JPanel();
		user_buttonPanel.setOpaque(false);
		user_buttonPanel.setLayout(new GridLayout(4,1));
		user_buttonPanel_mini = new JPanel();
		user_buttonPanel_mini.setOpaque(false);
		user_buttonPanel_mini.setLayout(new GridLayout(5,1,5,5));
		user_buttonPanel.add(user_buttonPanel_mini);
		user_button = new JButton("增加用户");	user_buttonPanel_mini.add(user_button);
		user_button2 = new JButton("删除用户设备");	user_buttonPanel_mini.add(user_button2);
		user_button3 = new JButton("更改用户信息"); user_buttonPanel_mini.add(user_button3);
		user_button4 = new JButton("查询用户数据"); user_buttonPanel_mini.add(user_button4);
		user_button5 = new JButton("重置用户密码");	user_buttonPanel_mini.add(user_button5);
		user_panel.add(user_buttonPanel);
		//表格部分
		user_tablePanel = new JPanel();
		user_tablePanel.setOpaque(false);
		user_tablePanel.setLayout(new BorderLayout());
		JTable user_table = new JTable(user_rowData,user_columnNames);
		user_table.setOpaque(false);
		user_table.setRowHeight(30);//设置行高
		user_table.setFont(new Font("微软雅黑",2,15));//设置字体格式
		SetTableColumnCenter user_TableSet = new SetTableColumnCenter();
		user_TableSet.setTableColumnCenter(user_table);//字体居中
		user_table.setEnabled(false);//不可更改
		user_tablePanel.add(user_table.getTableHeader(), BorderLayout.NORTH);
		user_tablePanel.add(user_table, BorderLayout.CENTER);
		user_ScrollPane = new JScrollPane(user_tablePanel,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		user_panel.add(user_buttonPanel,BorderLayout.WEST);
		user_panel.add(user_ScrollPane,BorderLayout.CENTER);
		user_button.addActionListener(this);
		user_button2.addActionListener(this);
		user_button3.addActionListener(this);
		user_button4.addActionListener(this);
		user_button5.addActionListener(this);
		
		//设备界面
		//按钮部分
		equip_buttonPanel = new JPanel();
		equip_buttonPanel.setOpaque(false);
		equip_buttonPanel.setLayout(new GridLayout(4,1));
		equip_buttonPanel_mini = new JPanel();
		equip_buttonPanel_mini.setOpaque(false);
		equip_buttonPanel_mini.setLayout(new GridLayout(4,1,5,5));
		equip_buttonPanel.add(equip_buttonPanel_mini);
		equip_button = new JButton("增加设备");	equip_buttonPanel_mini.add(equip_button);
		equip_button2 = new JButton("删除设备");	equip_buttonPanel_mini.add(equip_button2);
		equip_button3 = new JButton("更改设备信息"); equip_buttonPanel_mini.add(equip_button3);
		equip_button4 = new JButton("查询设备数据"); equip_buttonPanel_mini.add(equip_button4);
		equip_panel.add(equip_buttonPanel);
		//表格部分
		equip_tablePanel = new JPanel();
		equip_tablePanel.setOpaque(false);
		equip_tablePanel.setLayout(new BorderLayout());
		JTable equip_table = new JTable(equip_rowData,equip_columnNames);
		equip_table.setOpaque(false);
		equip_table.setRowHeight(30);//设置行高
		equip_table.setFont(new Font("微软雅黑",2,15));//设置字体格式
		SetTableColumnCenter equip_TableSet = new SetTableColumnCenter();
		equip_TableSet.setTableColumnCenter(equip_table);//字体居中
		equip_table.setEnabled(false);//不可更改
		equip_tablePanel.add(equip_table.getTableHeader(), BorderLayout.NORTH);
		equip_tablePanel.add(equip_table, BorderLayout.CENTER);
		equip_ScrollPane = new JScrollPane(equip_tablePanel,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		equip_panel.add(equip_buttonPanel,BorderLayout.WEST);
		equip_panel.add(equip_ScrollPane,BorderLayout.CENTER);
		equip_button.addActionListener(this);
		equip_button2.addActionListener(this);
		equip_button3.addActionListener(this);
		equip_button4.addActionListener(this);
		
		//设备类别界面
		//按钮部分
		class_buttonPanel = new JPanel();
		class_buttonPanel.setOpaque(false);
		class_buttonPanel.setLayout(new GridLayout(4,1));
		class_buttonPanel_mini = new JPanel();
		class_buttonPanel_mini.setOpaque(false);
		class_buttonPanel_mini.setLayout(new GridLayout(4,1,5,5));
		class_buttonPanel.add(class_buttonPanel_mini);
		class_button = new JButton("增加设备类别");	class_buttonPanel_mini.add(class_button);
		class_button2 = new JButton("删除设备类别");	class_buttonPanel_mini.add(class_button2);
		class_button3 = new JButton("修改设备类别");	class_buttonPanel_mini.add(class_button3);
		class_button4 = new JButton("查询设备类别");	class_buttonPanel_mini.add(class_button4);
		class_panel.add(class_buttonPanel);
		//表格部分
		class_tablePanel = new JPanel();
		class_tablePanel.setOpaque(false);
		class_tablePanel.setLayout(new BorderLayout());
		JTable class_table = new JTable(class_rowData,class_columnNames);
		class_table.setOpaque(false);
		class_table.setRowHeight(30);//设置行高
		class_table.setFont(new Font("微软雅黑",2,15));//设置字体格式
		SetTableColumnCenter class_TableSet = new SetTableColumnCenter();
		class_TableSet.setTableColumnCenter(class_table);//字体居中
		class_table.setEnabled(false);//不可更改
		class_tablePanel.add(class_table.getTableHeader(), BorderLayout.NORTH);
		class_tablePanel.add(class_table, BorderLayout.CENTER);
		class_ScrollPane = new JScrollPane(class_tablePanel,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		class_panel.add(class_buttonPanel,BorderLayout.WEST);
		class_panel.add(class_ScrollPane,BorderLayout.CENTER);
		class_button.addActionListener(this);
		class_button2.addActionListener(this);
		class_button3.addActionListener(this);
		class_button4.addActionListener(this);
		
		//数据界面
		//按钮部分
		data_buttonPanel = new JPanel();
		data_buttonPanel.setOpaque(false);
		data_buttonPanel.setLayout(new GridLayout(4,1));
		data_buttonPanel_mini = new JPanel();
		data_buttonPanel_mini.setOpaque(false);
		data_buttonPanel_mini.setLayout(new GridLayout(4,1,5,5));
		data_buttonPanel.add(data_buttonPanel_mini);
		data_button = new JButton("查询详细数据");	data_buttonPanel_mini.add(data_button);
		data_button2 = new JButton("统计测量值个数");	data_buttonPanel_mini.add(data_button2);
		data_button3 = new JButton("测量值分布"); data_buttonPanel_mini.add(data_button3);
		data_button4 = new JButton("统计多个家庭"); data_buttonPanel_mini.add(data_button4);
		data_panel.add(data_buttonPanel);
		//表格部分
		data_tablePanel = new JPanel();
		data_tablePanel.setOpaque(false);
		data_tablePanel.setLayout(new BorderLayout());
		JTable data_table = new JTable(data_rowData,data_columnNames);
		data_table.setOpaque(false);
		data_table.setRowHeight(30);//设置行高
		data_table.setFont(new Font("微软雅黑",2,15));//设置字体格式
		SetTableColumnCenter data_TableSet = new SetTableColumnCenter();
		data_TableSet.setTableColumnCenter(data_table);//字体居中
		data_table.setEnabled(false);//不可更改
		data_tablePanel.add(data_table.getTableHeader(), BorderLayout.NORTH);
		data_tablePanel.add(data_table, BorderLayout.CENTER);
		data_ScrollPane = new JScrollPane(data_tablePanel,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		data_panel.add(data_buttonPanel,BorderLayout.WEST);
		data_panel.add(data_ScrollPane,BorderLayout.CENTER);
		data_button.addActionListener(this);
		data_button2.addActionListener(this);
		data_button3.addActionListener(this);
		data_button4.addActionListener(this);
		
		/*JTabbedPane data_Tab = new JTabbedPane(JTabbedPane.LEFT);
		data_panel.add(data_Tab);
		//frame1.add(data_Tab);
		data_Tab.setFont(new Font("微软雅黑",0,15));
		data_Tab.addTab("家庭管理",null,family_panel,"管理家庭数据");
		data_Tab.addTab("用户管理",null,user_panel,"管理现有用户");
		data_Tab.addTab("设备管理",null,equip_panel,"管理现有设备");
		data_Tab.addTab("设备类别管理",null,class_panel,"管理现有设备类别");
		data_Tab.addTab("测量数据管理",null,data_panel,"管理、统计测量数据");*/

		JTabbedPane admin_Tab = new JTabbedPane(JTabbedPane.TOP);
		frame1.add(admin_Tab);
		admin_Tab.setFont(new Font("微软雅黑",0,15));
		admin_Tab.addTab("家庭管理",null,family_panel,"管理家庭数据");
		admin_Tab.addTab("用户管理",null,user_panel,"管理现有用户");
		admin_Tab.addTab("设备管理",null,equip_panel,"管理现有设备");
		admin_Tab.addTab("设备类别管理",null,class_panel,"管理现有设备类别");
		admin_Tab.addTab("测量数据管理",null,data_panel,"管理、统计测量数据");
		
		frame1.setSize(700,600);
		frame1.setVisible(true);
		frame1.setLocationRelativeTo(null);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		//家庭界面按钮
		if (source.equals(family_button)) {new family_Add(frame1);}
		if (source.equals(family_button2)) {new family_Delete(frame1);}
		if (source.equals(family_button3)) {new family_inforModify(frame1);}
		if (source.equals(family_button4)) {new family_inforSelect(frame1);}
		//用户界面按钮
		if (source.equals(user_button)) {new user_Add(frame1);}
		if (source.equals(user_button2)) {new user_Delete(frame1);}
		if (source.equals(user_button3)) {new user_inforModify(frame1);}
		if (source.equals(user_button4)) {new user_inforSelect(frame1);}
		if (source.equals(user_button5)) {new reset_password(frame1);}
		//设备界面按钮
		if (source.equals(equip_button)) {new equip_Add(frame1,0);}
		if (source.equals(equip_button2)) {new equip_Delete(frame1,0,null);}
		if (source.equals(equip_button3)) {new equip_inforModify(frame1,0,null);}
		if (source.equals(equip_button4)) {new equip_inforSelect(frame1,0);}
		//设备类别界面按钮
		if (source.equals(class_button)) {new class_Add(frame1);}
		if (source.equals(class_button2)) {new class_Delete(frame1);}
		if (source.equals(class_button3)) {new class_inforModify(frame1);}
		if (source.equals(class_button4)) {new class_inforSelect(frame1);}
		//数据界面按钮
		if (source.equals(data_button)) {new select_Detail();}
		if (source.equals(data_button2)) {new select_NumberCount();}
		if (source.equals(data_button3)) {new select_Distribution();}
		if (source.equals(data_button4)) {new select_FamilyCount();}
	}
}
	
