package Mini_term;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public static Connector con=new Connector();
    public Connector(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Database cannot be loaded" + e.getMessage());
        }
    }
    public static Connection getConn(){

            try {
                Connection conn = null;
                String ur1 = "jdbc:mysql://localhost:3306/miniterm";
                String username = "root";
                String password = "123456";
                conn = DriverManager.getConnection( ur1, username, password);
                //	  JOptionPane.showMessageDialog(null, "Database is connected successfully! " );
                return conn;
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Database cannot be connected! " + e.getMessage());
                return null;
            }
        }
    }

