/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBConnection;

import java.sql.*;

/**
 *
 * @author kguna
 */
public class DBConnection {
    private static DBConnection ob;
    private Connection connection;
    
    private DBConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Thogakade", "root", "1234");
    }

    public Connection getConnection(){
        return  connection;
    }

    public static DBConnection getInstance() throws ClassNotFoundException, SQLException{
        if(ob==null){
            ob=new DBConnection();
        }
        return ob;
    }
}
