package com.login.exec.dao.impl;

import com.login.exec.dao.LoginDao;
import com.login.exec.model.User;

import java.sql.*;

public class LoginDaoImpl implements LoginDao {
    @Override
    public User checkUser(String username, String password){
        //创建JDBC对象
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        //加载驱动获取连接
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet?serverTimezone=GMT%2B8","root","root");
            String sql = "select * from user where username = ? and password = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
        //创建SQL执行器
            rs = ps.executeQuery();
        //获取结果集，关闭资源
            while (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                }
            if (ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }

    @Override
    public User checkUserById(Integer id) {
        //创建JDBC对象
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        //加载驱动获取连接
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet?serverTimezone=GMT%2B8","root","root");
            String sql = "select * from user where id = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            //创建SQL执行器
            rs = ps.executeQuery();
            //获取结果集，关闭资源
            while (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }
}
