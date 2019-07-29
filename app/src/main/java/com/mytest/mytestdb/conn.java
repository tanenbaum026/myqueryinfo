package com.mytest.mytestdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conn {

    Connection con;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";



    public Connection getConnection(String url, String user,String password)
    {
        try
        {
            Class.forName(JDBC_DRIVER);

        }catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        try{
            con = DriverManager.getConnection(url,user,password);
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return con;
    }



}
