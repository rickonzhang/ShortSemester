package Mini_term;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

public class class_Add implements ActionListener {
	JFrame frame;
	Add_picture pic_panel = new Add_picture();
	JPanel title_Panel,id_Panel,name_Panel,button_Panel;
	JLabel title_Label,id_Label,name_Label;
	JTextField id_TextField,name_TextField;
	JButton button;
	String[] infor = new String[10];
	int guide = 0;
	JFrame superFrame;
	
	public class_Add(JFrame adminFrame) {
		this.superFrame = adminFrame;
		frame = new JFrame("设备类别增加");
		frame.add(pic_panel);
		pic_panel.setLayout(new GridLayout(4,1));
		
		title_Label = new JLabel("请输入设备类别相关信息",JLabel.CENTER);
		title_Label.setFont(new Font("微软雅黑",0,25));
		title_Panel = new JPanel();
		title_Panel.setOpaque(false);
		title_Panel.add(title_Label);
		pic_panel.add(title_Panel);
		
		id_Label = new JLabel("设备类别编号"); 
		id_Label.setFont(new Font("微软雅黑",0,18));
		id_Panel = new JPanel();
		id_Panel.setOpaque(false);
		id_TextField = new JTextField();
		id_TextField.setPreferredSize(new Dimension (200,30));
		id_Panel.add(id_Label);
		id_Panel.add(id_TextField);
		pic_panel.add(id_Panel);
		
		name_Label = new JLabel("设备类别姓名");
		name_Label.setFont(new Font("微软雅黑",0,18));
		name_Panel = new JPanel();
		name_Panel.setOpaque(false);
		name_TextField = new JTextField();
		name_TextField.setPreferredSize(new Dimension (200,30));
		name_Panel.add(name_Label);
		name_Panel.add(name_TextField);
		pic_panel.add(name_Panel);
		
		button_Panel = new JPanel();
		button_Panel.setOpaque(false);
		button = new JButton("增加");
		button_Panel.add(button);
		pic_panel.add(button_Panel);
		button.addActionListener(this);
		
		frame.setSize(500,650);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		guide = 0;
		JButton source = (JButton)e.getSource();
		if (source.equals(button)) {
			infor[0] = id_TextField.getText();
			infor[1] = name_TextField.getText();
		}
		for(int i = 0; i < 2 ; i++){
			if(infor[i].equals("")){
				guide = 1;
				break;
			}
		}
		if( guide == 1 ) {
		    JOptionPane.showMessageDialog(null, "请填写遗漏的信息", "信息不完整",JOptionPane.ERROR_MESSAGE);
		}
		else {
			eClass new_eClass = new eClass();
			new_eClass.setcID(infor[0]);
			new_eClass.setCname(infor[1]);
			eClassmanage.insert(new_eClass);
			frame.dispose();
		    superFrame.dispose();
    		new Admin();		    		
		}
			
	}

}
