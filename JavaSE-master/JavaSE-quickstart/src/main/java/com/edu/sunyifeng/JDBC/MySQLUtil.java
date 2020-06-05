package com.edu.sunyifeng.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLUtil {

    /**
     * 批量读取 MySQL 数据库数据
     * 大数据量下使用，可以防止内存溢出
     * useCursorFetch=true&defaultFetchSize=500
     *
     * @throws Exception
     */
    public static void batchRead() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://110.16.79.182:16603/aic_crawler?useUnicode=true&characterEncoding=utf-8&useCursorFetch=true&defaultFetchSize=500", "aic_crawler", "crawler!20200525");
        Statement statement = connection.createStatement();
        String sql = "select * from law_detail;";
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("11111111111111111111111111");
        while (resultSet.next()) {
            System.out.println( resultSet.getString("update_time"));
        }
    }

    public static void main(String[] args) throws Exception {
        batchRead();
    }


}
