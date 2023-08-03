package org.ac0802.jdbc_1;

import org.ac0802.dao.AccountDao;
import org.ac0802.dto.AccountDTO;

import java.util.List;

public class Quiz01 {
    public static void main(String[] args) {
        // Account 테이블 모두 출력
        AccountDao accountDao = new AccountDao();

        List<AccountDTO> list = accountDao.selectAll();

        System.out.println("idx\t userID\t userPw\t \t nick\t email\t join_date");
        System.out.println("-----------------------------------------------------------------");

        for (AccountDTO accountDTO : list) {
            System.out.printf("%4d\t %10s\t %10s\t %15s\t %20s\t %s\n",
                    accountDTO.getIdx(), accountDTO.getUserId(), accountDTO.getUserPw(),
                    accountDTO.getNick(), accountDTO.getEmail(), accountDTO.getJoin_Date());
        }

    }

}
