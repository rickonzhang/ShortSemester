package Mini_term;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Manufmanage {
	public static void insert(Manuf m) {
    	try {
    		 Connection conn = Connector.getConn();
    		 
    		 PreparedStatement pss = conn.prepareStatement("SELECT mID,isDelete from `manufacturer` where mID ='"+ m.getmID() +"'");
    		 ResultSet rss = pss.executeQuery();
    		 if(rss.next()){
    			 if(rss.getLong(2)==0){
    				 
    				 pss.close();
        	         conn.close();
        			 JOptionPane.showMessageDialog(null, "failed,The ID you have entered has existed");
        			 return;
    			 }else{
    				 PreparedStatement ps = conn.prepareStatement("update `manufacturer` set mname='"+ m.getMname() +"',pwd ='"+ MD5.encode(m.getPwd()) +"',isDelete = 0 where mID = '"+ m.getmID() +"'");
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
    		PreparedStatement ps = conn.prepareStatement("INSERT into `manufacturer`(mID,pwd,mname,isDelete)values(?,?,?,?)");
    		 
    		if(m.getmID().equals("") || m.getPwd().equals("") ||m.getMname().equals("") ){
    			 ps.close();
    	         conn.close();
    			 JOptionPane.showMessageDialog(null, "failed,The information you have entered is incomplete");
    			 return;
    		 }
    		
    		 ps.setString(1, m.getmID());
              ps.setString(2, MD5.encode(m.getPwd()));
              ps.setString(3, m.getMname());
              ps.setLong(4,m.getIsDelete());
              
           
              
              int i = ps.executeUpdate();
                  if(i > 0)
                  {
                	  JOptionPane.showMessageDialog(null, "Insert successfully!");
                  }
                  else JOptionPane.showMessageDialog(null, "Insert failed");
                  ps.close();
                  conn.close();
    		 }catch(SQLException er)
    	{
    		  JOptionPane.showMessageDialog(null, "failed,Foreign key must exist");
    		  er.printStackTrace();
    	}
    }
	
	public static void delete(String mid)
    {
    	try {
    		      Connection conn = Connector.getConn();
    		      
    		      PreparedStatement pss = conn.prepareStatement("SELECT mID,isDelete from `manufacturer` where mID ='"+ mid +"'");
   	    		 ResultSet rss = pss.executeQuery();
   	    		 if(!rss.next()){
   	    			 pss.close();
  	        	         conn.close();
  	        			 JOptionPane.showMessageDialog(null, "failed,the manufacturer you want to delete doesn't exist ");
  	        			 return;
   	    		 }
   	    		 
   	    		if(rss.getLong(2)==1){
   	    				 
   	    			pss.close();
   	        	    conn.close();
   	        		JOptionPane.showMessageDialog(null, "failed,the manufacturer you want to delete doesn't exist ");
   	        		return;
   	    		}
    		      PreparedStatement ps = conn.prepareStatement("update `manufacturer` set isDelete = 1 where mID = ?");
    		      ps.setString(1, mid);
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
	public static String[] inquery(String mid)
    {
    	String[] data = new String[100];
    	int i =0;
    	try {	
    		
    		Connection conn = Connector.getConn();
    		
    		 PreparedStatement psss = conn.prepareStatement("SELECT mID,isDelete from `manufacturer` where mID ='"+ mid +"'");
	    		 ResultSet rsss = psss.executeQuery();
	    		 if(!rsss.next()){
	    			 psss.close();
	        	         conn.close();
	        			 JOptionPane.showMessageDialog(null, "failed,the user you want to query doesn't exist ");
	        			 return null;
	    		 }
	    		 
    		PreparedStatement ps = conn.prepareStatement("SELECT eid from `equipment`,`manufacturer` where mid = manufacturer_mid and manufacturer.isDelete=0 and equipment.isDelete=0 and mID ='"+ mid +"'");
    		ResultSet rs = ps.executeQuery();
    		PreparedStatement pss = conn.prepareStatement("SELECT isDelete from `equipment`");
        	ResultSet rss = pss.executeQuery();
        	
        	while(rs.next() && rs.getRow() > 0)
        	{
        		rss.next();rss.getRow();
        		//Vector row = new Vector();
        		
        			
        			data[i] = rs.getString(1);
        			//System.out.println(rs.getString(col));
        		//System.out.println(i);
        		i++;
        		//for(int j = 0;j<4;j++)
                	//System.out.println(data[j]);
        			//v.add(row);
        	}
        	
    	}catch(Exception e){
    		JOptionPane.showMessageDialog(null, "inquery failed");
    		e.printStackTrace();
    		return null;
    	}
    	return data;
    }
	
	/*
	public static void main(String[] args){
		for(int i = 0;i<3;i++)
			System.out.println(Manufmanage.inquery("m1")[i]);
		
	}*/
}
