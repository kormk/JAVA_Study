package com.example.onlystudy.Controller;

import com.example.onlystudy.DTO.testDTO;
import com.example.onlystudy.Service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class testController {

    private testDTO dto;
    private testService service;
    public testController(@Autowired testDTO dto,
                          @Autowired testService service) {
        this.dto = dto;
        this.service = service;
    }



    @PostMapping("/test-post") // URL에 대문자 쓰지 말것, 행위에 대한 명명을 하지말것
    public String testPost(@RequestBody testDTO dto) { return service.regist(dto); }

    @GetMapping("/test-get") // 요청 받은 카테고리에 대항하는 아이템만 보이도록 필터링
    public List<testDTO> testGet(@RequestParam String detail)
    {
        return service.filter(detail);
    }

    @PutMapping("/test-put")
    public String testPut(@RequestBody testDTO dto) { return service.modify(dto); }

    @DeleteMapping("/test-delete")
    public String testDelete(String name)
    {
        return name;
    }

}
