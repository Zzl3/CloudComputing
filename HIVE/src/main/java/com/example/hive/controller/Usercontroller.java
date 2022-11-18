package com.example.hive.controller;

import com.example.hive.pojo.User;
import com.example.hive.result.Result;
import com.example.hive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

@Controller
public class Usercontroller {
    @Autowired
    UserService userService;
    @CrossOrigin
    @PostMapping(value = "/api/test")
    @ResponseBody
    public Result test(@RequestBody User requestUser) {
        String username = requestUser.getName();
        username = HtmlUtils.htmlEscape(username);
        User user = userService.getByName(username);
        if (null == user) {
            return new Result(400);
        } else {
            return new Result(200);
        }
    }
}
