package Mini_term;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Login implements ActionListener {	
	int guide = 0;
	int checkIdentity;
	String[] infor = new String[4];
	
	JFrame frame;
	JButton button;
	JTextField textField;
	JRadioButton adMinButton;
	JRadioButton manuButton;
	JPasswordField passwordField;
	ButtonGroup group;
	
	public Login() {
		frame = new JFrame("智能家居登录界面");
		JLabel label = new JLabel("欢迎登陆智能家居系统",JLabel.CENTER);
		label.setFont(new Font("微软雅黑",0,35));
		
		JLabel label2 = new JLabel("智能品质——乐享生活",JLabel.CENTER);
		label2.setFont(new Font("方正舒体", 2, 18));
		
		JPanel panel = new JPanel();
		JLabel label3 = new JLabel("用户名");
		textField = new JTextField(20);
		label3.setFont(new Font("宋体", 0, 18));
		panel.add(label3);
		panel.add(textField);
		panel.setOpaque(false);
		
		JPanel panel2 = new JPanel();
		JLabel label4 = new JLabel("密码  ");
		passwordField = new JPasswordField(20);
		label4.setFont(new Font("宋体", 0, 18));
		panel2.add(label4);
		panel2.add(passwordField);
		panel2.setOpaque(false);
		
		JPanel panel3 = new JPanel();
		JLabel label5 = new JLabel("身份  ");
		adMinButton = new JRadioButton("管理员  ", true);
		adMinButton.setOpaque(false);
		adMinButton.setFont(new Font("楷体",0,15));
		manuButton = new JRadioButton("设备厂家 ", false);
		manuButton.setOpaque(false);
		manuButton.setFont(new Font("楷体",0,15));
		group = new ButtonGroup();
		group.add(manuButton);
		group.add(adMinButton);
		label5.setFont(new Font("宋体", 0, 18));
		panel3.add(label5);
		panel3.add(adMinButton);
		panel3.add(manuButton);
		panel3.setOpaque(false);
		
		JPanel panel4 = new JPanel();
		button = new JButton("登录");
		button.setFont(new Font("微软雅黑",0,18));
		panel4.add(button);
		panel4.setOpaque(false);
		
		Add_picture aPanel = new Add_picture();
		frame.add(aPanel);
		aPanel.setLayout(new GridLayout(6,1));
		aPanel.add(label);
		aPanel.add(label2);
		aPanel.add(panel);
		aPanel.add(panel2);
		aPanel.add(panel3);
		aPanel.add(panel4);
		button.addActionListener(this);
		
		frame.setSize(600,400);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent event) {
		JButton source = (JButton)event.getSource();
		if (source.equals(button)) {
			guide = 0;
			infor[0] = textField.getText();
			infor[1] = String.valueOf(this.passwordField.getPassword());
			if(adMinButton.isSelected()) {
				infor[2] = "administrator";
			}
			if(manuButton.isSelected()) {
				infor[2] = "manufacturer";
			}
		/**
		 * 判断是否有信息未填
		 */
			for(int i = 0; i < 3 ; i++){
				if(infor[i].equals(""))
				{
					guide = 1;
					break;
				}
			}
			/**
			 * 有信息未填
			 */
			if( guide == 1 ) {
		    	JOptionPane.showMessageDialog(null, "请填写遗漏的信息", "信息不完整",JOptionPane.ERROR_MESSAGE);
		    }
		    else {
		    	checkIdentity = Goldenkey.judgement(infor);
		    	if(checkIdentity == 1)
		    	{
		    		int n = JOptionPane.showConfirmDialog(null,"Have you checked all the information is correct? You can't change the information once the information is submitted. ","Confirm check in?",JOptionPane.YES_NO_OPTION);
			    	if( n == JOptionPane.YES_OPTION) {
			    		frame.dispose();
			    		if(adMinButton.isSelected()){
			    			new Admin();
			    		}
			    		if(manuButton.isSelected()) {
			    			new Manu(infor[0]);
			    		}
			    	}
		    	}
		    	else {
		    		JOptionPane.showMessageDialog(null, "信息不正确，请重新输入", "信息错误信息不完整",JOptionPane.ERROR_MESSAGE);
		    	}
			}
		}
	}
}
