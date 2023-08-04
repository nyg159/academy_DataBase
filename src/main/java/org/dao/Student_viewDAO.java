package org.dao;

import org.dto.Student_viewDTO;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class Student_viewDAO extends DAO{
    public List<Student_viewDTO> selectAll(){
        try {

            String sql = "select * from test_student_view";

            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            List<Student_viewDTO> list = new ArrayList<Student_viewDTO>();

            while (rs.next()) {
                Student_viewDTO row = new Student_viewDTO();

                row.setEng(rs.getInt("eng"));
                row.setKor(rs.getInt("kor"));
                row.setMat(rs.getInt("mat"));
                row.setName(rs.getString("name"));
                row.setAvg(rs.getDouble("avg"));
                row.setTotal(rs.getInt("total"));

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
