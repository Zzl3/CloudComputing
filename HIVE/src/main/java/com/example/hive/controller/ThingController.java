package com.example.hive.controller;

import com.example.hive.dao.ThingDAO;
import com.example.hive.dao.UserDAO;
import com.example.hive.pojo.Thing;
import com.example.hive.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @CrossOrigin
    @PostMapping(value = "/api/findbytitle")
    @ResponseBody
    public List<Thing> findbytitle(@RequestBody String title) {
        List<Thing> things=thingDAO.findByTitleLike("%"+title+"%");
        return things;
    }

    @CrossOrigin
    @PostMapping(value = "/api/findbyid")
    @ResponseBody
    public Optional<Thing> findbyid(@RequestBody String thingid) {
        Optional<Thing> thing=thingDAO.findById(Integer.valueOf(thingid));
        return thing;
    }
}
