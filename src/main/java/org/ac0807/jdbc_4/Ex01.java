package org.ac0807.jdbc_4;

import org.ac0807.other.Controller;

/*
        Controller : 생성할 메서드가 작성된 클래스
        -run : Account 테이블에 실행 할 매뉴를 출력

        AccountDAO : account 데이터를 조작할 클래스
        - selectAll : 테이블 전체를 출력
        - insert : 테이블에 행 추가
        - delete : 지정 idx 와 동일한 행을 제거
        - update : 지정 idx 와 동일한 행을 수정
        - selectOne : 지정 idx 와 동일한 행만 출력

        AccountATO : account 데이터의 열정보를 가진 클래스

 */
public class Ex01 {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run();

    }

}
