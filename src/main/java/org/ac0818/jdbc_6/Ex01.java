package org.ac0818.jdbc_6;

/*
    DAO 를 활용해서 sal_up 프로시저를 실행 후 반환값을 받아서 출력
 */
public class Ex01 {
    public static void main(String[] args) {
        Dao0818 dao0818 = new Dao0818();
        System.out.println("인상된 금액은 : "+dao0818.sal_up_pro(20230112,5));

    }
}
