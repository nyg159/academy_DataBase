package org.ac0807.other;

import java.util.List;
import java.util.Scanner;

public class Controller {
    Scanner scanner = new Scanner(System.in);


     public void run(){
         int menu;

         do {
             System.out.println("-------- 매뉴-----------");
             System.out.println("1. 테이블 전체 출력");
             System.out.println("2. 테이블에 행 추가");
             System.out.println("3. 지정 idx 와 동일한 행 제거");
             System.out.println("4. 지정 idx 와 동일한 행을 수정");
             System.out.println("5. 지정 idx 와 동일한 행만 출력");
             System.out.println("-----------------------------\n");
             System.out.print("번호를 입력해주세요 : ");

             menu = scanner.nextInt();


             switch (menu) {
                 case 1 :
                     System.out.println("1. 테이블 전체 출력");
                     AccountDAO dao = new AccountDAO();
                     List<AccountDTO> list = dao.selectAll();
                     printList(list);
                     System.out.println(dao.test());
                     break;

//                 case 2 :
//
//                     break;
//
//                 case 3 :
//
//                     break;
//
//                 case 4 :
//
//                     break;
//
//                 case 5 :
//
//                     break;
                 default:
                     System.out.println("없는 매뉴 입니다.");
                     break;
             }


         } while (menu != 0);

         System.out.println("프로그램이 종료되었습니다.");

         scanner.close();
     }

    public static void printList(List<AccountDTO> list) {
        for (AccountDTO accountDTO : list) {
            String msg = accountDTO.getIdx()
                    + "\t" + accountDTO.getUserid()
                    + "\t" + accountDTO.getUserPw()
                    + "\t" + accountDTO.getNick()
                    + "\t\t" + accountDTO.getEmail()
                    + "\t" + accountDTO.getJoin_date();
            System.out.println(msg);
        }
        System.out.println();

    }

}
