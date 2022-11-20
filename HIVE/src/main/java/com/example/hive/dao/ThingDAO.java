package com.example.hive.dao;
import com.example.hive.pojo.Thing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ThingDAO extends JpaRepository<Thing,Integer> {
    List<Thing> findAll(); //查询全部
    List<Thing> findByTitleLike(String title); //查询title模糊查询
    Optional<Thing> findById(Integer id); //通过id查询

}
