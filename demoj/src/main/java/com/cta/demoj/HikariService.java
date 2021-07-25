package com.cta.demoj;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class HikariService {

    public DataSource getDataSource(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/ecrime");
        config.setUsername("root");
        config.setPassword("123456");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "100");
        config.addDataSourceProperty("maximumPoolSize", "10");
        DataSource ds = new HikariDataSource(config);
        return ds;
    }

    public void query() throws SQLException {
        DataSource ds = getDataSource();

        Connection conn = ds.getConnection();
        try {
            String sql = "select * from areas where code = ? ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,"460100");
            ResultSet re = preparedStatement.executeQuery();
            re.next();
            int id = re.getInt(1);
            System.out.println("id:"+id);


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(conn!=null){
                conn.close();
            }
        }


    }
}













