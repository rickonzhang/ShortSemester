package Mini_term;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class family_inforSelect implements ActionListener {
	JFrame frame;
	Add_picture pic_panel = new Add_picture();
	JLabel label,label2,label3;
	JPanel panel,panel2,panel4,panel5;
	JPanel panel3 = new JPanel();
	JButton equip_Button,user_Button;
	JTextField textField,textField2;
	String[] infor = new String[5];
	int guide = 0;
	JFrame superFrame;
	
	int type;//0为设备，1为成员
	public family_inforSelect(JFrame aFrame) {
		this.superFrame = aFrame;
		frame = new JFrame("家庭信息查询");
		frame.add(pic_panel);
		pic_panel.setLayout(new BorderLayout());
		
		label = new JLabel("请输入查询的家庭编号",JLabel.CENTER);
		label.setFont(new Font("微软雅黑",0,25));
		panel = new JPanel();
		panel.setOpaque(false);
		panel.add(label);
		panel.setPreferredSize(new Dimension(80,400));
		pic_panel.add(panel,BorderLayout.NORTH);
		
		label2 = new JLabel("家庭编号");
		label2.setFont(new Font("微软雅黑",0,18));
		panel2 = new JPanel();
		panel2.setOpaque(false);
		textField = new JTextField();
		textField.setPreferredSize(new Dimension (100,30));
		panel2.setLayout(null);
		//panel.add(label2);
		panel.add(textField);
		panel2.setPreferredSize(new Dimension(70, 400));
		pic_panel.add(panel2);
		
		panel4 = new JPanel();
		panel4.setOpaque(false);
		equip_Button = new JButton("家庭所有设备查询");
		user_Button = new JButton("家庭所有成员查询");
		panel4.add(equip_Button);
		panel4.add(user_Button);
		pic_panel.add(panel4,BorderLayout.SOUTH);
		equip_Button.addActionListener(this);
		user_Button.addActionListener(this);
		
		frame.setSize(500,400);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent e) {
		guide = 0;
		type = -1;//0为设备，1为成员
		
		JButton source = (JButton)e.getSource();
		if (source.equals(equip_Button)) {
			infor[0] = textField.getText();
			type = 0;
		}
		if (source.equals(user_Button)) {
			infor[0] = textField.getText();
			type = 1;
		}
		if(infor[0].equals("")){
			guide = 1;
		}
		if(guide == 1){
			JOptionPane.showMessageDialog(null, "请填写遗漏的信息", "信息不完整",JOptionPane.ERROR_MESSAGE);
	    }
		else {
			//eClassmanage.modifyins(infor[0], infor[1]);
			
			if(type == 0)
			{
				JFrame aFrame = new JFrame();
				Object[][] rowData = Equipmanage.fIDinquery(infor[0]);
				String[] columnNames = {"设备编号","设备类别编号","设备类别名称","设备名称","说明","所属家庭编号","厂商编号"};
				JTable table = new JTable(rowData,columnNames);
				table.setRowHeight(30);//设置行高
				table.setFont(new Font("微软雅黑",2,15));//设置字体格式
				SetTableColumnCenter set = new SetTableColumnCenter();
				set.setTableColumnCenter(table);
				JPanel aJPanel = new JPanel();
				
				aJPanel.add(table.getTableHeader(),BorderLayout.NORTH);
				aJPanel.add(table, BorderLayout.CENTER);
				aFrame.add(aJPanel);
				
				aFrame.setSize(700,400);
				aFrame.setVisible(true);
				aFrame.setLocationRelativeTo(null);
			}
			else {
				JFrame aFrame = new JFrame();
				Object[][] rowData = Usersmanage.familyinQuery(infor[0]);
				String[] columnNames = {"用户编号","用户名称","密码","性别","电话","邮箱","所属家庭编号"};
				JTable table = new JTable(rowData,columnNames);
				table.setRowHeight(30);//设置行高
				table.setFont(new Font("微软雅黑",2,15));//设置字体格式
				SetTableColumnCenter set = new SetTableColumnCenter();
				set.setTableColumnCenter(table);
				JPanel aJPanel = new JPanel();
				
				aJPanel.add(table.getTableHeader(),BorderLayout.NORTH);
				aJPanel.add(table, BorderLayout.CENTER);
				aFrame.add(aJPanel);
				
				aFrame.setSize(700,400);
				aFrame.setVisible(true);
				aFrame.setLocationRelativeTo(null);
			}
	    }
	}
}
