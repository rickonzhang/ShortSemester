package Mini_term;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class menufinquire {
    public static Vector minquire1(String eid,String start,String end) {


        try {
            Vector vector = new Vector();//存储查询的结果集
            Connection conn = Connector.getConn();//连接数据库
            String sql = null;
            //PreparedStatement ps1 = conn.prepareStatement("select * from data where isDelete=0 AND ? = ?");

            sql = "select * from data where equipment_eId = '" + eid + "' and time between '" + start + "' and '" + end + "'";

            PreparedStatement ps1 = conn.prepareStatement(sql);
            // ps1.setString(1, name);//设备表、设备类别表或家庭表
            // ps1.setString(1, ID);//对应ID
            System.out.println(sql);
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


            return vector;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Query failed");
            e.printStackTrace();
            return null;
        }
    }}




