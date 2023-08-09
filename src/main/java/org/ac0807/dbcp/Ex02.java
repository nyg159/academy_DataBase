package org.ac0807.dbcp;

import org.dto.PersonVO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class PersonDAO extends Dao {



    public List<PersonVO1> selectAll() {
        try {
            String sql = "select * from person";

            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            List<PersonVO1> list = new ArrayList<>();

            while (rs.next()) {
                PersonVO1 row = new PersonVO1();

                row.setName(rs.getString("name"));
                row.setHeight(rs.getDouble("height"));
                row.setBirth(rs.getDate("birth"));

                list.add(row);

            }

            return list;

        } catch (SQLException e) {
            System.err.println("select 예외 : "+e.getMessage());
        }finally {
            close();
        }

        return null;
    }

    int insert(PersonVO1 input){
        try {
            String sql = "insert into person values(?,?,?)";

            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, input.getName());
            pstmt.setDouble(2, input.getHeight());
            pstmt.setDate(3, input.getBirth());

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("insert 예외 : " + e.getMessage());
        }finally {
            close();
        }
        return 0;
    }

    int delete(String name) {

        try {
            String sql = "delete from person where name = ?";
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);

            return pstmt.executeUpdate();


        } catch (SQLException e) {
            System.err.println("delete 예외 : " + e.getMessage());
        }finally {
            close();

        }
        return 0;
    }

    int update(PersonVO1 input, String name){
        try {
            String sql = "update person " +
                    "set name = ? " +
                    "height = ? " +
                    "birth = ? " +
                    "where name = ?";

            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, input.getName());
            pstmt.setDouble(2, input.getHeight());
            pstmt.setDate(3, input.getBirth());
            pstmt.setString(4, name);

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("update 예외 : " + e.getMessage());
        }finally {
            close();
        }
        return 0;
    }

}
public class Ex02 {

    static void printList(List<PersonVO1> list){
        for (PersonVO1 row : list) {
            System.out.println(row);
        }
        System.out.println();
    }

    static PersonVO1 getInstance(Scanner scanner){

        PersonVO1 row = new PersonVO1();

        System.out.println("이름 : ");
        row.setName(scanner.next());

        System.out.println("신장 : ");
        row.setHeight(scanner.nextDouble());

        System.out.println("생년월일(-입력) : ");
        row.setBirth(Date.valueOf(scanner.next()));

        return row;
    }

    static String getName(Scanner scanner) {
        System.out.println("\n이름 : ");
        String name1 = scanner.next();

        return name1;
    }

    public static void main(String[] args) {



        PersonDAO dao = new PersonDAO();

        // 1. select
        System.out.println(dao.selectAll());

        // 2. insert
//        Scanner scanner = new Scanner(System.in);
//        PersonVO1 input = getInstance(scanner);
//        int row = dao.insert(input);
//
//        // 3. delect
//        String name = getName(scanner);
//        row = dao.delete(name);
//
//        // 4. update
//        name = getName(scanner);
//        input = getInstance(scanner);
//        row = dao.update(input, name);
//
//
//        System.out.println(dao.selectAll());

    }
}
