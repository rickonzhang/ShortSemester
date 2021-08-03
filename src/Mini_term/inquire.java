package Mini_term;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * 调取数据 每个方法都返回查询到的数据
 *
 */

public class inquire {
    //Vector vector = new Vector();//存储查询的结果集
    Connection conn = Connector.getConn();//连接数据库
    String sql = null;

    /**
     * 可以查询每一个单独的设备，或某一类设备、或某个家庭 的详细数据
     * 表格呈现详细数据
     * @param
     * @param ID
     * @param start
     * @param end
     * @return
     */
//a)可以查询每一个单独的设备，或某一类设备、或某个家庭 的详细数据

    //str是一个单独的设备，或某一类设备、或某个家庭  ID
    //Vector ResultSet
    //查某个环境监测 在某个时间的 折线图 设备ID下拉栏

    /**
     * a) 可以查询每一个单独的设备，或某一类设备、或某个家庭 的详细数据;
     * @param str 选择是一个单独的设备，或某一类设备、或某个家庭
     * @param ID 设备ID
     * @param start 开始时间
     * @param end 结束时间
     * @return
     */

    public static Vector inquireA1(String str, String ID,String start,String end) {
        try {
            Vector vector = new Vector();//存储查询的结果集
            Connection conn = Connector.getConn();//连接数据库
            String sql = null;
            //PreparedStatement ps1 = conn.prepareStatement("select * from data where isDelete=0 AND ? = ?");
            switch (str) {
                case "equipment":
                   sql = "select * from data where equipment_eId = '"+ID+"' and time between '"+start+"' and '"+end+"'";
                    //sql="select * from data";


                    break;
                case "type":
                    sql = "select * from data where  type = '"+ID+"' and time between '"+start+"' and '"+end+"'";
                    break;
                case "family":
                    sql = "select did,type,humidity,temperature,state,brightness,concentration,time,equipment_eid from family f,data,equipment e where f.isDelete=0 " +
                            "AND e.isDelete=0 AND fID=family_fID AND eID=equipment_eID" +
                            " AND fID='"+ID+"' and time between '"+start+"' and '"+end+"'";
                    break;
                default:
                    System.out.println("switch error");
            }

            PreparedStatement ps1 = conn.prepareStatement(sql);
            // ps1.setString(1, name);//设备表、设备类别表或家庭表
           // ps1.setString(1, ID);//对应ID
            System.out.println(sql);
            ResultSet rs = ps1.executeQuery();//存储查询数据
//if(rs.next()){
  //  System.out.println("查到了");}
//else System.out.println("没查到");
         /*  while (rs.next() && rs.getRow() >0)//rs.next()获取下一条数据的信息 rs.getRow()获取当前信息的行数 逐行读取


            {
                Vector row = new Vector();//存储每一行读取的元素
                for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++)//获得表结构 获得列数
            //    { System.out.println(rs.getString(col));
             //   if(rs.getString(col)!=null)
                    row.add(String.valueOf(rs.getString(col)));
               // else{JOptionPane.showMessageDialog(null,"提示","查询结果有误，请重新输入",JOptionPane.ERROR_MESSAGE);
              //  }


                }
                vector.add(row);//存每一行数据

            return vector;
            //return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Query failed");
            e.printStackTrace();
            return null;
        }

          */
            while (rs.next() && rs.getRow() > 0)//rs.next()获取下一条数据的信息 rs.getRow()获取当前信息的行数 逐行读取


            {
                Vector row = new Vector();//存储每一行读取的元素
                for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++)//获得表结构 获得列数
                {
                    row.add(String.valueOf(rs.getString(col)));
                }
                vector.add(row);//存每一行数据
            }



return vector;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Query failed");
            e.printStackTrace();
            return null;
        }


    }

    public static Vector inquireA2(String ID,String start,String end) {
       try {
            Vector vector = new Vector();//存储查询的结果集
            Connection conn = Connector.getConn();//连接数据库

            String sql = null;
            //PreparedStatement ps1 = conn.prepareStatement("select * from data where isDelete=0 AND ? = ?");


            sql = "select humidity,temperature,time from data where equipment_eId = '"+ID+"' and time between '"+start+"' and '"+end+"' order by time ";
         //  sql = "select humidity from data where equipment_eId = '"+ID+"' and time between '"+start+"' and '"+end+"' order by time ";

            PreparedStatement ps1 = conn.prepareStatement(sql);

            System.out.println(sql);
            ResultSet rs = ps1.executeQuery();//存储查询数据
//if(rs.next()){
            //  System.out.println("查到了");}
//else System.out.println("没查到");
         //   try{
           while (rs.next() && rs.getRow() > 0)//rs.next()获取下一条数据的信息 rs.getRow()获取当前信息的行数 逐行读取


           {
               Vector row = new Vector();//存储每一行读取的元素
               for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++)//获得表结构 获得列数
               {
                   row.add(String.valueOf(rs.getString(col)));
               }
               vector.add(row);//存每一行数据
           }


       return vector;
            //return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Query failed");
            e.printStackTrace();
            return null;
        }


    }

    /**
     * 某个灯某一时间段测量值的折线图 //亮度str
     */
    public static Vector inquireA3( String ID,String start,String end) {
        try {
            Vector vector = new Vector();//存储查询的结果集
            Connection conn = Connector.getConn();//连接数据库
            String sql = null;

            sql = "select  brightness,time from data where equipment_eId = '"+ID+"' and time between '"+start+"' and '"+end+"' order by time ";


            PreparedStatement ps1 = conn.prepareStatement(sql);
            // ps1.setString(1, name);//设备表、设备类别表或家庭表
            // ps1.setString(1, ID);//对应ID
            System.out.println(sql);
            ResultSet rs = ps1.executeQuery();//存储查询数据
//if(rs.next()){
            //  System.out.println("查到了");}
//else System.out.println("没查到");
            while (rs.next() && rs.getRow() >0)//rs.next()获取下一条数据的信息 rs.getRow()获取当前信息的行数 逐行读取


            {
                Vector row = new Vector();//存储每一行读取的元素
                for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++)//获得表结构 获得列数
                {
                    row.add(String.valueOf(rs.getString(col)));
                }
                vector.add(row);//存每一行数据
            }
            return vector;
            //return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Query failed");
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 可以统计某个设备，某个测量值大于(1)、等于(2)、小于(3)某个数值的个数或者其它数值
     * 饼图呈现
     * @param eID
     * @param num
     * @param start
     * @param end
     * @return
     */
    //b) 可以统计某个设备，某个测量值大于(1)、等于(2)、小于(3)某个数值的个数或者其它数值
 //al[0]大于 al[1]等于 al[2]小于
//eID 设备ID, valueName 测量值名称 ,num 某个数值大
// humidity
    public static Vector inquireB1(String eID, int num,String start,String end) {
        Vector vector = new Vector();
        Connection conn = Connector.getConn();//连接数据库
        String sql, sql2, sql3 = null;
        try {
            sql="select count(case when  equipment_eId = '"+eID+"' and humidity>'"+num+"' and time between '"+start+"' and '"+end+"' then 1 end)as greater," +
                    "count(case when equipment_eId = '"+eID+"' and humidity='"+num+"' and time between '"+start+"' and '"+end+"'then 1 end )as equil," +
                    "count(case when equipment_eId = '"+eID+"' and humidity<'"+num+"' and time between '"+start+"' and '"+end+"'then 1 end )as smaller from data order by greater";

            //System.out.println(sql);
            PreparedStatement ps1 = conn.prepareStatement(sql);
            ResultSet rs = ps1.executeQuery();//存储查询数据


            while (rs.next() && rs.getRow() > 0)//rs.next()获取下一条数据的信息 rs.getRow()获取当前信息的行数 逐行读取


            {
                Vector row = new Vector();//存储每一行读取的元素
                for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++)//获得表结构 获得列数
                {
                    row.add(String.valueOf(rs.getString(col)));
                }
                vector.add(row);//存每一行数据
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vector;
    }


//temperature
public static Vector inquireB2(String eID, int num,String start,String end) {
    //String n= Integer.toString(num);
    Vector vector = new Vector();
    Connection conn = Connector.getConn();//连接数据库
    String sql, sql2, sql3 = null;
    try {
        sql="select count(case when  equipment_eId = '"+eID+"' and temperature>'"+num+"' and time between '"+start+"' and '"+end+"' then 1 end)as greater," +
                "count(case when equipment_eId = '"+eID+"' and temperature='"+num+"' and time between '"+start+"' and '"+end+"'then 1 end )as equil," +
                "count(case when equipment_eId = '"+eID+"' and temperature<'"+num+"' and time between '"+start+"' and '"+end+"' then 1 end )as smaller from data order by greater";

        //System.out.println(sql);
        PreparedStatement ps1 = conn.prepareStatement(sql);
        ResultSet rs = ps1.executeQuery();//存储查询数据


        while (rs.next() && rs.getRow() > 0)//rs.next()获取下一条数据的信息 rs.getRow()获取当前信息的行数 逐行读取


        {
            Vector row = new Vector();//存储每一行读取的元素
            for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++)//获得表结构 获得列数
            {
                row.add(String.valueOf(rs.getString(col)));
            }
            vector.add(row);//存每一行数据
        }


    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return vector;
}


  /*  ArrayList al = new ArrayList();
    // Vector vector = new Vector();//存储查询的结果集
    Connection conn = Connector.getConn();//连接数据库
    String sql, sql2, sql3 = null;
    try {

        //PreparedStatement ps1 = conn.prepareStatement("select * from data where isDelete=0 AND ? = ?");

        sql = "select count(temperature) from data where equipment_eId = ? and temperature>? ";
        PreparedStatement ps1 = conn.prepareStatement(sql);
        ps1.setString(1, eID);//对应ID
        ps1.setInt(2, num);//对应I
        ResultSet rs1 = ps1.executeQuery();//存储查询数据
        sql2 = "select count(temperature) from data where equipment_eId = ? and temperature=? ";
        PreparedStatement ps2 = conn.prepareStatement(sql2);
        ps2.setString(1, eID);//对应ID
        ps2.setInt(2, num);//对应I
        ResultSet rs2 = ps2.executeQuery();//存储查询数据
        sql3 = "select count(temperature) from data where equipment_eId = ? and temperature<? ";
        PreparedStatement ps3 = conn.prepareStatement(sql3);*/
     /*   ps3.setString(1, eID);//对应ID
        ps3.setInt(2, num);//对应I
        ResultSet rs3 = ps3.executeQuery();//存储查询数据


        al.add(rs1.getInt(1));
        al.add(rs2.getInt(1));
        al.add(rs3.getInt(1));



    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return al; }*/
//state
public static Vector inquireB3(String eID,String start,String end) {
    //String n= Integer.toString(num);
    Vector vector = new Vector();
    Connection conn = Connector.getConn();//连接数据库
    String sql, sql2, sql3 = null;
    try {
        sql="select count(case when  equipment_eId = '"+eID+"' and state=0  and time between '"+start+"' and '"+end+"'then 1 end)as off," +
                "count(case when equipment_eId = '"+eID+"' and state=1  and time between '"+start+"' and '"+end+"'then 1 end )as o from data ";

        System.out.println(sql);
        PreparedStatement ps1 = conn.prepareStatement(sql);
        ResultSet rs = ps1.executeQuery();//存储查询数据


        while (rs.next() && rs.getRow() > 0)//rs.next()获取下一条数据的信息 rs.getRow()获取当前信息的行数 逐行读取


        {
            Vector row = new Vector();//存储每一行读取的元素
            for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++)//获得表结构 获得列数
            {
                row.add(String.valueOf(rs.getString(col)));
            }
            vector.add(row);//存每一行数据
        }


    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return vector;
}





//brightness
public static Vector inquireB4(String eID, int num,String start,String end) {

    Vector vector = new Vector();
    Connection conn = Connector.getConn();//连接数据库
    String sql, sql2, sql3 = null;
    try {
        sql="select count(case when  equipment_eId = '"+eID+"' and brightness>'"+num+"'  and time between '"+start+"' and '"+end+"'then 1 end)as greater," +
                "count(case when equipment_eId = '"+eID+"' and brightness='"+num+"' and time between '"+start+"' and '"+end+"'then 1 end )as equil," +
                "count(case when equipment_eId = '"+eID+"' and brightness<'"+num+"' and time between '"+start+"' and '"+end+"'then 1 end )as smaller from data order by greater";

        //System.out.println(sql);
        PreparedStatement ps1 = conn.prepareStatement(sql);
        ResultSet rs = ps1.executeQuery();//存储查询数据


        while (rs.next() && rs.getRow() > 0)//rs.next()获取下一条数据的信息 rs.getRow()获取当前信息的行数 逐行读取


        {
            Vector row = new Vector();//存储每一行读取的元素
            for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++)//获得表结构 获得列数
            {
                row.add(String.valueOf(rs.getString(col)));
            }
            vector.add(row);//存每一行数据
        }


    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return vector;
}



//c) 可以统计某个测量值的数值分布情况，例如湿度在 0-30,31-60,61-100 之间的分布。饼图
//测量值名 name 每段上限 arr fori 对应的设备类型type
   // type d\灯 温室检测 门
    //name 湿度 温度 亮度 状态
public static Vector inquireC(String type,String name,int[] arr,String start,String end) {
    Vector vector = new Vector();
    Connection conn = Connector.getConn();//连接数据库
    String sql, sql2, sql3 = null;

    try {
        sql="select count(case when type='"+type+"' and "+name+ " >= 0 and "+name+ "< "+arr[0]+"  and time between '"+start+"' and '"+end+"'then 1 end)as ct1,";
        for(int i=0;i<arr.length-2;i++){
            sql=sql+"count(case when type='"+type+"' and "+name+" >= "+arr[i]+" and "+name+ "<"+arr[i+1]+"  and time between '"+start+"' and '"+end+"'then 1 end)as ct"+(i+1)+",";}
        sql=sql+"count(case when type='"+type+"' and "+name+" >= "+arr[arr.length-2]+" and "+name+ "<="+arr[arr.length-1]+"  and time between '"+start+"' and '"+end+"'then 1 end)as ct"+arr.length+" from data ";
        System.out.println(sql);


        //System.out.println(sql);
        PreparedStatement ps1 = conn.prepareStatement(sql);
        ResultSet rs = ps1.executeQuery();//存储查询数据


        while (rs.next() && rs.getRow() > 0)//rs.next()获取下一条数据的信息 rs.getRow()获取当前信息的行数 逐行读取


        {
            Vector row = new Vector();//存储每一行读取的元素
            for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++)//获得表结构 获得列数
            {
                row.add(String.valueOf(rs.getString(col)));
            }
            vector.add(row);//存每一行数据
        }


    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return vector;
}

    /**
     * 能跑 计算多个家庭平均温度 湿度 亮度
     * @param str
     * @param start
     * @param end
     * @return
     */
//d) 可以统计多个家庭的汇总数据
    //str 需要统计的家庭ID
    //平均温度、湿度。灯亮度
public static Vector inquireD2(String[] str,String start,String end) {
    Vector vector = new Vector();
    Connection conn = Connector.getConn();//连接数据库
    String sql, sql2, sql3 = null;

    try {

        sql="select (avg(humidity)+20) as avghum,(avg(temperature)+10) as avgtem,(avg(brightness)+5) as avgbri from family f,equipment e,data d  where ";
        for(int i=0;i<str.length-1;i++)
            sql=sql+"(f.isDelete=0 and e.isDelete=0 and fID=family_fid and eid=equipment_eid and fid='"+str[i]+"' and time between '"+start+"' and '"+end+"') or ";

        sql=sql+"(f.isDelete=0 and e.isDelete=0   and fID=family_fid and eid=equipment_eid and fid='"+str[str.length-1]+"' and time between '"+start+"' and '"+end+"') ";
        System.out.println(sql);


        //System.out.println(sql);
        PreparedStatement ps1 = conn.prepareStatement(sql);
        ResultSet rs = ps1.executeQuery();//存储查询数据


        while (rs.next() && rs.getRow() > 0)//rs.next()获取下一条数据的信息 rs.getRow()获取当前信息的行数 逐行读取


        {
            Vector row = new Vector();//存储每一行读取的元素
            for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++)//获得表结构 获得列数
            {
                row.add(String.valueOf(rs.getString(col)));
            }
            vector.add(row);//存每一行数据
        }


    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return vector;
}

    /**
     * 查询多个家庭 温度 湿度 在时间段内的平均值
     * 柱状图呈现
     * @param str
     * @param
     * @param start
     * @param end
     * @return
     */
  /*  public static Vector inquireD2(String[] str,String start,String end) {
        Vector vector = new Vector();
        Connection conn = Connector.getConn();//连接数据库
       // String sql, sql2, sql3 = null;

        try {
String sql=null;
           // sql="select f.fid,avg(humidity),avg(temperature)from family f,equipment e,data d  where ";
            for(int i=0;i<str.length;i++) {
                sql = sql + "select f.fid avg(humidity (case when f.isDelete=0 and e.isDelete=0 and fID=family_fid and eid=equipment_eid and fid='" + str[i] + "' and type= hummeasure  and time between '" + start + "' and '" + end + "'))  ";
                sql = sql + "(f.isDelete=0 and e.isDelete=0 and fID=family_fid and eid=equipment_eid and fid='" + str[i] + "' and type= temmeasure  and time between '" + start + "' and '" + end + "')  ";

            }
            sql=sql+" from family f,equipment e,data d group by f.fid";
            System.out.println(sql);


            //System.out.println(sql);
            PreparedStatement ps1 = conn.prepareStatement(sql);
            ResultSet rs = ps1.executeQuery();//存储查询数据


            while (rs.next() && rs.getRow() > 0)//rs.next()获取下一条数据的信息 rs.getRow()获取当前信息的行数 逐行读取


            {
                Vector row = new Vector();//存储每一行读取的元素
                for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++)//获得表结构 获得列数
                {
                    row.add(String.valueOf(rs.getString(col)));
                }
                vector.add(row);//存每一行数据
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vector;
    }
*/
    /**
     * 能跑===============
     * 查指定几个家庭的所有数据  表格列出来
     * 折线图显示温度
     * 柱状图 亮度 每个家庭
     * @param str
     * @param start
     * @param end
     * @return
     */
//灯的开关次数

    public static Vector inquireD1(String[] str,String start,String end) {
        Vector vector = new Vector();
        Connection conn = Connector.getConn();//连接数据库
        // String sql, sql2, sql3 = null;

        try {
            String sql=null;
            sql="select f.fid,dataID, type, humidity, temperature,state, brightness, time, equipment_eid  from family f,equipment e,data d  where ";
            for(int i=0;i<str.length-1;i++){
            sql=sql+"(f.isDelete=0 and e.isDelete=0  and fID=family_fid and fid='" + str[i] + "') or ";}
            // sql="select f.fid,avg(humidity),avg(temperature)from family f,equipment e,data d  where ";

            sql=sql+"(f.isDelete=0 and e.isDelete=0 and fID=family_fid  and fid='" + str[str.length-1] + "') order by f.fid ";
            System.out.println(sql);


            //System.out.println(sql);
            PreparedStatement ps1 = conn.prepareStatement(sql);
            ResultSet rs = ps1.executeQuery();//存储查询数据


            while (rs.next() && rs.getRow() > 0)//rs.next()获取下一条数据的信息 rs.getRow()获取当前信息的行数 逐行读取


            {
                Vector row = new Vector();//存储每一行读取的元素
                for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++)//获得表结构 获得列数
                {
                    row.add(String.valueOf(rs.getString(col)));
                }
                vector.add(row);//存每一行数据
            }}


         catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vector;
    }

    /**
     *多个家庭每个家庭的温度折线图
     * @param str
     * @param
     * @param start
     * @param end
     * @return
     */
    /*public static Vector inquireD4(String[] str,String start,String end) {
        Vector vector = new Vector();
        Connection conn = Connector.getConn();//连接数据库
        // String sql, sql2, sql3 = null;

        try {
            String sql=null;
            for(int i=0;i<str.length;i++){
            sql="select f.fid,humidity, temperature, time from family f,equipment e,data d  where ";

                sql=sql+"(f.isDelete=0 and e.isDelete=0 and fID=family_fid and fid='" + str[i] + "'";
            // sql="select f.fid,avg(humidity),avg(temperature)from family f,equipment e,data d  where ";


            System.out.println(sql);


            //System.out.println(sql);
            PreparedStatement ps1 = conn.prepareStatement(sql);
            ResultSet rs = ps1.executeQuery();//存储查询数据


            while (rs.next() && rs.getRow() > 0)//rs.next()获取下一条数据的信息 rs.getRow()获取当前信息的行数 逐行读取


            {
                Vector row = new Vector();//存储每一行读取的元素
                for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++)//获得表结构 获得列数
                {
                    row.add(String.valueOf(rs.getString(col)));
                }
                vector.add(row);//存每一行数据
            }}





    } catch (SQLException e) {
            e.printStackTrace();
        }
        return vector;}

        public static Vector inquireD3(String[] str,String name1,String start,String end) {
        Vector vector = new Vector();
        Connection conn = Connector.getConn();//连接数据库
        String sql= null;

        try {
switch (name1){
    case"humidity":
        sql="select count (case when humidity between 16 and 26 then 1 end)as comfortable,count (case when humidity between 26 and 35 then 1 end)as normal,count(case when humidity >35 then 1 end )as hot from family f,equipment e,data d  where ";
        for(int i=0;i<str.length-1;i++)
            sql=sql+"(f.isDelete=0 and e.isDelete=0 and fID=family_fid and eid=equipment_eid and fid='"+str[i]+"' and time between '"+start+"' and '"+end+"') or ";

        sql=sql+"(f.isDelete=0 and e.isDelete=0   and fID=family_fid and eid=equipment_eid and fid='"+str[str.length-1]+"' and time between '"+start+"' and '"+end+"') ";
        System.out.println(sql);
        break;
    case"temperature":
        sql="select count (case when temperature between 0 and 40 then 1 end)as dry,count (case when temperature between 41 and 60 then 1 end)as comfortable,count(case when tempereture>60 then 1 end )as moist from family f,equipment e,data d  where ";
        for(int i=0;i<str.length-1;i++)
            sql=sql+"(f.isDelete=0 and e.isDelete=0 and fID=family_fid and eid=equipment_eid and fid='"+str[i]+"' and time between '"+start+"' and '"+end+"') or ";

        sql=sql+"(f.isDelete=0 and e.isDelete=0   and fID=family_fid and eid=equipment_eid and fid='"+str[str.length-1]+"' and time between '"+start+"' and '"+end+"') ";
        System.out.println(sql);
        break;

    default:
        System.out.println("error");
}



            //System.out.println(sql);
            PreparedStatement ps1 = conn.prepareStatement(sql);
            ResultSet rs = ps1.executeQuery();//存储查询数据


            while (rs.next() && rs.getRow() > 0)//rs.next()获取下一条数据的信息 rs.getRow()获取当前信息的行数 逐行读取


            {
                Vector row = new Vector();//存储每一行读取的元素
                for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++)//获得表结构 获得列数
                {
                    row.add(String.valueOf(rs.getString(col)));
                }
                vector.add(row);//存每一行数据
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vector;
    }
//多个家庭测量值的饼图  name1 测量值名称（温度，湿度，烟雾浓度） str 家庭id
   /* public static Vector inquireD2(String[] str,String name1,String start,String end) {
        Vector vector = new Vector();
        Connection conn = Connector.getConn();//连接数据库
        String sql, sql2, sql3 = null;

        try {
            switch(name1){
                case"humidity":
                    sql="select * from"
                    sql="select count(case when  equipment_eId = '"+eID+"' and brightness>'"+num+"'  and time between '"+start+"' and '"+end+"'then 1 end)as greater," +
                            "count(case when equipment_eId = '"+eID+"' and brightness='"+num+"' and time between '"+start+"' and '"+end+"'then 1 end )as equil," +
                            "count(case when equipment_eId = '"+eID+"' and brightness<'"+num+"' and time between '"+start+"' and '"+end+"'then 1 end )as smaller from data order by greater";

            }
            sql="select count(case when type='"+type+"' and "+name+ " >= 0 and "+name+ "< "+arr[0]+"  and time between '"+start+"' and '"+end+"'then 1 end)as ct1,";
            for(int i=0;i<arr.length-2;i++){
                sql=sql+"count(case when type='"+type+"' and "+name+" >= "+arr[i]+" and "+name+ "<"+arr[i+1]+"  and time between '"+start+"' and '"+end+"'then 1 end)as ct"+(i+1)+",";}
            sql=sql+"count(case when type='"+type+"' and "+name+" >= "+arr[arr.length-2]+" and "+name+ "<="+arr[arr.length-1]+"  and time between '"+start+"' and '"+end+"'then 1 end)as ct"+arr.length+" from data ";
            System.out.println(sql);


            //System.out.println(sql);
            PreparedStatement ps1 = conn.prepareStatement(sql);
            ResultSet rs = ps1.executeQuery();//存储查询数据


            while (rs.next() && rs.getRow() > 0)//rs.next()获取下一条数据的信息 rs.getRow()获取当前信息的行数 逐行读取


            {
                Vector row = new Vector();//存储每一行读取的元素
                for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++)//获得表结构 获得列数
                {
                    row.add(String.valueOf(rs.getString(col)));
                }
                vector.add(row);//存每一行数据
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vector;
    }*/

// 某个时间段的测量值变化趋势

}
//state

    /*
    //某个单独设备 eid设备id
public  static Vector inquireA1(String eID) {
        try {
            Vector vector = new Vector();//存储查询的结果集
            Connection conn = Connector.getConn();//连接数据库
            //PreparedStatement ps1 = conn.prepareStatement("select * from data where isDelete=0 AND ? = ?");
            PreparedStatement ps1 = conn.prepareStatement("select * from data where  equipment_eId = ?");
           // ps1.setString(1, name);//设备表、设备类别表或家庭表
            ps1.setString(1,eID);//对应ID
            ResultSet rs = ps1.executeQuery();//存储查询数据

            while(rs.next() && rs.getRow() > 0)//rs.next()获取下一条数据的信息 rs.getRow()获取当前信息的行数 逐行读取


            {
                Vector row = new Vector();//存储每一行读取的元素
                for(int col = 1; col <= rs.getMetaData().getColumnCount();col++)//获得表结构 获得列数
                {
                    row.add(String.valueOf(rs.getString(col)));
                }
                vector.add(row);//存每一行数据
            }
            return vector;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Query failed");
            e.printStackTrace();
            return null;
        }}
  //按设备类型查询 type设备类型
    public  static Vector inquireA2(String type) {
        try {
            Vector vector = new Vector();//存储查询的结果集
            Connection conn = Connector.getConn();//连接数据库
            //PreparedStatement ps1 = conn.prepareStatement("select * from data where isDelete=0 AND ? = ?");
            PreparedStatement ps1 = conn.prepareStatement("select * from data where  type = ?");
            // ps1.setString(1, name);//设备表、设备类别表或家庭表
            ps1.setString(1,type);//对应ID
            ResultSet rs = ps1.executeQuery();//存储查询数据

            while(rs.next() && rs.getRow() > 0)//rs.next()获取下一条数据的信息 rs.getRow()获取当前信息的行数 逐行读取


            {
                Vector row = new Vector();//存储每一行读取的元素
                for(int col = 1; col <= rs.getMetaData().getColumnCount();col++)//获得表结构 获得列数
                {
                    row.add(String.valueOf(rs.getString(col)));
                }
                vector.add(row);//存每一行数据
            }
            return vector;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Query failed");
            e.printStackTrace();
            return null;
        }}
//按家庭查询 fid
public  static Vector inquireA3(String fID) {
    try {
        Vector vector = new Vector();//存储查询的结果集
        Connection conn = Connector.getConn();//连接数据库
        //PreparedStatement ps1 = conn.prepareStatement("select * from data where isDelete=0 AND ? = ?");
        PreparedStatement ps1 = conn.prepareStatement("select * from family f,data,equipment e where f.isDelete=0 " +
                "AND e.isDelete=0 AND fID=family_fID AND eID=equipment_eID" +
                "AND fID=?");
        // ps1.setString(1, name);//设备表、设备类别表或家庭表
        ps1.setString(1,fID);//对应ID
        ResultSet rs = ps1.executeQuery();//存储查询数据

        while(rs.next() && rs.getRow() > 0)//rs.next()获取下一条数据的信息 rs.getRow()获取当前信息的行数 逐行读取


        {
            Vector row = new Vector();//存储每一行读取的元素
            for(int col = 1; col <= rs.getMetaData().getColumnCount();col++)//获得表结构 获得列数
            {
                row.add(String.valueOf(rs.getString(col)));
            }
            vector.add(row);//存每一行数据
        }
        return vector;
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, "Query failed");
        e.printStackTrace();
        return null;
    }}
    */

 //b) 可以统计某个设备，某个测量值大于(1)、等于(2)、小于(3)某个数值的个数或者其它数值
 //name1设备ID  name2测量值的名字(humidity,temperature,) num0某个数值
   /*     public static Vector inquireB(String name1, String name2,String num0) {

        int num=Integer.parseInt(num0);
            try {
                Vector vector = new Vector();
                Connection conn = Connector.getConn();//连接数据库
                PreparedStatement ps1 = conn.prepareStatement("select sum(?) from `equipment` where isDelete=0 AND eID='?' AND  ?> ?");
                ps1.setString(1, name2);//设备表、设备类别表或家庭表
                ps1.setString(2,name1);//对应ID
                ps1.setString(3,name2);//对应ID
                ps1.setString(4,num0);//对应ID
                ResultSet rs = ps1.executeQuery();//存储查询数据

                while(rs.next() && rs.getRow() > 0)//rs.next()获取下一条数据的信息 rs.getRow()获取当前信息的行数


                {
                    Vector row = new Vector();
                    for(int col = 1; col <= rs.getMetaData().getColumnCount();col++)//获得表结构 获得列数
                    {
                        row.add(String.valueOf(rs.getString(col)));
                    }
                    vector.add(row);//存每一行数据
                }
                return vector;
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Query failed");
                e.printStackTrace();
                return null;
            }

    }

    */
//c) 可以统计某个测量值的数值分布情况，例如湿度在 0-30,31-60,61-100 之间的分布。

    /*
    public static Vector inquireC(String name,String id) {
        try {
            Vector vector = new Vector();
            Connection conn = Connector.getConn();//连接数据库
            PreparedStatement ps1 = conn.prepareStatement("select * from `user` where isDelete=0 AND ? = ?");
            ps1.setString(1, name);//设备表、设备类别表或家庭表
            ps1.setString(2,id);//对应ID
            ResultSet rs = ps1.executeQuery();//存储查询数据

            while(rs.next() && rs.getRow() > 0)//rs.next()获取下一条数据的信息 rs.getRow()获取当前信息的行数


            {
                Vector row = new Vector();
                for(int col = 1; col <= rs.getMetaData().getColumnCount();col++)//获得表结构 获得列数
                {
                    row.add(String.valueOf(rs.getString(col)));
                }
                vector.add(row);//存每一行数据
            }
            return vector;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Query failed");
            e.printStackTrace();
            return null;
        }}

*/
/**
 * 某个家庭某一时间段的气温折线图，湿度折线图
 */

