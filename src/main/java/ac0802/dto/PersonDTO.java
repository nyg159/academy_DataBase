package ac0802.dto;

/*
 * 		DTO : Data Transfer Object
 * 		데이터를 주고 받기 위한 객체
 * 		DAO 와 이름이 유사해 VO 라고도 한다.
 */

import java.sql.Date;

public class PersonDTO {
    // person table의 정보를 주고 받을거라
    // person table의 열 정보를 필드로 가지면 된다.

    public String name;
    public double height;
    public Date birth;

}
