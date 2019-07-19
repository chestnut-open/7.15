package com.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoFather {
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/users?characterEncoding=utf8&useSSL=false&serverTimezone=CST";
    private static final String username = "root";
    private static final String password = "root";
    public Connection getConnection(){
        try {
            Class.forName(DRIVER_CLASS);
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void closeAll(Connection conn, PreparedStatement sta, ResultSet rs){
        try {
            if(rs!=null) rs.close();
            if(sta!=null) sta.close();
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
