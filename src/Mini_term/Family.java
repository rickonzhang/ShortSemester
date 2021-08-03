package Mini_term;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Family {
	private String fID = null;
    private String fname = null;
    private String address = null;
    public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	private int isDelete = 0;
    
	public String getfID() {
		return fID;
	}
	public void setfID(String fID) {
		this.fID = fID;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public static String[] show(){
		
    	try {
    		//Vector v = new Vector();
    		int i = 0;
    		String[] first = new String[20];
    		String[] qu = new String[20];
    		Connection conn = Connector.getConn();
    		PreparedStatement ps = conn.prepareStatement("SELECT fName from `family` where isDelete = 0");
    		ResultSet rs = ps.executeQuery();
    		while(rs.next() && rs.getRow() > 0)
    		{
    			qu[i] = rs.getString(1);	
    			i++;
    		} 
    		
    		return qu;
    	}
    	catch(Exception e)
    	{
    		JOptionPane.showMessageDialog(null, "failed");
    		e.printStackTrace();
    		return null;
    	}
    	 
    }
	
	public static String nametoid(String name){
		
    	try {
    		//Vector v = new Vector();
    		String qu = new String();
    		Connection conn = Connector.getConn();
    		PreparedStatement ps = conn.prepareStatement("SELECT fID from `family` where isDelete = 0 and fname = '" + name +"'");
    		ResultSet rs = ps.executeQuery();
    		while(rs.next() && rs.getRow() > 0)
    		{
    			qu = rs.getString(1);	
    			return qu;
    		}
    		 JOptionPane.showMessageDialog(null, "Sorry,the family name you typed does not exist");
    		return null;
    	}
    	catch(Exception e)
    	{
    		JOptionPane.showMessageDialog(null, "error!");
    		e.printStackTrace();
    		return null;
    	}
    	 
    }

}
