package org.ac0809.jdbc_4;

/*
        문제 : 컴공과 학생의 정보를 출력(단, 학번 이름, 연락처, 학과명, 학과 연락처)
        dbcp 를 사용해서 해봐라
 */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class Quiz02DTO{
    private String student_name, department_name, department_phone, student_phone;
    private int student_idx;

    public int getStudent_idx() {
        return student_idx;
    }

    public void setStudent_idx(int student_idx) {
        this.student_idx = student_idx;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getDepartment_phone() {
        return department_phone;
    }

    public void setDepartment_phone(String department_phone) {
        this.department_phone = department_phone;
    }

    public String getStudent_phone() {
        return student_phone;
    }

    public void setStudent_phone(String student_phone) {
        this.student_phone = student_phone;
    }

}

class Quiz02Dao extends DaoQuiz{
    public List<Quiz01DTO> selectAll(){
        try {
            String sql = "select a.idx as a_idx, a.name as a_name, a.phone as a_phone, " +
                    "b.name as b_name, b.phone as b_phone from student a " +
                    "inner join department b " +
                    "on a.dep_code = b.idx where b.name = '컴퓨터공학'";

            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            List<Quiz01DTO> list = new ArrayList<>();

            while (rs.next()) {
                Quiz01DTO row = new Quiz01DTO();

                row.setStudent_idx(rs.getInt("a_idx"));
                row.setStudent_name(rs.getString("a_name"));
                row.setStudent_phone(rs.getString("a_phone"));
                row.setDepartment_name(rs.getString("b_name"));
                row.setDepartment_phone(rs.getString("b_phone"));

                list.add(row);
            }
            return list;

        } catch (SQLException e) {
            System.err.println("select 예외 : " + e.getMessage());
        }finally {
            close();
        }
        return null;
    }

}
public class Quiz02 {
    static void printList(List<Quiz01DTO> list){
        for (Quiz01DTO dto : list) {
            String msg = dto.getStudent_idx()
                    + "\t" + dto.getStudent_name()
                    + "\t" + dto.getStudent_phone()
                    + "\t" + dto.getDepartment_name()
                    + "\t" + dto.getDepartment_phone();
            System.out.println(msg);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Quiz02Dao dao = new Quiz02Dao();
        List<Quiz01DTO> list = dao.selectAll();
        printList(list);
    }
}
