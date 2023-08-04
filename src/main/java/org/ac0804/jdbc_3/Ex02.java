package org.ac0804.jdbc_3;

import org.dao.Person0804Dao;
import org.dto.PersonVO;

import java.util.List;
import java.util.Scanner;

/*
        1. Person 테이블을 모두 출력

        2. 사용자에게 입력 받은 내용을 Person 에 추가

        3. 추가 후 다시 테이블 출력
 */
public class Ex02 {
    static void printList(List<PersonVO> list) {
        for (PersonVO personVO : list) {
            String msg = personVO.getName()
                    + "\t" + personVO.getHeight()
                    + "\t" + personVO.getBirth();
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Person0804Dao dao = new Person0804Dao();
        List<PersonVO> list = dao.selectAll();

        printList(list);

        Scanner scanner = new Scanner(System.in);
        PersonVO personVO = PersonVO.InputInstance(scanner);

        int row = dao.insert(personVO);
        System.out.println(row != 0 ? "성공" : "실패");
        System.out.println();


        // 3. 추가 후 다시 테이블 출력
        printList(dao.selectAll());
        scanner.close();
    }
}
