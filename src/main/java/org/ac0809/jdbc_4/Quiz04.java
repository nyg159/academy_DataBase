package org.ac0809.jdbc_4;

/*
        문제 : 학생 정보를 출력 (단, 학번, 학생 이름, 전공 이름, 전공 교수 이름)
        dbcp 를 사용해서 해봐라
 */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class Quiz04DTO{
    private int stu_idx;
    private String stu_name, dart_name, pro_name;

    public int getStu_idx() {
        return stu_idx;
    }

    public void setStu_idx(int stu_idx) {
        this.stu_idx = stu_idx;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getDart_name() {
        return dart_name;
    }

    public void setDart_name(String dart_name) {
        this.dart_name = dart_name;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }
}

class Quiz04Dao extends DaoQuiz{

    public List<Quiz04DTO> selectAll(){
        try {
            String sql = "select s.idx as s_idx, s.name as s_name, d.name as d_name, p.name as p_name " +
                    "from student s " +
                    "inner join department d on s.dep_code = d.idx " +
                    "inner join professor p on d.idx = p.dep_code";

            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            List<Quiz04DTO> list = new ArrayList<>();

            while (rs.next()) {
                Quiz04DTO row = new Quiz04DTO();

                row.setStu_idx(rs.getInt("s_idx"));
                row.setStu_name(rs.getString("s_name"));
                row.setDart_name(rs.getString("d_name"));
                row.setPro_name(rs.getString("p_name"));

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

public class Quiz04 {

    static void printList(List<Quiz04DTO> list){
        for (Quiz04DTO dto : list) {
            String msg = dto.getStu_idx()
                    + "\t" + dto.getStu_name()
                    + "\t" + dto.getDart_name()
                    + "\t" + dto.getPro_name();
            System.out.println(msg);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Quiz04Dao dao = new Quiz04Dao();
        List<Quiz04DTO> list = dao.selectAll();
        printList(list);

    }
}
