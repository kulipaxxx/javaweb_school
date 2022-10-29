package com.cheng.Dao;

import com.mysql.jdbc.Driver;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    //静态代码块，类加载时初始化
    static {
        Properties properties = new Properties();

        InputStream stream = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");

        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = properties.getProperty("jdbc.driver");
        url = properties.getProperty("jdbc.url");
        username = properties.getProperty("jdbc.username");
        password = properties.getProperty("jdbc.password");
    }

    //获取数据库的连接
    public static Connection getConnection() {

        Connection connection = null;
        try {
            //加载驱动
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
