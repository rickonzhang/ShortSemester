package Mini_term;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Goldenkey {
	public static String[][] Get(String table){
		String[][] data = new String[1000][10];
		Connection conn = Connector.getConn();
		int i = 0;
		switch(table){
		case "administrator":
			try {	
	            	PreparedStatement ps = conn.prepareStatement("SELECT aID,pwd from `administrator` where isDelete=0");
	            	
	            	ResultSet rs = ps.executeQuery();
	            	PreparedStatement pss = conn.prepareStatement("SELECT isDelete from `administrator`");
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
	            	
	            }catch(Exception e)
	            {
	            	JOptionPane.showMessageDialog(null, "Query1 failed");
	            	e.printStackTrace();
	            	return null;
	            }break;
		case "user":
			try {	
            		PreparedStatement ps = conn.prepareStatement("SELECT uID,uName,pwd,gender,phone,email,family_fID from `user` where isDelete=0");
            		ResultSet rs = ps.executeQuery();
            		PreparedStatement pss = conn.prepareStatement("SELECT isDelete from `user`");
	            	ResultSet rss = pss.executeQuery();
	            	
	            	while(rs.next() && rs.getRow() > 0)
	            	{
	            		rss.next();rss.getRow();
	            		//System.out.println("11111");
	            		//Vector row = new Vector();
	            		for(int col = 1; col <= rs.getMetaData().getColumnCount();col++)
	            		{
	            			if(rss.getLong(1)==1){
	            				i--;
	            				break;
	            			}
	            			
	            			data[i][col-1] = rs.getString(col);
	            			//System.out.println(data[i][col-1]);
	            		}
	            		i++;
	            			//v.add(row);
	            	}
            	}catch(Exception e){
            		JOptionPane.showMessageDialog(null, "Query1 failed");
            		e.printStackTrace();
            		return null;
            	}break;
		case "family":
			try {	
            		PreparedStatement ps = conn.prepareStatement("SELECT fID,fName,address from `family` where isDelete=0");
            		ResultSet rs = ps.executeQuery();
            		PreparedStatement pss = conn.prepareStatement("SELECT isDelete from `family`");
	            	ResultSet rss = pss.executeQuery();
	            	
	            	while(rs.next() && rs.getRow() > 0)
	            	{
	            		rss.next();rss.getRow();
	            		//Vector row = new Vector();
	            		for(int col = 1; col <= rs.getMetaData().getColumnCount();col++)
	            		{
	      
	            			data[i][col-1] = rs.getString(col);
	            			
	            		}
	            		i++;
	            			//v.add(row);
	            	}
            	}catch(Exception e){
            		JOptionPane.showMessageDialog(null, "Query1 failed");
            		e.printStackTrace();
            		return null;
            	}break;
	    
	case "equipment":
		try {	
        		PreparedStatement ps = conn.prepareStatement("SELECT eID,class_cID,cName,ename,instruction,family_fID,manufacturer_mID from `equipment`,`class` where class_cID = cID and (equipment.isDelete=0 or class.isDelete=0) and equipment.isDelete=0");
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
        	}break;
	case "class":
		try {	
        		PreparedStatement ps = conn.prepareStatement("SELECT cID,cName from `class` where isDelete=0");
        		ResultSet rs = ps.executeQuery();
        		PreparedStatement pss = conn.prepareStatement("SELECT isDelete from `class`");
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
        	}break;
	case "manufacturer":
		try {	
        		PreparedStatement ps = conn.prepareStatement("SELECT mID,pwd,mName from `manufacturer` where isDelete=0");
        		ResultSet rs = ps.executeQuery();
        		PreparedStatement pss = conn.prepareStatement("SELECT isDelete from `manufacturer`");
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
        	}break;
	case "data":
		try {	
        		PreparedStatement ps = conn.prepareStatement("SELECT * from `data` ");
        		ResultSet rs = ps.executeQuery();
        		while(rs.next() && rs.getRow() > 0)
        		{
        		
        		//Vector row = new Vector();
        			for(int col = 1; col <= rs.getMetaData().getColumnCount();col++)
        			{
        				data[i][col-1] = rs.getString(col);
        				
        			}
        			i++;
        			//v.add(row);
        		} 
        	
        	}catch(Exception e){
        		JOptionPane.showMessageDialog(null, "Query1 failed");
        		e.printStackTrace();
        		return null;
        	}break;
		}
		return data;
	}
	
	public static String[][] manufGet(String mID){
		String[][] data = new String[100][10];
		Connection conn = Connector.getConn();
		int i = 0;
		
		try {	
    		PreparedStatement ps = conn.prepareStatement("SELECT eID,class_cID,cName,ename,instruction,family_fID,manufacturer_mID from `equipment`,`class` where class_cID = cID and equipment.isDelete = 0 and class.isDelete = 0 and manufacturer_mID = '"+ mID +"'");
    		ResultSet rs = ps.executeQuery();
    		PreparedStatement pss = conn.prepareStatement("SELECT isDelete from `equipment`");
        	ResultSet rss = pss.executeQuery();
        	
        	while(rs.next() && rs.getRow() > 0)
        	{
        		
        		for(int col = 1; col <= rs.getMetaData().getColumnCount();col++)
        		{
        			
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
		
	public static int judgement(String[] a){
		int i = 0;
		String[] id = new String[20];
		String[] pwd = new String[20];
		int[] isDelete = new int[20];
		int judge = 0; 
		
		Connection conn = Connector.getConn();
		switch(a[2]){
		case "user":
			
			try {
				PreparedStatement ps = conn.prepareStatement("SELECT uID,pwd,isDelete from `user`");
				ResultSet rs = ps.executeQuery();
				
				while(rs.next() && rs.getRow() > 0)
				{


			//Vector row = new Vector();
					id[i] = rs.getString(1);
					pwd[i] = rs.getString(2);
					
					if(rs.getInt(3)==0){
						if(id[i].equals(a[0]))
							judge++;
						if(MD5.encode(a[1]).equals(pwd[i]))
							judge++;
						if(judge==2)
							return 1;
						//Vector row = new Vector();
					}
					judge = 0;
					i++;	//v.add(row);
				}
			}catch(Exception e){
    		JOptionPane.showMessageDialog(null, "Query1 failed");
    		e.printStackTrace();
    		return 0;
			}break;
		
		case "administrator":
			try {
					PreparedStatement ps = conn.prepareStatement("SELECT aID,pwd,isDelete from `administrator`");
					ResultSet rs = ps.executeQuery();
					while(rs.next() && rs.getRow() > 0)
					{
					
						id[i] = rs.getString(1);
						pwd[i] = rs.getString(2);
						if(rs.getInt(3)==0){
						if(id[i].equals(a[0]))
							judge++;
						System.out.println(judge);
						if(MD5.encode(a[1]).equals(pwd[i]))
							judge++;
						System.out.println(pwd[i]);
						System.out.println(a[1]);
						System.out.println(MD5.encode(a[1]));
						if(judge==2)
							return 1;
						//Vector row = new Vector();
						}	
						i++;
						judge = 0;//v.add(row);
					}
				}
				catch(Exception e){
	    		JOptionPane.showMessageDialog(null, "Query1 failed");
	    		e.printStackTrace();
	    		return 0;
				}break;
		case "manufacturer":
			try {
				PreparedStatement ps = conn.prepareStatement("SELECT mID,pwd,isDelete from `manufacturer`");
				ResultSet rs = ps.executeQuery();
				while(rs.next() && rs.getRow() > 0)
				{
				
			//Vector row = new Vector();
					id[i] = rs.getString(1);
					pwd[i] = rs.getString(2);
					if(rs.getInt(3)==0){
						if(id[i].equals(a[0]))
							judge++;
						if(MD5.encode(a[1]).equals(pwd[i]))
							judge++;
						if(judge==2)
							return 1;
						//Vector row = new Vector();
					}
					i++;
					judge = 0;//v.add(row);
				}
			}catch(Exception e){
    		JOptionPane.showMessageDialog(null, "Query1 failed");
    		e.printStackTrace();
    		return 0;
			}break;
			
		}
		if(judge==2)
		return 1;
		else
		return 0;					
	}
	
	public static String eidtocname(String eID){
		
		try {	
			String cname = null;
			Connection conn = Connector.getConn();
			
    		PreparedStatement ps = conn.prepareStatement("SELECT cName from `class`,`equipment` where cID = class_cID and eID = '"+ eID +"'");
    		ResultSet rs = ps.executeQuery();
    		
        
        	while(rs.next() && rs.getRow() > 0){
        		cname = rs.getString(1);
        		System.out.println(cname);
        	}
        	
        	return cname;
    	}catch(Exception e){
    		JOptionPane.showMessageDialog(null, "Query1 failed");
    		e.printStackTrace();
    		return null;
    	}
		
	}
	
	public static int[] converttoInt(String str){
		int i=0;
		int[] a = new int[500]; 
		int j=0;
		int stop=1;
		str=str.trim();
		String str2="";
		if(str != null && !"".equals(str)){
			for(i=0;i<str.length();i++){
				if(str.charAt(i)>=48 && str.charAt(i)<=57){
					str2+=str.charAt(i);
					//System.out.println(str2);
				}else
				{   if(!str2.equals(""))
					stop = 0;
				}
				if(i==str.length()-1)
					stop = 0;
				//System.out.println(stop);
			    if(stop==0&&!str2.equals("")){
			    	a[j] = Integer.parseInt(str2);;
			    	j++;
			    	stop = 1;
			    	//System.out.println(j);
			    	str2 = new String();
			    }
			} 
		}
		int[] last = new int[j+1];
		for(int x = 0;x<j+1;x++)
		last[x]=a[x];
		return last;
	}
	
	public static String[] converttoString(String str){
		String[] a = new String[100]; 
		int j=0;
		
		str=str.trim();
		String str2="";
		if(str != null && !"".equals(str)){
			for(int i=0;i<str.length();i++){
				if(str.charAt(i)!=','){
					str2+=str.charAt(i);
				}
				
					//System.out.println(str2);
				if(i==str.length()-1)
					a[j] = str2;
				//System.out.println(stop);
			    if(str.charAt(i)==','){
			    	a[j] = str2;
			    	j++;
			    	
			    	//System.out.println(j);
			    	str2 = new String();
			    }
			    
			} 
		}
		//for(int i=0;i<5;i++)
		//System.out.println(a[i]);
		String[] last = new String[j+1];
		for(int x = 0;x<j+1;x++)
		last[x]=a[x];
		return last;
		
	}
	
	
	public static String[][] vectortoString(Vector<Vector<Object>> a){
		String[][] string = new String[1000][10];
		int i=0,j=0;
		for (i = 0; i < a.size(); i++) {
			for(j=0;a.get(i).size() > j;j++){
				
				string[i][j] = (String) a.get(i).get(j);   
			}	
        }
		return string;
	}
	
	
/*
	public static void main(String[] args){
		for (int i = 0; i < 10; i++) {
			for(int j=0;j<10;j++){
				
			System.out.print(Goldenkey.Get("family")[i][j])  ;
			}	
			System.out.println();
    	}
	//Goldenkey.Get("family");
	}*/

}
