package com.example.onlystudy.Service;

import com.example.onlystudy.DAO.TestDAO;
import com.example.onlystudy.DTO.anotherDTO;
import com.example.onlystudy.DTO.testDTO;
import com.example.onlystudy.Entity.testEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class testService {


    private final TestDAO dao;

    // 원래 의도의 valid검사
    private final GlobalValidCheck<testDTO> validCheck;
    public testService(@Autowired TestDAO dao,
                       @Autowired GlobalValidCheck<testDTO> validCheck)
    {
        this.dao = dao;
        this.validCheck = validCheck;
    }


//// 제네릭 타입에 잘못 넣은 경우
//    private final GlobalValidCheck<anotherDTO> validCheck;
//    public testService(@Autowired TestDAO dao,
//                       @Autowired GlobalValidCheck<anotherDTO> validCheck)
//    {
//        this.dao = dao;
//        this.validCheck = validCheck;
//    }


    public String regist(testDTO dto)
    {
        String validatoin = validCheck.validCheck(dto);

        if (validatoin.equals("success")) dao.createTest(DtoToEneity(dto));

        return validatoin;
    }

    public void modify(testDTO dto)
    {
        dao.updateTest(DtoToEneity(dto));
    }





    public testEntity DtoToEneity(testDTO dto)
    {
        // global valid check 들어갈 자리
        return new testEntity().DtoToEntity(dto);
    }

}
