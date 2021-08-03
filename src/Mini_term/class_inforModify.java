package Mini_term;

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
import javax.swing.JTextField;

public class class_inforModify implements ActionListener {
	JFrame frame;
	Add_picture pic_panel = new Add_picture();
	JLabel label,label2,label3;
	JPanel panel,panel2,panel3,panel4;
	JButton button;
	JTextField textField,textField2;
	String[] infor = new String[5];
	int guide = 0;
	JFrame superFrame;
	
	public class_inforModify(JFrame aFrame) {
		this.superFrame = aFrame;
		frame = new JFrame("设备类别信息修改");
		frame.add(pic_panel);
		pic_panel.setLayout(new GridLayout(4,1));
		
		label = new JLabel("请输入修改设备类别的设备类别编号",JLabel.CENTER);
		label.setFont(new Font("微软雅黑",0,25));
		panel = new JPanel();
		panel.setOpaque(false);
		panel.add(label);
		pic_panel.add(panel);
		
		label2 = new JLabel("设备类别编号");
		label2.setFont(new Font("微软雅黑",0,18));
		panel2 = new JPanel();
		panel2.setOpaque(false);
		textField = new JTextField();
		textField.setPreferredSize(new Dimension (200,30));
		panel2.add(label2);
		panel2.add(textField);
		pic_panel.add(panel2);
		
		label3 = new JLabel("设备类别信息");
		label3.setFont(new Font("微软雅黑",0,18));
		panel3 = new JPanel();
		panel3.setOpaque(false);
		textField2 = new JTextField();
		textField2.setPreferredSize(new Dimension (200,30));
		panel3.add(label3);
		panel3.add(textField2);
		pic_panel.add(panel3);
		
		panel4 = new JPanel();
		panel4.setOpaque(false);
		button = new JButton("更改");
		panel4.add(button);
		pic_panel.add(panel4);
		button.addActionListener(this);
		
		frame.setSize(500,400);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		if (source.equals(button)) {
			infor[0] = textField.getText();
			infor[1] = textField2.getText();
		}
		for(int i = 0; i < 2 ; i++){
			if(infor[i].length() == 0){
				guide = 1;
				break;
			}
		}
		if(guide == 1){
			JOptionPane.showMessageDialog(null, "请填写遗漏的信息", "信息不完整",JOptionPane.ERROR_MESSAGE);
	    }
		else {
			eClassmanage.modifyins(infor[0], infor[1]);
			frame.dispose();
    		superFrame.dispose();
    		new Admin();
	    }
	}
}
