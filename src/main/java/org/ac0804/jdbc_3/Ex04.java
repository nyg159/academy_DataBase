package org.ac0804.jdbc_3;

import org.dao.Person0804Dao;
import org.dto.PersonVO;

import java.util.List;
import java.util.Scanner;

/*

 */
public class Ex04 {
    public static void main(String[] args) {
        Person0804Dao dao = new Person0804Dao();
        List<PersonVO> list = dao.selectAll();

        Ex02.printList(list);

        Scanner scanner = new Scanner(System.in);
        String name;

        System.out.println("변경할 사람의 이름 : ");
        name = scanner.next();

        PersonVO personVO = PersonVO.InputInstance(scanner);

        int row = dao.update(personVO, name);
        System.out.println(row != 0 ? "성공" : "실패");

        Ex02.printList(dao.selectAll());
        scanner.close();

    }
}
