package com.cta.demoj;


import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.springframework.stereotype.Component;

import javax.sound.midi.Soundbank;
import java.sql.*;

@Component
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
    public void query() throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        try {

            Statement statement = conn.createStatement();

            String query = "select * from areas";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String code = resultSet.getString("code");
                String name = resultSet.getString("name");
                System.out.println("id:"+id+" code:"+code+" name:"+name);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(conn !=null){
                try {
                    conn.close();
                    System.out.println("Database connection closed");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public void query2() throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        String sql = "select * from areas where code = ? ";
        PreparedStatement preparedStatement =
                conn.prepareStatement(sql);
        preparedStatement.setString(1,"460100");
        ResultSet re = preparedStatement.executeQuery();
        re.next();
        int id = re.getInt(1);
        System.out.println("id:"+id);
    }

    public void save() throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        try {
            conn.setAutoCommit(false);
            System.out.println("默认的事务隔离级别："+conn.getTransactionIsolation());

            String sql = "insert areas values(2892533333,null,null,null,null,'469999',null,'我的市县',null)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.executeUpdate();
            System.out.println("插入成功");

//            String sql2 = "insert areas values(3322892533333,'','','','',null,null,null,null,'469999',null,'我的市县',null)";
//
//            PreparedStatement ps2 = conn.prepareStatement(sql2);
//            ps2.executeUpdate();
//            System.out.println("第二个插入成功");
            conn.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(conn!=null){
                conn.rollback();
            }
        }finally {
            if(conn!=null){
                conn.close();
                System.out.println("数据库链接关闭");
            }
        }

    }






}

