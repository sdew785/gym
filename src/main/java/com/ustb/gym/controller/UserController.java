package com.ustb.gym.controller;

import com.ustb.gym.pojo.Admin;
import com.ustb.gym.pojo.User;
import com.ustb.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @ClassName： UserController
 * @Author: xumin
 * @Date: 2023/5/17 18:55
 * @Description: 必须描述类做什么事情, 实现什么功能
 */
@Controller
public class UserController {

    @GetMapping("/")
    public String toS() {
        return "front/login";
    }

    @GetMapping("/login")
    public String toLogin() {
        return "front/login";
    }

    @Autowired
    UserService userService;

    @PostMapping("/sign")
    public String mainPage(@RequestParam("userName") String name,
                           @RequestParam("password") String password,
                           HttpSession session, Model model) {
        if (name.trim().equals("") || password.trim().equals("")) {
            model.addAttribute("msg", "用户名与密码不可为空");
            return "front/login";
        }
        User login = userService.login(name, password);
        Admin admin = userService.toAdmin(name, password);
        if (login.getPwd().equals("0") || admin.getNotes().equals("0")) {
            model.addAttribute("msg", "密码不正确");
            return "front/login";
        } else if (login.getPwd().equals("1") && admin.getNotes().equals("1")) {
            model.addAttribute("msg", "用户不存在");
            return "front/login";
        } else if ( login.getPwd().equals("1") && admin.getPwd().equals(password)) {
            return "back/index";
        } else {
            session.setAttribute("loginUser", login);
            session.setAttribute("userName", name);
            Integer uid = login.getUid();
            Integer type = login.getType();
            session.setAttribute("uid", uid);
            //(1,教师，2.学生，3.普通)
            session.setAttribute("type", type);
            model.addAttribute("msg", "登录成功");
            //登录成功重定向到main，防止表单重复提交
            return "redirect:/reserve";
        }
    }

    @GetMapping("/deU")
    public String deU(@RequestParam("uid") Integer uid){
        userService.deU(uid);
        return "redirect:/user";
    }
}
