package Mini_term;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Manu implements ActionListener {
	JFrame frame1;
	JPanel panel,panel2; 
	JLabel label;
	JButton button,button2,button3,button4;
	
	String[] columnNames = {"设备编号","设备类别编号","设备类别名称","设备名称","设备信息"};
	Add_picture pic_panal = new Add_picture();
	
	String manu_Id;

	public Manu(String infor){
		this.manu_Id = infor;
		//System.out.println(manu_Id);
		Object[][] rowData = Goldenkey.manufGet(this.manu_Id);
		frame1 = new JFrame("生产厂家");
		frame1.add(pic_panal);
		pic_panal.setLayout(new BorderLayout());
		
		//columnNames.setfont(new Font("宋体",0,20));
		JTable table = new JTable(rowData,columnNames);
		table.setRowHeight(30);//设置行高
		table.setFont(new Font("微软雅黑",2,15));//设置字体格式
		SetTableColumnCenter set = new SetTableColumnCenter();
		set.setTableColumnCenter(table);
		panel = new JPanel();
		panel.setOpaque(false);
		pic_panal.add(panel,BorderLayout.CENTER);
		table.setOpaque(false);
		panel.add(table.getTableHeader(),BorderLayout.NORTH);
		panel.add(table, BorderLayout.CENTER);
		
		button = new JButton("增加设备");
		button2 = new JButton("删除设备");
		button3 = new JButton("更改设备信息");
		button4 = new JButton("查询设备数据");
		
		button.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		
		panel2 = new JPanel();
		panel2.setOpaque(false);
		panel2.add(button);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		pic_panal.add(panel2,BorderLayout.SOUTH);
		
		frame1.setSize(500,700);
		frame1.setVisible(true);
		frame1.setLocationRelativeTo(null);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		if (source.equals(button)) {
			new equip_Add(frame1,1,manu_Id);
		}
		if (source.equals(button2)) {
			new equip_Delete(frame1, 1,manu_Id);
		}
		if (source.equals(button3)) {
			new equip_inforModify(frame1,1,manu_Id);
		}
		if (source.equals(button4)) {
			new equip_inforSelect(frame1,1,manu_Id);
		}
	}
}
