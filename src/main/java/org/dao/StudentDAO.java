package org.dao;

import org.dto.StudentDTO;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DAO{
    public List<StudentDTO> selectAll(){
        try {

            String sql = "select * from test_student";

            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            List<StudentDTO> list = new ArrayList<StudentDTO>();

            while (rs.next()) {
                StudentDTO row = new StudentDTO();

                row.setEng(rs.getInt("eng"));
                row.setKor(rs.getInt("kor"));
                row.setMat(rs.getInt("mat"));
                row.setName(rs.getString("name"));

                list.add(row);
            }

            return list;

        } catch (Exception e) {
            System.err.println("selectAll 예외 : "+ e.getMessage());
        }finally {

            close();

        }
        return null;
    }
}
