package com.ustb.gym.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ustb.gym.pojo.Place;
import com.ustb.gym.pojo.Reserve;
import com.ustb.gym.pojo.Trade;
import com.ustb.gym.pojo.User;
import com.ustb.gym.service.PlaceService;
import com.ustb.gym.service.ReseService;
import com.ustb.gym.service.TradeService;
import com.ustb.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName： AdminController
 * @Author: xumin
 * @Date: 2023/5/19 16:35
 * @Description: 必须描述类做什么事情, 实现什么功能
 */

@Controller
public class AdminController {

    @Autowired
    PlaceService placeService;

    @Autowired
    ReseService reseService;

    @Autowired
    TradeService tradeService;

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public String toUser(@RequestParam(value = "pageNum",
            defaultValue = "1") Integer pageNum,
                         Model model) {
        //为了程序的严谨性，判断非空：
        if (pageNum == null) {//若pageNum为空
            pageNum = 1;   //设置默认当前页为1
        }
        if (pageNum <= 0) {  //若为负数
            pageNum = 1;   //设置默认值为1
        }
        int pageSize = 8;
        try {
            //调用分页查询的方法
            List<User> users = userService.allUser(pageNum, pageSize);
            model.addAttribute("users", users);
            Integer size = userService.userSize();
            model.addAttribute("size", size);
            PageInfo pageInfo = new PageInfo(users, pageSize);//设置页面大小
            model.addAttribute("pageInfo", pageInfo);//将页面信息传到前端
            return "back/user";
        } finally {
            PageHelper.clearPage(); //清理 ThreadLocal 存储的分页参数,保证线程安全
        }
    }

    @GetMapping("/rese")
    public String toRese(@RequestParam(value = "pageNum",
            defaultValue = "1") Integer pageNum,
                         Model model) {
        //为了程序的严谨性，判断非空：
        if (pageNum == null) {//若pageNum为空
            pageNum = 1;   //设置默认当前页为1
        }
        if (pageNum <= 0) {  //若为负数
            pageNum = 1;   //设置默认值为1
        }
        int pageSize = 8;
        try {
            //调用分页查询的方法
            List<Reserve> reses = reseService.allRese(pageNum, pageSize);
            Integer size = reseService.reseSize();
            model.addAttribute("size", size);
            model.addAttribute("reses", reses);
            PageInfo pageInfo = new PageInfo(reses, pageSize);//设置页面大小
            model.addAttribute("pageInfo", pageInfo);//将页面信息传到前端
            return "back/reserve";
        } finally {
            PageHelper.clearPage(); //清理 ThreadLocal 存储的分页参数,保证线程安全
        }
    }

    @GetMapping("/place")
    public String toPlace(@RequestParam(value = "pageNum",
            defaultValue = "1") Integer pageNum,
                          Model model) {
        //为了程序的严谨性，判断非空：
        if (pageNum == null) {//若pageNum为空
            pageNum = 1;   //设置默认当前页为1
        }
        if (pageNum <= 0) {  //若为负数
            pageNum = 1;   //设置默认值为1
        }
        int pageSize = 8;
        try {
            //调用分页查询的方法
            List<Place> places = placeService.allPlace(pageNum, pageSize);
            Integer size = placeService.placeSize();
            model.addAttribute("size", size);
            model.addAttribute("places", places);
            PageInfo pageInfo = new PageInfo(places, pageSize);//设置页面大小
            model.addAttribute("pageInfo", pageInfo);//将页面信息传到前端
            return "back/place";
        } finally {
            PageHelper.clearPage(); //清理 ThreadLocal 存储的分页参数,保证线程安全
        }
    }

