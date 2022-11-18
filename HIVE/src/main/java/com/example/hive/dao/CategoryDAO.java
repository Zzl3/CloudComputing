package com.example.hive.dao;
import com.example.hive.pojo.Category;
import com.example.hive.pojo.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDAO extends JpaRepository<Category,Integer> {
    List<Category> findAll(); //查询全部
}
