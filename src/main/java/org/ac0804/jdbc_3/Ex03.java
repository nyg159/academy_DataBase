package org.ac0804.jdbc_3;

import org.dao.Person0804Dao;
import org.dto.PersonVO;

import java.util.List;
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Person0804Dao dao = new Person0804Dao();
        List<PersonVO> list = dao.selectAll();

        Ex02.printList(list);

        Scanner scanner = new Scanner(System.in);
        String name;

        System.out.println("삭제할 이름 : ");
        name = scanner.next();

        int row = dao.delete(name);

        Ex02.printList(dao.selectAll());

        scanner.close();

    }
}
