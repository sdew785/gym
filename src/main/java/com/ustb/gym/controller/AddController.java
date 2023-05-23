package com.ustb.gym.controller;

import com.ustb.gym.pojo.Place;
import com.ustb.gym.pojo.User;
import com.ustb.gym.service.PlaceService;
import com.ustb.gym.service.ReseService;
import com.ustb.gym.service.TradeService;
import com.ustb.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @ClassName： AddController
 * @Author: xumin
 * @Date: 2023/5/22 13:51
 * @Description: 必须描述类做什么事情, 实现什么功能
 */
@Controller
public class AddController {
    @Autowired
    PlaceService placeService;

    @Autowired
    ReseService reseService;

    @Autowired
    TradeService tradeService;

    @Autowired
    UserService userService;

    @PostMapping("/addPl")
    public String addPl(@RequestParam("name") String name,
                        @RequestParam("type") String type,
                        @RequestParam("notes") String note,
                        @RequestParam("num") String num,
                        @RequestParam("stu") String stu,
                        @RequestParam("th") String th,
                        @RequestParam("tem") String tem,
                        @RequestParam("statu") String statu) {
        if (name.trim().equals("") || type.trim().equals("")
                || num.trim().equals("") || statu.trim().equals("")
                || stu.trim().equals("") || th.trim().equals("")
                || tem.trim().equals("")) {
            return "redirect:/place";
        }
        Place place = new Place();
        place.setName(name);
        place.setType(type);
        place.setNotes(note);
        place.setNumber(num);
        double dstu = Double.parseDouble(stu);
        place.setStu(dstu);
        double dth = Double.parseDouble(th);
        place.setTh(dth);
        double dtem = Double.parseDouble(tem);
        place.setTem(dtem);
        if (statu.equals("可使用")) {
            place.setStatu(0);
        }
        if (statu.equals("不可使用")) {
            place.setStatu(1);
        }
        placeService.addPlace(place);
        return "redirect:/place";
    }

    @PostMapping("/addU")
    public String addU(@RequestParam("name") String name,
                        @RequestParam("type") String type,
                        @RequestParam("note") String note,
                        @RequestParam("pwd") String pwd,
                        @RequestParam("bal") String bal,
                        @RequestParam("vip") String vip,
                        @RequestParam("statu") String statu) {
        if (name.trim().equals("") || type.trim().equals("")
                || pwd.trim().equals("") || statu.trim().equals("")
                || bal.trim().equals("") || vip.trim().equals("")) {
            return "redirect:/user";
        }
        User user = new User();
        Integer ibal = Integer.parseInt(bal);
        user.setVipBal(ibal);
        user.setPwd(pwd);
        user.setNotes(note);
        user.setUname(name);
        user.setCreateTime(new Date());
        if (statu.equals("正常")) {
           user.setStatu(0);
        }
        if (statu.equals("封号")) {
            user.setStatu(1);
        }
        if (vip.equals("是")) {
            user.setVip(1);
        }
        if (vip.equals("否")) {
            user.setVip(2);
        }
        if (type.equals("教师")) {
            user.setType(1);
        }
        if (type.equals("学生")) {
            user.setType(2);
        }
        if (type.equals("游客")) {
            user.setType(3);
        }
        userService.addUser(user);
        return "redirect:/user";
    }

}
