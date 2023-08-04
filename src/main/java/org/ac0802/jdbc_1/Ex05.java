package org.ac0802.jdbc_1;


/*
 * 		//아래 코드 실행되게 구현
		StudentDAO dao = new StudentDAO();
		List<StudentDAO> list = dao.selectAll();


		// 2. 그 후 모두 출력
		// 단, 간격은 크게 신경 쓰지 말자
 */

import org.dao.StudentDAO;
import org.dao.Student_viewDAO;
import org.dto.StudentDTO;
import org.dto.Student_viewDTO;

import java.util.List;

public class Ex05 {
    public static void main(String[] args) {
        //아래 코드 실행되게 구현
        StudentDAO dao = new StudentDAO();
        List<StudentDTO> list = dao.selectAll();

        System.out.println("        이름\t  국어 \t 영어 \t 수학");
        System.out.println("------------------------------------");

        // 2. 그 후 모두 출력
        // 단, 간격은 크게 신경 쓰지 말자
        for (StudentDTO studentDTO : list) {
            System.out.printf("%10s\t %3d\t %3d\t %3d\n",
                    studentDTO.getName(),studentDTO.getKor(),
                    studentDTO.getEng(),studentDTO.getMat());

        }

        Student_viewDAO viewDAO = new Student_viewDAO();
        List<Student_viewDTO> list2 = viewDAO.selectAll();

        System.out.println();
        System.out.println("        이름\t  국어 \t 영어 \t 수학\t 총합\t 평균\t");
        System.out.println("------------------------------------");

        for (Student_viewDTO viewDTO : list2) {
            System.out.printf("%10s\t %3d\t %3d\t %3d\n",
                    viewDTO.getName(),viewDTO.getKor(),
                    viewDTO.getEng(),viewDTO.getMat(),
                    viewDTO.getTotal(),viewDTO.getAvg());

        }
    }
}
