package Mini_term;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;



public class Usersmanage {
	 
				/**
				 * ����Ա��user�Ĳ��룬���뱣֤user�Ķ�����ӵ�е�9�����Զ��Ƿǿյģ��������Ҫ��family�е�������Ӧ��
				 * @param u
				 */
                public static void insert(User u) {
                	try {
                		  
                		 Connection conn = Connector.getConn();
                		 
                		 PreparedStatement pss = conn.prepareStatement("SELECT uID,isDelete from `user` where uID ='"+ u.getuID() +"'");
                		 ResultSet rss = pss.executeQuery();
                		 if(rss.next()){
                			 if(rss.getLong(2)==0){
                				 
                				 pss.close();
                    	         conn.close();
                    			 JOptionPane.showMessageDialog(null, "failed,The ID you have entered has existed");
                    			 return;
                			 }else{
                				 PreparedStatement ps = conn.prepareStatement("update `user` set uname='"+ u.getuName() +"',email='"+ u.getEmail() +"',phone='"+ u.getPhone() +"',gender='"+ u.getGender() +"',pwd='"+ MD5.encode(u.getPwd()) +"',isDelete = 0 where uID = '"+ u.getuID() +"'");
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
                		 PreparedStatement ps = conn.prepareStatement("INSERT into `user`(uID,uName,pwd,gender,phone,email,isDelete,family_fID)values(?,?,?,?,?,?,?,?)");
                		
                		 if(u.getuID().equals("") || u.getuName().equals("") ||u.getPwd().equals("") ||u.getEmail().equals("") ||u.getPhone().equals("") ||u.getGender().equals("") ||u.getFamily_fID().equals("") ){
                			 ps.close();
                	         conn.close();
                			 JOptionPane.showMessageDialog(null, "failed,The information you have entered is incomplete");
                			 return;
                		 }
                		 
                		 ps.setString(1, u.getuID());
                          ps.setString(2, u.getuName());
                          ps.setString(3,MD5.encode(u.getPwd()));
                          ps.setString(4, u.getEmail());
                          ps.setString(5,u.getPhone());
                          ps.setString(6, u.getGender());
                          ps.setLong(7, u.getIsDelete());
                          ps.setString(8, u.getFamily_fID());
                          
                          int f = ps.executeUpdate();
                              if(f > 0)
                              {
                            	  JOptionPane.showMessageDialog(null, "Insert successfully!");
                              }
                              else JOptionPane.showMessageDialog(null, "Insert failed");
                              ps.close();
                              conn.close();
                		 }
                	catch(SQLException e)
                	{
                		  JOptionPane.showMessageDialog(null, "failed,Foreign key must exist");
                		  e.printStackTrace();
                	}
                }
                
                public static void modify(User u) {
                	try {
                		 
                		 Connection conn = Connector.getConn();
                		 
                		 PreparedStatement pss = conn.prepareStatement("SELECT uID,isDelete from `user` where uID ='"+ u.getuID() +"'");
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
                		 
                		 PreparedStatement ps = conn.prepareStatement("update `user` set uname='"+ u.getuName() +"',email='"+ u.getEmail() +"',phone='"+ u.getPhone() +"',gender='"+ u.getGender() +"',family_fID='"+ u.getFamily_fID() +"' where uID ='"+ u.getuID() + "'");
                		
                		 if(u.getuID().equals("") || u.getuName().equals("") ||u.getEmail().equals("") ||u.getPhone().equals("") ||u.getGender().equals("") ||u.getFamily_fID().equals("") ){
                			 ps.close();
                	         conn.close();
                			 JOptionPane.showMessageDialog(null, "failed,The information you have entered is incomplete");
                			 return;
                		 }
                          
                          int f = ps.executeUpdate();
                              if(f > 0)
                              {
                            	  JOptionPane.showMessageDialog(null, "update successfully!");
                              }
                              else JOptionPane.showMessageDialog(null, "update failed");
                              ps.close();
                              conn.close();
                		 }
                	catch(SQLException e)
                	{
                		  JOptionPane.showMessageDialog(null, "failed!");
                		  e.printStackTrace();
                	}
                }
                
                
                public static void delete(String uid)
                {
                	try {
                		      Connection conn = Connector.getConn();
                		      
                		      PreparedStatement pss = conn.prepareStatement("SELECT uID,isDelete from `user` where uID ='"+ uid +"'");
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
                		      PreparedStatement ps = conn.prepareStatement("update `user` set isDelete = 1 where uID = ?");
                		      ps.setString(1, uid);
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
               
                
                /**
                 * ���ֻ�Ƕ������������
                 * @param uid
                 */
               
                public static void reset(String uid)
                {
                	try {
                		      // System.out.println(password(uid));
                		        Connection conn = Connector.getConn();
                		        String a = Rand.password();
                		        
                		        PreparedStatement pss = conn.prepareStatement("SELECT uID,isDelete from `user` where uID ='"+ uid +"'");
               	    		 ResultSet rss = pss.executeQuery();
               	    		 if(!rss.next()){
               	    			 pss.close();
              	        	         conn.close();
              	        			 JOptionPane.showMessageDialog(null, "failed,the user you want to reset doesn't exist ");
              	        			 return;
               	    		 }
                		       System.out.println("111111");
                		        PreparedStatement ps = conn.prepareStatement("update `user` set pwd = '"+ MD5.encode(a) +"'where uID = ?");
                		        ps.setString(1, uid );
                		        int f = ps.executeUpdate();
                		        if(f > 0)
                  		      {
                  		    	  JOptionPane.showMessageDialog(null, "Reset successfully!The reset password is" + a );
                                }
                                else JOptionPane.showMessageDialog(null, "Reset failed");
                  		      ps.close();
                  		      conn.close();
                	}
                	catch(Exception e)
                	{
                		  JOptionPane.showMessageDialog(null, "Connected failed!" );
                		  e.printStackTrace();
                	}
                }
                
                
                public static String[][] idQuery (String uID)
                {
                	String[][] data = new String[100][10];
                	int i =0;
                	try {	
                		
                		Connection conn = Connector.getConn();
                		 PreparedStatement psss = conn.prepareStatement("SELECT uID,isDelete from `user` where uID ='"+ uID +"'");
           	    		 ResultSet rsss = psss.executeQuery();
           	    		 if(!rsss.next()){
           	    			 psss.close();
          	        	         conn.close();
          	        			 JOptionPane.showMessageDialog(null, "failed,the user you want to query doesn't exist ");
          	        			 return null;
           	    		 }
                		
                		PreparedStatement ps = conn.prepareStatement("SELECT uID,uName,pwd,gender,phone,email,family_fID from `user` where isDelete=0 and uID ='"+ uID +"'");
                		ResultSet rs = ps.executeQuery();
                		PreparedStatement pss = conn.prepareStatement("SELECT isDelete from `user`");
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
                
                
                public static String[][] genderQuery (String gender)
                {
                	String[][] data = new String[100][10];
                	int i =0;
                	try {	
                		
                		Connection conn = Connector.getConn();
                		
                		PreparedStatement ps = conn.prepareStatement("SELECT uID,uName,pwd,gender,phone,email,family_fID from `user` where isDelete=0 and gender ='"+ gender +"'");
                		ResultSet rs = ps.executeQuery();
                		PreparedStatement pss = conn.prepareStatement("SELECT isDelete from `user`");
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
                
                public static String[][] familyinQuery (String fID)
                {
                	String[][] data = new String[500][10];
                	int i =0;
                	try {	
                		
                		Connection conn = Connector.getConn();
                		
                		 PreparedStatement psss = conn.prepareStatement("SELECT fID,isDelete from `family` where fID ='"+ fID +"'");
           	    		 ResultSet rsss = psss.executeQuery();
           	    		 if(!rsss.next()){
           	    			 psss.close();
          	        	         conn.close();
          	        			 JOptionPane.showMessageDialog(null, "failed,the user you want to query doesn't exist ");
          	        			 return null;
           	    		 }
           	    		 
                		PreparedStatement ps = conn.prepareStatement("SELECT uID,uName,pwd,gender,phone,email,family_fID from `user` where isDelete=0  and family_fID ='"+ fID +"'");
                		ResultSet rs = ps.executeQuery();
                		
    	            	
    	            	while(rs.next() && rs.getRow() > 0)
    	            	{
    	            		
    	            		//System.out.println("11111");
    	            		//Vector row = new Vector();
    	            		for(int col = 1; col <= rs.getMetaData().getColumnCount();col++)
    	            		{
    	         
    	            			data[i][col-1] = rs.getString(col);
    	            			
    	            		}
    	            		i++;
    	            			//v.add(row);
    	            	}
                	}catch(Exception e){
                		JOptionPane.showMessageDialog(null, "familyQuery failed");
                		e.printStackTrace();
                		return null;
                	}
                	return data;
                }
                
                public static String[] singleQuery (String uID)
                {
                	String[] data = new String[10];
                	int i =0;
                	try {	
                		
                		Connection conn = Connector.getConn();
                		
                		 PreparedStatement psss = conn.prepareStatement("SELECT uID,isDelete from `user` where uID ='"+ uID +"'");
           	    		 ResultSet rsss = psss.executeQuery();
           	    		 if(!rsss.next()){
           	    			 psss.close();
          	        	         conn.close();
          	        			 JOptionPane.showMessageDialog(null, "failed,the user you want to query doesn't exist ");
          	        			 return null;
           	    		 }
           	    		 
                		PreparedStatement ps = conn.prepareStatement("SELECT uID,uName,pwd,gender,phone,email,family_fID from `user`,`family` where user.isDelete=0 and family.isDelete=0 and uID ='"+ uID +"'");
                		ResultSet rs = ps.executeQuery();
                		PreparedStatement pss = conn.prepareStatement("SELECT isDelete from `user`");
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
    	            			
    	            			data[col-1] = rs.getString(col);
    	            			
    	            		}
    	            		i++;
    	            			//v.add(row);
    	            	}
                	}catch(Exception e){
                		JOptionPane.showMessageDialog(null, "familyQuery failed");
                		e.printStackTrace();
                		return null;
                	}
                	return data;
                }
               /* public static void main(String args[]){
                	User u = new User();
                	u.setEmail("sdas");
                	u.setFamily_fID("f1");
                	u.setGender("sadas");
                	
                	u.setPhone("asd");
                	u.setPwd("asd");
                	u.setuID("u10000");
                	u.setuName("asd");
                	Usersmanage.modify(u);
                	//Usersmanage.reset("u1");
   
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
               // }     /
                

}

