package ac0802.jdbc_1;

import ac0802.dao.DAO;

/*
 * 	OOP : 객체 지향의 핵심은 '재사용'
 */
public class Ex03 {
    public static void main(String[] args) {
        DAO dao1 = new DAO();

        System.out.println(dao1.test());
    }
}
