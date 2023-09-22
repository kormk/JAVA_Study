package com.example.onlystudy.Entity;

import com.example.onlystudy.DTO.testDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;


@Entity
@Getter
public class testEntity {

    @Id
    String id; // id

    @Column
    String pw; // 정규식 검사 특정 문자 포함

    @Column
    String email; // 정규식 검사 이메일 형식

    @Column
    String date; // 정규식 검사 날짜 형식

    @Column
    int age; // validation



    public testEntity DtoToEntity(testDTO dto)
    {
        testEntity entity = new testEntity();

        entity.id = dto.getId();
        entity.pw = dto.getPw();
        entity.email = dto.getEmail();
        entity.date = dto.getDate();
        entity.age = dto.getAge();

        return entity;
    }
}
