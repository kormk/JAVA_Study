package com.example.onlystudy.Repository;

import com.example.onlystudy.Entity.testEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.onlystudy.DTO.testDTO;

import java.util.List;


@Repository
public interface testRepository extends JpaRepository<testEntity, String> {
    public List<testEntity> getAllByCategory(String category);
}
