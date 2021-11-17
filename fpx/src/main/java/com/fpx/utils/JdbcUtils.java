package com.fpx.utils;

import java.sql.*;

/**
 * @author qfc
 * jdbc的工具类
 */
public class JdbcUtils {
    private static final String DRIVER="com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/web_log_view";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    /*
     *获取链接
     * */
    public static Connection getConnection() throws SQLException,ClassNotFoundException{
        //1.1.创建数据库创建表
        //1.2.导入jar包
        //1.3.注册驱动
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL,USER,PASSWORD);

    }
    public static void close(Connection connection, Statement statement, ResultSet resultSet)throws SQLException{
        //关闭资源

        resultSet.close();
        statement.close();
        connection.close();

    }

}
