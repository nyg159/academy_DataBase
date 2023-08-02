package ac0802.dao;

import java.sql.*;

public class DAO {
    protected String driver = "oracle.jdbc.driver.OracleDriver";
    protected String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
    protected String user = "c##itbank";
    protected String password = "it";

    protected Connection conn = null; // DB에 연결을 생성하고 유지하는 객체
    protected Statement stmt = null; // SQL 구문을 실행할 객체
    protected ResultSet rs = null; // table의 결과를 가진 집합(= Set)

    public DAO() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.err.println("생성자 예외 : " + e.getMessage());
        }
    }

    protected void close() {

        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public String test() {

        try {
            String sql = "select banner from v$version";

            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            rs.next();

            return rs.getString("banner");

        } catch (SQLException e) {
            System.err.println("test 예외 : " + e.getMessage());

        } finally {
            close();
        }

        return null;
    }
}
