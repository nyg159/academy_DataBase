package org.ac0809.jdbc_4;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
        문제 : 교수의 정보를 출력 (단, 교수 번호, 교수 이름, 교수 연락처, 전공 이름, 전공 연락처)
        dbcp 를 사용해서 해봐라
 */
class Quiz03DTO{
    private int pro_idx;
    private String pro_name, pro_phone, dart_name, dart_phone;


    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getPro_phone() {
        return pro_phone;
    }

    public void setPro_phone(String pro_phone) {
        this.pro_phone = pro_phone;
    }

    public String getDart_name() {
        return dart_name;
    }

    public void setDart_name(String dart_name) {
        this.dart_name = dart_name;
    }

    public String getDart_phone() {
        return dart_phone;
    }

    public void setDart_phone(String dart_phone) {
        this.dart_phone = dart_phone;
    }

    public int getPro_idx() {
        return pro_idx;
    }

    public void setPro_idx(int pro_idx) {
        this.pro_idx = pro_idx;
    }
}

class Quiz03Dao extends DaoQuiz{
    public List<Quiz03DTO> selectAll(){
        try {
            String sql = "select p.idx as p_idx, p.name as p_name, " +
                    "p.phone as p_phone, d.name as d_name, d.phone as d_phone " +
                    "from professor p inner join department d " +
                    "on p.dep_code = d.idx";

            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            List<Quiz03DTO> list = new ArrayList<>();

            while (rs.next()) {
                Quiz03DTO row = new Quiz03DTO();

                row.setPro_idx(rs.getInt("p_idx"));
                row.setPro_name(rs.getString("p_name"));
                row.setPro_phone(rs.getString("p_phone"));
                row.setDart_name(rs.getString("d_name"));
                row.setDart_phone(rs.getString("d_phone"));

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


public class Quiz03 {
    static void printList(List<Quiz03DTO> list){
        for (Quiz03DTO dto : list) {
            String msg = dto.getPro_idx()
                    + "\t" + dto.getPro_name()
                    + "\t" + dto.getPro_phone()
                    + "\t" + dto.getDart_name()
                    + "\t" + dto.getDart_phone();
            System.out.println(msg);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Quiz03Dao dao = new Quiz03Dao();
        List<Quiz03DTO> list = dao.selectAll();
        printList(list);
    }
}
