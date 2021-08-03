package Mini_term;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class SetTableColumnCenter {
	public void setTableColumnCenter(JTable table){//字体居中
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		table.setDefaultRenderer(Object.class, r);
		//((Object) table).setLineWrap(true);
	}
}
