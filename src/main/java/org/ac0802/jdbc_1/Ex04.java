package org.ac0802.jdbc_1;

import org.dao.PersonDao;
import org.dto.PersonDTO;

import java.util.List;

public class Ex04 {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();

        String ver = personDao.test();
        List<PersonDTO> list = personDao.selectAll();

        System.out.println("이름\t 신장\t 생년월일");
        System.out.println("-------------------------------");

        for (PersonDTO row : list) {
            System.out.printf("%s\t %.1f\t %s\n", row.name, row.height, row.birth);
        }
    }
}
