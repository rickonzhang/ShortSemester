package Mini_term;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Familymanage {
	public static void insert(Family f) {
    	try {
    		 Connection conn = Connector.getConn();
    		 
    		 PreparedStatement pss = conn.prepareStatement("SELECT fID,isDelete from `family` where fID ='"+ f.getfID() +"'");
    		 ResultSet rss = pss.executeQuery();
    		 if(rss.next()){
    			 if(rss.getLong(2)==0){
    				 
    				 pss.close();
        	         conn.close();
        			 JOptionPane.showMessageDialog(null, "failed,The ID you have entered has existed");
        			 return;
    			 }else{
    				 PreparedStatement ps = conn.prepareStatement("update `family` set fname='"+ f.getFname() +"',address='"+ f.getAddress() +"',isDelete = 0 where fID = '"+ f.getfID() +"'");
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
    		 PreparedStatement ps = conn.prepareStatement("INSERT into `family`(fID,fname,address,isDelete)values(?,?,?,?)");
    		 if(f.getfID().equals("") || f.getFname().equals("") ||f.getAddress().equals("")){
    			 ps.close();
    	         conn.close();
    			 JOptionPane.showMessageDialog(null, "failed,The information you have entered is incomplete");
    			 return;
    		 }
    		
              ps.setString(1, f.getfID());
              ps.setString(2, f.getFname());
              ps.setString(3, f.getAddress());
              ps.setLong(4,f.getIsDelete());
              
           
              
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
	
	public static void delete(String fid)
    {
    	try {
    		      Connection conn = Connector.getConn();
    		      
    		      PreparedStatement pss = conn.prepareStatement("SELECT fID,isDelete from `family` where fID ='"+ fid +"'");
  	    		 ResultSet rss = pss.executeQuery();
  	    		 if(!rss.next()){
  	    			 pss.close();
 	        	         conn.close();
 	        			 JOptionPane.showMessageDialog(null, "failed,the family you want to delete doesn't exist ");
 	        			 return;
  	    		 }
  	    		 
  	    		if(rss.getLong(2)==1){
  	    				 
  	    			pss.close();
  	        	    conn.close();
  	        		JOptionPane.showMessageDialog(null, "failed,the family you want to delete doesn't exist ");
  	        		return;
  	    		}
    		      PreparedStatement ps = conn.prepareStatement("update `family` set isDelete = 1 where fID = ?");
    		      ps.setString(1, fid);
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
	
	
	public static void modify(Family f) {
    	try {
    		 
    		 Connection conn = Connector.getConn();
    		 
    		 PreparedStatement pss = conn.prepareStatement("SELECT fID,isDelete from `family` where fID ='"+ f.getfID() +"'");
    		 ResultSet rss = pss.executeQuery();
    		
    		 if(rss.next()){
    			 if(rss.getLong(2)==1){
    				 
    				 pss.close();
        	         conn.close();
        			 JOptionPane.showMessageDialog(null, "failed,The ID you have entered don't existed");
        			 return;
    			 }
    		 }else{
    			 pss.close();
    	         conn.close();
    			 JOptionPane.showMessageDialog(null, "failed,The ID you have entered don't existed");
    			 return;
    		 }
    		 
    		 PreparedStatement ps = conn.prepareStatement("update `family` set fname='"+ f.getFname()+"',address='"+ f.getAddress()+"'where fID ='"+ f.getfID() +"'");
    		
    		 if(f.getfID().equals("") || f.getFname().equals("") || f.getAddress().equals("")){
    			 ps.close();
    	         conn.close();
    			 JOptionPane.showMessageDialog(null, "failed,The information you have entered is incomplete");
    			 return;
    		 }
    		 
              int as = ps.executeUpdate();
              System.out.println("iiii");
                  if(as > 0)
                  {
                	  JOptionPane.showMessageDialog(null, "modify successfully!");
                  }
                  else JOptionPane.showMessageDialog(null, "modify failed");
                  ps.close();
                  conn.close();
    		 }
    	catch(SQLException e)
    	{
    		  JOptionPane.showMessageDialog(null, "failed!");
    		  e.printStackTrace();
    	}
    }
	 public static void main(String args[]){
		 Family f = new Family();
		 f.setAddress("sadas");
		 f.setfID("f1");
		 f.setFname("sadasdassa");
		 Familymanage.modify(f);
     	/*String[] a = new String[3];
     	a[0] = "a1";
     	a[1] = "123";
     	a[2] = "administrator";
     	System.out.println(Goldenkey.judgement(a));
     	System.out.println(MD5.encode(a[1]));
     	System.out.println(MD5.encode("123"));*/
     	/*for(int i=0;i<10;i++)
     	System.out.println(Goldenkey.Get("user")[0][i]);*/
     	//System.out.println(MD5.encode("123"));
     }  

}
