package com.example.onlystudy.DAO;

import com.example.onlystudy.Entity.testEntity;

import java.util.List;


public interface TestDAO {
    public void createTest(testEntity testEntity);

    public void updateTest(testEntity testEntity);
    public void deleteTest(testEntity testEntity);
    public List<testEntity> categoryFillter(String category);
}
