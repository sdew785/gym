package com.ustb.gym.controller;

import com.ustb.gym.mapper.ReseMapper;
import com.ustb.gym.pojo.Place;
import com.ustb.gym.pojo.Reserve;
import com.ustb.gym.pojo.User;
import com.ustb.gym.service.PlaceService;
import com.ustb.gym.service.ReseService;
import com.ustb.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName： ReserveController
 * @Author: xumin
 * @Date: 2023/5/17 21:09
 * @Description: 必须描述类做什么事情, 实现什么功能
 */
@Controller
public class ReserveController {

    @Autowired
    PlaceService placeService;

    @Autowired
    ReseService reseService;

    @Autowired
    UserService userService;
    //去预订页
    @GetMapping("/reserve")
    public String toReserve(Model model) {
        List<Place> baAll = placeService.getPlace("篮球全场");
        List<Place> wbaAll = placeService.getPlace("篮球全场1");
        List<Place> ba = placeService.getPlace("篮球半场");
        List<Place> wba = placeService.getPlace("篮球半场1");
        List<Place> bmn = placeService.getPlace("羽毛球");
        List<Place> pp = placeService.getPlace("乒乓球");
        List<Place> ten = placeService.getPlace("网球");
        List<Place> ppq = placeService.getPlace("跑廊乒乓球");
        model.addAttribute("wbaAlls", wbaAll);
        model.addAttribute("wba", wba);
        model.addAttribute("baAlls", baAll);
        model.addAttribute("bas", ba);
        model.addAttribute("bmns", bmn);
        model.addAttribute("pps", pp);
        model.addAttribute("ppqs", ppq);
        model.addAttribute("tens", ten);
        return "front/yuding";
    }

    @PostMapping("/rba")
    public String rBa(@RequestParam("time") String time,
                      @RequestParam("type") String type,
                      @RequestParam("dates") String date,
                      @RequestParam("num") String num,
                      HttpSession session) throws ParseException {
        if (time.trim().equals("") || type.trim().equals("")
                ||date.trim().equals("") || num.trim().equals("")) {
            return "redirect:/reserve";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//括号里的参数格式可以根据需求进行修改
        Date newTime = sdf.parse(date);//time为页面接收的String类型的参数
        Reserve reserve = new Reserve();
        Place place = placeService.placeName(type);
        int uid = (int)  session.getAttribute("uid");
        reserve.setCreate(new Date());
        reserve.setNumber(num);
        reserve.setPid(place.getPid());
        reserve.setUid(uid);
        reserve.setTime(time);
        reserve.setDates(newTime);
        reseService.addRese(reserve);
        User user = userService.getUserByName(
                (String) session.getAttribute("userName"));
       if(user.getType() == 1){
           int vip = (int)(user.getVipBal() -  place.getTh());
           userService.upUser(vip,uid);
           return "redirect:/reserve";
       }else if(user.getType() == 2){
           int vip = (int)(user.getVipBal() -  place.getStu());
           userService.upUser(vip,uid);
           return "redirect:/reserve";
       }else{
           int vip = (int)(user.getVipBal() -  place.getTem());
           userService.upUser(vip,uid);
           return "redirect:/reserve";
       }
    }
}
