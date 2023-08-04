package org.ac0804.jdbc_3;

import org.dao.DAO;

/*
        DAO 클래스를 작성 후 접속 테스트
        단, 테스트 구문으로 DB 에서 현재시간을 받아서 변환
 */
public class Ex01 {
    public static void main(String[] args) {
        DAO dao = new DAO();
        System.out.println(dao.test());
        String sysTime = dao.systemTime();
        System.out.println("systemTime : " + sysTime);

    }
}
