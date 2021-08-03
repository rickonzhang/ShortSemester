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

public class family_inforModify implements ActionListener {
	JFrame frame;
	Add_picture pic_panel = new Add_picture();
	JPanel title_panel,id_Panel,name_Panel,address_Panel,button_Panel;
	JLabel title_label,id_Label,name_Label,address_Label;
	JTextField id_TextField,name_TextField,address_TextField;
	JButton button;
	String[] infor = new String[10];
	int guide = 0;
	JFrame superFrame;
//	String[] classNames = eClass.show();
//	String[] familyNames = eClass.show();
	//String[] class = 
	
	public family_inforModify(JFrame adminFrame) {
		this.superFrame = adminFrame;
		frame = new JFrame("家庭信息更改");
		frame.add(pic_panel);
		pic_panel.setLayout(new GridLayout(5,1));
		
		title_label = new JLabel("请输入家庭相关信息",JLabel.CENTER);
		title_label.setFont(new Font("微软雅黑",0,25));
		title_panel = new JPanel();
		title_panel.setOpaque(false);
		title_panel.add(title_label);
		pic_panel.add(title_panel);
		
		id_Label = new JLabel("家庭编号");
		id_Label.setFont(new Font("微软雅黑",0,18));
		id_Panel = new JPanel();
		id_Panel.setOpaque(false);
		id_TextField = new JTextField();
		id_TextField.setPreferredSize(new Dimension (200,30));
		id_Panel.add(id_Label);
		id_Panel.add(id_TextField);
		pic_panel.add(id_Panel);
		
		name_Label = new JLabel("家庭名称");
		name_Label.setFont(new Font("微软雅黑",0,18));
		name_Panel = new JPanel();
		name_Panel.setOpaque(false);
		name_TextField = new JTextField();
		name_TextField.setPreferredSize(new Dimension (200,30));
		name_Panel.add(name_Label);
		name_Panel.add(name_TextField);
		pic_panel.add(name_Panel);
		
		address_Label = new JLabel("家庭地址");
		address_Label.setFont(new Font("微软雅黑",0,18));
		address_Panel = new JPanel();
		address_Panel.setOpaque(false);
		address_TextField = new JTextField();
		address_TextField.setPreferredSize(new Dimension (200,30));
		address_Panel.add(address_Label);
		address_Panel.add(address_TextField);
		pic_panel.add(address_Panel);
		
		button_Panel = new JPanel();
		button_Panel.setOpaque(false);
		button = new JButton("更改");
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
			infor[2] = address_TextField.getText();
		}
		for(int i = 0; i < 3 ; i++){
			if(infor[i].equals("")){
				guide = 1;
				break;
			}
		}
		if( guide == 1 ) {
		    JOptionPane.showMessageDialog(null, "请填写遗漏的信息", "信息不完整",JOptionPane.ERROR_MESSAGE);
		}
		else {
			Family new_Family = new Family();
			new_Family.setfID(infor[0]);
			new_Family.setFname(infor[1]);
			new_Family.setAddress(infor[2]);
			Familymanage.modify(new_Family);
			frame.dispose();
		    superFrame.dispose();
    		new Admin();		    		
		}
	}

}

	/*JFrame frame;
	Add_picture pic_panel = new Add_picture();
	JPanel title_panel,id_Panel,name_Panel,address_Panel,button_Panel;
	JLabel title_label,id_Label,name_Label,address_Label;
	JTextField id_TextField,name_TextField,address_TextField;
	JButton button;
	String[] infor = new String[5];
	int guide = 0;
	JFrame superFrame;
	
	public family_inforModify(JFrame aFrame) {
		this.superFrame = aFrame;
		frame = new JFrame("设备家庭信息修改");
		frame.add(pic_panel);
		pic_panel.setLayout(new GridLayout(4,1));
		
		title_label = new JLabel("请输入家庭相关信息",JLabel.CENTER);
		title_label.setFont(new Font("微软雅黑",0,25));
		title_panel = new JPanel();
		title_panel.setOpaque(false);
		title_panel.add(title_label);
		pic_panel.add(title_panel);
		
		id_Label = new JLabel("家庭编号");
		id_Label.setFont(new Font("微软雅黑",0,18));
		id_Panel = new JPanel();
		id_Panel.setOpaque(false);
		id_TextField = new JTextField();
		id_TextField.setPreferredSize(new Dimension (200,30));
		id_Panel.add(id_Label);
		id_Panel.add(id_TextField);
		pic_panel.add(id_Panel);
		
		name_Label = new JLabel("家庭名称");
		name_Label.setFont(new Font("微软雅黑",0,18));
		name_Panel = new JPanel();
		name_Panel.setOpaque(false);
		name_TextField = new JTextField();
		name_TextField.setPreferredSize(new Dimension (200,30));
		name_Panel.add(name_Label);
		name_Panel.add(name_TextField);
		pic_panel.add(name_Panel);
		
		address_Label = new JLabel("家庭地址");
		address_Label.setFont(new Font("微软雅黑",0,18));
		address_Panel = new JPanel();
		address_Panel.setOpaque(false);
		address_TextField = new JTextField();
		address_TextField.setPreferredSize(new Dimension (200,30));
		address_Panel.add(address_Label);
		address_Panel.add(address_TextField);
		pic_panel.add(address_Panel);
		
		button_Panel = new JPanel();
		button_Panel.setOpaque(false);
		button = new JButton("增加");
		button_Panel.add(button);
		pic_panel.add(button_Panel);
		button.addActionListener(this);
		
		frame.setSize(300,400);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		if (source.equals(button)) {
			infor[0] = id_TextField.getText();
			infor[1] = name_TextField.getText();
			infor[2] = address_TextField.getText();
		}
		for(int i = 0; i < 3 ; i++){
			if(infor[i].length() == 0){
				guide = 1;
				break;
			}
		}
		if(guide == 1){
			JOptionPane.showMessageDialog(null, "请填写遗漏的信息", "信息不完整",JOptionPane.ERROR_MESSAGE);
	    }
		else {
			Family new_Family = new Family();
			new_Family.setfID(infor[0]);
			new_Family.setFname(infor[1]);
			new_Family.setAddress(infor[2]);
			Familymanage.modify(new_Family);
			frame.dispose();
		    superFrame.dispose();
    		new Admin();
	    }
	}
}*/