    @GetMapping("/trade")
    public String toTrade(@RequestParam(value = "pageNum",
            defaultValue = "1") Integer pageNum,
                          Model model) {
        //为了程序的严谨性，判断非空：
        if (pageNum == null) {//若pageNum为空
            pageNum = 1;   //设置默认当前页为1
        }
        if (pageNum <= 0) {  //若为负数
            pageNum = 1;   //设置默认值为1
        }
        int pageSize = 8;
        try {
            //调用分页查询的方法
            List<Trade> trades = tradeService.allTrade(pageNum, pageSize);
            Integer size = tradeService.reseSize();
            model.addAttribute("size", size);
            model.addAttribute("trades", trades);
            PageInfo pageInfo = new PageInfo(trades, pageSize);//设置页面大小
            model.addAttribute("pageInfo", pageInfo);//将页面信息传到前端
            return "back/trade";
        } finally {
            PageHelper.clearPage(); //清理 ThreadLocal 存储的分页参数,保证线程安全
        }
    }


    @PostMapping("/so")
    public String so(@RequestParam("logo") String logo,
                     @RequestParam("key") String key,
                     @RequestParam(value = "pageNum",
                             defaultValue = "1") Integer pageNum,
                     Model model) {
        //为了程序的严谨性，判断非空：
        if (pageNum == null) {//若pageNum为空
            pageNum = 1;   //设置默认当前页为1
        }
        if (pageNum <= 0) {  //若为负数
            pageNum = 1;   //设置默认值为1
        }
        int pageSize = 8;
        try {
            if (logo.equals("a")) {
                List<User> so = userService.so(key, pageNum, pageSize);
                Integer size = userService.soSize(key);
                model.addAttribute("users", so);
                model.addAttribute("size", size);
                PageInfo pageInfo = new PageInfo(so, pageSize);//设置页面大小
                model.addAttribute("pageInfo", pageInfo);//将页面信息传到前端
                return "back/user";
            }
            if (logo.equals("b")) {
                List<Reserve> reses = reseService.so(key, pageNum, pageSize);
                Integer size = reseService.soSize(key);
                model.addAttribute("size", size);
                model.addAttribute("reses", reses);
                PageInfo pageInfo = new PageInfo(reses, pageSize);//设置页面大小
                model.addAttribute("pageInfo", pageInfo);//将页面信息传到前端
                return "back/reserve";
            }
            if (logo.equals("c")) {
                List<Place> places = placeService.so(key, pageNum, pageSize);
                Integer size = placeService.soSize(key);
                model.addAttribute("size", size);
                model.addAttribute("places", places);
                PageInfo pageInfo = new PageInfo(places, pageSize);//设置页面大小
                model.addAttribute("pageInfo", pageInfo);//将页面信息传到前端
                return "back/place";
            }
            if (logo.equals("d")) {
                List<Trade> trades = tradeService.so(key, pageNum, pageSize);
                Integer size = tradeService.soize(key);
                model.addAttribute("size", size);
                model.addAttribute("trades", trades);
                PageInfo pageInfo = new PageInfo(trades, pageSize);//设置页面大小
                model.addAttribute("pageInfo", pageInfo);//将页面信息传到前端
                return "back/trade";
            }
            return "index";
        } finally {
            PageHelper.clearPage(); //清理 ThreadLocal 存储的分页参数,保证线程安全
        }
    }

    @GetMapping("/addPlace")
    public String addPlace(){
        return "back/place_add";
    }

    @GetMapping("/upPlace")
    public String upPlace(@RequestParam("pid") Integer pid,
                          Model model){
        Place pid1 = placeService.pid(pid);
        model.addAttribute("place",pid1);
        return "back/place_udp";
    }

    @GetMapping("/addRese")
    public String addRese(){
        return "back/reserve_add";
    }

    @GetMapping("/upRese")
    public String upRese(){
        return "back/reserve_udp";
    }
    @GetMapping("/addTrade")
    public String addTrade(){
        return "back/trade_add";
    }

    @GetMapping("/upTrade")
    public String upTrade(){
        return "back/trade_udp";
    }

    @GetMapping("/addUser")
    public String addUser(){
        return "back/user_add";
    }

    @GetMapping("/upUser")
    public String upUser(@RequestParam("uid") Integer uid,
                         Model model){
        User uid1 = userService.uid(uid);
        model.addAttribute("user",uid1);
        return "back/user_udp";
    }
}
