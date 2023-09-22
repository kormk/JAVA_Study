package com.example.onlystudy.Controller;

import com.example.onlystudy.DTO.testDTO;
import com.example.onlystudy.Service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class testController {

    private testDTO dto;
    private testService service;
    public testController(@Autowired testDTO dto, @Autowired testService service) {

        this.dto = dto;
        this.service = service;
    }

    @PostMapping("/test-post") // URL에 대문자 쓰지 말것, 행위에 대한 명명을 하지마 말것
    public String testPost(@RequestBody testDTO dto) {
        return service.regist(dto); }

    @GetMapping("/test-get")
    public String testGet(String name)
    {
        return "ok";
    }

    @PutMapping("/test-put")
    public String testPut(@RequestBody testDTO dto)
    {
        service.regist(dto);
        return dto.toString();
    }

    @DeleteMapping("/test-delete")
    public String testDelete(String name)
    {
        return name;
    }

}
