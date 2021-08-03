package Mini_term;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class user_Delete implements ActionListener {
	JFrame frame;
	Add_picture pic_panel = new Add_picture();
	JButton button;
	JPanel panel,panel2,panel3;
	JTextField textField;
	JLabel label,label2;
	String[] infor = new String[5];
	JFrame superFrame;

	public user_Delete(JFrame aFrame) {
		this.superFrame = aFrame;
		frame = new JFrame("用户删除");
		frame.add(pic_panel);
		pic_panel.setLayout(new GridLayout(3,1));
		
		label = new JLabel("请输入删除用户的用户编号",JLabel.CENTER);
		label.setFont(new Font("微软雅黑",0,25));
		panel = new JPanel();
		panel.setOpaque(false);
		panel.add(label);
		pic_panel.add(panel);
		
		label2 = new JLabel("用户编号");
		label2.setFont(new Font("微软雅黑",0,18));
		panel2 = new JPanel();
		panel2.setOpaque(false);
		textField = new JTextField();
		textField.setPreferredSize(new Dimension (200,30));
		panel2.add(label2);
		panel2.add(textField);
		pic_panel.add(panel2);
		
		panel3 = new JPanel();
		panel3.setOpaque(false);
		button = new JButton("删除");
		panel3.add(button);
		pic_panel.add(panel3);
		button.addActionListener(this);
		
		frame.setSize(500,400);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		if (source.equals(button)) {
			infor[0] = textField.getText();
		}
		if(infor[0].equals(""))
		{
			JOptionPane.showMessageDialog(null, "请填写遗漏的信息", "信息不完整",JOptionPane.ERROR_MESSAGE);
	    }
		else {
			int n = JOptionPane.showConfirmDialog(null,"Have you checked all the information is correct? You can't change the information once the information is submitted. ","Confirm check in?",JOptionPane.YES_NO_OPTION);
	    	if( n == JOptionPane.YES_OPTION) {
	    		Usersmanage.delete(infor[0]);
	    		frame.dispose();
	    		superFrame.dispose();
	    		new Admin();
	    	}
		}
	}
}
