package org.dao;

import org.dto.PersonVO;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Person0804Dao extends DAO2{

    public List<PersonVO> selectAll(){

        try {
            String sql = "select * from person";

            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            List<PersonVO> list = new ArrayList<>();

            while (rs.next()) {
                PersonVO row = new PersonVO();

                row.setName(rs.getString("name"));
                row.setHeight(rs.getDouble("height"));
                row.setBirth(rs.getDate("birth"));

                list.add(row);
            }

            return list;


        } catch (SQLException e) {
            System.err.println("예외 : " + e.getMessage());
        }
        finally {
            close();

        }

        return null;
    }
    public int insert(PersonVO per) {

        try {
            String sql = "insert into person values(?, ?, ?)";
            //  1  2  3

            conn = DriverManager.getConnection(url, user, password);
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, per.getName());
            pstmt.setDouble(2, per.getHeight());
            pstmt.setDate(3, per.getBirth());

            int row = pstmt.executeUpdate();

            return row;
            // ※ executeQuery() : 테이블의 결과를 반환. select 사용시, ResultSet으로 반환
            // ※ executeUpdate() : 실행 후 행 개수를 반환. insert, update, delete 사용시

        } catch (SQLException e) {
            System.err.println("insert 예외 : " + e.getMessage());

        } finally {
            close();
        }

        return 0;
    }

    public int delete(String name) {
        try {
            String sql = "delete from person name = ?";

            conn = DriverManager.getConnection(url, user, password);
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,name);

            return pstmt.executeUpdate();
            // ※ executeQuery() : 테이블의 결과를 반환. select 사용시, ResultSet으로 반환
            // ※ executeUpdate() : 실행 후 행 개수를 반환. insert, update, delete 사용시

        } catch (SQLException e) {
            System.err.println("insert 예외 : " + e.getMessage());

        } finally {
            close();
        }

        return 0;


    }
    public  int update(PersonVO personVO,String name) {

        try {

            String sql = "update person set name = ?, " +
                    "height = ?, birth = ? where name = ?";

            conn = DriverManager.getConnection(url, user, password);
            pstmt = conn.prepareStatement(sql);





        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        return 0;
    }


}
