package com.example.hive.controller;

import com.example.hive.dao.ReviewDAO;
import com.example.hive.dao.ThingDAO;
import com.example.hive.dao.UserDAO;
import com.example.hive.pojo.Review;
import com.example.hive.pojo.Thing;
import com.example.hive.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;
import java.util.Map;

@RestController
public class ReviewController {
    @Autowired
    ReviewDAO reviewDAO;

    @CrossOrigin
    @PostMapping(value = "/api/findbyyear")
    @ResponseBody
    public List<Review> findbyyear(@RequestBody Map<String,Object> datas) {
        Integer a=Integer.valueOf(datas.get("a").toString());
        Integer b=Integer.valueOf(datas.get("b").toString());
        List<Review> reviews=reviewDAO.findByYearBetween(a,b);
        return reviews;
    }

    @CrossOrigin
    @PostMapping(value = "/api/findallreview")
    @ResponseBody
    public List<Review> findallreview() {
        List<Review> reviews=reviewDAO.findAll();
        return reviews;
    }

    @CrossOrigin
    @PostMapping(value = "/api/findbythingid")
    @ResponseBody
    public List<Review> findbythingid(@RequestBody String thingid) {//前端只能传送string参数
        List<Review> reviews=reviewDAO.findByThingid(Integer.valueOf(thingid));
        return reviews;
    }

    @CrossOrigin
    @PostMapping(value = "/api/findbyuserlike")
    @ResponseBody
    public List<Review> findByUseridLike(@RequestBody String userid) {
        List<Review> reviews=reviewDAO.findByUseridLike("%"+userid+"%");
        return reviews;
    }

    @CrossOrigin
    @PostMapping(value = "/api/findbyuser")
    @ResponseBody
    public List<Review> findByUserid(@RequestBody String userid) {
        List<Review> reviews=reviewDAO.findByUserid(userid);
        return reviews;
    }
}
