package com.ustb.gym.service;/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xumin
 * @Date: 2023/05/17/18:52
 * @Description:
 */

import com.github.pagehelper.PageHelper;
import com.ustb.gym.mapper.UserMapper;
import com.ustb.gym.pojo.Admin;
import com.ustb.gym.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName： UserService
 * @Author: xumin
 * @Date: 2023/5/17 18:52
 * @Description: 必须描述类做什么事情, 实现什么功能
 */
@Service
public class UserService {
    @Autowired(required = false)
    UserMapper userMapper;

    public List<User> allUser(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.allUser();
    }

    public Integer userSize() {
        return userMapper.allUser().size();
    }

//    User getUserByName(@Param("name") String name);

    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    //获取登录信息,验证登录
    public User login(String name, String password) {
        User user = (User) userMapper.getUserByName(name);
        if (user == null) {
            User user2 = new User();
            user2.setPwd("1");
            return user2;
        }
        if (user.getPwd().equals(password)) {
            return user;
        } else {
            User user1 = new User();
            user1.setPwd("0");
            return user1;
        }
    }

    public Admin toAdmin(String name, String password) {
        Admin admin = (Admin) userMapper.toAdmin(name);
        if (admin == null) {
            Admin ad2 = new Admin();
            ad2.setNotes("1");
            return ad2;
        }
        if (admin.getPwd().equals(password)) {
            return admin;
        } else {
            Admin ad1 = new Admin();
            ad1.setNotes("0");
            return ad1;
        }
    }

    public void upUser(Integer vipBal, Integer uid) {
        userMapper.upBal(vipBal, uid);
    }

    public List<User> so(String key, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.so(key);
    }

    public Integer soSize(String key) {
        return userMapper.so(key).size();
    }

    public void addUser(User user) {
        userMapper.addUser(user);
    }

    public User uid(Integer uid) {
        return userMapper.userByUid(uid);
    }

    public void upU(User user) {
        userMapper.upU(user);
    }

    public void deU(Integer uid){
        userMapper.deU(uid);
    }
}
