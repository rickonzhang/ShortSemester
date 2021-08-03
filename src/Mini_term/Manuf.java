package Mini_term;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Manuf {
	
	private String mID = null;
	private String pwd = null;
    private String mname = null;
    private int isDelete = 0;
    
	public String getmID() {
		return mID;
	}
	public void setmID(String mID) {
		this.mID = mID;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
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
    		PreparedStatement ps = conn.prepareStatement("SELECT mName from `manufacturer` where isDelete = 0");
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
    		PreparedStatement ps = conn.prepareStatement("SELECT mID from `manufacturer` where mname = '" + name +"'");
    		ResultSet rs = ps.executeQuery();
    		while(rs.next() && rs.getRow() > 0)
    		{
    			qu = rs.getString(1);	
    			return qu;
    		}
    		 JOptionPane.showMessageDialog(null, "Sorry,the family manufacturer you typed does not exist");
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
