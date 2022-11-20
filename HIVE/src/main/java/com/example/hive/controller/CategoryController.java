package com.example.hive.controller;

import com.example.hive.dao.CategoryDAO;
import com.example.hive.dao.ReviewDAO;
import com.example.hive.dao.UserDAO;
import com.example.hive.pojo.Category;
import com.example.hive.pojo.Review;
import com.example.hive.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryDAO categoryDAO;

    @CrossOrigin
    @GetMapping(value = "/api/findallcategory")
    public List<Category> findallcategory() {
        List<Category> categories=categoryDAO.findAll();
        return categories;
    }
}
