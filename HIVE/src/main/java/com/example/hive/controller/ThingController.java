package com.example.hive.controller;

import com.example.hive.dao.ThingDAO;
import com.example.hive.dao.UserDAO;
import com.example.hive.pojo.Thing;
import com.example.hive.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Controller
public class ThingController {
    @Autowired
    ThingDAO thingDAO;

    @CrossOrigin
    @PostMapping(value = "/api/findallthing")
    @ResponseBody
    public List<Thing> findallthing() {
        List<Thing> things=thingDAO.findAll();
        return things;
    }
}
