package com.example.hive.controller;
import com.example.hive.dao.UserDAO;
import com.example.hive.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Controller
public class Usercontroller {
    @Autowired
    UserDAO userDAO;
    //进行模糊查询，找到对应的用户
    @CrossOrigin
    @PostMapping(value = "/api/finduser")
    @ResponseBody
    public List<User> test(@RequestBody User requestUser) {
        String username = requestUser.getUserid();
        username = HtmlUtils.htmlEscape(username);
        List<User> users = userDAO.findByUseridLike("%"+username+"%");
        return users;
    }
}
