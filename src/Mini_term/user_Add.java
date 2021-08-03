package Mini_term;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class user_Add implements ActionListener {
	JFrame admin_Frame;
	Add_picture pic_panel = new Add_picture();
	JPanel title_Panel,id_Panel,name_Panel,family_Panel,password_Panel,gender_Panel
			,phone_Panel,email_Panel,button_Panel;
	JLabel title_Label,id_Label,name_Label,family_Label,password_Label,gender_Label
			,phone_Label,email_Label,button_Label;
	JTextField id_TextField,name_TextField,password_TextField,phone_TextField
			,email_TextField;
	JComboBox<String> gender_ComboBox,family_ComboBox;
	JButton button;
	
	String[] infor = new String[10];
	int guide = 0;
	JFrame superFrame;
	String[] family_Name = Family.show();
	String[] gender_Name = new String[] {"","男","女"};
	
	public user_Add(JFrame aFrame) {
		this.superFrame = aFrame;
		admin_Frame = new JFrame("用户增加");
		admin_Frame.add(pic_panel);
		pic_panel.setLayout(new GridLayout(9,1));
		
		title_Label = new JLabel("请输入用户相关信息",JLabel.CENTER);
		title_Label.setFont(new Font("微软雅黑",0,25));
		title_Panel = new JPanel();
		title_Panel.setOpaque(false);
		title_Panel.add(title_Label);
		pic_panel.add(title_Panel);
		
		id_Label = new JLabel("用户编号");
		id_Label.setFont(new Font("微软雅黑",0,18));
		id_Panel = new JPanel();
		id_Panel.setOpaque(false);
		id_TextField = new JTextField();
		id_TextField.setPreferredSize(new Dimension (200,30));
		id_Panel.add(id_Label);
		id_Panel.add(id_TextField);
		pic_panel.add(id_Panel);
		
		password_Label = new JLabel("密      码");
		password_Label.setFont(new Font("微软雅黑",0,18));
		password_Panel = new JPanel();
		password_Panel.setOpaque(false);
		password_TextField = new JTextField();
		password_TextField.setPreferredSize(new Dimension (200,30));
		password_Panel.add(password_Label);
		password_Panel.add(password_TextField);
		pic_panel.add(password_Panel);
		
		name_Label = new JLabel("用户姓名");
		name_Label.setFont(new Font("微软雅黑",0,18));
		name_Panel = new JPanel();
		name_Panel.setOpaque(false);
		name_TextField = new JTextField();
		name_TextField.setPreferredSize(new Dimension (200,30));
		name_Panel.add(name_Label);
		name_Panel.add(name_TextField);
		pic_panel.add(name_Panel);
		
		family_Label = new JLabel("所属家庭");
		family_Label.setFont(new Font("微软雅黑",0,18));
		family_Panel = new JPanel();
		family_Panel.setOpaque(false);	
		//family_ComboBox = new JComboBox<String>(family1);
		family_ComboBox = new JComboBox<String>();
		family_ComboBox.addItem("  ");
		for(int i = 0 ; family_Name[i] != null; i++ ){
			family_ComboBox.addItem(family_Name[i]);
		}
		family_ComboBox.setPreferredSize(new Dimension (200,30));
		family_Panel.add(family_Label);
		family_Panel.add(family_ComboBox);
		pic_panel.add(family_Panel);
		
		gender_Label = new JLabel("性     别");
		gender_Label.setFont(new Font("微软雅黑",0,18));
		gender_Panel = new JPanel();
		gender_Panel.setOpaque(false);	
		//gender_ComboBox = new JComboBox<String>(gender1);
		gender_ComboBox = new JComboBox<String>(gender_Name);
		gender_ComboBox.setPreferredSize(new Dimension (200,30));
		gender_Panel.add(gender_Label);
		gender_Panel.add(gender_ComboBox);
		pic_panel.add(gender_Panel);
		
		phone_Label = new JLabel("电      话");
		phone_Label.setFont(new Font("微软雅黑",0,18));
		phone_Panel = new JPanel();
		phone_Panel.setOpaque(false);
		phone_TextField = new JTextField();
		phone_TextField.setPreferredSize(new Dimension (200,30));
		phone_Panel.add(phone_Label);
		phone_Panel.add(phone_TextField);
		pic_panel.add(phone_Panel);
		
		email_Label = new JLabel("邮      箱");
		email_Label.setFont(new Font("微软雅黑",0,18));
		email_Panel = new JPanel();
		email_Panel.setOpaque(false);
		email_TextField = new JTextField();
		email_TextField.setPreferredSize(new Dimension (200,30));
		email_Panel.add(email_Label);
		email_Panel.add(email_TextField);
		pic_panel.add(email_Panel);
		
		button_Panel = new JPanel();
		button_Panel.setOpaque(false);
		button = new JButton("增加");
		button_Panel.add(button);
		pic_panel.add(button_Panel);
		button.addActionListener(this);
		
		admin_Frame.setSize(500,400);
		admin_Frame.setVisible(true);
		admin_Frame.setLocationRelativeTo(null);
		//admin_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		guide = 0;
		JButton source = (JButton)e.getSource();
		if (source.equals(button)) {
			infor[0] = id_TextField.getText();
			infor[1] = password_TextField.getText();
			infor[2] = name_TextField.getText();
			infor[3] = (String) family_ComboBox.getSelectedItem();
			infor[4] = (String) gender_ComboBox.getSelectedItem();
			infor[5] = phone_TextField.getText();
			infor[6] = email_TextField.getText();
		}
		for(int i = 0; i < 7 ; i++){
			if(infor[i].equals("")){
				guide = 1;
				break;
			}
		}
		if( guide == 1 ) {
		    JOptionPane.showMessageDialog(null, "请填写遗漏的信息", "信息不完整",JOptionPane.ERROR_MESSAGE);
		}
		else {		    		
		    User new_User = new User();
		    new_User.setuID(infor[0]);
		    new_User.setPwd(infor[1]);
		    new_User.setuName(infor[2]);
		    new_User.setFamily_fID(Family.nametoid(infor[3]));
		    new_User.setGender(infor[4]);
		    new_User.setPhone(infor[5]);
		    new_User.setEmail(infor[6]);
		    Usersmanage.insert(new_User);
		    admin_Frame.dispose();
		    superFrame.dispose();
			new Admin();
		}
	}
}
