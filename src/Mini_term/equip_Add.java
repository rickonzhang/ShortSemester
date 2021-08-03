package Mini_term;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class equip_Add implements ActionListener {
	JFrame admin_Frame,manu_Frame;
	Add_picture pic_panel = new Add_picture();
	JPanel title_Panel,id_Panel,class_Panel,name_Panel,information_Panel,manu_Panel,family_Panel
			,buttPanel;
	JLabel title_Label,id_Label,class_Label,name_Label,information_Label,manu_Label,family_Label;
	JTextField id_TextField,name_JTextField,information_TextField;
	JComboBox<String> class_ComboBox,family_ComboBox,manu_ComboBox;
	//JTextField textField,textField2,textField3,textField4,textField5;
	JButton button;
	String[] infor = new String[10];
	//JComboBox<String> comboBox;
	int guide = 0;
	JFrame superFrame;
	int id;//0为管理员，1为厂商
	String identity;
	String[] classNames = eClass.show();
	String[] family_Name = Family.show();
	String[] manu_Name = Manuf.show();
	
	public equip_Add(JFrame aFrame, int a) {//管理员设备增加
		this.superFrame = aFrame;
		this.id = a;
		admin_Frame = new JFrame("设备增加");
		admin_Frame.add(pic_panel);
		pic_panel.setLayout(new GridLayout(8,1));
		
		title_Label = new JLabel("请输入设备相关信息",JLabel.CENTER);
		title_Label.setFont(new Font("微软雅黑",0,25));
		title_Panel = new JPanel();
		title_Panel.setOpaque(false);
		title_Panel.add(title_Label);
		pic_panel.add(title_Panel);
		
		id_Label = new JLabel("设备编号");
		id_Label.setFont(new Font("微软雅黑",0,18));
		id_Panel = new JPanel();
		id_Panel.setOpaque(false);
		id_TextField = new JTextField();
		id_TextField.setPreferredSize(new Dimension (200,30));
		id_Panel.add(id_Label);
		id_Panel.add(id_TextField);
		pic_panel.add(id_Panel);
		
		class_Label = new JLabel("设备类别");
		class_Label.setFont(new Font("微软雅黑",0,18));
		class_Panel = new JPanel();
		class_Panel.setOpaque(false);	
		class_ComboBox = new JComboBox<String>(classNames);
		/*class_ComboBox = new JComboBox<String>();
		class_ComboBox.addItem("  ");
		for(int i = 0 ; classNames[i] != null; i++ )
		{
			class_ComboBox.addItem(classNames[i]);
		}*/
		class_ComboBox.setPreferredSize(new Dimension (200,30));
		class_Panel.add(class_Label);
		class_Panel.add(class_ComboBox);
		pic_panel.add(class_Panel);
		
		name_Label = new JLabel("设备名称");
		name_Label.setFont(new Font("微软雅黑",0,18));
		name_Panel = new JPanel();
		name_Panel.setOpaque(false);
		name_JTextField = new JTextField();
		name_JTextField.setPreferredSize(new Dimension (200,30));
		name_Panel.add(name_Label);
		name_Panel.add(name_JTextField);
		pic_panel.add(name_Panel);
		
		information_Label = new JLabel("设备信息");
		information_Label.setFont(new Font("微软雅黑",0,18));
		information_Panel = new JPanel();
		information_Panel.setOpaque(false);
		information_TextField = new JTextField();
		information_TextField.setPreferredSize(new Dimension (200,30));
		information_Panel.add(information_Label);
		information_Panel.add(information_TextField);
		pic_panel.add(information_Panel);
		
		
		manu_Label = new JLabel("设备生产商");
		manu_Label.setFont(new Font("微软雅黑",0,18));
		manu_Panel = new JPanel();
		manu_Panel.setOpaque(false);	
		//manu_ComboBox = new JComboBox<String>(manu1);
		manu_ComboBox = new JComboBox<String>(manu_Name);
		/*manu_ComboBox.addItem("  ");
		for(int i = 0 ; manu_Name[i] != null; i++ )
		{
			manu_ComboBox.addItem(manu_Name[i]);
		}*/
		manu_ComboBox.setPreferredSize(new Dimension (200,30));
		manu_Panel.add(manu_Label);
		manu_Panel.add(manu_ComboBox);
		pic_panel.add(manu_Panel);
		
		family_Label = new JLabel("设备所属家庭");
		family_Label.setFont(new Font("微软雅黑",0,18));
		family_Panel = new JPanel();
		family_Panel.setOpaque(false);	
		//family_ComboBox = new JComboBox<String>(family1);
		family_ComboBox = new JComboBox<String>();
		family_ComboBox.addItem("  ");
		for(int i = 0 ; family_Name[i] != null; i++ )
		{
			family_ComboBox.addItem(family_Name[i]);
		}
		family_ComboBox.setPreferredSize(new Dimension (200,30));
		family_Panel.add(family_Label);
		family_Panel.add(family_ComboBox);
		pic_panel.add(family_Panel);
		
		buttPanel = new JPanel();
		buttPanel.setOpaque(false);
		button = new JButton("增加");
		buttPanel.add(button);
		pic_panel.add(buttPanel);
		button.addActionListener(this);
		
		admin_Frame.setSize(500,400);
		admin_Frame.setVisible(true);
		admin_Frame.setLocationRelativeTo(null);
		//admin_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public equip_Add(JFrame frame1, int a, String identity) {//设备厂商设备增加
		this.superFrame = frame1;
		this.id = a;
		this.identity = identity;
		manu_Frame = new JFrame("设备增加");
		manu_Frame.add(pic_panel);
		pic_panel.setLayout(new GridLayout(7,1));
		
		title_Label = new JLabel("请输入设备相关信息",JLabel.CENTER);
		title_Label.setFont(new Font("微软雅黑",0,25));
		title_Panel = new JPanel();
		title_Panel.setOpaque(false);
		title_Panel.add(title_Label);
		pic_panel.add(title_Panel);
		
		id_Label = new JLabel("设备编号");
		id_Label.setFont(new Font("微软雅黑",0,18));
		id_Panel = new JPanel();
		id_Panel.setOpaque(false);
		id_TextField = new JTextField();
		id_TextField.setPreferredSize(new Dimension (200,30));
		id_Panel.add(id_Label);
		id_Panel.add(id_TextField);
		pic_panel.add(id_Panel);
		
		class_Label = new JLabel("设备类别");
		class_Label.setFont(new Font("微软雅黑",0,18));
		class_Panel = new JPanel();
		class_Panel.setOpaque(false);	
		class_ComboBox = new JComboBox<String>(classNames);
		/*class_ComboBox = new JComboBox<String>();
		class_ComboBox.addItem("  ");
		for(int i = 0 ; classNames[i] != null; i++ )
		{
			class_ComboBox.addItem(classNames[i]);
		}*/
		class_ComboBox.setPreferredSize(new Dimension (200,30));
		class_Panel.add(class_Label);
		class_Panel.add(class_ComboBox);
		pic_panel.add(class_Panel);
		
		name_Label = new JLabel("设备名称");
		name_Label.setFont(new Font("微软雅黑",0,18));
		name_Panel = new JPanel();
		name_Panel.setOpaque(false);
		name_JTextField = new JTextField();
		name_JTextField.setPreferredSize(new Dimension (200,30));
		name_Panel.add(name_Label);
		name_Panel.add(name_JTextField);
		pic_panel.add(name_Panel);
		
		information_Label = new JLabel("设备信息");
		information_Label.setFont(new Font("微软雅黑",0,18));
		information_Panel = new JPanel();
		information_Panel.setOpaque(false);
		information_TextField = new JTextField();
		information_TextField.setPreferredSize(new Dimension (200,30));
		information_Panel.add(information_Label);
		information_Panel.add(information_TextField);
		pic_panel.add(information_Panel);
		
		family_Label = new JLabel("设备所属家庭");
		family_Label.setFont(new Font("微软雅黑",0,18));
		family_Panel = new JPanel();
		family_Panel.setOpaque(false);	
		//family_ComboBox = new JComboBox<String>(family1);
		family_ComboBox = new JComboBox<String>();
		family_ComboBox.addItem("  ");
		for(int i = 0 ; family_Name[i] != null; i++ )
		{
			family_ComboBox.addItem(family_Name[i]);
		}
		family_ComboBox.setPreferredSize(new Dimension (200,30));
		family_Panel.add(family_Label);
		family_Panel.add(family_ComboBox);
		pic_panel.add(family_Panel);
		
		buttPanel = new JPanel();
		buttPanel.setOpaque(false);
		button = new JButton("增加");
		buttPanel.add(button);
		pic_panel.add(buttPanel);
		button.addActionListener(this);
		
		manu_Frame.setSize(500,400);
		manu_Frame.setVisible(true);
		manu_Frame.setLocationRelativeTo(null);
		//manu_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		guide = 0;
		JButton source = (JButton)e.getSource();
		if (source.equals(button)) {
			infor[0] = id_TextField.getText();
			infor[1] = (String) class_ComboBox.getSelectedItem();
			infor[2] = name_JTextField.getText();
			infor[3] = information_TextField.getText();
			infor[4] = (String) family_ComboBox.getSelectedItem();
		}
		for(int i = 0; i < 5 ; i++){
			if(infor[i].equals("")){
				guide = 1;
				break;
			}
		}
		if( guide == 1 ) {
		    JOptionPane.showMessageDialog(null, "请填写遗漏的信息", "信息不完整",JOptionPane.ERROR_MESSAGE);
		}
		else {		    		
		    Equip eeEquip = new Equip();
			eeEquip.seteID(infor[0]);
			eeEquip.setClass_cID(eClass.nametoid(infor[1]));
			eeEquip.setEname(infor[2]);
    		eeEquip.setInstruction(infor[3]);
		    eeEquip.setFamily_fID(Family.nametoid(infor[4]));
		    
		    //System.out.println(id+identity);
		    if(id == 0 ){
		    	infor[5] = (String) manu_ComboBox.getSelectedItem();
		    	eeEquip.setManufacturer_mID(Manuf.nametoid(infor[5]));
		    	Equipmanage.insert(eeEquip);
		    	admin_Frame.dispose();
		    	//superFrame.setVisible(false);
		    	superFrame.dispose();
    			new Admin();
    		}
    		else {
    			infor[5] = identity;
    			System.out.println(id+" "+infor[5]);
    			eeEquip.setManufacturer_mID(infor[5]);
    			Equipmanage.insert(eeEquip);
    			manu_Frame.dispose();
    			superFrame.dispose();
				new Manu(identity);
			}
		}
			
	}

}
