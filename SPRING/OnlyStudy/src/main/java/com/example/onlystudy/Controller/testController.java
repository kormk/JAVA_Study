package com.example.onlystudy.Controller;

import com.example.onlystudy.DTO.testDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Validator;


@RestController
public class testController {
   private final Validator validator;

    public testController(@Autowired Validator validator) {
        this.validator = validator;
    }


    @PostMapping("/testPost")
    public String testPost(@RequestBody testDTO dto)
    {
        return dto.toString();
    }


    @GetMapping("/testGet")
    public String testGet(String name)
    {
        return "ok";
    }

    @PutMapping("/testPut")
    public String testPut(@RequestBody testDTO dto)
    {
        return dto.toString();
    }

    @DeleteMapping("/testDelete")
    public String testDelete(String name)
    {
        return name;
    }





}
