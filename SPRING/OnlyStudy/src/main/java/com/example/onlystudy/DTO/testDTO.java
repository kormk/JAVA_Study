package com.example.onlystudy.DTO;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
public class testDTO {
    String name;
    @Min(1)
    String text;

    int price;


}
