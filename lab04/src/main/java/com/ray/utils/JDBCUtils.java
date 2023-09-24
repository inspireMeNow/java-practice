package com.ray.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Base64;
import java.util.Properties;

//JDBC工具类
public  class JDBCUtils {
    //1.私有构造方法
    private JDBCUtils(){}
    //2.申明所需要的配置变量
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;
    private static Connection con;
    //3.提供静态代码块。读取配置文件的信息为变量赋值，注册驱动
    static {

        try {
            username="root";
            password="796184@.cnCN";
            url="jdbc:mariadb://127.0.0.1:3306/grade";
//            driverClass=prop.getProperty("driverClass");
            Class.forName("org.mariadb.jdbc.Driver");
//            byte[] decodedByte = Base64.getDecoder().decode(password);
//            password=new String(decodedByte);
            //注册驱动
            //Class.forName(driverClass);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //4.提供获取数据库连接的方式
    public static Connection getConnection(){
        try {
            con= DriverManager.getConnection(url,username,password);
//            System.out.println("数据库连接成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }
    //5.提供释放资源的方法
    public static void close(Connection con, Statement stat, ResultSet rs){
        if (con!=null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stat!=null){
            try {
                stat.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void close(Connection con, Statement stat){
        if (con!=null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stat!=null){
            try {
                stat.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}