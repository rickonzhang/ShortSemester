package Mini_term;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class user_inforSelect implements ActionListener {
	JFrame frame;
	Add_picture pic_panel = new Add_picture();
	JLabel label,label2,label3;
	JPanel panel,panel2,panel4;
	JPanel panel3 = new JPanel();
	JButton button;
	JTextField textField,textField2;
	String[] infor = new String[5];
	int guide = 0;
	JFrame superFrame;
	
	public user_inforSelect(JFrame aFrame) {
		this.superFrame = aFrame;
		frame = new JFrame("用户信息查询");
		frame.add(pic_panel);
		pic_panel.setLayout(new BorderLayout());
		
		label = new JLabel("请输入查询的设用户编号",JLabel.CENTER);
		label.setFont(new Font("微软雅黑",0,25));
		panel = new JPanel();
		panel.setOpaque(false);
		panel.add(label);
		panel.setPreferredSize(new Dimension(80,400));
		pic_panel.add(panel,BorderLayout.NORTH);
		
		label2 = new JLabel("用户编号");
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
		button = new JButton("查询");
		panel4.add(button);
		pic_panel.add(panel4,BorderLayout.SOUTH);
		button.addActionListener(this);
		
		frame.setSize(500,400);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent e) {
		guide = 0;
		JButton source = (JButton)e.getSource();
		if (source.equals(button)) {
			infor[0] = textField.getText();
		}
		if(infor[0].equals("")){
				guide = 1;
		}
		if(guide == 1){
			JOptionPane.showMessageDialog(null, "请填写遗漏的信息", "信息不完整",JOptionPane.ERROR_MESSAGE);
	    }
		else {
			JFrame aFrame = new JFrame();
			Object[] rowData = Usersmanage.singleQuery(infor[0]);
			
			JTextArea textArea = new JTextArea(null, 5, 10);
	        
	        //textArea.setBackground(new Color(238, 238, 238));
	        textArea.setFont(new Font("微软雅黑",10,20));
	        textArea.append("用户id    : "+ rowData[0]+"\n");
	        textArea.append("用户姓名 : "+ rowData[1]+"\n");
	        textArea.append("密码     ："+ rowData[2]+"\n");
	        textArea.append("性别     ："+ rowData[3]+"\n");
	        textArea.append("电话     ："+ rowData[4]+"\n");
	        textArea.append("邮箱     ："+ rowData[5]+"\n");
	        textArea.append("家庭     ："+ rowData[6]+"\n");
	        textArea.setOpaque(false);
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);  
	        textArea.setBorder(BorderFactory.createLoweredBevelBorder());
	        aFrame.add(BorderLayout.CENTER , textArea);
	       
			
			aFrame.setSize(700,400);
			aFrame.setVisible(true);
			aFrame.setLocationRelativeTo(null);
	    }
	}
}