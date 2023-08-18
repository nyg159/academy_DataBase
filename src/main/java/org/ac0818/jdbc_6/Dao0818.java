package org.ac0818.jdbc_6;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao0818 {
    String url = "jdbc:oracle:thin:@192.168.113.200:1521:xe";
    String userName = "c##itbank";
    String passWord = "it";

    BasicDataSource ds;

    Connection conn;
    Statement stmt;
    PreparedStatement pstmt;
    CallableStatement cstmt;    // 프로시저 호출시 사용할 statement
    ResultSet rs;

    public Dao0818(){
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

    public int sal_up_pro(int n1, int n2){
        try {
            String sql = "{call sal_up(?,?,?)}";

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

    public int absFunc(int n1) {
        try {
            String sql = "select num1(?) from dual";

            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,n1);
            rs = pstmt.executeQuery();

            rs.next();

            return rs.getInt(1);

        } catch (SQLException e) {
            System.err.println("절대값 함수 예외");
        }finally {
            close();
        }
        return 0;
    }


    public int reverseFuc(int n1) {
        try {
            String sql = "select rev(?) from dual";

            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, n1);
            rs = pstmt.executeQuery();

            rs.next();

            return rs.getInt(1);

        } catch (SQLException e) {
            System.err.println("입력 받은 수를 반대로 반환 함수 예외");
        } finally {
            close();
        }
        return 0;
    }


}
