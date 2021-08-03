package Mini_term;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Equipmanage {
	
	public static void insert(Equip e) {
    	try {
    		 Connection conn = Connector.getConn();
    		 
    		 PreparedStatement pss = conn.prepareStatement("SELECT eID,isDelete from `equipment` where eID ='"+ e.geteID() +"'");
    		 ResultSet rss = pss.executeQuery();
    		// System.out.println("1111");
    		 if(rss.next()){
    			 if(rss.getLong(2)==0){
    				 
    				 pss.close();
        	         conn.close();
        			 JOptionPane.showMessageDialog(null, "failed,The ID you have entered has existed");
        			 return;
    			 }else{
    				 PreparedStatement ps = conn.prepareStatement("update `equipment` set ename='"+ e.getEname() +"',class_cID='"+ e.getClass_cID() +"',instruction='"+ e.getInstruction() +"',family_fID='"+ e.getFamily_fID() +"',manufacturer_mID='"+ e.getManufacturer_mID() +"',isDelete = 0 where eID = '"+ e.geteID() +"'");
    				 //System.out.println("1111");
    				 ps.executeUpdate();
    				 //System.out.println("1111");
    				 ps.close();
    				 pss.close();
        	         conn.close();
        	         JOptionPane.showMessageDialog(null, "Insert successfully!");
        	         return;
    			 }
    
    		 }
    		 
    		 PreparedStatement ps = conn.prepareStatement("INSERT into `equipment`(eID,class_cID,ename,instruction,isDelete,family_fID,manufacturer_mID)values(?,?,?,?,?,?,?)");
    		 if(e.geteID().equals("") || e.getClass_cID().equals("") || e.getEname().equals("") ||e.getInstruction().equals("") ||e.getFamily_fID().equals("") ||e.getManufacturer_mID().equals("")){
    			 ps.close();
    	         conn.close();
    			 JOptionPane.showMessageDialog(null, "failed,The information you have entered is incomplete");
    			 return;
    		 }
    		 ps.setString(1, e.geteID());
              ps.setString(2, e.getClass_cID());
              ps.setString(3,e.getEname());
              ps.setString(4, e.getInstruction());
              ps.setLong(5,e.getIsDelete());
              ps.setString(6, e.getFamily_fID());
              ps.setString(7, e.getManufacturer_mID());
           
              
              int f = ps.executeUpdate();
                  if(f > 0)
                  {
                	  JOptionPane.showMessageDialog(null, "Insert successfully!");
                  }
                  else JOptionPane.showMessageDialog(null, "Insert failed");
                  ps.close();
                  conn.close();
    		 }
    	catch(SQLException er)
    	{
    		  JOptionPane.showMessageDialog(null, "failed,Foreign key must exist");
    		  er.printStackTrace();
    	}
    }
	
	public static void delete(String eid)
    {
    	try {
    		      Connection conn = Connector.getConn();
    		      
    		      PreparedStatement pss = conn.prepareStatement("SELECT eID,isDelete from `equipment` where eID ='"+ eid +"'");
 	    		 ResultSet rss = pss.executeQuery();
 	    		 if(!rss.next()){
 	    			 pss.close();
	        	         conn.close();
	        			 JOptionPane.showMessageDialog(null, "failed,the equipment you want to delete doesn't exist ");
	        			 return;
 	    		 }
 	    		 
 	    		if(rss.getLong(2)==1){
 	    				 
 	    			pss.close();
 	        	    conn.close();
 	        		JOptionPane.showMessageDialog(null, "failed,the equipment you want to delete doesn't exist ");
 	        		return;
 	    		}
    		      PreparedStatement ps = conn.prepareStatement("update `equipment` set isDelete = 1 where eID = ?");
    		      ps.setString(1, eid);
    		      int f = ps.executeUpdate();
    		      if(f > 0)
    		      {
    		    	  JOptionPane.showMessageDialog(null, "Delete successfully!");
                  }
                  else JOptionPane.showMessageDialog(null, "Delete failed");
    		      ps.close();
    		      conn.close();
    	}
    	catch(Exception e)
    	{
    		JOptionPane.showMessageDialog(null, "Connected failed!");
    	}
    }
	public static void modifyins(String eid,String instruction)
    {
    	try {
    		      Connection conn = Connector.getConn();
    		      
    		      PreparedStatement pss = conn.prepareStatement("SELECT eID,isDelete from `equipment` where eID ='"+ eid +"'");
  	    		 ResultSet rss = pss.executeQuery();
  	    		 if(!rss.next()){
  	    			 pss.close();
 	        	         conn.close();
 	        			 JOptionPane.showMessageDialog(null, "failed,the equipment you want to modify doesn't exist ");
 	        			 return;
  	    		 }
    		      PreparedStatement ps = conn.prepareStatement("update `equipment` set instruction = '"+ instruction+" ' where eID = ?");
    		      ps.setString(1, eid);
    		      int f = ps.executeUpdate();
    		      if(f > 0)
    		      {
    		    	  JOptionPane.showMessageDialog(null, "modify successfully!");
                  }
                  else JOptionPane.showMessageDialog(null, "modify failed");
    		      ps.close();
    		      conn.close();
    	}
    	catch(Exception e)
    	{
    		JOptionPane.showMessageDialog(null, "Connected failed!");
    	}
    }
	public static String[][] fIDinquery(String fid){
		String[][] data = new String[100][10];
    	int i =0;
		try {	
			Connection conn = Connector.getConn();
			
				PreparedStatement psss = conn.prepareStatement("SELECT eID from `equipment`,`class` where class_cID = cID and equipment.isDelete=0 and class.isDelete=0 and family_fID ='"+ fid +"'");
	    		 ResultSet rsss = psss.executeQuery();
	    		 if(!rsss.next()){
	    			 psss.close();
        	         conn.close();
        			 JOptionPane.showMessageDialog(null, "failed,the equipment you want to inquery doesn't exist ");
        			 return null;
	    		 }
    		PreparedStatement ps = conn.prepareStatement("SELECT eID,class_cID,cName,ename,instruction,family_fID,manufacturer_mID from `equipment`,`class` where class_cID = cID and equipment.isDelete=0 and class.isDelete=0 and family_fID ='"+ fid +"'");
    		ResultSet rs = ps.executeQuery();
    		PreparedStatement pss = conn.prepareStatement("SELECT isDelete from `equipment`");
        	ResultSet rss = pss.executeQuery();
        	
        	while(rs.next() && rs.getRow() > 0)
        	{
        		rss.next();rss.getRow();
        		//Vector row = new Vector();
        		for(int col = 1; col <= rs.getMetaData().getColumnCount();col++)
        		{
        			if(rss.getLong(1)==1){
        				i--;
        				break;
        			}
        			
        			data[i][col-1] = rs.getString(col);
        			
        		}
        		i++;
        			//v.add(row);
        	}
    	}catch(Exception e){
    		JOptionPane.showMessageDialog(null, "fIDinquire failed");
    		e.printStackTrace();
    		return null;
    	}
		return data;
	}
	public static String[][] mIDinquery(String mid){
		String[][] data = new String[100][10];
    	int i =0;
		try {	
			Connection conn = Connector.getConn();
			
			PreparedStatement psss = conn.prepareStatement("SELECT eID from `equipment`,`class`,`manufacturer` where class_cID = cID and manufacturer_mID = mID and equipment.isDelete=0 and class.isDelete=0 and manufacturer.isDelete=0 and mID ='"+ mid +"'");
   		 ResultSet rsss = psss.executeQuery();
   		 if(!rsss.next()){
   			 psss.close();
   	         conn.close();
   			 JOptionPane.showMessageDialog(null, "failed,the equipment you want to inquery doesn't exist ");
   			 return null;
   		 }
    		PreparedStatement ps = conn.prepareStatement("SELECT eID,class_cID,cName,ename,instruction,family_fID,manufacturer_mID,mname from `equipment`,`class`,`manufacturer` where class_cID = cID and manufacturer_mID = mID and equipment.isDelete=0 and class.isDelete=0 and manufacturer.isDelete=0 and manufacturer_mID ='"+ mid +"'");
    		ResultSet rs = ps.executeQuery();
    		PreparedStatement pss = conn.prepareStatement("SELECT isDelete from `equipment`");
        	ResultSet rss = pss.executeQuery();
        	
        	while(rs.next() && rs.getRow() > 0)
        	{
        		rss.next();rss.getRow();
        		//Vector row = new Vector();
        		for(int col = 1; col <= rs.getMetaData().getColumnCount();col++)
        		{
        			if(rss.getLong(1)==1){
        				i--;
        				break;
        			}
        			
        			data[i][col-1] = rs.getString(col);
        			
        		}
        		i++;
        			//v.add(row);
        	}
    	}catch(Exception e){
    		JOptionPane.showMessageDialog(null, "Query1 failed");
    		e.printStackTrace();
    		return null;
    	}
		return data;
	}
	
	public static String[][] cIDinquery(String cid){
		String[][] data = new String[100][10];
    	int i =0;
		try {	
			Connection conn = Connector.getConn();
			
			PreparedStatement psss = conn.prepareStatement("SELECT eID from `equipment`,`class` where class_cID = cID and equipment.isDelete=0 and class.isDelete=0  and cID ='"+ cid +"'");
	   		 ResultSet rsss = psss.executeQuery();
	   		 if(!rsss.next()){
	   			 psss.close();
	   	         conn.close();
	   			 JOptionPane.showMessageDialog(null, "failed,the equipment you want to inquery doesn't exist ");
	   			 return null;
	   		 }
    		PreparedStatement ps = conn.prepareStatement("SELECT eID,class_cID,cName,ename,instruction,family_fID,manufacturer_mID from `equipment`,`class` where class_cID = cID and equipment.isDelete=0 and class.isDelete=0  and cID ='"+ cid +"'");
    		ResultSet rs = ps.executeQuery();
    		PreparedStatement pss = conn.prepareStatement("SELECT isDelete from `equipment`");
        	ResultSet rss = pss.executeQuery();
        	
        	while(rs.next() && rs.getRow() > 0)
        	{
        		rss.next();rss.getRow();
        		//Vector row = new Vector();
        		for(int col = 1; col <= rs.getMetaData().getColumnCount();col++)
        		{
        			if(rss.getLong(1)==1){
        				i--;
        				break;
        			}
        			
        			data[i][col-1] = rs.getString(col);
        			
        		}
        		i++;
        			//v.add(row);
        	}
    	}catch(Exception e){
    		JOptionPane.showMessageDialog(null, "Query1 failed");
    		e.printStackTrace();
    		return null;
    	}
		return data;
	}
	

}
