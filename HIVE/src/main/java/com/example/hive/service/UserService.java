package com.example.hive.service;

import com.example.hive.dao.UserDAO;
import com.example.hive.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;
    public User getByName(String username) {
        return userDAO.findByName(username);
    }
}