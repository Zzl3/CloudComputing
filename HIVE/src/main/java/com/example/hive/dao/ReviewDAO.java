package com.example.hive.dao;
import com.example.hive.pojo.Review;
import com.example.hive.pojo.Thing;
import com.example.hive.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewDAO extends JpaRepository<Review,Integer> {
    List<Review> findAll(); //查询全部
    List<Review> findByUseridLike(String userid);//模糊查询userid
    List<Review> findByYearBetween(Integer a,Integer b);//模糊查询在a到b之间的评论
}
