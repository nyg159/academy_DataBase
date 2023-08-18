package org.ac0818.jdbc_6;


import java.util.List;
/*
    5. DB에서 작성한 사용자 정의 함수 abs(), rev() 를 호출해서 화면에 출력
 */
public class Ex02 {
    public static void main(String[] args) {
        Dao0818 dao0818 = new Dao0818();

        System.out.println(dao0818.absFunc(-123));

        System.out.println(dao0818.reverseFuc(123));
    }
}
