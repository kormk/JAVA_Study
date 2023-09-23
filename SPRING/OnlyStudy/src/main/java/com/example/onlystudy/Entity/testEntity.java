package com.example.onlystudy.Entity;

import com.example.onlystudy.DTO.testDTO;
import com.example.onlystudy.Service.Category;
import jakarta.persistence.*;
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

    @Column
    String category;

    public testEntity dtoToEntity(testDTO dto)
    {
        testEntity entity = new testEntity();

        entity.id = dto.getId();
        entity.pw = dto.getPw();
        entity.email = dto.getEmail();
        entity.date = dto.getDate();
        entity.age = dto.getAge();
        entity.category = Category.valueOf(dto.getCategory().toUpperCase()).name();

        return entity;
    }

    public testDTO entityToDto(testEntity entity)
    {
        testDTO dto = new testDTO();

        dto.setId(entity.id);
        dto.setPw(entity.pw);
        dto.setEmail(entity.email);
        dto.setDate(entity.date);
        dto.setAge(entity.age);
        dto.setCategory(entity.category);

        return dto;
    }

}
