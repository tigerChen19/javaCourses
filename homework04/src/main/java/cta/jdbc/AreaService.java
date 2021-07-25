package cta.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AreaService {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/ecrime";
        String username="root";
        String password="123456";

        Connection conn = DriverManager.getConnection(url,username,password);
        System.out.println("Database connection success");

        return conn;
    }

}
