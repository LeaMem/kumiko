package com.lea.kumiko.midware.others;

import com.mysql.cj.jdbc.Driver;

import java.io.BufferedWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.*;
import java.util.Enumeration;

public class JDBCTest {

    /**
     *      https://www.cnblogs.com/fzz9/p/8970210.html
     *      https://github.com/ZhangZiSheng001/jdbc-demo
     * @throws ClassNotFoundException
     * @throws SQLException
     */


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://mysql.dev.idc.cedu.cn:3306/trcommander?autoReconnect=true&autoCommit=false&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
        String userName = "qingqingDev";
        String password = "qingqing@dev";

        String sql = "select * from t_department limit 10";

        //Step 1: register jdbc driver
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        DriverManager.registerDriver(new Driver());
//        DriverManager.setLogWriter(new PrintWriter(System.out, true));
        Enumeration<java.sql.Driver> drivers = DriverManager.getDrivers();



        //Step 2: open a connection
        try(Connection connection = DriverManager.getConnection(url, userName, password)){

            //createStatement 是什么
            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, 1);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                String deptName = resultSet.getString("department_name");
                System.out.println(deptName);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }



    }

}
