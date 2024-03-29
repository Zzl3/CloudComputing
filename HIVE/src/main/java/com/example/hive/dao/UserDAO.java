package com.example.hive.dao;

import com.example.hive.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<User,Integer> {
    List<User> findByUseridLike(String userid);
}
