package com.example.onlystudy.DTO;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
@AllArgsConstructor
@NoArgsConstructor
public class testDTO {

//    @Pattern(regexp = "[가-힣]*$", message = "형식이 올바르지 않습니다.")
    String id; // id

    String pw; // 정규식 검사 특정 문자 포함

    @Pattern(regexp = "^[a-z0-9A-Z._-]*@[a-z0-9A-Z]*.[a-zA-Z.]*$", message = "이메일 형식이 아닙니다.")
    String email; // 정규식 검사 이메일 형식

    String date; // 정규식 검사 날짜 형식

    @Max(value = 30,message = "최대 나이는 30살 입니다.")
    int age;  // validation

    String category;

}
