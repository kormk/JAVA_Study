package com.example.onlystudy.DAO;


import com.example.onlystudy.Entity.testEntity;
import com.example.onlystudy.Repository.testRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class TestDAOImpl implements TestDAO{

    private final testRepository testRepository;

    public TestDAOImpl(@Autowired  testRepository testRepository){
        this.testRepository = testRepository;
    }

    @Override
    public void createTest(testEntity testEntity) { this.testRepository.save(testEntity); }

    @Override
    public void updateTest(testEntity testEntity)
    {
        this.testRepository.save(testEntity);
    }

    @Override
    public void deleteTest(testEntity testEntity) {
        this.testRepository.deleteById(testEntity.getId());
    }

}
