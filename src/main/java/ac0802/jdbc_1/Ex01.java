package ac0802.jdbc_1;

import java.sql.*;

public class Ex01 {
    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
        String user = "c##itbank";
        String password = "it";

        Connection conn = null;	// DB에 연결을 생성하고 유지하는 객체
        Statement stmt = null;		// SQL 구문을 실행할 객체
        ResultSet rs = null;		// table 의 결과를 가진 집합(= Set)

        try {
            Class.forName(driver);

            String sql = "select banner from v$version";

            conn = DriverManager.getConnection(url, user, password);	// 1. 연결을 생성
            stmt = conn.createStatement();								// 2. SQL 실행 객체 생성
            rs = stmt.executeQuery(sql);								// 3. 실행 결과를 rs 객체에 저장

            rs.next();

            String banner = rs.getString("banner");

            System.out.println("banner = " + banner);

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("예외 발생 : " + e.getMessage());

        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();

            } catch (Exception e) {}
        }
    }
}
