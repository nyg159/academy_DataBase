package org.ac0817.jdbc_5;

import org.ac0817.Dao;

public class Ex01 {
    public static void main(String[] args) {
        Dao dao = new Dao();
        String ver = dao.test();

        System.out.println(ver);

        System.out.println(dao.proTest(3,4));


    }
}
