package Mini_term;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class eClassmanage {
	public static void insert(eClass c) {
    	try {
    		 Connection conn = Connector.getConn();
    		 
    		 PreparedStatement pss = conn.prepareStatement("SELECT cID,isDelete from `class` where cID ='"+ c.getcID() +"'");
    		 ResultSet rss = pss.executeQuery();
    		 if(rss.next()){
    			 if(rss.getLong(2)==0){
    				 
    				 pss.close();
        	         conn.close();
        			 JOptionPane.showMessageDialog(null, "failed,The ID you have entered has existed");
        			 return;
    			 }else{
    				 PreparedStatement ps = conn.prepareStatement("update `class` set cname='"+ c.getCname() +"',isDelete = 0 where cID = '"+ c.getcID() +"'");
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
    		 
    		 PreparedStatement ps = conn.prepareStatement("INSERT into `class`(cID,cname,isDelete)values(?,?,?)");
    		 
    		 if(c.getcID().equals("") || c.getCname().equals("")){
    			 ps.close();
    	         conn.close();
    			 JOptionPane.showMessageDialog(null, "failed,The information you have entered is incomplete");
    			 return;
    		 } 
    		 
    		 ps.setString(1, c.getcID());
              ps.setString(2, c.getCname());
              ps.setLong(3,c.getIsDelete());
              
              int i = ps.executeUpdate();
                  if(i > 0)
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
	
	public static void delete(String cid)
    {
    	try {
    		      Connection conn = Connector.getConn();
    		      
    		      PreparedStatement pss = conn.prepareStatement("SELECT cID,isDelete from `class` where cID ='"+ cid +"'");
    	    		 ResultSet rss = pss.executeQuery();
    	    		 if(!rss.next()){
    	    			 pss.close();
	        	         conn.close();
	        			 JOptionPane.showMessageDialog(null, "failed,the user you want to delete doesn't exist ");
	        			 return;
    	    		 }
    	    		 
    	    		if(rss.getLong(2)==1){
    	    				 
    	    			pss.close();
    	        	    conn.close();
    	        		JOptionPane.showMessageDialog(null, "failed,the user you want to delete doesn't exist ");
    	        		return;
    	    		}
    	    
    	    		 
    		      
    		      PreparedStatement ps = conn.prepareStatement("update `class` set isDelete = 1 where cID = ?");
    		      ps.setString(1, cid);
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
	public static void modifyins(String cid,String cname)
    {
    	try {
    		      Connection conn = Connector.getConn();
    		      PreparedStatement pss = conn.prepareStatement("SELECT cID,isDelete from `class` where cID ='"+ cid +"'");
 	    		 ResultSet rss = pss.executeQuery();
 	    		 if(!rss.next()){
 	    			 pss.close();
	        	         conn.close();
	        			 JOptionPane.showMessageDialog(null, "failed,the user you want to modify doesn't exist ");
	        			 return;
 	    		 }
    		      PreparedStatement ps = conn.prepareStatement("update `class` set cname = '"+ cname+" ' where cID = ?");
    		      ps.setString(1, cid);
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
	
	
	

}
