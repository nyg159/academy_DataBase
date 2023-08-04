package org.ac0803.jdbc_2;

/*
        복습용
 */
import org.dao.Student_viewDAO;
import org.dto.Student_viewDTO;

import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        Student_viewDAO dao = new Student_viewDAO();
        List<Student_viewDTO> list = dao.selectAll();

        for (Student_viewDTO dto : list) {
            String msg = "%s %d %d %d %d %.2f";

            msg = String.format(msg,dto.getName(),dto.getKor(),
                    dto.getEng(),dto.getMat(),dto.getTotal(),dto.getAvg());
            System.out.println(msg);

        }
    }
}
