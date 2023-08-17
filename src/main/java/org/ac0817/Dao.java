package org.ac0817;

import org.apache.commons.dbcp2.BasicDataSource;

import java.lang.reflect.Type;
import java.sql.*;

public class Dao {
    String url = "jdbc:oracle:thin:@192.168.113.200:1521:xe";
    String userName = "c##itbank";
    String passWord = "it";

    BasicDataSource ds;

    Connection conn;
    Statement stmt;
    PreparedStatement pstmt;
    CallableStatement cstmt;    // 프로시저 호출시 사용할 statement
    ResultSet rs;

    public Dao(){
        ds = new BasicDataSource();

        ds.setUrl(url);
        ds.setUsername(userName);
        ds.setPassword(passWord);

        close();
    }

    private void close() {
        try {
            if(rs != null){
                rs.close();
            }
            if(cstmt != null){
                cstmt.close();
            }
            if(pstmt != null){
                pstmt.close();
            }
            if(conn != null){
                conn.close();
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String test(){
        try {
            String sql = "select banner from v$version";

            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            rs.next();

            return rs.getString("banner");



        } catch (SQLException e) {
            System.err.println("test 예외");
        }finally {
            close();
        }
        return null;
    }

    public int proTest(int n1, int n2){
        try {
            String sql = "select banner from v$version";

            conn = ds.getConnection();
            cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, n1);
            cstmt.setInt(2, n2);

            cstmt.registerOutParameter(3, Types.INTEGER);
            // out 매개변수로 지정

            cstmt.execute();
            // 지정한 프로시저를 실행

            int result1 = cstmt.getInt(3);
            // get 자료형() 형태로 가져온다.

            return result1;


        } catch (SQLException e) {
            System.err.println("test 예외");
        }finally {
            close();
        }
        return 0;
    }

}
