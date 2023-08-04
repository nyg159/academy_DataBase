package org.dto;

import java.sql.Date;
import java.util.Scanner;

public class PersonVO {
    private String name;
    private double height;
    private Date birth;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public static PersonVO InputInstance(Scanner scanner){
        PersonVO personVO = new PersonVO();

        System.out.print("이름 신장 생년월일 : ");
        personVO.name = scanner.next();
        personVO.height = scanner.nextDouble();
        personVO.birth = Date.valueOf(scanner.next());
        // valueOf(문자열) : 전달한 문자열을 Date 타입으로 변환
        
        return personVO;
        
    }
    
}
