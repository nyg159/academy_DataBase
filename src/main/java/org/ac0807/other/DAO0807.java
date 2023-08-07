package org.ac0807.other;

import java.sql.*;

public class DAO0807 {
    protected String driver = "oracle.jdbc.driver.OracleDriver";
    protected String url = "jdbc:oracle:thin:@192.168.113.200:1521:xe";
    protected String user = "c##itbank";
    protected String password = "it";

    protected Connection conn;
    protected Statement stmt;
    protected PreparedStatement pstmt;
    protected ResultSet rs;

    protected void close() {
        try {
            if (rs != null) 	rs.close();
            if (pstmt != null) 	pstmt.close();
            if (stmt != null) 	stmt.close();
            if (conn != null) 	conn.close();
        } catch(Exception e) {}
    }

    public String test() {
        try {
            String sql = "select "
                    + "to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS') as time "
                    + "from dual";

            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            rs.next();

            return rs.getString("time");

        } catch(SQLException e) {
            System.err.println("test 예외 : " + e.getMessage());

        } finally {
            close();
        }

        return null;
    }




}
