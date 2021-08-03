package Mini_term;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class eClass {
	private String cID = null;
    private String cname = null;
    private int isDelete = 0;
    
	public String getcID() {
		return cID;
	}
	public void setcID(String cID) {
		this.cID = cID;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public static String nametoid(String name){
		
        	try {
        		//Vector v = new Vector();
        		String qu = new String();
        		Connection conn = Connector.getConn();
        		PreparedStatement ps = conn.prepareStatement("SELECT cID from `class` where cname = '" + name +"'");
        		ResultSet rs = ps.executeQuery();
        		while(rs.next() && rs.getRow() > 0)
        		{
        			qu = rs.getString(1);	
        			return qu;
        		}
        		 JOptionPane.showMessageDialog(null, "Sorry,the class name you typed does not exist");
        		return null;
        	}
        	catch(Exception e)
        	{
        		JOptionPane.showMessageDialog(null, "error!");
        		e.printStackTrace();
        		return null;
        	}
        	 
        }
	
	public static String[] show(){
		
    	try {
    		//Vector v = new Vector();
    		int i = 0;
    		String[] first = new String[6];
    		String[] qu = new String[6];
    		Connection conn = Connector.getConn();
    		PreparedStatement ps = conn.prepareStatement("SELECT cName from `class` where isDelete = 0");
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
	
}
